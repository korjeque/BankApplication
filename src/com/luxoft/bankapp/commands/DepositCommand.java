package com.luxoft.bankapp.commands;

import java.util.Scanner;

public class DepositCommand implements Command {

    @Override
    public void execute() {

        System.out.println("How much you want to deposit?");
        Scanner s = new Scanner(System.in);
        String depositedAmmount = s.nextLine();

        //TODO add validation
        BankCommander.currentClient.deposit(Float.parseFloat(depositedAmmount));

    }

    @Override
    public void printCommandInfo() {
        System.out.println("Deposit the client account");
    }
}
