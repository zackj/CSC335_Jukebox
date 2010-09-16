package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Jukebox.Account;
import Jukebox.AccountCollection;

public class AccountCollectionTest {
	@Test
	public void addAndRetrieveAccountTest() {
		AccountCollection aCollection = new AccountCollection();
		aCollection.addAccount(new Account("Chris"));
		aCollection.addAccount(new Account("Casey"));
		aCollection.addAccount(new Account("Chase"));
		aCollection.addAccount(new Account("Carson"));
		
		assertTrue(aCollection.getAccountById("Chris") != null);
		assertTrue(aCollection.getAccountById("Carson") != null);
		assertTrue(aCollection.getAccountById("Chase") != null);
		assertTrue(aCollection.getAccountById("Casey") != null);
	}
	
	@Test
	public void failedRetrieveAccountTest() {
		assertTrue(aCollection.getAccountById("Chris") == null);
	}
}