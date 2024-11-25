package com.example.aplicaciongestionlistview; // Cambia esto por el paquete de tu proyecto

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplicaciongestionlistview.R;

public class FormularioActivity extends AppCompatActivity {

    private EditText etTitulo, etDescripcion, etFechaEntrega;
    private SeekBar sbPuntuacion;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo); // Asegúrate de que el archivo XML se llama "activity_formulario"

        // Referenciar los elementos de la interfaz
        etTitulo = findViewById(R.id.etTitulo);
        etDescripcion = findViewById(R.id.etDescripcion);
        etFechaEntrega = findViewById(R.id.etFechaEntrega);
        sbPuntuacion = findViewById(R.id.sbPuntuacion);
        btnGuardar = findViewById(R.id.btnGuardar);

        // Configurar el botón Guardar
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los datos del formulario
                String titulo = etTitulo.getText().toString().trim();
                String descripcion = etDescripcion.getText().toString().trim();
                String fechaEntrega = etFechaEntrega.getText().toString().trim();
                int puntuacion = sbPuntuacion.getProgress();

                // Validar los campos
                if (titulo.isEmpty() || descripcion.isEmpty() || fechaEntrega.isEmpty()) {
                    Toast.makeText(FormularioActivity.this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show();
                } else {
                    // Procesar los datos (ejemplo de salida en un Toast)
                    String mensaje = "Título: " + titulo + "\n" +
                            "Descripción: " + descripcion + "\n" +
                            "Fecha de Entrega: " + fechaEntrega + "\n" +
                            "Puntuación: " + puntuacion + " estrellas";
                    Toast.makeText(FormularioActivity.this, mensaje, Toast.LENGTH_LONG).show();

                    // Aquí podrías guardar los datos en una base de datos o realizar otras acciones
                }
            }
        });
    }
}
