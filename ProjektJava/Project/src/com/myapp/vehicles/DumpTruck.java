package com.myapp.vehicles;

public class DumpTruck extends Truck {
    double dumpCapacity; // ładowność skrzyni

    public DumpTruck(String name, String brand, double capacity, double dumpCapacity) {
        super(name, brand, capacity);
        this.dumpCapacity = dumpCapacity;
    }

    public double getDumpCapacity() {
        return dumpCapacity;
    }

    public void setDumpCapacity(double dumpCapacity) {
        this.dumpCapacity = dumpCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Rodzaj ciężarówki: Wywrotka");
        System.out.println("Ładowność skrzyni: " + dumpCapacity + " m³");
    }
}
