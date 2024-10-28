package com.example.ejerciciospracticos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class act4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main3), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView mitexto = findViewById(R.id.textView);
        CheckBox checkBox1 = findViewById(R.id.checkBox1);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        EditText cuadro1 = findViewById(R.id.editText1);
        EditText cuadro2 = findViewById(R.id.editText2);

        // Listener para checkBox1
        checkBox1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkBox2.setChecked(false); // Desmarcar checkBox2
                realizarCalculo(mitexto, cuadro1, cuadro2, true); // Calcular suma
            }
        });

        // Listener para checkBox2
        checkBox2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkBox1.setChecked(false); // Desmarcar checkBox1
                realizarCalculo(mitexto, cuadro1, cuadro2, false); // Calcular resta
            }
        });

        // Listener para el botón (opcional
    }

    // Método para realizar el cálculo
    private void realizarCalculo(TextView mitexto, EditText cuadro1, EditText cuadro2, boolean isSuma) {
        if (!cuadro1.getText().toString().isEmpty() && !cuadro2.getText().toString().isEmpty()) {
            try {
                int num1 = Integer.parseInt(cuadro1.getText().toString());
                int num2 = Integer.parseInt(cuadro2.getText().toString());
                int resultado;

                if (isSuma) {
                    resultado = num1 + num2; // Suma
                } else {
                    resultado = num1 - num2; // Resta
                }

                mitexto.setText(String.valueOf(resultado)); // Muestra el resultado
            } catch (NumberFormatException e) {
                mitexto.setText("Error: Entrada no válida");
            }
        } else {
            mitexto.setText("Error: Debes ingresar números en ambos campos");
        }
    }
}