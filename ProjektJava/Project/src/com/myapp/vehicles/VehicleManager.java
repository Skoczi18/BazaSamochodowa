package com.myapp.vehicles;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Klasa VehicleManager odpowiedzialna za zarządzanie listą pojazdów.
 * Pozwala dodawać, usuwać i wyszukiwać pojazdy na różne sposoby.
 */
public class VehicleManager {
    private List<Vehicle> vehicles;

    public VehicleManager() {
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("\nPojazd został dodany:");
        vehicle.displayInfo();
        System.out.println();
    }

    public void removeVehicleById(int id) {
        boolean removed = vehicles.removeIf(v -> v.getId() == id);
        if (removed) {
            System.out.println("Usunięto pojazd o ID: " + id);
        } else {
            System.out.println("Nie znaleziono pojazdu o ID: " + id);
        }
    }

    public Vehicle getVehicleById(int id) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Vehicle> getVehiclesByType(Class<? extends Vehicle> type) {
        return vehicles.stream()
                .filter(type::isInstance)
                .collect(Collectors.toList());
    }

    public String getAllVehiclesInfo() {
        StringBuilder info = new StringBuilder();
        vehicles.forEach(vehicle -> info.append(vehicle.getInfo()).append("\n"));
        return info.toString();
    }

    public void displayVehiclesByName(String namePart) {
        System.out.println("\nPojazdy, których nazwa zawiera '" + namePart + "':");
        vehicles.stream()
                .filter(v -> v.getName().toLowerCase().contains(namePart.toLowerCase()))
                .forEach(Vehicle::displayInfo);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
