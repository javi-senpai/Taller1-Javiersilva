package com.example.taller10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    private ArrayList<User> usersList;  // List of users
    private EditText userIdInput;
    private TextView userDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // Get lista de  MainActivity2
        usersList = getIntent().getParcelableArrayListExtra("usersList");

        userIdInput = findViewById(R.id.userIdInput);
        userDetails = findViewById(R.id.userDetails);

        Button searchButton = findViewById(R.id.searchButton);
        Button backButton = findViewById(R.id.backButton);


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchUserById();
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    private void searchUserById() {
        String idString = userIdInput.getText().toString();
        if (!idString.isEmpty()) {
            int id = Integer.parseInt(idString);
            boolean userFound = false;

            // buscar lista
            for (User user : usersList) {
                if (user.getId() == id) {
                    userFound = true;
                    userDetails.setText("ID: " + user.getId() + "\n" +
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
                    break;
                }
            }

            if (!userFound) {
                userDetails.setText("Usuario no encontrado con el ID: " + id);
            }
        } else {
            userDetails.setText("Por favor ingrese un ID válido.");
        }
    }
}
