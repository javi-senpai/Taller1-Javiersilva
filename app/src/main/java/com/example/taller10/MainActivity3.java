package com.example.taller10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        ArrayList<User> usersList = getIntent().getParcelableArrayListExtra("usersList");

        // ver lista
        LinearLayout layout = findViewById(R.id.userListLayout);


        if (usersList != null) {

            for (User user : usersList) {
                TextView userData = new TextView(this);
                userData.setText("ID: " + user.getId() + "\n" +
                        "Nombre: " + user.getName() + "\n" +
                        "Apellido: " + user.getSurname() + "\n" +
                        "Documento: " + user.getDocument() + "\n" +
                        "Edad: " + user.getAge() + "\n" +
                        "Teléfono: " + user.getPhone() + "\n" +
                        "Dirección: " + user.getAddress() + "\n" +
                        "Fecha de Nacimiento: " + user.getBirthdate() + "\n" +
                        "Email: " + user.getEmail() + "\n" +
                        "Estado Civil: " + user.getMaritalStatus() + "\n" +
                        "Género: " + user.getGender() + "\n" +
                        "Gustos: " + user.getInterests() + "\n" +
                        "Equipo de Fútbol Favorito: " + user.getFootballTeam() + "\n" +
                        "Película Favorita: " + user.getFavMovie() + "\n" +
                        "Color Favorito: " + user.getFavColor() + "\n" +
                        "Comedia Favorita: " + user.getFavComedy() + "\n" +
                        "Libro Favorito: " + user.getFavBook() + "\n" +
                        "Canción Favorita: " + user.getFavSong() + "\n" +
                        "Descripción: " + user.getDescription());

                // Add  layout
                layout.addView(userData);
            }
        } else {
            // Show a message if there are no users
            TextView noDataText = new TextView(this);
            noDataText.setText("No hay datos de usuarios.");
            layout.addView(noDataText);
        }


        Button backButton = findViewById(R.id.volver);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
