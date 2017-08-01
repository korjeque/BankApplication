package com.luxoft.bankapp.commands;

import com.luxoft.bankapp.model.Account;

import java.util.List;

public class GetAccountCommand implements Command {

    @Override
    public void execute() {
        System.out.println("List of accounts of " + BankCommander.currentClient.getName() + ":");
        for (Account account : BankCommander.currentClient.getAccounts()) {
            StringBuilder sb = new StringBuilder()
                    .append("Account: ")
                    .append(account.getAccountName())
                    .append(" Balance: ")
                    .append(account.getBalance());
            sb.toString();
        }
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Get the list of the client accounts and the balance on each account");
    }
}
