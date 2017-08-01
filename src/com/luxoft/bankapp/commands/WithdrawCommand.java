package com.luxoft.bankapp.commands;

import com.luxoft.bankapp.exceptions.NotEnoughFundsException;

import java.util.Scanner;

public class WithdrawCommand implements Command {

    @Override
    public void execute() {

        System.out.println("How much you want to withdraw?");
        Scanner s = new Scanner(System.in);
        String withdrawAmmount = s.nextLine();

        //TODO add validation
        try {
            BankCommander.currentClient.withdraw(Float.parseFloat(withdrawAmmount));
        } catch (NotEnoughFundsException e) {

        }

    }

    @Override
    public void printCommandInfo() {
        System.out.println("Withdraw funds from the client account");
    }
}
