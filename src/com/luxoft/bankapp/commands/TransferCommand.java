package com.luxoft.bankapp.commands;

import com.luxoft.bankapp.exceptions.NotEnoughFundsException;
import com.luxoft.bankapp.model.Client;
import com.luxoft.bankapp.commands.FindClientCommand;

import java.util.Scanner;

public class TransferCommand implements Command {

    @Override
    public void execute() {

        System.out.println("Enter client to send money");
        Scanner s = new Scanner(System.in);
        String inputData = s.nextLine();

        //TODO replace with method from client class
        //TODO add validation
        Client recieveClient = FindClientCommand.searchClient(inputData);

        System.out.println("How much you want to transfer?");
        String transferAmmount = s.nextLine();

        //TODO add validation
        try {
            BankCommander.currentClient.withdraw(Float.parseFloat(transferAmmount));
            recieveClient.deposit(Float.parseFloat(transferAmmount));
        } catch (NotEnoughFundsException e) {

        }

    }

    @Override
    public void printCommandInfo() {
        System.out.println("Withdraw funds from the client account");
    }
}
