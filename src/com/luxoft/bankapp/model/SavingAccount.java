package com.luxoft.bankapp.model;

import com.luxoft.bankapp.exceptions.NotEnoughFundsException;

public class SavingAccount extends AbstractAccount {

	public SavingAccount(float initialBalance) throws IllegalArgumentException {
		accountType = "s";
		if (initialBalance >= 0) {
			balance = initialBalance;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void withdraw(float x) throws NotEnoughFundsException {
		if (balance >= x)
			balance -= x;
		else
			throw new NotEnoughFundsException(x);
	}

	public String getAccountName() {
		return "Saving Account";
	}

}
