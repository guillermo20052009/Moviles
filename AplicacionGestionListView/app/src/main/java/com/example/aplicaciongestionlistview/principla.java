package com.example.aplicaciongestionlistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class principla extends AppCompatActivity {
    private HashMap<String, String> userDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        // Inicializamos el HashMap con los usuarios y contraseñas
        userDatabase = new HashMap<>();
        populateUserDatabase();

        EditText editTextUsername = findViewById(R.id.editTextUsername);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                if (isValidUser(username, password)) {
                    // Intent para abrir otra aplicación
                    Intent launchIntent = new Intent(principla.this, MainActivity.class);
                    if (launchIntent != null) {
                        startActivity(launchIntent);
                    } else {
                        Toast.makeText(principla.this, "No se encontró la aplicación a abrir", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Mostrar un Toast si las credenciales son incorrectas
                    Toast.makeText(principla.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Método para inicializar el HashMap con 10 ejemplos
    private void populateUserDatabase() {
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
        userDatabase.put("user3", "password3");
        userDatabase.put("user4", "password4");
        userDatabase.put("user5", "password5");
        userDatabase.put("user6", "password6");
        userDatabase.put("user7", "password7");
        userDatabase.put("user8", "password8");
        userDatabase.put("user9", "password9");
        userDatabase.put("user10", "password10");
        userDatabase.put("a", "a");

    }

    // Verificar si las credenciales son válidas
    private boolean isValidUser(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }
}
