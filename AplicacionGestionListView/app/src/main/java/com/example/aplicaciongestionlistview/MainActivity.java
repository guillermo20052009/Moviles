package com.example.aplicaciongestionlistview;

import android.content.Intent;
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

    private static final int REQUEST_CODE_ADD = 1; // Código de solicitud para añadir
    private List<Elemento> elementos; // Lista de elementos
    private ElementoAdapter adapter; // Adaptador del ListView
    private sqlBDD dbHelper;
    private int idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idUsuario = getIntent().getIntExtra("id_usuario", -1);
        dbHelper = new sqlBDD(this);

        // Obtener los datos de la base de datos
        elementos = dbHelper.getAllElementos(idUsuario);

        adapter = new ElementoAdapter(this, elementos);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            view.setSelected(true);
            return false;
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
        } else if (item.getItemId() == R.id.action_add) {
            // Abrir la pantalla para añadir un nuevo elemento
            Intent intent = new Intent(this, FormularioActivity.class);
            startActivityForResult(intent, REQUEST_CODE_ADD);
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
        int position = (info != null) ? info.position : -1; // Manejar posición solo si existe

        if (item.getItemId() == R.id.action_delete) {
            // Lógica para eliminar el elemento
            if (position >= 0) {
                deleteElemento(position);
            }
            return true;
        } else if (item.getItemId() == R.id.action_add) {
            // Lógica para abrir la pantalla de añadir
            Intent intent = new Intent(this, FormularioActivity.class);
            startActivityForResult(intent, REQUEST_CODE_ADD);
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ADD && resultCode == RESULT_OK) {
            String titulo = data.getStringExtra("titulo");
            String descripcion = data.getStringExtra("descripcion");
            String fechaEntrega = data.getStringExtra("fechaEntrega");
            int puntuacion = data.getIntExtra("puntuacion", 0);

            Elemento nuevoElemento = new Elemento(R.drawable.android, titulo, descripcion, puntuacion, fechaEntrega);
            dbHelper.addElemento(nuevoElemento,idUsuario); // Guardar en la base de datos
            nuevoElemento.setId(dbHelper.getLastIdElemento());
            elementos.add(nuevoElemento); // Actualizar la lista en memoria
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Elemento añadido con éxito.", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteElemento(int position) {
        Elemento elemento = elementos.get(position);
        dbHelper.deleteElemento(elemento.getId()); // Suponiendo que el ID es la posición + 1
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
