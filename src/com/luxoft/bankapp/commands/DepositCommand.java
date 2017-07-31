package com.luxoft.bankapp.commands;

public class DepositCommand implements Command {

    @Override
    public void execute() {
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Deposit the client account");
    }
}
