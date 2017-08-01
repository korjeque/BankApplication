package com.luxoft.bankapp.commands;

import com.luxoft.bankapp.exceptions.ClientExistsException;
import com.luxoft.bankapp.model.Client;

import java.util.Scanner;

public class AddClientCommand implements Command {

    @Override
    public void execute() {

        //TODO do optional task
        //TODO add validation
        System.out.println("Enter client name");
        Scanner s = new Scanner(System.in);
        String clientName = s.nextLine();

        System.out.println("Enter client initial overdraft");
        String inputData = s.nextLine();
        Float clientInitialOverdraft = Float.parseFloat(inputData);

        System.out.println("Enter client gender");
        inputData = s.nextLine();
        Client.Gender clientGender = null;
        if (inputData.trim().equals("M"))
            clientGender = Client.Gender.MALE;
        if (inputData.trim().equals("F"))
            clientGender = Client.Gender.FEMALE;

        try {
            Client client = new Client(clientName, clientInitialOverdraft, clientGender);
            BankCommander.currentBank.addClient(client);
            BankCommander.currentClient = client;
        } catch (ClientExistsException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void printCommandInfo() {
        System.out.println("Register the new client");
    }
}
