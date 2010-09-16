package Jukebox;

public class Account {
	private String userId;
	private int songsPlayedToday = 0;
	private int minutesPlayed = 0;
	
	public Account(String id) {
		userId = id;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void newDay() {
		songsPlayedToday = 0;
	}
	
	public void songPlayedToday() {
		songsPlayedToday++;
	}
	public int getSongsPlayedToday() {
		return songsPlayedToday;
	}
	
	public void addToMinutesPlayed(int minutes) {
		minutesPlayed += minutes;
	}
	public int getMinutesPlayed() {
		return minutesPlayed;
	}
	
	public boolean canPlayASongNow() {
		return (songsPlayedToday < 2 && minutesPlayed < 1500);
	}
}