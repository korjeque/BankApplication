package com.luxoft.bankapp.commands;

import com.luxoft.bankapp.model.Bank;
import com.luxoft.bankapp.model.Client;

import java.util.Scanner;

public class BankCommander {

    public static Bank currentBank = new Bank("MyBank");
    public static Client currentClient;

    static Command[] commands = {
            new FindClientCommand(),
            new GetAccountCommand(),
            new DepositCommand(),
            new WithdrawCommand(),
            new TransferCommand(),
            new AddClientCommand(),
            new Command() {
                public void execute() {
                    System.exit(0);
                }

                public void printCommandInfo() {
                    System.out.println("Exit");
                }
            }
    };

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);

        while (true) {
            for (int i = 0; i < commands.length; i++) {
                System.out.print(i + ") ");
                commands[i].printCommandInfo();
            }
            String commandString = s.nextLine();
            int command = Integer.parseInt(commandString);
            commands[command].execute();
        }
    }


}
