package com.example.propuesta55;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView textViewSelectedDay;
    private RadioGroup radioGroupDays;
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
        textViewSelectedDay = findViewById(R.id.textViewSelectedDay);
        radioGroupDays = findViewById(R.id.radioGroupDays);

        // Listener para el RadioGroup
        radioGroupDays.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Obtiene el RadioButton seleccionado
                RadioButton selectedRadioButton = findViewById(checkedId);
                String selectedDay = selectedRadioButton.getText().toString();
                // Actualiza el TextView según el día seleccionado
                    textViewSelectedDay.setText("Sábado pulsado");

                    textViewSelectedDay.setText(selectedDay);

            }
        });
    }

}