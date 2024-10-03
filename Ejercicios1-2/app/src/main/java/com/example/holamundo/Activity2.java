package com.example.holamundo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.i("EJEMPLO", "Estoy en onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("EJEMPLO", "Estoy en onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("EJEMPLO", "Estoy en onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("EJEMPLO", "Estoy en onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("EJEMPLO", "Estoy en onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("EJEMPLO", "Estoy en onDestroy");

    }

}