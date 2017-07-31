package com.luxoft.bankapp.commands;

public class AddClientCommand implements Command {

    @Override
    public void execute() {
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Register the new client");
    }
}
