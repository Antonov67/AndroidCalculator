package com.example.androidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


    }

    public void calc(View view) {

        startActivity(new Intent(MainActivity.this, CalcActivity.class));
    }

    public void help(View view) {
        startActivity(new Intent(MainActivity.this, HelpActivity.class));
    }
}