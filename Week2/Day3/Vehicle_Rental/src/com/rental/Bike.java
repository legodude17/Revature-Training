package com.rental;

// Inheritance used here: Bike inherits from Vehicle
public class Bike extends Vehicle {
	public Bike(String vehicleNumber, String model, double ratePerDay, int days) {
		super(vehicleNumber, model, ratePerDay, days);
	}

	@Override
	public double calculateRent() {
		return super.calculateRent() * 0.9;
	}

	@Override
	public void displayDetails() {
		System.out.println("Bike | " + vehicleNumber + " | " + model + " | Days: " + days + " | Rent: " + calculateRent());
	}

}
