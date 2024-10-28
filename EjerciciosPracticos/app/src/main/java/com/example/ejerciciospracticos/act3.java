package com.example.ejerciciospracticos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class act3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main3), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView mitexto = findViewById(R.id.textView);
        Button button =findViewById(R.id.button);
        CheckBox checkBox = findViewById(R.id.checkBox1);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        EditText cuadro1 = findViewById(R.id.editText1);
        EditText cuadro2 = findViewById(R.id.editText2);

        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkBox2.setChecked(false); // Desmarcar checkBox2
            }
        });

        // Listener para checkBox2
        checkBox2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkBox.setChecked(false); // Desmarcar checkBox1
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtiene el elemento seleccionado en el Spinner
                if (checkBox.isChecked() && !cuadro1.getText().toString().isEmpty() && !cuadro2.getText().toString().isEmpty()){
                    try {
                        int num1 = Integer.parseInt(cuadro1.getText().toString());
                        int num2 = Integer.parseInt(cuadro2.getText().toString());
                        int suma = num1 + num2;
                        mitexto.setText(String.valueOf(suma)); // Muestra el resultado en mitexto
                    } catch (NumberFormatException e) {
                        // Manejo de errores si el texto no es un número válido
                        mitexto.setText("Error: Entrada no válida");
                    }
                } else if (checkBox2.isChecked() && !cuadro1.getText().toString().isEmpty() && !cuadro2.getText().toString().isEmpty()){
                    try {
                        int num1 = Integer.parseInt(cuadro1.getText().toString());
                        int num2 = Integer.parseInt(cuadro2.getText().toString());
                        int resta = num1 - num2;
                        mitexto.setText(String.valueOf(resta)); // Muestra el resultado en mitexto
                    } catch (NumberFormatException e) {
                        // Manejo de errores si el texto no es un número válido
                        mitexto.setText("Error: Entrada no válida");
                    }
                }
            }
        });
    }
}
