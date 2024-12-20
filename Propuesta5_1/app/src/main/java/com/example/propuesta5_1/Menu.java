package com.example.propuesta5_1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.menu), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onButtonClick1(View view) {
        Log.i("EJEMPLO", "Boton pulsado");
        Intent ejemplo = new Intent(this, MainActivity.class);
        startActivity(ejemplo);
    }

    public void onButtonClick2(View view) {
        Log.i("EJEMPLO", "Boton pulsado");
        Intent ejemplo = new Intent(this, MainActivity2.class);
        startActivity(ejemplo);
    }

    public void onButtonClick3(View view) {
        Log.i("EJEMPLO", "Boton pulsado");
        Intent ejemplo = new Intent(this, MainActivity3.class);
        startActivity(ejemplo);
    }

    public void onButtonClick4(View view) {
        Log.i("EJEMPLO", "Boton pulsado");
        Intent ejemplo = new Intent(this, MainActivity4.class);
        startActivity(ejemplo);
    }
}

