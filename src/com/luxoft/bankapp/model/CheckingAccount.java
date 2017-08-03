package com.luxoft.bankapp.model;

import com.luxoft.bankapp.exceptions.OverDraftLimitExceededException;

import java.util.Map;

public class CheckingAccount extends AbstractAccount {
	private float overdraft;

	public CheckingAccount(float overdraft) throws IllegalArgumentException {
		accountType = "c";
		if (overdraft >= 0) {
			this.overdraft = overdraft;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void setOverdraft(float x) throws IllegalArgumentException {
		if (x >= 0) {
			overdraft = x;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void withdraw(float x) throws OverDraftLimitExceededException {
		if (balance + overdraft > x) {
			balance -= x;
		} else {
			throw new OverDraftLimitExceededException(getAccountName(), balance
					+ overdraft);
		}
	}

	@Override
	public void parseFeed(Map<String, String> feed) {
		super.parseFeed(feed);
		this.overdraft = Float.parseFloat(feed.get("overdraft"));
	}

	public String getAccountName() {
		return "Checking Account";
	}

}
