package com.myapp.vehicles;

public abstract class Vehicle {
    private static int nextId = 1;
    private int id;
    private String name;
    private String brand;
    private Parking parking;

    public Vehicle(String name, String brand) {
        this.id = generateId();
        this.name = name;
        this.brand = brand;
        this.parking = Parking.P1; // Domyślnie wszystkie pojazdy są na Parking 1
    }

    public static int generateId() {
        return nextId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public void displayInfo() {
        System.out.println(getInfo());
    }

    public String getInfo() {
        return "ID: " + id + ", Nazwa: " + name + ", Marka: " + brand + ", Parking: " + parking;
    }
}
