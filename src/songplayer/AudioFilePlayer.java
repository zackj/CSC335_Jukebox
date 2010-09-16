package songplayer;

/**
 * Play the given audio file in a new Thread if started like this 
 * (Note: The following code does not register a listener).
 * 
 *    AudioFilePlayer player = new AudioFilePlayer(fileName); 
 *    // This calls start() in class Thread that calls run() below
 *    player.start(); 
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class AudioFilePlayer extends Thread {

  private String filename;

  private ArrayList<EndOfSongListener> listeners;

  public AudioFilePlayer(String fileName) {
    this.filename = fileName;
    listeners = new ArrayList<EndOfSongListener>();
  }

  /**
   * Register an EndOfSongListener
   * 
   * @param listener A reference to an EndOfSongListener that is
   * interested in knowing when the audio file has finished. 
   */
  public void addEndOfSongListener(EndOfSongListener listener) {
    listeners.add(listener);
  }

  // User call Thread's start() method which calls this run method
  @Override
  public void run() {
    play();
  }

  // This Code snippet is from JavaZOOM'a JLayer project
  public void play() {
    AudioFormat decodedFormat = null;
    try {
      File file = new File(filename);
      AudioInputStream in = AudioSystem.getAudioInputStream(file);
      AudioInputStream din = null;
      AudioFormat baseFormat = in.getFormat();

      decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
          baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
          baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);

      din = AudioSystem.getAudioInputStream(decodedFormat, in);
      // Play now.
      rawplay(decodedFormat, din);
      in.close();
      //     stop();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  // This Code snippet is from JavaZOOM
  private void rawplay(AudioFormat targetFormat, AudioInputStream din) {
    SourceDataLine line = null;
    try {
      byte[] data = new byte[4096];
      try {
        line = getLine(targetFormat);
      } catch (LineUnavailableException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      if (line != null) {
        // Start
        line.start();
        int nBytesRead = 0;
        @SuppressWarnings("unused")
        int nBytesWritten = 0;
        while (nBytesRead != -1) {
          nBytesRead = din.read(data, 0, data.length);
          if (nBytesRead != -1)
            nBytesWritten = line.write(data, 0, nBytesRead);
        }
        // Stop
        line.drain();
        line.stop();
        line.close();
        din.close();
        // Notify the one listener 
        for (int index = 0; index < listeners.size(); index++)
          listeners.get(index).songFinishedPlaying(filename);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private SourceDataLine getLine(AudioFormat audioFormat)
      throws LineUnavailableException {
    SourceDataLine res = null;
    DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
    res = (SourceDataLine) AudioSystem.getLine(info);
    res.open(audioFormat);
    return res;
  }
}