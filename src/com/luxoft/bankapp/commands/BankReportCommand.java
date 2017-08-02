package com.luxoft.bankapp.commands;

import com.luxoft.bankapp.service.BankReport;

public class BankReportCommand implements Command {
    @Override
    public void execute() {
        BankReport bankReport = new BankReport();
        bankReport.getAccountsNumber(BankCommander.currentBank);
        bankReport.getBankCreditSum(BankCommander.currentBank);
        bankReport.getClientsByCity(BankCommander.currentBank);
        bankReport.getClientsSorted(BankCommander.currentBank);
        bankReport.getNumberOfClients(BankCommander.currentBank);
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Print bank report");
    }
}
