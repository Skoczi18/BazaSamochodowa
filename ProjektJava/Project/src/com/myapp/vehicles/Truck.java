package com.myapp.vehicles;

public class Truck extends Vehicle implements Ridable {
    private double capacity;

    public Truck(String name, String brand, double capacity) {
        super(name, brand);
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Rodzaj ciężarówki: Standardowa");
        System.out.println("Ładowność: " + capacity + " ton");
    }

    @Override
    public void ride() {
        System.out.println("Jedziesz ciężarówką: " + getName());
    }
}
