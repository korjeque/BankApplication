package com.luxoft.bankapp.commands;

public class FindClientCommand implements Command {

    @Override
    public void execute() {
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Find client by his name");
    }
}
