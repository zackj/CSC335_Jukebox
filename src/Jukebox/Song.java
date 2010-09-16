package Jukebox;

public class Song implements Comparable<Song>{

	private int songLength;
	private int todayPlayCount = 0;
	private String songName;
	private String songArtist;
	private String fileName;
	
	
	public Song(String name, String artist, String fName, int length){
		songName = name;
		songLength = length;
		songArtist = artist;
		fileName = fName;
	}
	
	
	/**
	* Provide access to the length of a song
	* 
	* @return the song length, in seconds
	*/
	public int getLength() {
		return songLength;
	}
	
	/**
	 * Provide way to increment play count
	 */
	public void incrementPlayCount(){
		todayPlayCount++;
	}
	
	/**
	 * Provide way to zero the play count
	 */
	public void zeroPlayCount(){
		todayPlayCount = 0;
	}
	
	/**
	 * Provide a way to get the long name (artist space song)
	 * @return the long format song name
	 */
	public String getLongSongName(){
		return songArtist + " " + songName;
	}
	
	/**
	 * Provide access to the fileName
	 * @return
	 */
	public String getFileName(){
		return fileName;
	}

	/**
	 * Required for comparable
	 */
	public int compareTo(Song o) {
		return this.getLongSongName().compareTo(o.getLongSongName());
	}


	
}
