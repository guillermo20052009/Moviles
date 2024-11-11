package com.example.ex2ev1guillermonbarcenalopez;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {
    String[] opciones = {"APPLE PIE","BANANA BREAD","CUPCAKE","DONUT","ECLAIR","FROYO",
            "GINGERBREAD","HONEYCOMB","ICE CREAM SANDWICH","JELLY BEAN","KITKAT","LOLLIPOP",
            "MARSHMALLOW","NOUGAT","OREO","PIE","ANDROID 10"};
    AutoCompleteTextView cuadroTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        cuadroTexto=(AutoCompleteTextView) findViewById(R.id.cuadro);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,opciones);
        cuadroTexto.setAdapter(adaptador);

    }
}