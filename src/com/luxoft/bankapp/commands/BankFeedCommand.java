package com.luxoft.bankapp.commands;

import com.luxoft.bankapp.service.BankFeedService;

import java.util.Scanner;

public class BankFeedCommand implements Command {

    @Override
    public void execute() {

        System.out.println("Enter feed folder");
        Scanner s = new Scanner(System.in);
        String folder = s.nextLine();

        //TODO check
        //TODO refactor
        new BankFeedService().loadFeed(folder);
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Load the feeds and fill data in the domain model");
    }
}
