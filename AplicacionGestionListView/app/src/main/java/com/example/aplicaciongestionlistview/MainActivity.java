package com.example.aplicaciongestionlistview;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Elemento> elementos; // Lista de elementos
    private ElementoAdapter adapter; // Adaptador del ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configura la Toolbar como barra de acciones
        setSupportActionBar(findViewById(R.id.toolbar));

        // Inicializa el ListView
        ListView listView = findViewById(R.id.listView);

        // Crea una lista de elementos de ejemplo
        elementos = new ArrayList<>();
        elementos.add(new Elemento(R.drawable.acceso, "Acceso a datos", "Tarea MongoDB", 4.5f, "14/11/24"));
        elementos.add(new Elemento(R.drawable.android, "Moviles", "Aplicacion de gestion", 3.0f, "15/11/24"));
        elementos.add(new Elemento(R.drawable.github, "Libre Configuracion", "Presentacion Github", 4.5f, "17/11/24"));
        elementos.add(new Elemento(R.drawable.diu, "DIU", "Gestion de hoteles", 3.0f, "24/11/24"));
        elementos.add(new Elemento(R.drawable.odoo, "SGE", "Implantacion de Odoo", 4.5f, "13/11/24"));
        elementos.add(new Elemento(R.drawable.pro, "PSP", "Tareas de hilos", 3.0f, "21/11/24"));

        // Configura el adapter para el ListView
        adapter = new ElementoAdapter(this, elementos);
        listView.setAdapter(adapter);

        // Registrar el menú contextual
        registerForContextMenu(listView);

        // Detectar un clic normal en un elemento del ListView
        listView.setOnItemClickListener((parent, view, position, id) -> {
            // Mostrar un Toast con el título del elemento clickeado
            Elemento elementoSeleccionado = elementos.get(position);
            String mensaje = "Clic en: " + elementoSeleccionado.getTitulo();
            Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
        });

        // Registrar el menú contextual
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            // Registrar el menú contextual en el ListView
            view.setSelected(true);
            openContextMenu(view);
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla el menú con los ítems definidos en res/menu/menu.xml
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.nombre) {
            // Ordenar elementos por nombre
            sortBy("name");
            return true;
        } else if (item.getItemId() == R.id.rating) {
            // Ordenar elementos por rating
            sortBy("rating");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // Infla el menú contextual desde el archivo XML
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position; // Obtén la posición del elemento seleccionado

        if (item.getItemId() == R.id.action_add) {
            // Lógica para añadir el elemento
            addElemento(position);
            return true;
        } else if (item.getItemId() == R.id.action_delete) {
            // Lógica para eliminar el elemento
            deleteElemento(position);
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }

    // Método para añadir un elemento
    private void addElemento(int position) {
        // Aquí puedes agregar la lógica para añadir un nuevo elemento
        Elemento nuevoElemento = new Elemento(R.drawable.logo, "Nuevo", "Nueva tarea", 4.0f, "12/12/24");
        elementos.add(nuevoElemento);
        adapter.notifyDataSetChanged();
    }

    // Método para eliminar un elemento
    private void deleteElemento(int position) {
        // Eliminar el elemento de la lista
        elementos.remove(position);
        adapter.notifyDataSetChanged();
    }

    private void sortBy(String criteria) {
        if (criteria.equals("name")) {
            elementos.sort((e1, e2) -> e1.getTitulo().compareTo(e2.getTitulo()));
        } else if (criteria.equals("rating")) {
            elementos.sort((e1, e2) -> Float.compare(e2.getPuntuacion(), e1.getPuntuacion()));
        }
        adapter.notifyDataSetChanged();
    }
}
