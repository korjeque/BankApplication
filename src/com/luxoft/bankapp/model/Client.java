package com.luxoft.bankapp.model;

import com.luxoft.bankapp.exceptions.NotEnoughFundsException;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Client implements Report {
    private String name;
    private Set<Account> accounts = new HashSet<Account>();

    private Account activeAccount;
    private float initialOverdraft;
    private float initialBalance;
    private Gender gender;
    private String city;

    public Client(String name) {
        this.name = name;
    }

    public Client(String name, float initialOverdraft, Gender gender) {
        this.name = name;
        this.initialOverdraft = initialOverdraft;
        this.gender = gender;
    }

    public Client(String name, Gender gender) {
        this(name, 0, gender);
    }

    public String getGender() {
        return gender == Gender.MALE ? "m" : "f";
    }

    public float getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(float initialBalance) {
        this.initialBalance = initialBalance;
    }

    public void setInitialOverdraft(float initialOverdraft) {
        this.initialOverdraft = initialOverdraft;
    }

    public void setActiveAccount(Account activeAccount) {
        this.activeAccount = activeAccount;
    }

    public String getName() {
        return this.name;
    }

    public float getBalance() {
        return activeAccount.getBalance();
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    private Account getAccount(String accountType) {
        for (Account acc : accounts) {
            if (acc.getAccountType().equals(accountType)) {
                return acc;
            }
        }
        return createAccount(accountType);
    }

    /**
     * This method creates account by its type
     */
    public Account createAccount(String accountType) {

        Account account;

        switch (accountType) {
            case "s": {
                account = new SavingAccount(initialBalance);
                break;
            }
            case "c": {
                account = new CheckingAccount(initialOverdraft);
                break;
            }
            default: {
                throw new IllegalArgumentException("Account type not found " + accountType);
            }
        }

        accounts.add(account);
        return account;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void deposit(float x) throws IllegalArgumentException {
        activeAccount.deposit(x);
    }

    public void withdraw(float x) throws NotEnoughFundsException {
        activeAccount.withdraw(x);
    }

    public void printReport() {
        System.out.println("Name : " + this.getClientSalutation() + " " + name);
        for (Account a : accounts) {
            System.out.print(a.getAccountName() + " balance: " + a.getBalance() + " ");
        }
        System.out.println();
    }

    public String getClientSalutation() {
        return gender.getSalutation();
    }

    public void parseFeed(Map<String, String> feed) {

        String accountType = feed.get("accountType");
        Account acc = getAccount(accountType);

        this.setCity(feed.get("city"));
        String gender = feed.get("gender");
        if (gender.equals("m")) this.gender = Gender.MALE;
        if (gender.equals("f")) this.gender = Gender.FEMALE;

        acc.parseFeed(feed);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        return gender == client.gender;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append(gender)
                .append(" ")
                .append(name)
                .append("\n Initial balance: ")
                .append(initialBalance)
                .append("\n Initial overdraft: ")
                .append(initialOverdraft)
                .append("\n Active account: ")
                .append(activeAccount)
                .append("List of accounts:");

        for (Account a : accounts) {
            sb
                    .append("\n")
                    .append(a);

        }

        return sb.toString();
    }

    public enum Gender {
        MALE("Mr"), FEMALE("Ms");

        private String prefix;

        Gender(String prefix) {
            this.prefix = prefix;
        }

        String getSalutation() {
            return prefix;
        }

    }
}
