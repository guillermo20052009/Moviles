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
        elementos.add(new Elemento(R.drawable.pablo, "Título 1", "Contenido 1", 4.5f, "www.example.com", "+1 234 567 890"));
        elementos.add(new Elemento(R.drawable.pablo, "Título 2", "Contenido 2", 3.0f, "www.example.com", "+1 987 654 321"));
        // Añade más elementos según sea necesario

        // Configura el adapter
        ElementoAdapter adapter = new ElementoAdapter(elementos);
        recyclerView.setAdapter(adapter);
    }
}
