package com.rental;

// Inheritance used here: Car inherits from Vehicle
public class Car extends Vehicle {
	private double insurancePerDay;

	public Car(String vehicleNumber, String model, double ratePerDay, int days, double insurancePerDay) {
		super(vehicleNumber, model, ratePerDay, days);
		this.insurancePerDay = insurancePerDay;
	}

	@Override
	public double calculateRent() {
		return super.calculateRent() + insurancePerDay * days;
	}

	@Override
	public void displayDetails() {
		System.out.println("Car  | " + vehicleNumber + " | " + model + " | Days: " + days + " | Rent: " + calculateRent());
	}
}
