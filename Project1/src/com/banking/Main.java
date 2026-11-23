package com.banking;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.banking.operations.BankOperation;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mainLoop: while (true) {
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
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Invalid choice. Please enter a number between 1 and 9.");
                continue mainLoop;
            } finally {
                scanner.nextLine(); // Consume the newline to avoid an error with a consecutive string input
            }

            BankOperation operation;

            switch (choice) {
                
                case 9:
                    break mainLoop;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 9.");
                    continue mainLoop;
            }

            operation.getInput(scanner);

            operation.execute();
        }

        scanner.close();
    }
}
