package com.luxoft.bankapp.model;

import com.luxoft.bankapp.exceptions.ClientExistsException;
import com.luxoft.bankapp.exceptions.ClientNotExistsException;
import com.luxoft.bankapp.service.BankService;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Bank implements Report, Serializable {

    private static final long serialVersionUID = -4157871135257285214L;
    private static String serializationFileName;
    private String name;
    private Set<Client> clients = new HashSet<Client>();
    private Map<String, Client> clientMap = new HashMap<>();

    public Bank() {
    }


    public Bank(String name) {
        this.name = name;
    }

    public static void setSerializationFileName(String fileName) {
        serializationFileName = fileName;
    }

    public static Bank readBank() {
        if (serializationFileName == null) {
            return null;
        }
        // check if file does exist and exit if not
        if (!new File(serializationFileName).exists()) {
            return null;
        }

        Bank bank = null;

        try {
            ObjectInputStream ois =
                    new ObjectInputStream(
                            new FileInputStream(
                                    serializationFileName));
            bank = (Bank) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return bank;
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

    public void parseFeed(Map<String, String> feed) {

        String name = feed.get("name");

        Client client = null;
        try {
            client = getClient(name);
        } catch (ClientNotExistsException e) {
            try {
                client = new Client(name);
                addClient(client);
            } catch (ClientExistsException e1) {
                e1.printStackTrace();
            }
        }

        client.parseFeed(feed);

    }
}
