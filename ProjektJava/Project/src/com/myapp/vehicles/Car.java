package com.myapp.vehicles;

public class Car extends Vehicle implements Ridable {
    private CarType carType;
    private int numberOfDoors;

    public Car(String name, String brand, CarType carType, int numberOfDoors) {
        super(name, brand);
        this.carType = carType;
        this.numberOfDoors = numberOfDoors;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Napęd: Spalinowy");
        System.out.println("Typ: " + getCarType());
        System.out.println("Drzwi: " + getNumberOfDoors());
    }

    @Override
    public void ride() {
        System.out.println("Jedziesz samochodem: " + getName());
    }
}
