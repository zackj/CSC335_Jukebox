package songplayer;

/**
 * The listener interface for receiving end of song events. 
 * The object that is interested in processing an end of song 
 * event implements this interface. The object created with
 * that class is registered with the AudioFilePlayer object,
 * using the AudioFilePlayer's addEndOfSongListener method. 
 * 
 * When the end of play event occurs, that object's 
 * songFinishedPlaying method is invoked.
 * 
 * @author Rick Mercer
 */
public interface EndOfSongListener {

  // This message is sent to any registered EndOfSongListener from the
  // AudioFilePlayer object when the audio file has been read and played.
  public void songFinishedPlaying(String fileName);

}