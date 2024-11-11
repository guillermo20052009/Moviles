package com.example.propuesta61;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
    Spinner lista;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lista=(Spinner) findViewById(R.id.spinner);
        String[] paises = {"España","Francia","Italia","Andorra","Reino Unido","Portugal","Belgica",
        "Paises Bajos","Alemania","Polonia"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,paises);
        lista.setAdapter(adapter);
        texto=(TextView) findViewById(R.id.textView);

        lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Acción cuando se selecciona un elemento
                String textoItem = (String) parent.getItemAtPosition(position);
                texto.setText(textoItem); // Muestra el texto seleccionado en un TextView
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Acción cuando no se selecciona ningún elemento (opcional)
            }
        });

    }
}