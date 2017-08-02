package com.luxoft.bankapp.service;

import com.luxoft.bankapp.model.Account;
import com.luxoft.bankapp.model.Bank;
import com.luxoft.bankapp.model.Client;

import java.util.*;

public class BankReport {

    public void getNumberOfClients(Bank bank) {
        int numberOfClients = 0;
        Iterator<Client> iterator = bank.getClients().iterator();
        while (iterator.hasNext()) {
            iterator.next();
            numberOfClients++;
        }
        System.out.println("Total number of clients: " + numberOfClients);
    }

    public void getAccountsNumber(Bank bank) {
        int numberOfAccounts = 0;
        Iterator<Client> clientIterator = bank.getClients().iterator();
        while (clientIterator.hasNext()) {
            Client client = clientIterator.next();
            Iterator<Account> accountIterator = client.getAccounts().iterator();
            while (accountIterator.hasNext()) {
                accountIterator.next();
                numberOfAccounts++;
            }
        }
        System.out.println("Total number of accounts: " + numberOfAccounts);
    }

    public void getClientsSorted(Bank bank) {
        Set<Client> clients = new TreeSet<Client>((c1, c2) -> {
            if (c1.getBalance() > c2.getBalance()) return 1;
            if (c1.getBalance() < c2.getBalance()) return -1;
            return 0;
        });
        clients.addAll(bank.getClients());
        System.out.println("Sorted client list: ");
        for (Client c : clients) {
            System.out.println(c.getName());
        }
    }

    public void getBankCreditSum(Bank bank) {
        float bankCreditSum = 0;
        Iterator<Client> clientIterator = bank.getClients().iterator();
        while (clientIterator.hasNext()) {
            Iterator<Account> accountIterator = clientIterator.next().getAccounts().iterator();
            while (accountIterator.hasNext()) {
                Account account = accountIterator.next();
                if (account.getAccountName() == "Checking Account" && account.getBalance() < 0) {
                    bankCreditSum += account.getBalance();
                }
            }
        }
        System.out.println("Total bank credit summ: " + bankCreditSum);
    }

    public void getClientsByCity(Bank bank) {
        Map<String, List<Client>> map = new HashMap<String, List<Client>>();

        for (Client client : bank.getClients()) {
            List<Client> clientList = map.get(client.getCity());
            if (clientList == null) {
                clientList = new ArrayList<Client>();
            }
            clientList.add(client);
            map.put(client.getCity(), clientList);
        }

        System.out.println("Clients grouped by city: ");
        Iterator<Map.Entry<String, List<Client>>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, List<Client>> entry = entryIterator.next();
            System.out.println("City: " + entry.getKey());
            for (Client c : entry.getValue()) {
                System.out.println(c.toString());
            }
        }
    }

}
