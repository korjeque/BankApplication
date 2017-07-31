package com.luxoft.bankapp.model;

import com.luxoft.bankapp.exceptions.ClientExistsException;

import java.util.ArrayList;
import java.util.List;

public class Bank implements Report {

    private String name;

    private List<Client> clients = new ArrayList<Client>();

    public Bank() {
    }

    public Bank(String name) {
        this.name = name;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void addClient(Client c) throws ClientExistsException {
        if (!checkIfClientExists(c)) {
            clients.add(c);
        } else {
            throw new ClientExistsException();
        }
    }

    public void removeClient(Client c) {
        clients.remove(c);
    }

    @Override
    public void printReport() {
        for (Client c : clients) {
            c.printReport();
        }

    }

    public boolean checkIfClientExists(Client client) {
        for (Client c : clients) {
            if (c.getName().equals(client.getName())) {
                return true;
            }
        }
        return false;
    }

}
