package com.example.propuesta61;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    TextView texto;
    Button eliminar;
    Button añadir;
    int seleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lista=(ListView) findViewById(R.id.listView);
        ArrayList<String> paises = new ArrayList<>(Arrays.asList("España", "Francia", "Italia", "Andorra", "Reino Unido", "Portugal", "Belgica", "Paises Bajos", "Alemania", "Polonia"));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,paises);
        lista.setAdapter(adapter);
        texto=(TextView) findViewById(R.id.textView);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String textoItem = (String) adapterView.getItemAtPosition(i);
                texto.setText(textoItem);
                seleccion=i;
            }
        });
        eliminar = (Button) findViewById(R.id.eliminar);
        añadir = (Button) findViewById(R.id.añadir);

        eliminar.setOnClickListener(view -> {
            // Aquí puedes implementar la lógica de eliminación
            // Por ejemplo, mostrar un mensaje de confirmación:
            adapter.remove(adapter.getItem(seleccion));
            Toast.makeText(this, "Elemento eliminado", Toast.LENGTH_SHORT).show();
        });
        añadir.setOnClickListener(view -> {
            // Aquí puedes implementar la lógica de eliminación
            // Por ejemplo, mostrar un mensaje de confirmación:
            adapter.add("Jose");
            Toast.makeText(this, "Elemento añadido", Toast.LENGTH_SHORT).show();
        });
    }
}