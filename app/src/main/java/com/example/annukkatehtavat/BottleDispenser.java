package com.example.annukkatehtavat;

import java.util.ArrayList;


public class BottleDispenser {

    private static BottleDispenser machine = new BottleDispenser();


    public static BottleDispenser getInstance(){
        return machine;
    }

    private int bottles;
    private double money;

    ArrayList<Bottle> inventory = new ArrayList<Bottle>();

    private BottleDispenser() {

        bottles = 5;

        money = 0;

        for(int i = 0;i<bottles;i++) {
            Bottle bottle = new Bottle();
            inventory.add(bottle);
        }

    }
    public double getMoney() {
        return money;
    }

    public double addMoney() {
        money += 1;
        return money;
    }


    public int buyBottle() {


        if(inventory.size() == 0) {
            return 2;

        }else if(money < inventory.get(inventory.size() - 1).getPrice()){
            return 1;

        }else if(money > inventory.get(inventory.size() - 1).getPrice()){

            bottles -= 1;
            money -= inventory.get(inventory.size() - 1).getPrice();
            inventory.remove(bottles);
            return 3;
        }
        return 0;
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