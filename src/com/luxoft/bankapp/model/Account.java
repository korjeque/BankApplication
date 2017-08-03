package com.luxoft.bankapp.model;

import com.luxoft.bankapp.exceptions.NotEnoughFundsException;

import java.util.Map;

public interface Account extends Report {

	String getAccountName();

	String getAccountType();

	float getBalance();

	int decimalValue();

	void deposit(float x) throws IllegalArgumentException;

	void withdraw(float x) throws NotEnoughFundsException;

	void parseFeed(Map<String, String> feed);
}
