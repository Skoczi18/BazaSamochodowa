package com.myapp.vehicles;

public class SportsMotorcycle extends Motorcycle {
    private double topSpeed; // prędkość maksymalna

    public SportsMotorcycle(String name, String brand, String typeOfHandlebars, double topSpeed) {
        super(name, brand, typeOfHandlebars);
        this.topSpeed = topSpeed;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Rodzaj motocykla: Sportowy");
        System.out.println("Prędkość maksymalna: " + topSpeed + " km/h");
    }
}
