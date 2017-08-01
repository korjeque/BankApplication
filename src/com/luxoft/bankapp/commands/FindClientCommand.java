package com.luxoft.bankapp.commands;

import com.luxoft.bankapp.exceptions.ClientNotExistsException;
import com.luxoft.bankapp.model.Client;

import java.util.Scanner;

public class FindClientCommand implements Command {

    @Override
    public void execute() {

        System.out.println("Enter client name: ");

        Scanner s = new Scanner(System.in);
        String inputData = s.nextLine();

        try {
            Client client = BankCommander.currentBank.getClient(inputData);
            BankCommander.currentClient = client;
            System.out.println(client.toString());
        } catch (ClientNotExistsException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void printCommandInfo() {
        System.out.println("Find client by his name");
    }
}
