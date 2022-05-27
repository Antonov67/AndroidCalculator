package com.example.androidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalcActivity extends AppCompatActivity {

    private Button  ceBut, plusBut, minusBut, delenieBut, umnogenieBut, prozentBut;
    private  Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private Button signBut, zapBut, ravnoBut;

    private EditText tabloField;

    private String aText = "", bText = "";
    private double a, b;
    private int number = 1;
    private boolean isFinish = false;
    private String operation = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        getSupportActionBar().hide();

        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);

        ceBut = findViewById(R.id.ceBut);
        plusBut = findViewById(R.id.plusBut);
        minusBut = findViewById(R.id.minusBut);
        delenieBut = findViewById(R.id.delenieBut);
        umnogenieBut = findViewById(R.id.umnogenieBut);
        prozentBut = findViewById(R.id.prozentBut);

        signBut = findViewById(R.id.signBut);
        zapBut = findViewById(R.id.zapBut);

        ravnoBut = findViewById(R.id.ravnoBut);

        tabloField = findViewById(R.id.tabloField);

        //внутренний класс для кнопок цифр
        class NumberButtonClickListener implements View.OnClickListener{
            String numberText;

            //конструктор
            public NumberButtonClickListener(String numberText) {
                this.numberText = numberText;
            }

            @Override
            public void onClick(View v) {
                if (number == 1 && !numberText.equals("-")){
                    if (isFinish){
                        tabloField.setText("");
                        isFinish = false;
                    }
                    aText += numberText;
                    Log.d("calc777", "a1");

                }
                else if (number == 2 && !numberText.equals("-")) {
                    bText += numberText;
                }
                if (number == 1 && numberText.equals("-")){
                    if (isFinish){
                        tabloField.setText("");
                        isFinish = false;
                    }
                    aText = "-" + aText;
                    Log.d("calc777", "a2");
                    Log.d("calc777", aText);
                }
                else if (number == 2 && numberText.equals("-")) {
                    bText = "-" + bText;
                }
                if (numberText.equals("-")){
                    tabloField.setText(aText + operation + bText);
                }else {
                    tabloField.setText(tabloField.getText() + numberText);
                }

                Log.d("calc777", aText + operation + bText);
            }
        }

        b0.setOnClickListener(new NumberButtonClickListener("0"));
        b1.setOnClickListener(new NumberButtonClickListener("1"));
        b2.setOnClickListener(new NumberButtonClickListener("2"));
        b3.setOnClickListener(new NumberButtonClickListener("3"));
        b4.setOnClickListener(new NumberButtonClickListener("4"));
        b5.setOnClickListener(new NumberButtonClickListener("5"));
        b6.setOnClickListener(new NumberButtonClickListener("6"));
        b7.setOnClickListener(new NumberButtonClickListener("7"));
        b8.setOnClickListener(new NumberButtonClickListener("8"));
        b9.setOnClickListener(new NumberButtonClickListener("9"));
        signBut.setOnClickListener(new NumberButtonClickListener("-"));
        zapBut.setOnClickListener(new NumberButtonClickListener("."));

        //внутренний класс для клавиш операций
        class OperationButtonClickListener implements View.OnClickListener{
            String operationText;
            //конструктор
            public OperationButtonClickListener(String operationText) {
                this.operationText = operationText;
            }

            @Override
            public void onClick(View v) {
                tabloField.setText(tabloField.getText() + operationText);
                number = 2;
                operation = operationText;
            }
        }

        plusBut.setOnClickListener(new OperationButtonClickListener("+"));
        minusBut.setOnClickListener(new OperationButtonClickListener("-"));
        umnogenieBut.setOnClickListener(new OperationButtonClickListener("*"));
        delenieBut.setOnClickListener(new OperationButtonClickListener("/"));
        prozentBut.setOnClickListener(new OperationButtonClickListener("%"));

        //кнопка РАВНО
        ravnoBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aText.length() !=0)
                    a = Double.parseDouble(aText);
                if (bText.length() !=0)
                    b = Double.parseDouble(bText);
                number = 1;
                isFinish = true;
                aText = "";
                bText = "";
                if (operation.equals("+"))
                    tabloField.setText(tabloField.getText() + "=" + (a+b));
                if (operation.equals("-"))
                    tabloField.setText(tabloField.getText() + "=" + (a-b));
                if (operation.equals("*"))
                    tabloField.setText(tabloField.getText() + "=" + (a*b));
                if (operation.equals("/")){
                    tabloField.setText(tabloField.getText() + "=" + (a/b));
                    Toast.makeText(getApplicationContext(), "А вообще на ноль делить нельзя", Toast.LENGTH_LONG).show();
                }

                if (operation.equals("%"))
                    tabloField.setText(tabloField.getText() + "=" + (a*b/100));

            }
        });

        //кнопка очистки
        ceBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabloField.setText("");
                number = 1;
                isFinish = true;
                aText = "";
                bText = "";
                operation = "";
            }
        });





    }
}