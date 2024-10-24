package com.example.calculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculadora extends AppCompatActivity {

    private TextView display;
    private double num1 = 0;
    private double num2 = 0;
    private String operacion = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.salida);

        Operacion(R.id.btnSuma, "+");
        Operacion(R.id.btnResta, "-");
        Operacion(R.id.btnMultiplicacion, "*");
        Operacion(R.id.btnDivision, "/");
        Operacion(R.id.btnPotencia, "^");
        Borrar(R.id.btnborrar);


        Numero(R.id.btn0, "0");
        Numero(R.id.btn1, "1");
        Numero(R.id.btn2, "2");
        Numero(R.id.btn3, "3");
        Numero(R.id.btn4, "4");
        Numero(R.id.btn5, "5");
        Numero(R.id.btn6, "6");
        Numero(R.id.btn7, "7");
        Numero(R.id.btn8, "8");
        Numero(R.id.btn9, "9");
        Numero(R.id.btnpunto,".");

        findViewById(R.id.btnIgual).setOnClickListener(v -> Resultado());
    }


    private void Operacion(int id, String signo) {
        Button button = findViewById(id);
        button.setOnClickListener(v -> {
            if (!display.getText().toString().isEmpty()) {
                num1 =num1 + Double.parseDouble(display.getText().toString());
                operacion = signo;
                display.setText("");
            }
        });
    }

    private void Numero(int id, String numero) {
        Button button = findViewById(id);
        button.setOnClickListener(v -> {
            display.append(numero);
        });
    }
    private void Resultado() {
        if (!display.getText().toString().isEmpty()) {
            num2 = Double.parseDouble(display.getText().toString());
            double result = 0;

            switch (operacion) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "/":
                    if (num2!=0)
                        result = num1 / num2;
                    else
                        display.setText("Error");
                    break;
                case "*":
                        result = num1 * num2;
                    break;
                case "^":
                    result=num1;
                        for (int i=1;i<num2;i++){
                           result=result*num1;
                        }
            }
            display.setText(String.valueOf(result));
    }

    }
    private void Borrar(int id) {
        Button button = findViewById(id);
        button.setOnClickListener(v -> {
            display.setText("");
            num1=0;
            num2=0;
            operacion="";
        });
    }
}


