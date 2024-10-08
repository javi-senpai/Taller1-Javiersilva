package com.example.taller10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    private ArrayList<User> usersList;  // Lista de usuarios
    private EditText userIdInput;
    private TextView userDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // Obtener la lista de usuarios desde MainActivity2
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
                intent.putParcelableArrayListExtra("updatedUsersList", usersList); // Pasar la lista actualizada
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<User> updatedUsersList = getIntent().getParcelableArrayListExtra("updatedUsersList");
        if (updatedUsersList != null) {
            usersList = updatedUsersList; // Actualizar la lista de usuarios
        }
    }

    private void searchUserById() {
        String idString = userIdInput.getText().toString();
        if (!idString.isEmpty()) {
            int id = Integer.parseInt(idString);
            boolean userFound = false;

            // Buscar en la lista
            for (User user : usersList) {
                if (user.getId() == id) {
                    userFound = true;
                    displayUserDetails(user);
                    break;
                }
            }


            if (!userFound) {
                userFound = readUserFromFile(id);
            }

            if (!userFound) {
                userDetails.setText("Usuario no encontrado con el ID: " + id);
            }
        } else {
            userDetails.setText("Por favor ingrese un ID válido.");
        }
    }

    private boolean readUserFromFile(int id) {
        String fileName = "user_" + id + ".txt"; // Nombre del archivo basado en el ID
        try {
            FileInputStream fis = openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
            br.close();

            // Procesar y mostrar los datos
            String[] userData = content.toString().split("\n");
            if (userData.length >= 15) {
                User user = new User(id, userData[0], userData[1], userData[2], userData[3],
                        userData[4], userData[5], userData[6], userData[7],
                        userData[8], userData[9], userData[10], userData[11],
                        userData[12], userData[13], userData[14], userData[15],
                        userData[16], userData[17]);
                displayUserDetails(user);
                return true; // Usuario encontrado
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error al leer el usuario desde el archivo: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    private void displayUserDetails(User user) {
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
    }
}
