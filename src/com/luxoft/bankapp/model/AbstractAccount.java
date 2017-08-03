package com.luxoft.bankapp.model;

import java.util.Map;

public abstract class AbstractAccount implements Account {
	protected float balance;
	protected String accountName;
	protected String accountType;

	@Override
	public void printReport() {
		System.out.println("Account balance: " + balance);
	}

	@Override
	public void deposit(float x) throws IllegalArgumentException {
		if (x >= 0) {
			balance += x;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public float getBalance() {
		return balance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		AbstractAccount that = (AbstractAccount) o;

		return getAccountName() != null ? getAccountName().equals(that.getAccountName()) : that.getAccountName() == null;
	}

	@Override
	public int hashCode() {
		return getAccountName() != null ? getAccountName().hashCode() : 0;
	}

    @Override
    public String toString() {
	    return new StringBuilder()
                .append(accountName)
                .append(" with balance ")
                .append(balance)
                .toString();
    }

    @Override
    public int decimalValue() {
	    return Math.round(getBalance());
    }

	@Override
	public String getAccountType() {
		return accountType;
	}

	@Override
	public void parseFeed(Map<String, String> feed) {
		this.balance = Float.parseFloat(feed.get("balance"));
	}
}
