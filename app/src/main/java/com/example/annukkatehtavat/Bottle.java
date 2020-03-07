package com.example.annukkatehtavat;
public class Bottle {

    private String name;

    private String manufacturer;

    private double price;

    private double size;

    private double total_energy;



    public Bottle(){
        name = "Pepsi Max";
        manufacturer = "Pepsi";
        price = 1.80;
        size = 0.5;
    }

    public Bottle(String name, double price, double size){
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public double getSize(){
        return size;
    }

    public double getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public double getEnergy(){
        return total_energy;
    }

}