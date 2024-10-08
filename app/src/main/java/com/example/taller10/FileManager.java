package com.example.taller10;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class FileManager {
    private static final String FILE_NAME = "users.txt"; // Nombre del archivo

    // Método para guardar la lista de usuarios en un archivo
    public static void saveUsers(ArrayList<User> usersList, Context context) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE)))) {
            for (User user : usersList) {
                writer.write(userToString(user));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  cargar la lista de usuarios desde un archivo
    public static ArrayList<User> loadUsers(Context context) {
        ArrayList<User> usersList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(context.openFileInput(FILE_NAME)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                usersList.add(stringToUser(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usersList;
    }


    private static String userToString(User user) {
        return user.getId() + "," +
                user.getName() + "," +
                user.getSurname() + "," +
                user.getDocument() + "," +
                user.getAge() + "," +
                user.getPhone() + "," +
                user.getAddress() + "," +
                user.getBirthdate() + "," +
                user.getEmail() + "," +
                user.getMaritalStatus() + "," +
                user.getGender() + "," +
                user.getInterests() + "," +
                user.getFootballTeam() + "," +
                user.getFavMovie() + "," +
                user.getFavColor() + "," +
                user.getFavComedy() + "," +
                user.getFavBook() + "," +
                user.getFavSong() + "," +
                user.getDescription();
    }

    private static User stringToUser(String userString) {
        String[] data = userString.split(","); // Dividir la cadena en partes
        return new User(
                Integer.parseInt(data[0]), // ID
                data[1], // Nombre
                data[2], // Apellido
                data[3], // Documento
                data[4], // Edad
                data[5], // Teléfono
                data[6], // Dirección
                data[7], // Fecha de nacimiento
                data[8], // Email
                data[9], // Estado civil
                data[10], // Género
                data[11], // Intereses
                data[12], // Equipo de fútbol
                data[13], // Película favorita
                data[14], // Color favorito
                data[15], // Comedia favorita
                data[16], // Libro favorito
                data[17], // Canción favorita
                data[18] // Descripción
        );
    }


}
