package com.example.taller10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private ArrayList<User> usersList; // Lista de usuarios
    private RecyclerView usersRecyclerView;
    private UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        usersList = new ArrayList<>();

        // Obtener la lista
        ArrayList<User> newUsersList = getIntent().getParcelableArrayListExtra("usersList");
        if (newUsersList != null) {
            usersList.addAll(newUsersList); // Añadir los nuevos usuarios a la lista
        }

        // Cargar usuarios desde archivos
        loadUsersFromFiles();

        // Configurar RecyclerView
        usersRecyclerView = findViewById(R.id.usersRecyclerView);
        usersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        usersAdapter = new UsersAdapter(usersList);
        usersRecyclerView.setAdapter(usersAdapter);

        Button backButton = findViewById(R.id.volver);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity.class);
            intent.putParcelableArrayListExtra("updatedUsersList", usersList); // Pasar la lista actualizada
            startActivity(intent);
            finish();
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        // Obtener la lista actualizada de usuarios
        ArrayList<User> updatedUsersList = getIntent().getParcelableArrayListExtra("updatedUsersList");
        if (updatedUsersList != null) {
            usersList = updatedUsersList; // Actualizar la lista de usuarios
            usersAdapter.updateUsers(usersList); // Actualizar el adaptador
        }
    }


    private void loadUsersFromFiles() {
        for (int i = 1; ; i++) { // Suponiendo que los IDs empiezan en 1
            String fileName = "user_" + i + ".txt";
            try {
                FileInputStream fis = openFileInput(fileName);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader bufferedReader = new BufferedReader(isr);

                String name = bufferedReader.readLine();
                String surname = bufferedReader.readLine();
                String document = bufferedReader.readLine();
                String age = bufferedReader.readLine();
                String phone = bufferedReader.readLine();
                String address = bufferedReader.readLine();
                String birthdate = bufferedReader.readLine();
                String email = bufferedReader.readLine();
                String maritalStatus = bufferedReader.readLine();
                String gender = bufferedReader.readLine();
                String interests = bufferedReader.readLine();
                String footballTeam = bufferedReader.readLine();
                String favMovie = bufferedReader.readLine();
                String favColor = bufferedReader.readLine();
                String favComedy = bufferedReader.readLine();
                String favBook = bufferedReader.readLine();
                String favSong = bufferedReader.readLine();
                String description = bufferedReader.readLine();

                // Crear un nuevo objeto usuario y agregarlo a la lista
                User user = new User(i, name, surname, document, age, phone, address, birthdate, email,
                        maritalStatus, gender, interests, footballTeam, favMovie, favColor,
                        favComedy, favBook, favSong, description);
                usersList.add(user);

                bufferedReader.close();
            } catch (Exception e) {
                break;
            }
        }
    }
}
