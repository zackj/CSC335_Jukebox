package Jukebox;

public interface Account {
	//public void setUserId(String id); User ID is set at construction
	public String getUserId();
	
	public void songPlayedToday();
	public int getSongsPlayedToday();
	
	public void addToMinutesPlayed(int minutes);
	public int getMinutesPlayer();
}