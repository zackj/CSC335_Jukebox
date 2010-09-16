package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Jukebox.Account;

public class AccountTest {
	@Test
	public void accountCreationTest() {
		Account anAccount = new Account("Chris");
		assertTrue(anAccount.getUserId().compareTo("Chris") == 0);
	}
	
	@Test
	public void songsPlayedTodayTest() {
		Account anAccount = new Account("Chase");
		assertTrue(anAccount.getSongsPlayedToday() == 0);
		
		anAccount.songPlayedToday();
		assertTrue(anAccount.getSongsPlayedToday() == 1);

		anAccount.songPlayedToday();
		assertTrue(anAccount.getSongsPlayedToday() == 2);
		
		anAccount.newDay();
		assertTrue(anAccount.getSongsPlayedToday() == 0);
	}
	
	@Test
	public void minutesPlayedTest() {
		Account anAccount = new Account("Carson");
		assertTrue(anAccount.getMinutesPlayed() == 0);
		
		anAccount.addToMinutesPlayed(5);
		assertTrue(anAccount.getMinutesPlayed() == 5);
		
		anAccount.addToMinutesPlayed(300);
		assertTrue(anAccount.getMinutesPlayed() == 305);
	}
	
	@Test
	public void canPlayASongTest() {
		Account anAccount = new Account("Casey");
		assertTrue(anAccount.getSongsPlayedToday() == 0);
		
		assertTrue(anAccount.canPlayASongNow());
		
		anAccount.songPlayedToday();
		anAccount.songPlayedToday();
		
		assertFalse(anAccount.canPlayASongNow());
		
		anAccount.newDay();
		
		assertTrue(anAccount.canPlayASongNow());
		
		anAccount.addToMinutesPlayed(1499);
		assertTrue(anAccount.canPlayASongNow());
		
		anAccount.addToMinutesPlayed(3);
		assertFalse(anAccount.canPlayASongNow());
	}
}
