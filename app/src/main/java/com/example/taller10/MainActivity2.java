package com.example.taller10;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    public static ArrayList<User> getUsersList() {
        return usersList;
    }



    private static ArrayList<User> usersList = new ArrayList<>();
    private int userIdCounter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


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


            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            intent.putParcelableArrayListExtra("usersList", (ArrayList<? extends Parcelable>) usersList);
            startActivity(intent);

        });
    }
}
