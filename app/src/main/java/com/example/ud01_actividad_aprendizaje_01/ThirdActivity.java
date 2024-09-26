package com.example.ud01_actividad_aprendizaje_01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtiene referencias a los TextViews, interruptor y botón definidos en el archivo de diseño.
        TextView Tv4 = findViewById(R.id.TvText);
        TextView Tv5 = findViewById(R.id.TvNumber1);
        TextView Tv6 = findViewById(R.id.TvNumber2);

        Switch Sw2 = findViewById(R.id.Sw2);

        Button btnVolver = findViewById(R.id.btnBack);

// Configura un listener para manejar el clic en el botón de volver.
        btnVolver.setOnClickListener(v -> {
            // Crea un Intent para regresar a la MainActivity.
            Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
            // Inicia la MainActivity.
            startActivity(intent);
            // Finaliza la ThirdActivity para que no se quede en la pila de actividades.
            finish();
        });

// Obtiene el Intent que inició esta actividad y recupera los extras enviados desde la SecondActivity.
        Intent intent = getIntent();

// Recupera los datos enviados desde la SecondActivity y formatea las cadenas para mostrarlas en los TextViews.
        String text1 = "Nombre completo:  " + intent.getStringExtra("text1");
        String number1 = "Edad:  " + intent.getStringExtra("number1");
        String number2 = "Altura (metros):  " + intent.getStringExtra("number2");

// Recupera el valor del Switch (booleano) enviado desde la SecondActivity.
        boolean bool = intent.getBooleanExtra("bool", false);

// Establece el texto de los TextViews con los datos recuperados.
        Tv4.setText(text1);
        Tv5.setText(number1);
        Tv6.setText(number2);

// Configura el estado del Switch según el valor booleano recuperado.
        Sw2.setChecked(bool);
    }
}