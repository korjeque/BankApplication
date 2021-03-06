package com.luxoft.bankapp.service;

import com.luxoft.bankapp.exceptions.ClientExistsException;
import com.luxoft.bankapp.exceptions.ClientNotExistsException;
import com.luxoft.bankapp.exceptions.NotEnoughFundsException;
import com.luxoft.bankapp.exceptions.OverDraftLimitExceededException;
import com.luxoft.bankapp.model.Account;
import com.luxoft.bankapp.model.Bank;
import com.luxoft.bankapp.model.Client;

import java.util.Iterator;

public class BankServiceImpl implements BankService {

	@Override
	public void addClient(Bank bank, Client client) throws ClientExistsException {
		bank.addClient(client);
	}

	@Override
	public Client getClient(Bank bank, String clientName) throws ClientNotExistsException {
		Iterator<Client> clientIterator = bank.getClients().iterator();
		while (clientIterator.hasNext()) {
			Client client = clientIterator.next();
			if (client.getName().equals(clientName)) {
				return client;
			}
		}
		throw new ClientNotExistsException();
	}

	@Override
	public void removeClient(Bank bank, Client client) {
		bank.removeClient(client);
	}

	@Override
	public void addAccount(Client client, Account account) {
		client.addAccount(account);
	}

	@Override
	public void setActiveAccount(Client client, Account account) {
		client.setActiveAccount(account);
	}

	public Account createAccount(Client client, String accountType) {
		return client.createAccount(accountType);
	}

	public void deposit(Client client, float x) {
		client.deposit(x);
	}

	public void withdraw(Client client, float x) throws NotEnoughFundsException, OverDraftLimitExceededException {
		client.withdraw(x);
	}

}
