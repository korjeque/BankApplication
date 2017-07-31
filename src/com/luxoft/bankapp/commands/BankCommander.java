package com.luxoft.bankapp.commands;

import com.luxoft.bankapp.model.Bank;
import com.luxoft.bankapp.model.Client;

import java.util.Scanner;

public class BankCommander {

    public static Bank currentBank = new Bank("MyBank");
    public static Client currentClient;

    static Command[] commands = {
            //new FindClientCommand(), // 1
            //new GetAccountCommand(), // 2
            // etc.
            new Command() { // 7 - Exit Command
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
                // show menu
                System.out.print(i + ") ");
                commands[i].printCommandInfo();
            }
            String commandString = s.nextLine();
            int command = 0;
            // initialize command with commandString
            commands[command].execute();
        }
    }


}
