package com.example.taller10;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    public static ArrayList<User> getUsersList() {
        return usersList;
    }

    private static ArrayList<User> usersList = new ArrayList<>();
    private static int userIdCounter;

    // Nombre del archivo para guardar el contador de ID
    private static final String PREFS_NAME = "UserPrefs";
    private static final String USER_ID_COUNTER_KEY = "UserIdCounter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Obtener el contador de ID de SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        userIdCounter = sharedPreferences.getInt(USER_ID_COUNTER_KEY, 1); // Por defecto inicia en 1

        EditText nameField = findViewById(R.id.name);
        EditText surnameField = findViewById(R.id.surname);
        EditText documentField = findViewById(R.id.document);
        EditText ageField = findViewById(R.id.age);
        EditText phoneField = findViewById(R.id.phone);
        EditText addressField = findViewById(R.id.address);
        EditText birthdateField = findViewById(R.id.birthdate);
        EditText emailField = findViewById(R.id.email);
        RadioGroup maritalStatusGroup = findViewById(R.id.maritalStatus);
        RadioGroup genderGroup = findViewById(R.id.gender);
        CheckBox musicCheckbox = findViewById(R.id.music);
        CheckBox sportsCheckbox = findViewById(R.id.sports);
        CheckBox moviesCheckbox = findViewById(R.id.movies);
        CheckBox comedyCheckbox = findViewById(R.id.comedy);
        CheckBox travelCheckbox = findViewById(R.id.travel);
        CheckBox booksCheckbox = findViewById(R.id.books);
        Spinner footballTeamSpinner = findViewById(R.id.footballTeam);
        EditText favMovieField = findViewById(R.id.favMovie);
        EditText favColorField = findViewById(R.id.favColor);
        EditText favComedyField = findViewById(R.id.favComedy);
        EditText favBookField = findViewById(R.id.favBook);
        EditText favSongField = findViewById(R.id.favSong);
        EditText descriptionField = findViewById(R.id.description);

        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(v -> {
            String name = nameField.getText().toString();
            String surname = surnameField.getText().toString();
            String document = documentField.getText().toString();
            String age = ageField.getText().toString();
            String phone = phoneField.getText().toString();
            String address = addressField.getText().toString();
            String birthdate = birthdateField.getText().toString();
            String email = emailField.getText().toString();
            String maritalStatus = ((RadioButton) findViewById(maritalStatusGroup.getCheckedRadioButtonId())).getText().toString();
            String gender = ((RadioButton) findViewById(genderGroup.getCheckedRadioButtonId())).getText().toString();

            StringBuilder interests = new StringBuilder();
            if (musicCheckbox.isChecked()) interests.append("Música, ");
            if (sportsCheckbox.isChecked()) interests.append("Deporte, ");
            if (moviesCheckbox.isChecked()) interests.append("Cine, ");
            if (comedyCheckbox.isChecked()) interests.append("Comedia, ");
            if (travelCheckbox.isChecked()) interests.append("Viajes, ");
            if (booksCheckbox.isChecked()) interests.append("Libros, ");

            String footballTeam = footballTeamSpinner.getSelectedItem().toString();
            String favMovie = favMovieField.getText().toString();
            String favColor = favColorField.getText().toString();
            String favComedy = favComedyField.getText().toString();
            String favBook = favBookField.getText().toString();
            String favSong = favSongField.getText().toString();
            String description = descriptionField.getText().toString();

            // Crear nuevo objeto usuario con id
            User newUser = new User(userIdCounter++, name, surname, document, age, phone, address,
                    birthdate, email, maritalStatus, gender, interests.toString(),
                    footballTeam, favMovie, favColor, favComedy, favBook, favSong, description);

            // Añadir a ArrayList
            usersList.add(newUser);

            // Guardar el nuevo ID en SharedPreferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(USER_ID_COUNTER_KEY, userIdCounter);
            editor.apply();

            // Guardar datos del usuario en un archivo
            saveUserToFile(newUser);

            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            intent.putParcelableArrayListExtra("usersList", (ArrayList<? extends Parcelable>) usersList);
            startActivity(intent);
        });
    }

    private void saveUserToFile(User user) {
        String fileName = "user_" + user.getId() + ".txt";
        try {
            FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write(user.getName() + "\n" + user.getSurname() + "\n" + user.getDocument() + "\n" +
                    user.getAge() + "\n" + user.getPhone() + "\n" + user.getAddress() + "\n" +
                    user.getBirthdate() + "\n" + user.getEmail() + "\n" + user.getMaritalStatus() + "\n" +
                    user.getGender() + "\n" + user.getInterests() + "\n" + user.getFootballTeam() + "\n" +
                    user.getFavMovie() + "\n" + user.getFavColor() + "\n" + user.getFavComedy() + "\n" +
                    user.getFavBook() + "\n" + user.getFavSong() + "\n" + user.getDescription());
            osw.close();
        } catch (Exception e) {
            Toast.makeText(this, "Error al guardar usuario: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
