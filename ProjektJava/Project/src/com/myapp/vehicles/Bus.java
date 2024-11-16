package com.myapp.vehicles;

public class Bus extends Vehicle implements Ridable {
    private int numberOfSeats;

    public Bus(String name, String brand, int numberOfSeats) {
        super(name, brand);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Rodzaj autobusu: Standardowy");
        System.out.println("Miejsca: " + numberOfSeats);
    }

    @Override
    public void ride() {
        System.out.println("Jedziesz autobusem: " + getName());
    }
}
