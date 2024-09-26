package com.example.ud01_actividad_aprendizaje_01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        // Obtiene una referencia al botón definido en el archivo de diseño.
        Button btnWrite = findViewById(R.id.btnWrite);

        // Configura un listener para manejar el clic en el botón.
        btnWrite.setOnClickListener(v -> {
            // Crea un Intent para iniciar la SecondActivity.
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            // Inicia la SecondActivity.
            startActivity(intent);
            // Finaliza la MainActivity para que no se quede en la pila de actividades.
            finish();
        });
    }
}