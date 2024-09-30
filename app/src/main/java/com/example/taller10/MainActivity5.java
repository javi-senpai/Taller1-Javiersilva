package com.example.taller10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

    private EditText nameField, surnameField, documentField, ageField, phoneField, addressField, birthdateField, emailField;
    private int userId; // Para almacenar el ID del usuario a editar
    private static ArrayList<User> usersList; // Para almacenar la lista de usuarios

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        // Inicializar las vistas
        nameField = findViewById(R.id.nameField);
        surnameField = findViewById(R.id.surnameField);
        documentField = findViewById(R.id.documentField);
        ageField = findViewById(R.id.ageField);
        phoneField = findViewById(R.id.phoneField);
        addressField = findViewById(R.id.addressField);
        birthdateField = findViewById(R.id.birthdateField);
        emailField = findViewById(R.id.emailField);

        Button updateButton = findViewById(R.id.updateButton);
        Button backButton = findViewById(R.id.backButton);

        /*
        // Obtener el ID del usuario y la lista desde el intent
        userId = getIntent().getIntExtra("userId", -1);
        usersList = getIntent().getParcelableArrayListExtra("usersList");

        // Cargar los datos del usuario en los campos
        loadUserData();

        // Configurar los listeners de los botones
        updateButton.setOnClickListener(v -> updateUserData());
       */ backButton.setOnClickListener(v -> finish());/*
    }

    private void loadUserData() {
        if (usersList != null) {
            for (User user : usersList) {
                if (user.getId() == userId) {
                    nameField.setText(user.getName());
                    surnameField.setText(user.getSurname());
                    documentField.setText(user.getDocument());
                    ageField.setText(user.getAge());
                    phoneField.setText(user.getPhone());
                    addressField.setText(user.getAddress());
                    birthdateField.setText(user.getBirthdate());
                    emailField.setText(user.getEmail());
                    return; // Si se encuentra el usuario, salir del método
                }
            }
            Toast.makeText(this, "Usuario no encontrado.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No se encontraron usuarios.", Toast.LENGTH_SHORT).show();
        }
    }*/

   /* private void updateUserData() {
        if (usersList != null) {
            for (User user : usersList) {
                if (user.getId() == userId) {
                    // Actualizar los datos del usuario con los valores de entrada
                    user.setName(nameField.getText().toString());
                    user.setSurname(surnameField.getText().toString());
                    user.setDocument(documentField.getText().toString());
                    user.setAge(ageField.getText().toString());
                    user.setPhone(phoneField.getText().toString());
                    user.setAddress(addressField.getText().toString());
                    user.setBirthdate(birthdateField.getText().toString());
                    user.setEmail(emailField.getText().toString());

                    Toast.makeText(this, "Datos actualizados exitosamente.", Toast.LENGTH_SHORT).show();
                    finish(); // Cerrar esta actividad y regresar a la anterior
                    return;
                }
            }
            Toast.makeText(this, "Usuario no encontrado.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No se encontraron usuarios.", Toast.LENGTH_SHORT).show();
        }*/
    }
}

