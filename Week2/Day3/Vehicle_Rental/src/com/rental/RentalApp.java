package com.rental;

import java.util.Scanner;

public class RentalApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of vehicles: ");
		int count = sc.nextInt();
		sc.nextLine();
		Vehicle[] vehicles = new Vehicle[count];
		
		for (int i = 0; i < count; i++) {
			int type;
			while (true) {
				System.out.print("Enter type (1-Car, 2-Bike): ");
				type = sc.nextInt();
				if (type != 1 && type != 2) {
					System.out.println("Invalid type! Enter 1 or 2.");
					continue;
				}
				sc.nextLine();
				break;
			}
			System.out.print("Enter Vehicle Number: ");
			String vehicleNumber = sc.nextLine();
			
			System.out.print("Enter Model: ");
			String model = sc.nextLine();
			
			System.out.print("Enter Rate per Day: ");
			double ratePerDay = sc.nextDouble();
			sc.nextLine();
			
			System.out.print("Enter Days: ");
			int days = sc.nextInt();
			sc.nextLine();
			
			Vehicle v;
			
			if (type == 1) {
				System.out.print("Enter Insurance per Day: ");
				double insurancePerDay = sc.nextDouble();
				sc.nextLine();
				
				v = new Car(vehicleNumber, model, ratePerDay, days, insurancePerDay);
			} else {
				v = new Bike(vehicleNumber, model, ratePerDay, days);
			}
			
			vehicles[i] = v;
		}
		
		System.out.println("--- Rental Details ---");
		
		double totalRent = 0;
		for (Vehicle v : vehicles) {
			// Polymorphism used here: The calls to displayDetails and calculateRent will route to the appropriate override at runtime
			v.displayDetails();
			totalRent += v.calculateRent();
		}
		
		System.out.println("Total Rent Collected: " + totalRent);
		
		sc.close();
	}

}
