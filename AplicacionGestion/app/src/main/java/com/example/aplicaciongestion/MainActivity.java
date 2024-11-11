package com.example.aplicaciongestion;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa el RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Crea una lista de elementos de ejemplo
        List<Elemento> elementos = new ArrayList<>();
        elementos.add(new Elemento(R.drawable.acceso, "Acceso a datos", "Tarea MongoDB", 4.5f, "14/11/24"));
        elementos.add(new Elemento(R.drawable.android, "Moviles", "Aplicacion de gestion", 3.0f, "15/11/24"));
        // Añade más elementos según sea necesario

        // Configura el adapter
        ElementoAdapter adapter = new ElementoAdapter(elementos);
        recyclerView.setAdapter(adapter);
    }
}
