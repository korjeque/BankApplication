package com.luxoft.bankapp.model;

import com.luxoft.bankapp.exceptions.NotEnoughFundsException;

public interface Account extends Report {
	public String getAccountName();

	public float getBalance();

	public void deposit(float x) throws IllegalArgumentException;

	public void withdraw(float x) throws NotEnoughFundsException;
	
}
