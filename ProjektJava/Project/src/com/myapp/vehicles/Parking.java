package com.myapp.vehicles;

/**
 * Enum reprezentujący dostępne parkingi.
 */
public enum Parking {
    P1("Parking 1"),
    P2("Parking 2"),
    P3("Parking 3"),
    P4("Parking 4");

    private final String name;

    Parking(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
