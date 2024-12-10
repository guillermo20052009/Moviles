package com.example.aplicaciongestionlistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class principla extends AppCompatActivity {

    sqlBDD dbHelper = new sqlBDD(this);
    private static final int REQUEST_CODE_NUEVO_USUARIO = 1;
    ArrayList<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        usuarios=dbHelper.getAllUsuarios();

        EditText editTextUsername = findViewById(R.id.editTextUsername);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);
        Button buttonAnadir = findViewById(R.id.buttonanadir);

        buttonLogin.setOnClickListener(v -> {
            String username = editTextUsername.getText().toString();
            String password = editTextPassword.getText().toString();

            if (isValidUser(username, password) != -1) {
                // Usuario válido, pasar el ID al MainActivity
                Intent launchIntent = new Intent(principla.this, MainActivity.class);
                launchIntent.putExtra("id_usuario", isValidUser(username, password)); // Pasamos el ID
                startActivity(launchIntent);
            } else {
                Toast.makeText(principla.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });


        buttonAnadir.setOnClickListener(v -> {
            Intent launchIntent = new Intent(principla.this, NuevoUsuario.class);
            startActivityForResult(launchIntent, REQUEST_CODE_NUEVO_USUARIO);
        });
    }
    private int isValidUser(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(username) && usuario.getContraseña().equals(password)) {
                return usuario.getId(); // Usuario válido
            }
        }
        return -1; // Usuario no encontrado
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_NUEVO_USUARIO && resultCode == RESULT_OK && data != null) {
            // Obtener datos del nuevo usuario
            String nuevoNombre = data.getStringExtra("nombre");
            String nuevaContraseña = data.getStringExtra("contraseña");

            if (nuevoNombre != null && nuevaContraseña != null) {
                Usuario usuario= new Usuario(nuevoNombre,nuevaContraseña);
                dbHelper.addUsuario(usuario);
                usuario.setId(dbHelper.getLastIdUsuario());
                usuarios.add(usuario);
                Toast.makeText(this, "Usuario añadido: " + nuevoNombre, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
