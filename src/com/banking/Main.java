package com.banking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("       BANKING MANAGEMENT SYSTEM");
        System.out.println("====================================");
        System.out.println();
        System.out.println("1. Create Customer");
        System.out.println("2. Create Bank Account");
        System.out.println("3. View Customer Details");
        System.out.println("4. Deposit Money");
        System.out.println("5. Withdraw Money");
        System.out.println("6. Check Account Balance");
        System.out.println("7. Transfer Money");
        System.out.println("8. View Transaction History");
        System.out.println("9. Exit");
        System.out.println();
        System.out.print("Enter your choice: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        scanner.close();
    }
}
