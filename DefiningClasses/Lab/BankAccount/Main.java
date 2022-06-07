package com.company.DefiningClasses.Lab.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] command = scanner.nextLine().split("\\s+");
        Map<Integer, BankAccount> accountsMap = new HashMap<>();

        while (!command[0].equals("End")) {
            String printResult = "";

            if (command[0].equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                printResult = String.format("Account ID%d created", bankAccount.getId());
                accountsMap.put(bankAccount.getId(), bankAccount);
            } else if (command[0].equals("Deposit")) { //Deposit 1 20
                int accountID = Integer.parseInt(command[1]);
                double depositMoney = Double.parseDouble(command[2]);

                if (accountsMap.containsKey(accountID)) {
                    BankAccount accountDeposit = accountsMap.get(accountID);
                    accountDeposit.deposit(depositMoney);
                    accountsMap.put(accountID, accountDeposit);
                    printResult = String.format("Deposited %.0f to ID%d", depositMoney, accountID);
                } else {
                    printResult = "Account does not exist";
                }
            } else if (command[0].equals("SetInterest")) { // SetInterest 1.5
                double newInterest = Double.parseDouble(command[1]);
                BankAccount.setInterestRate(newInterest);
            } else {
                int accountID = Integer.parseInt(command[1]);
                int years = Integer.parseInt(command[2]);

                if (accountsMap.containsKey(accountID)) {
                    BankAccount accountInterest = accountsMap.get(accountID);
                    double finalInterest = accountInterest.getInterest(years);
                    printResult = String.format("%.2f", finalInterest);
                } else {
                    printResult = "Account does not exist";
                }
            }
            if (!printResult.isEmpty()) {
                System.out.println(printResult);
            }
            command = scanner.nextLine().split("\\s+");
        }

    }
}
