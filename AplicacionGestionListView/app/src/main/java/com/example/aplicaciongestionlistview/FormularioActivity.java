package com.example.aplicaciongestionlistview;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class FormularioActivity extends AppCompatActivity {

    private EditText etTitulo, etDescripcion;
    private TextView etFechaEntrega;
    private SeekBar sbPuntuacion;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo);

        // Referenciar los elementos de la interfaz
        etTitulo = findViewById(R.id.etTitulo);
        etDescripcion = findViewById(R.id.etDescripcion);
        etFechaEntrega = findViewById(R.id.etFechaEntrega); // Ahora es TextView
        sbPuntuacion = findViewById(R.id.sbPuntuacion);
        btnGuardar = findViewById(R.id.btnGuardar);

        // Configurar el clic para abrir el DatePickerDialog
        etFechaEntrega.setOnClickListener(v -> showDatePickerDialog());

        // Configurar el botón Guardar
        btnGuardar.setOnClickListener(v -> {
            // Obtener los datos del formulario
            String titulo = etTitulo.getText().toString().trim();
            String descripcion = etDescripcion.getText().toString().trim();
            String fechaEntrega = etFechaEntrega.getText().toString().trim();
            int puntuacion = sbPuntuacion.getProgress();

            // Validar los campos
            if (titulo.isEmpty() || descripcion.isEmpty() || fechaEntrega.isEmpty()) {
                showCustomToast("Por favor, completa todos los campos.");
            } else {
                // Crear un Intent para enviar los datos de vuelta
                Intent resultIntent = new Intent();
                resultIntent.putExtra("titulo", titulo);
                resultIntent.putExtra("descripcion", descripcion);
                resultIntent.putExtra("fechaEntrega", fechaEntrega);
                resultIntent.putExtra("puntuacion", puntuacion);
                setResult(RESULT_OK, resultIntent);

                // Finalizar la actividad
                finish();
            }
        });
    }

    // Método para mostrar el DatePickerDialog
    private void showDatePickerDialog() {
        // Obtener la fecha actual como predeterminada
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Mostrar el DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year1, month1, dayOfMonth) -> {
            // Formatear la fecha seleccionada y mostrarla en el TextView
            String selectedDate = String.format("%02d/%02d/%04d", dayOfMonth, month1 + 1, year1);
            etFechaEntrega.setText(selectedDate);
        }, year, month, day);

        datePickerDialog.show();
    }
    private void showCustomToast(String message) {
        // Inflar el diseño del Toast
        View toastView = getLayoutInflater().inflate(R.layout.toast_pers, null);

        // Configurar el texto y el icono
        TextView toastMessage = toastView.findViewById(R.id.toastMessage);
        toastMessage.setText(message);

        ImageView toastIcon = toastView.findViewById(R.id.toastIcon);
        toastIcon.setImageResource(R.drawable.x); // Cambia el icono si es necesario

        // Crear el Toast personalizado
        Toast customToast = new Toast(getApplicationContext());
        customToast.setDuration(Toast.LENGTH_SHORT);
        customToast.setView(toastView);
        customToast.show();
    }
}
