package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Jukebox.Account;
import Jukebox.AccountCollection;

public class AccountCollectionTest {
	@Test
	public void retrieveAccountTest() {
		AccountCollection aCollection = new AccountCollection();
		assertTrue(aCollection.getAccountById("Chris") != null);
		assertTrue(aCollection.getAccountById("Carson") != null);
		assertTrue(aCollection.getAccountById("Chase") != null);
		assertTrue(aCollection.getAccountById("Casey") != null);
	}
	
	@Test
	public void addAndRetrieveAccountTest() {
		AccountCollection aCollection = new AccountCollection();
		aCollection.addAccount(new Account("Mark"));
		assertTrue(aCollection.getAccountById("Mark") != null);
	}
	
	@Test
	public void failedRetrieveAccountTest() {
		AccountCollection aCollection = new AccountCollection();
		assertTrue(aCollection.getAccountById("Martin") == null);
	}
}
