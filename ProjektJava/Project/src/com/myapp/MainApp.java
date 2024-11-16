package com.myapp;

import com.myapp.vehicles.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {
    private static VehicleManager manager = new VehicleManager();

    public static void main(String[] args) {
        launch(args); // Uruchomienie aplikacji JavaFX
    }

    @Override
    public void start(Stage primaryStage) {
        // Ustawienia głównego okna
        primaryStage.setTitle("Vehicle Manager");

        // Tworzenie głównych elementów interfejsu
        Label label = new Label("Wybierz opcję:");
        Button addVehicleButton = new Button("Dodaj nowy pojazd");
        Button removeVehicleButton = new Button("Usuń pojazd o podanym ID");
        Button displayVehiclesButton = new Button("Wyświetl wszystkie pojazdy");
        Button displayVehiclesByTypeButton = new Button("Wyświetl pojazdy danego typu");
        Button searchVehiclesByNameButton = new Button("Wyszukaj pojazdy wg nazwy");
        Button parkVehicleButton = new Button("Przeparkuj pojazd");

        // Akcje dla przycisków
        addVehicleButton.setOnAction(e -> showAddVehicleTypeSelection());
        removeVehicleButton.setOnAction(e -> showRemoveVehicleForm());
        displayVehiclesButton.setOnAction(e -> showAllVehicles());
        displayVehiclesByTypeButton.setOnAction(e -> showVehiclesByTypeForm());
        searchVehiclesByNameButton.setOnAction(e -> showSearchVehicleForm());
        parkVehicleButton.setOnAction(e -> showParkVehicleForm());

        // Układ
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(label, addVehicleButton, removeVehicleButton, displayVehiclesButton,
                displayVehiclesByTypeButton, searchVehiclesByNameButton, parkVehicleButton);

        // Scena i scena ustawiona na okno główne
        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAddVehicleTypeSelection() {
        Stage typeSelectionStage = new Stage();
        typeSelectionStage.setTitle("Wybierz typ pojazdu");

        Label label = new Label("Wybierz typ pojazdu do dodania:");
        Button carButton = new Button("Samochód");
        Button truckButton = new Button("Ciężarówka");
        Button busButton = new Button("Autobus");
        Button motorcycleButton = new Button("Motocykl");

        carButton.setOnAction(e -> {
            showAddCarForm();
            typeSelectionStage.close();
        });

        truckButton.setOnAction(e -> {
            showAddTruckForm();
            typeSelectionStage.close();
        });

        busButton.setOnAction(e -> {
            showAddBusForm();
            typeSelectionStage.close();
        });

        motorcycleButton.setOnAction(e -> {
            showAddMotorcycleForm();
            typeSelectionStage.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(label, carButton, truckButton, busButton, motorcycleButton);

        Scene scene = new Scene(layout, 300, 250);
        typeSelectionStage.setScene(scene);
        typeSelectionStage.show();
    }

    private void showAddCarForm() {
        Stage addCarStage = new Stage();
        addCarStage.setTitle("Dodaj Nowy Samochód");

        Label nameLabel = new Label("Nazwa pojazdu:");
        TextField nameField = new TextField();

        Label brandLabel = new Label("Marka pojazdu:");
        TextField brandField = new TextField();

        Label typeLabel = new Label("Typ samochodu (SEDAN, SUV, HATCHBACK, COUPE):");
        TextField typeField = new TextField();

        Button addButton = new Button("Dodaj");
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String brand = brandField.getText();
            String type = typeField.getText().toUpperCase();

            CarType carType;
            try {
                carType = CarType.valueOf(type);
            } catch (IllegalArgumentException ex) {
                System.out.println("Nieprawidłowy typ samochodu.");
                return;
            }

            manager.addVehicle(new Car(name, brand, carType, 4)); // Przykładowe dane liczby drzwi
            addCarStage.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(nameLabel, nameField, brandLabel, brandField, typeLabel, typeField, addButton);

        Scene scene = new Scene(layout, 300, 300);
        addCarStage.setScene(scene);
        addCarStage.show();
    }

    private void showAddTruckForm() {
        Stage addTruckStage = new Stage();
        addTruckStage.setTitle("Dodaj Nową Ciężarówkę");

        Label nameLabel = new Label("Nazwa pojazdu:");
        TextField nameField = new TextField();

        Label brandLabel = new Label("Marka pojazdu:");
        TextField brandField = new TextField();

        Label capacityLabel = new Label("Ładowność (tony):");
        TextField capacityField = new TextField();

        Button addButton = new Button("Dodaj");
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String brand = brandField.getText();
            double capacity;
            try {
                capacity = Double.parseDouble(capacityField.getText());
            } catch (NumberFormatException ex) {
                System.out.println("Nieprawidłowa wartość ładowności.");
                return;
            }

            manager.addVehicle(new Truck(name, brand, capacity));
            addTruckStage.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(nameLabel, nameField, brandLabel, brandField, capacityLabel, capacityField, addButton);

        Scene scene = new Scene(layout, 300, 300);
        addTruckStage.setScene(scene);
        addTruckStage.show();
    }

    private void showAddBusForm() {
        Stage addBusStage = new Stage();
        addBusStage.setTitle("Dodaj Nowy Autobus");

        Label nameLabel = new Label("Nazwa pojazdu:");
        TextField nameField = new TextField();

        Label brandLabel = new Label("Marka pojazdu:");
        TextField brandField = new TextField();

        Label seatsLabel = new Label("Liczba miejsc:");
        TextField seatsField = new TextField();

        Button addButton = new Button("Dodaj");
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String brand = brandField.getText();
            int seats;
            try {
                seats = Integer.parseInt(seatsField.getText());
            } catch (NumberFormatException ex) {
                System.out.println("Nieprawidłowa liczba miejsc.");
                return;
            }

            manager.addVehicle(new Bus(name, brand, seats));
            addBusStage.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(nameLabel, nameField, brandLabel, brandField, seatsLabel, seatsField, addButton);

        Scene scene = new Scene(layout, 300, 300);
        addBusStage.setScene(scene);
        addBusStage.show();
    }

    private void showAddMotorcycleForm() {
        Stage addMotorcycleStage = new Stage();
        addMotorcycleStage.setTitle("Dodaj Nowy Motocykl");

        Label nameLabel = new Label("Nazwa pojazdu:");
        TextField nameField = new TextField();

        Label brandLabel = new Label("Marka pojazdu:");
        TextField brandField = new TextField();

        Label typeLabel = new Label("Typ motocykla (np. Sportowy):");
        TextField typeField = new TextField();

        Button addButton = new Button("Dodaj");
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String brand = brandField.getText();
            String type = typeField.getText();

            manager.addVehicle(new Motorcycle(name, brand, type));
            addMotorcycleStage.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(nameLabel, nameField, brandLabel, brandField, typeLabel, typeField, addButton);

        Scene scene = new Scene(layout, 300, 300);
        addMotorcycleStage.setScene(scene);
        addMotorcycleStage.show();
    }

    private void showRemoveVehicleForm() {
        Stage removeVehicleStage = new Stage();
        removeVehicleStage.setTitle("Usuń Pojazd");

        Label idLabel = new Label("Podaj ID pojazdu do usunięcia:");
        TextField idField = new TextField();

        Button removeButton = new Button("Usuń");
        removeButton.setOnAction(e -> {
            int id;
            try {
                id = Integer.parseInt(idField.getText());
            } catch (NumberFormatException ex) {
                System.out.println("Nieprawidłowy format ID.");
                return;
            }

            manager.removeVehicleById(id);
            removeVehicleStage.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(idLabel, idField, removeButton);

        Scene scene = new Scene(layout, 300, 200);
        removeVehicleStage.setScene(scene);
        removeVehicleStage.show();
    }

    private void showAllVehicles() {
        Stage allVehiclesStage = new Stage();
        allVehiclesStage.setTitle("Wszystkie Pojazdy");

        TextArea vehiclesArea = new TextArea();
        vehiclesArea.setEditable(false);
        StringBuilder allVehiclesInfo = new StringBuilder();
        for (Vehicle vehicle : manager.getVehicles()) {
            allVehiclesInfo.append(vehicle.getInfo()).append("\n");
        }
        vehiclesArea.setText(allVehiclesInfo.toString());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().add(vehiclesArea);

        Scene scene = new Scene(layout, 400, 400);
        allVehiclesStage.setScene(scene);
        allVehiclesStage.show();
    }

    private void showVehiclesByTypeForm() {
        Stage vehiclesByTypeStage = new Stage();
        vehiclesByTypeStage.setTitle("Wyświetl Pojazdy po Typie");

        Label typeLabel = new Label("Podaj typ pojazdu (Car, ElectricCar, Truck, DumpTruck, Bus, CityBus, Motorcycle, SportsMotorcycle):");
        TextField typeField = new TextField();
        Button searchButton = new Button("Szukaj");

        TextArea resultsArea = new TextArea();
        resultsArea.setEditable(false);

        searchButton.setOnAction(e -> {
            String type = typeField.getText().toLowerCase();
            StringBuilder results = new StringBuilder();

            switch (type) {
                case "car":
                    manager.getVehiclesByType(Car.class).forEach(vehicle -> results.append(vehicle.getInfo()).append("\n"));
                    break;
                case "electriccar":
                    manager.getVehiclesByType(ElectricCar.class).forEach(vehicle -> results.append(vehicle.getInfo()).append("\n"));
                    break;
                case "truck":
                    manager.getVehiclesByType(Truck.class).forEach(vehicle -> results.append(vehicle.getInfo()).append("\n"));
                    break;
                case "dumptruck":
                    manager.getVehiclesByType(DumpTruck.class).forEach(vehicle -> results.append(vehicle.getInfo()).append("\n"));
                    break;
                case "bus":
                    manager.getVehiclesByType(Bus.class).forEach(vehicle -> results.append(vehicle.getInfo()).append("\n"));
                    break;
                case "citybus":
                    manager.getVehiclesByType(CityBus.class).forEach(vehicle -> results.append(vehicle.getInfo()).append("\n"));
                    break;
                case "motorcycle":
                    manager.getVehiclesByType(Motorcycle.class).forEach(vehicle -> results.append(vehicle.getInfo()).append("\n"));
                    break;
                case "sportsmotorcycle":
                    manager.getVehiclesByType(SportsMotorcycle.class).forEach(vehicle -> results.append(vehicle.getInfo()).append("\n"));
                    break;
                default:
                    results.append("Nieprawidłowy typ pojazdu.");
            }

            resultsArea.setText(results.toString());
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(typeLabel, typeField, searchButton, resultsArea);

        Scene scene = new Scene(layout, 400, 400);
        vehiclesByTypeStage.setScene(scene);
        vehiclesByTypeStage.show();
    }

    private void showSearchVehicleForm() {
        Stage searchVehicleStage = new Stage();
        searchVehicleStage.setTitle("Wyszukaj Pojazd");

        Label nameLabel = new Label("Podaj fragment nazwy pojazdu:");
        TextField nameField = new TextField();

        Button searchButton = new Button("Szukaj");
        TextArea resultList = new TextArea();
        resultList.setEditable(false);

        searchButton.setOnAction(e -> {
            String namePart = nameField.getText();
            StringBuilder results = new StringBuilder();

            manager.getVehicles().stream()
                    .filter(vehicle -> vehicle.getName().toLowerCase().contains(namePart.toLowerCase()))
                    .forEach(vehicle -> results.append(vehicle.getInfo()).append("\n"));

            resultList.setText(results.toString());
        });

        VBox searchLayout = new VBox(10);
        searchLayout.setPadding(new Insets(20));
        searchLayout.getChildren().addAll(nameLabel, nameField, searchButton, resultList);

        Scene scene = new Scene(searchLayout, 400, 300);
        searchVehicleStage.setScene(scene);
        searchVehicleStage.show();
    }

    private void showParkVehicleForm() {
        Stage parkVehicleStage = new Stage();
        parkVehicleStage.setTitle("Przeparkuj Pojazd");

        Label idLabel = new Label("Podaj ID pojazdu:");
        TextField idField = new TextField();

        Label parkingLabel = new Label("Podaj numer parkingu (P1, P2, P3):");
        TextField parkingField = new TextField();

        Button parkButton = new Button("Przeparkuj");

        parkButton.setOnAction(e -> {
            try {
                int vehicleId = Integer.parseInt(idField.getText());
                Parking newParking = Parking.valueOf(parkingField.getText().toUpperCase());

                Vehicle vehicle = manager.getVehicleById(vehicleId);
                if (vehicle != null) {
                    vehicle.setParking(newParking);
                    System.out.println("Pojazd o ID " + vehicleId + " został przeparkowany na " + newParking);
                } else {
                    System.out.println("Nie znaleziono pojazdu o podanym ID.");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Nieprawidłowe dane. Sprawdź ID i nazwę parkingu.");
            }
            

            parkVehicleStage.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(idLabel, idField, parkingLabel, parkingField, parkButton);

        Scene scene = new Scene(layout, 300, 300);
        parkVehicleStage.setScene(scene);
        parkVehicleStage.show();
    }
}
