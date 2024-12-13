package com.example.aplicaciongestionlistview;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class EditarElementoActivity extends AppCompatActivity {

    private EditText edtTitulo, edtDescripcion;
    private TextView edtFechaEntrega;
    private SeekBar sbPuntuacion;
    private EditText urlCuadro;
    private Button btnGuardar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_elemento);

        // Referenciar los campos
        edtTitulo = findViewById(R.id.etTitulo);
        edtDescripcion = findViewById(R.id.etDescripcion);
        edtFechaEntrega = findViewById(R.id.etFechaEntrega); // Ahora es TextView
        sbPuntuacion = findViewById(R.id.sbPuntuacion);
        urlCuadro = findViewById(R.id.urlCuadro);
        btnGuardar = findViewById(R.id.btnGuardar);

        // Recibir datos de la actividad anterior
        String titulo = getIntent().getStringExtra("titulo");
        String descripcion = getIntent().getStringExtra("descripcion");
        String fechaEntrega = getIntent().getStringExtra("fechaEntrega");
        int puntuacion = getIntent().getIntExtra("puntuacion", 0);
        String urlImagen = getIntent().getStringExtra("fotoUri");

        // Completar los campos con los datos actuales
        edtTitulo.setText(titulo);
        edtDescripcion.setText(descripcion);
        edtFechaEntrega.setText(fechaEntrega);
        sbPuntuacion.setProgress(puntuacion);
        urlCuadro.setText(urlImagen);

        // Configurar el clic para abrir el DatePickerDialog
        edtFechaEntrega.setOnClickListener(v -> showDatePickerDialog());

        // Configurar el botón Guardar
        btnGuardar.setOnClickListener(v -> {
            // Obtener los datos actualizados del formulario
            String nuevoTitulo = edtTitulo.getText().toString().trim();
            String nuevaDescripcion = edtDescripcion.getText().toString().trim();
            String nuevaFechaEntrega = edtFechaEntrega.getText().toString().trim();
            int nuevaPuntuacion = sbPuntuacion.getProgress();
            String nuevaUrlImagen = urlCuadro.getText().toString().trim();

            // Validar los campos
            if (nuevoTitulo.isEmpty() || nuevaDescripcion.isEmpty() || nuevaFechaEntrega.isEmpty()) {
                showCustomToast("Por favor, completa todos los campos.");
                return;
            }

            // Enviar datos de vuelta
            Intent resultIntent = new Intent();
            resultIntent.putExtra("titulo", nuevoTitulo);
            resultIntent.putExtra("descripcion", nuevaDescripcion);
            resultIntent.putExtra("fechaEntrega", nuevaFechaEntrega);
            resultIntent.putExtra("puntuacion", nuevaPuntuacion);
            resultIntent.putExtra("urlImagen", nuevaUrlImagen);
            setResult(RESULT_OK, resultIntent);
            finish();
        });

    }

    // Método para mostrar el DatePickerDialog
    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year1, month1, dayOfMonth) -> {
            String selectedDate = String.format("%02d/%02d/%04d", dayOfMonth, month1 + 1, year1);
            edtFechaEntrega.setText(selectedDate);
        }, year, month, day);

        datePickerDialog.show();
    }

    private void showCustomToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
