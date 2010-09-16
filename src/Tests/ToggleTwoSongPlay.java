package Tests;
/**
 * This program allows you to play two different songs using
 * the type songplayer.AudioFilePlayer that extends Thread.
 * 
 * You will need the code given in method playFile to play
 * each audio file in a new Thread. This avoids other threads
 * having to wait for the audio file to finish. For example, if 
 * play() were called instead of start(), this GUI will lock up. 
 * 
 * @author Rick Mercer
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import songplayer.EndOfSongListener;
import songplayer.AudioFilePlayer;

public class ToggleTwoSongPlay extends JFrame {

  public static void main(String[] args) {
    new ToggleTwoSongPlay().setVisible(true);
  }

  // The sound files must be in the project in the directory /songfiles
  public static String baseDir = System.getProperty("user.dir") 
                                                       + "/songfiles/";
  private JButton button = new JButton("Play a song");
  private int counter;

  public ToggleTwoSongPlay() {
    this.setSize(200, 100);
    this.setLocation(100, 100);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    counter = 0; // Helps to toggle song plays in actionPerformed
    button.addActionListener(new ButtonListener());
    this.getContentPane().add(button);
  }

  // Play the audio file stored in filename in a new thread
  public void playFile(String fileName) {
    // AudioFilePlayer extends Thread. When start is called, the
    // overridden run method in AudioFilePlayer executes. If the song
    // is not played in a separate thread, the GUI "freezes".
    //
    // You must send a start() message to a new Thread. AudioFilePlayer
    // can not be an instance variable instantiated only once.
    AudioFilePlayer player = new AudioFilePlayer(fileName);
    player.addEndOfSongListener(new SongPlayedListener());
    player.start(); // Call start() in Thread to call run() in AudioFilePlayer
    // player.run(); // Does not call superclass constructor for a new Thread
  }

  private class SongPlayedListener implements EndOfSongListener {

    public void songFinishedPlaying(String fileName) {
      // This method will be called after any song finishes.
      System.out.println("AudioFilePlayer finished playing " + fileName);
    }
  }

  private class ButtonListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      if (counter == 0) {
        playFile(baseDir + "SwingCheese.mp3");
        counter++;
      } else {
        playFile(baseDir + "DeterminedTumbao.mp3");
        counter--;
      }
    }
  }
}