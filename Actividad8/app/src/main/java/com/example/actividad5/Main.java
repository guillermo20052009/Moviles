package com.example.actividad5;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void abrirCamara(View view) {
        // Configurar la Intent para iniciar la actividad deseada (puedes ajustar la clase destino)
        Intent intent = new Intent(this, TuClaseDestino.class); // Reemplaza "TuClaseDestino" con la actividad a abrir
        // Crear el PendingIntent
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Obtener el servicio de AlarmManager
        AlarmManager alarma = (AlarmManager) getSystemService(ALARM_SERVICE);
        // Establecer la alarma para que se active después de cierto tiempo (en milisegundos)
        long triggerTime = System.currentTimeMillis() + 5000; // Aquí espera 5 segundos antes de activarse
        // Configurar la alarma para activarse a la hora especificada
        alarma.set(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
    }
}