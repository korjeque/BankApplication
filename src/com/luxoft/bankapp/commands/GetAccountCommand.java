package com.luxoft.bankapp.commands;

public class GetAccountCommand implements Command {

    @Override
    public void execute() {
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Get the list of the client accounts and the balance on each account");
    }
}
