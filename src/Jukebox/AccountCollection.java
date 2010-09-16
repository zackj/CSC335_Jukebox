package Jukebox;

import java.util.ArrayList;

public class AccountCollection {
	
	ArrayList<Account> accounts = new ArrayList<Account>();
	
	public AccountCollection() {
		addAccount(new Account("Chris"));
		addAccount(new Account("Casey"));
		addAccount(new Account("Chase"));
		addAccount(new Account("Carson"));
	}
	
	public void addAccount(Account account) {
		Boolean accountExists = false;
		
		for (Account a : accounts)
			if (account.getUserId().compareTo(a.getUserId()) == 0) {
					accountExists = true;
			}
		
		if (!accountExists)
			accounts.add(account);
	}
	
	public Account getAccountById(String id) {
		for (Account a : accounts)
			if (a.getUserId().compareTo(id) == 0)
				return a;
		return null;
	}
}
