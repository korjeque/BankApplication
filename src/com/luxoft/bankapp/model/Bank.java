package com.luxoft.bankapp.model;

import com.luxoft.bankapp.exceptions.ClientExistsException;
import com.luxoft.bankapp.exceptions.ClientNotExistsException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Bank implements Report {

    private String name;

    private Set<Client> clients = new HashSet<Client>();

    private Map<String, Client> clientMap = new HashMap<>();

    public Bank() {
    }

    public Bank(String name) {
        this.name = name;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void addClient(Client c) throws ClientExistsException {
        if (!checkIfClientExists(c)) {
            clients.add(c);
            clientMap.put(c.getName(), c);
        } else {
            throw new ClientExistsException();
        }
    }

    public void removeClient(Client c) {
        clients.remove(c);
    }

    public Client getClient(String searchedClient) throws ClientNotExistsException {
        Client c = clientMap.get(searchedClient);
        if (c != null)
            return c;
        else
            throw new ClientNotExistsException();
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
