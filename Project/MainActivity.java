package com.example.calculatorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> history = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextNumber1 = (EditText) findViewById(R.id.editTextNumber1);
                EditText editTextNumber2 = (EditText) findViewById(R.id.editTextNumber2);
                TextView textViewResult = (TextView) findViewById(R.id.textViewResult);

                int num1 = Integer.parseInt(editTextNumber1.getText().toString());
                int num2 = Integer.parseInt(editTextNumber2.getText().toString());
                int result = num1 + num2;

                textViewResult.setText(result + "");
                String calculation = num1 + " + " + num2 + " = " + result;
                history.add(calculation);
            }
        });

        Button btnSubtract = (Button) findViewById(R.id.btnSubtract);
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextNumber1 = (EditText) findViewById(R.id.editTextNumber1);
                EditText editTextNumber2 = (EditText) findViewById(R.id.editTextNumber2);
                TextView textViewResult = (TextView) findViewById(R.id.textViewResult);

                int num1 = Integer.parseInt(editTextNumber1.getText().toString());
                int num2 = Integer.parseInt(editTextNumber2.getText().toString());
                int result = num1 - num2;

                textViewResult.setText(result + "");
                String calculation = num1 + " - " + num2 + " = " + result;
                history.add(calculation);
            }
        });

        Button btnDivide = (Button) findViewById(R.id.btnDivide);
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextNumber1 = (EditText) findViewById(R.id.editTextNumber1);
                EditText editTextNumber2 = (EditText) findViewById(R.id.editTextNumber2);
                TextView textViewResult = (TextView) findViewById(R.id.textViewResult);

                int num1 = Integer.parseInt(editTextNumber1.getText().toString());
                int num2 = Integer.parseInt(editTextNumber2.getText().toString());
                if (num2 == 0) {
                    String result = "Undefined";
                    textViewResult.setText(result + "");
                    String calculation = num1 + " / " + num2 + " = " + result;
                    history.add(calculation);
                }
                else {
                    float result = (float) num1 / num2;
                    textViewResult.setText(result + "");
                    String calculation = num1 + " / " + num2 + " = " + result;
                    history.add(calculation);
                }
            }
        });


        Button btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextNumber1 = (EditText) findViewById(R.id.editTextNumber1);
                EditText editTextNumber2 = (EditText) findViewById(R.id.editTextNumber2);
                TextView textViewResult = (TextView) findViewById(R.id.textViewResult);

                int num1 = Integer.parseInt(editTextNumber1.getText().toString());
                int num2 = Integer.parseInt(editTextNumber2.getText().toString());
                int result = num1 * num2;

                textViewResult.setText(result + "");
                String calculation = num1 + " * " + num2 + " = " + result;
                history.add(calculation);
            }
        });


        Button btnHistory = (Button) findViewById(R.id.btnHistory);
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), HistoryActivity.class);
                startIntent.putStringArrayListExtra("history",(ArrayList<String>) history);
                startActivity(startIntent);
            }
        });
    }
}