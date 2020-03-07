package com.example.annukkatehtavat;

import java.util.ArrayList;


public class BottleDispenser {

    private static BottleDispenser machine = new BottleDispenser();


    public static BottleDispenser getInstance(){
        return machine;
    }


    private double money;

    ArrayList<Bottle> inventory = new ArrayList<Bottle>();

    private BottleDispenser(){


        money = 0;

        Bottle bottle1 = new Bottle("Pepsi Max", 1.8, 0.5);
        inventory.add(bottle1);
        Bottle bottle2 = new Bottle("Pepsi Max", 2.2, 1.5);
        inventory.add(bottle2);
        Bottle bottle3 = new Bottle("Coca-Cola Zero", 2.0, 0.5);
        inventory.add(bottle3);
        Bottle bottle4 = new Bottle("Coca-Cola Zero", 2.5, 1.5);
        inventory.add(bottle4);
        Bottle bottle5 = new Bottle("Fanta Zero", 1.95, 0.5);
        inventory.add(bottle5);


    }


    public void addMoney() {
        money += 1;
    }


    public void buyBottle(int choise) {


        if(money < inventory.get(choise - 1).getPrice()) {
            System.out.println("Add money first!\n");
        }
        if(inventory.size() == 0) {
            System.out.println("No bottles left!\n");

        }else if(money > inventory.get(choise - 1).getPrice()){

            System.out.println("KACHUNK! " + inventory.get(choise - 1).getName() + " came out of the dispenser!\n");

            money -= inventory.get(choise - 1).getPrice();
            inventory.remove(choise - 1);

        }
    }


    public double returnMoney() {

        if(money>0) {
            double moneyback = money;
            money = 0;
            return moneyback;
        }
        return 0;
    }
    public void printBottle() {
        int i;
        for(i=0;i<inventory.size();i++){
            System.out.println((i + 1) + ". Name: " + inventory.get(i).getName());
            System.out.println("\tSize: " + inventory.get(i).getSize() + "\tPrice: " + inventory.get(i).getPrice());

        }
    }



}