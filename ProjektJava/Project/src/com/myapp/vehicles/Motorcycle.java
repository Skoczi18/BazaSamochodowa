package com.myapp.vehicles;

public class Motorcycle extends Vehicle implements Ridable {
    private String typeOfHandlebars;

    public Motorcycle(String name, String brand, String typeOfHandlebars) {
        super(name, brand);
        this.typeOfHandlebars = typeOfHandlebars;
    }

    public String getTypeOfHandlebars() {
        return typeOfHandlebars;
    }

    public void setTypeOfHandlebars(String typeOfHandlebars) {
        this.typeOfHandlebars = typeOfHandlebars;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Rodzaj motocykla: Standardowy");
        System.out.println("Rodzaj kierownicy: " + typeOfHandlebars);
    }

    @Override
    public void ride() {
        System.out.println("Jedziesz motocyklem: " + getName());
    }
}
