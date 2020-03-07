package com.example.annukkatehtavat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import android.view.View;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    TextView progressBar;
    TextView header;
    TextView balance;
    TextView screen;
    SeekBar seekBar;
    int max = 20, current = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        header = (TextView) findViewById(R.id.header);
        balance = (TextView) findViewById(R.id.balance);
        screen = (TextView) findViewById(R.id.screen);
        progressBar = (TextView) findViewById(R.id.progressBar);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setMax(max);
        seekBar.setProgress(current);
        progressBar.setText("" + current);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                current = progress;
                progressBar.setText("" + current);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }
    BottleDispenser machine = BottleDispenser.getInstance();
    public void buyBottle(View v){
        int i = machine.buyBottle();
        if (i == 1){
            screen.setText("Add money first!");
        }else if(i == 2){
            screen.setText("Machine is empty!");
        }else if(i == 3){
            screen.setText("Bottle came out of the dispenser!");
            double money = machine.getMoney();
            NumberFormat nm = NumberFormat.getNumberInstance();
            balance.setText(nm.format(money));

        }
    }
    public void addMoney(View v){
        double money = machine.addMoney(current);
        screen.setText("Klink! Added more money!");
        NumberFormat nm = NumberFormat.getNumberInstance();
        balance.setText(nm.format(money));
    }
    public void moneyback(View V){
        machine.returnMoney();
        balance.setText("Balance: 0.00");
    }


}
