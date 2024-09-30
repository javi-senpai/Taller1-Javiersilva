package com.example.taller10;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String surname;
    private String document;
    private String age;
    private String phone;
    private String address;
    private String birthdate;
    private String email;
    private String maritalStatus;
    private String gender;
    private String interests;
    private String footballTeam;
    private String favMovie;
    private String favColor;
    private String favComedy;
    private String favBook;
    private String favSong;
    private String description;

    // Constructor
    public User(int id, String name, String surname, String document, String age, String phone, String address,
                String birthdate, String email, String maritalStatus, String gender, String interests,
                String footballTeam, String favMovie, String favColor, String favComedy,
                String favBook, String favSong, String description) {
        this.id = ++idCounter; // Asignar el ID actual y luego incrementar
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.birthdate = birthdate;
        this.email = email;
        this.maritalStatus = maritalStatus;
        this.gender = gender;
        this.interests = interests;
        this.footballTeam = footballTeam;
        this.favMovie = favMovie;
        this.favColor = favColor;
        this.favComedy = favComedy;
        this.favBook = favBook;
        this.favSong = favSong;
        this.description = description;
    }

    // Parcelable implementation
    protected User(Parcel in) {
        id = in.readInt();
        name = in.readString();
        surname = in.readString();
        document = in.readString();
        age = in.readString();
        phone = in.readString();
        address = in.readString();
        birthdate = in.readString();
        email = in.readString();
        maritalStatus = in.readString();
        gender = in.readString();
        interests = in.readString();
        footballTeam = in.readString();
        favMovie = in.readString();
        favColor = in.readString();
        favComedy = in.readString();
        favBook = in.readString();
        favSong = in.readString();
        description = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeString(document);
        dest.writeString(age);
        dest.writeString(phone);
        dest.writeString(address);
        dest.writeString(birthdate);
        dest.writeString(email);
        dest.writeString(maritalStatus);
        dest.writeString(gender);
        dest.writeString(interests);
        dest.writeString(footballTeam);
        dest.writeString(favMovie);
        dest.writeString(favColor);
        dest.writeString(favComedy);
        dest.writeString(favBook);
        dest.writeString(favSong);
        dest.writeString(description);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDocument() {
        return document;
    }

    public String getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getEmail() {
        return email;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getGender() {
        return gender;
    }

    public String getInterests() {
        return interests;
    }

    public String getFootballTeam() {
        return footballTeam;
    }

    public String getFavMovie() {
        return favMovie;
    }

    public String getFavColor() {
        return favColor;
    }

    public String getFavComedy() {
        return favComedy;
    }

    public String getFavBook() {
        return favBook;
    }

    public String getFavSong() {
        return favSong;
    }

    public String getDescription() {
        return description;
    }
}
