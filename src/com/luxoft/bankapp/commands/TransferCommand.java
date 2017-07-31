package com.luxoft.bankapp.commands;

public class TransferCommand implements Command {

    @Override
    public void execute() {
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Make the transfer from one client account to another client account");
    }
}
