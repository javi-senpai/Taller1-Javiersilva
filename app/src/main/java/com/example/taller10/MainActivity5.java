package com.example.taller10;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

    private EditText searchUserId, nameField, surnameField, documentField, ageField, phoneField, addressField, birthdateField, emailField;
    private User selectedUser;
    private ArrayList<User> usersList;
    private Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        searchUserId = findViewById(R.id.searchUserId);
        nameField = findViewById(R.id.nameField);
        surnameField = findViewById(R.id.surnameField);
        documentField = findViewById(R.id.documentField);
        ageField = findViewById(R.id.ageField);
        phoneField = findViewById(R.id.phoneField);
        addressField = findViewById(R.id.addressField);
        birthdateField = findViewById(R.id.birthdateField);
        emailField = findViewById(R.id.emailField);
        updateButton = findViewById(R.id.updateButton);
        Button searchButton = findViewById(R.id.searchButton);
        Button backButton = findViewById(R.id.backButton);


        enableFields(false);

        // Obtener la lista de usuarios pasada desde la actividad anterior
        usersList = getIntent().getParcelableArrayListExtra("usersList");

        // Cargar usuarios guardados desde el archivo
        loadUsersFromFile();


        searchButton.setOnClickListener(v -> searchUserById());


        updateButton.setOnClickListener(v -> updateUserData());


        backButton.setOnClickListener(v -> finish());
    }

    private void loadUsersFromFile() {
        // Cargar usuarios desde el archivo de texto
        ArrayList<User> savedUsers = FileManager.loadUsers(this);
        if (savedUsers != null) {
            usersList.addAll(savedUsers);
        }
    }

    private void searchUserById() {
        String idString = searchUserId.getText().toString();
        if (!idString.isEmpty()) {
            try {
                int userId = Integer.parseInt(idString);
                boolean userFound = false;

                for (User user : usersList) {
                    if (user.getId() == userId) {
                        selectedUser = user;
                        userFound = true;
                        loadUserData(user);
                        enableFields(true);
                        updateButton.setEnabled(true);
                        break;
                    }
                }

                if (!userFound) {
                    Toast.makeText(this, "Usuario no encontrado con el ID: " + userId, Toast.LENGTH_SHORT).show();
                    enableFields(false);
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Por favor ingrese un ID válido.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Por favor ingrese un ID válido.", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadUserData(User user) {
        // Cargar los datos del usuario en los campos de texto
        nameField.setText(user.getName());
        surnameField.setText(user.getSurname());
        documentField.setText(user.getDocument());
        ageField.setText(String.valueOf(user.getAge())); // Asegúrate de convertir a String
        phoneField.setText(user.getPhone());
        addressField.setText(user.getAddress());
        birthdateField.setText(user.getBirthdate());
        emailField.setText(user.getEmail());
    }

    private void updateUserData() {
        if (selectedUser != null) {
            // Actualizar los datos del usuario seleccionado
            selectedUser.setName(nameField.getText().toString());
            selectedUser.setSurname(surnameField.getText().toString());
            selectedUser.setDocument(documentField.getText().toString());
            selectedUser.setAge(ageField.getText().toString());
            selectedUser.setPhone(phoneField.getText().toString());
            selectedUser.setAddress(addressField.getText().toString());
            selectedUser.setBirthdate(birthdateField.getText().toString());
            selectedUser.setEmail(emailField.getText().toString());

            // Reemplazar el usuario en la lista de usuarios
            for (int i = 0; i < usersList.size(); i++) {
                if (usersList.get(i).getId() == selectedUser.getId()) {
                    usersList.set(i, selectedUser);
                    break;
                }
            }

            // Guardar la lista actualizada en el archivo
            FileManager.saveUsers(usersList, this);

            Toast.makeText(this, "Datos actualizados exitosamente.", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "No se ha seleccionado ningún usuario.", Toast.LENGTH_SHORT).show();
        }
    }

    private void enableFields(boolean enable) {

        nameField.setEnabled(enable);
        surnameField.setEnabled(enable);
        documentField.setEnabled(enable);
        ageField.setEnabled(enable);
        phoneField.setEnabled(enable);
        addressField.setEnabled(enable);
        birthdateField.setEnabled(enable);
        emailField.setEnabled(enable);
        updateButton.setEnabled(enable);
    }
}
