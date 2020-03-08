package com.example.annukkatehtavat;

import java.util.ArrayList;


public class BottleDispenser {

    private static BottleDispenser machine = new BottleDispenser();
    public static BottleDispenser getInstance(){
        return machine;
    }



    private double money;

    ArrayList<Bottle> inventory = new ArrayList<Bottle>();

    private BottleDispenser() {

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
    public double getMoney() {
        return money;
    }

    public double addMoney(int current) {
        money += current;
        return money;
    }


    public int buyBottle(int choise) {
        try {
            if (inventory.size() == 0 || inventory.get(choise - 1) == null) {
                return 2;

            } else if (money < inventory.get(choise - 1).getPrice()) {
                return 1;

            } else if (money > inventory.get(choise - 1).getPrice()) {
                money -= inventory.get(choise - 1).getPrice();
                inventory.remove(choise - 1);
                return 3;
            }
        }catch(ArrayIndexOutOfBoundsException exception){
            return 2;
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




}