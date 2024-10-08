package com.example.taller10;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    private ArrayList<User> usersList;

    public UsersAdapter(ArrayList<User> usersList) {
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = usersList.get(position);
        holder.userDetails.setText("ID: "+ user.getId());
        holder.userName.setText(user.getName() + " " + user.getSurname());
        holder.userDocument.setText("Documento: " + user.getDocument());

        // Mostrar más detalles en una sola línea o usa otro TextView si necesitas más espacio
        holder.userDetails.setText("Edad: " + user.getAge() + ", Teléfono: " + user.getPhone() + ", Direccion: " + user.getAddress() + ", Fecha de nacimiento "+ user.getBirthdate()+ ", correo: "+ user.getEmail() + ", Estado Civil: " + user.getMaritalStatus() + ", Genero:" + user.getGender() +",  Equipo Favorito:"+ user.getFootballTeam() +", Pelicula Favorita: " + user.getFavMovie() + ", Color Favorito:" + user.getFavColor() + ", Libro Favorita: " + user.getFavBook() + ", Cancion Favorita: " + user.getFavSong() + ", Descripción: " + user.getDescription());
    }

    @Override
    public int getItemCount() {
        return usersList != null ? usersList.size() : 0;
    }

    // Método para actualizar la lista de usuarios
    public void updateUsers(ArrayList<User> updatedUsersList) {
        this.usersList = updatedUsersList;
        notifyDataSetChanged(); // Notificar que los datos han cambiado
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView userDocument;
        TextView userDetails;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName);
            userDocument = itemView.findViewById(R.id.userDocument);
            userDetails = itemView.findViewById(R.id.userDetails);
        }
    }
}
