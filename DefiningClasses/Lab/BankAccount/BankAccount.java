package com.company.DefiningClasses.Lab.BankAccount;

public class BankAccount {

    private static int accountCounts = 0;
    private int id;
    private double balance;
    private static double interestRate = 0.02;

    public BankAccount() {
        accountCounts++;
        this.id = accountCounts;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterest(int years) {
        return years * interestRate * this.balance;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }
}
