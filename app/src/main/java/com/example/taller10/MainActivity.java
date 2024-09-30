package com.example.taller10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

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

        Button buttonIngresar = findViewById(R.id.ingresar);
        buttonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        Button buttonbuscar = findViewById(R.id.buscar);
        buttonbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity4.class);
                intent.putParcelableArrayListExtra("usersList", MainActivity2.getUsersList());  // Pasar la lista
                startActivity(intent);
            }
        });

        Button buttonModificar = findViewById(R.id.modificar); // Asegúrate de que este ID exista en tu XML
        buttonModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int userIdToModify = 1;

                // Obtener la lista de usuarios para pasarla a la nueva actividad
                ArrayList<User> usersList = MainActivity2.getUsersList(); // Método para obtener la lista de usuarios

                Intent intent = new Intent(MainActivity.this, MainActivity5.class);
                intent.putExtra("userId", userIdToModify); // Pasar el ID del usuario
                intent.putExtra("usersList", usersList); // Pasar la lista de usuarios
                startActivity(intent);
            }
        });

        Button buttonCalculadora = findViewById(R.id.calculadora);
        buttonCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity6.class);
                startActivity(intent);
            }
        });

    }
}