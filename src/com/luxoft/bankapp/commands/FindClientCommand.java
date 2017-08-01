package com.luxoft.bankapp.commands;

import com.luxoft.bankapp.model.Client;

import java.util.Scanner;

public class FindClientCommand implements Command {

    @Override
    public void execute() {

        System.out.println("Enter client id: ");

        Scanner s = new Scanner(System.in);
        String inputData = s.nextLine();

        BankCommander.currentClient = searchClient(inputData);

    }

    //TODO move to client
    public static Client searchClient(String searchedClient) {
        //TODO replace dummy data
        return new Client("Dummy client", 0f, Client.Gender.FEMALE);
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Find client by his name");
    }
}
