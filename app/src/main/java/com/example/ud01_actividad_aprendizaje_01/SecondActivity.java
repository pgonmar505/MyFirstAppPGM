package com.example.ud01_actividad_aprendizaje_01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtiene referencias a los campos de texto, interruptor y botones definidos en el archivo de diseño.
        EditText EtText = findViewById(R.id.Et1);
        EditText EtNumber1 = findViewById(R.id.Et2);
        EditText EtNumber2 = findViewById(R.id.Et3);

        Switch Sw1 = findViewById(R.id.Sw1);

        Button btnSend = findViewById(R.id.btnSend);
        Button btnCancel = findViewById(R.id.btnCancel);

// Configura un listener para manejar el clic en el botón de enviar.
        btnSend.setOnClickListener(v -> {
            // Verifica si el campo de texto está vacío y muestra un mensaje Toast si es así.
            if (EtText.getText().toString().isEmpty()) {
                Toast toastText = new Toast(SecondActivity.this);
                toastText.setText("Text can't be empty");
                toastText.show();
                // Verifica si el primer campo de número está vacío y muestra un mensaje Toast si es así.
            } else if (EtNumber1.getText().toString().isEmpty()) {
                Toast toastNumber1 = new Toast(SecondActivity.this);
                toastNumber1.setText("Number1 can't be empty");
                toastNumber1.show();
                // Verifica si el segundo campo de número está vacío y muestra un mensaje Toast si es así.
            } else if (EtNumber2.getText().toString().isEmpty()) {
                Toast toastNumber3 = new Toast(SecondActivity.this);
                toastNumber3.setText("Number2 can't be empty");
                toastNumber3.show();
            } else {
                // Si todos los campos tienen datos, crea un Intent para iniciar la ThirdActivity.
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);

                // Agrega los datos de los campos como extras en el Intent.
                intent.putExtra("text1", EtText.getText().toString());
                intent.putExtra("number1", EtNumber1.getText().toString());
                intent.putExtra("number2", EtNumber2.getText().toString());
                intent.putExtra("bool", Sw1.isChecked());

                // Inicia la ThirdActivity.
                startActivity(intent);
                // Finaliza la SecondActivity para que no se quede en la pila de actividades.
                finish();
            }
        });

// Configura un listener para manejar el clic en el botón de cancelar.
        btnCancel.setOnClickListener(v -> {
            // Crea un Intent para regresar a la MainActivity.
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            // Inicia la MainActivity.
            startActivity(intent);
            // Finaliza la SecondActivity para que no se quede en la pila de actividades.
            finish();
        });
    }
}
