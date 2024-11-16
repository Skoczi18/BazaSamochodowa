package com.myapp.vehicles;

public class ElectricCar extends Car {
    private double batteryCapacity;

    public ElectricCar(String name, String brand, CarType carType, int numberOfDoors, double batteryCapacity) {
        super(name, brand, carType, numberOfDoors);
        this.batteryCapacity = batteryCapacity;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Nazwa: " + getName());
        System.out.println("Marka: " + getBrand());
        System.out.println("Parking: " + getParking());
        System.out.println("Napęd: Elektryczny");
        System.out.println("Typ: " + getCarType());
        System.out.println("Drzwi: " + getNumberOfDoors());
        System.out.println("Pojemność baterii: " + getBatteryCapacity() + " kWh");
    }
    

    @Override
    public void ride() {
        System.out.println("Jedziesz samochodem elektrycznym: " + getName());
    }
}
