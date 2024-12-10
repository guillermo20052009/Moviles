package com.example.aplicaciongestionlistview;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NuevoUsuario extends AppCompatActivity {

    private EditText etNombre, etContraseña;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevousuario);

        etNombre = findViewById(R.id.nombre);
        etContraseña = findViewById(R.id.contraseña);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(v -> guardarUsuario());
    }

    private void guardarUsuario() {
        String nombre = etNombre.getText().toString().trim();
        String contraseña = etContraseña.getText().toString().trim();

        if (TextUtils.isEmpty(nombre)) {
            mostrarToast("Por favor, introduce un nombre de usuario.");
            return;
        }
        if (TextUtils.isEmpty(contraseña)) {
            mostrarToast("Por favor, introduce una contraseña.");
            return;
        }

        // Devolver datos a la actividad principal
        Intent resultIntent = new Intent();
        resultIntent.putExtra("nombre", nombre);
        resultIntent.putExtra("contraseña", contraseña);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    private void mostrarToast(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
