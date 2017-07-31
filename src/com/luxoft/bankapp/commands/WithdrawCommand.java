package com.luxoft.bankapp.commands;

public class WithdrawCommand implements Command {

    @Override
    public void execute() {
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Withdraw funds from the client account");
    }
}
