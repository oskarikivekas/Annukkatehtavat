package com.example.annukkatehtavat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import android.view.View;
public class MainActivity extends AppCompatActivity {

    TextView header;
    TextView balance;
    TextView screen;
    Button buyB;
    Button listAllB;
    Button addMoneyB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        header = (TextView) findViewById(R.id.header);
        balance = (TextView) findViewById(R.id.balance);
        screen = (TextView) findViewById(R.id.screen);



    }
    BottleDispenser machine = BottleDispenser.getInstance();
    public void buyBottle(View v){
        machine.buyBottle(1);

    }
    public void addMoney(View v){
        machine.addMoney();
        screen.setText("Klink! Added more money!");
    }
    public void moneyback(View V){
        machine.returnMoney();
        balance.setText("Balance: 0.00");


    }


}
