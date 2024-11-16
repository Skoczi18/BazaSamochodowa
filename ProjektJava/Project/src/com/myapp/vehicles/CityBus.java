package com.myapp.vehicles;

public class CityBus extends Bus {
    private boolean lowFloor;

    public CityBus(String name, String brand, int numberOfSeats, boolean lowFloor) {
        super(name, brand, numberOfSeats);
        this.lowFloor = lowFloor;
    }

    public boolean isLowFloor() {
        return lowFloor;
    }

    public void setLowFloor(boolean lowFloor) {
        this.lowFloor = lowFloor;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Rodzaj autobusu: Miejski");
        System.out.println("Niska podłoga: " + (lowFloor ? "Tak" : "Nie"));
    }
}
