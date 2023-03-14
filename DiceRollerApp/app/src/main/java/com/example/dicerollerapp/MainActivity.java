package com.example.dicerollerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnRoll;
    TextView tvDiceRoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRoll = findViewById(R.id.btnRoll);
        tvDiceRoll = findViewById(R.id.tvDiceRoll);

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dice = getRandomNumber();
                tvDiceRoll.setText(Integer.toString(dice));
            }
        });
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}