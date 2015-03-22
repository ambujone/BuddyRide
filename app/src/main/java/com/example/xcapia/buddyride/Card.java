package com.example.xcapia.buddyride;

/**
 * Created by hs on 22/03/15.
*/
public class Card {
    private String name;
    private int vacantSeats;
    private String phonenumber;
    private String photoUrl;

    public Card(String name, String phonenumber, String photoUrl, int vacantSeats) {
        this.name = name;
        this.vacantSeats = vacantSeats;
        this.phonenumber = phonenumber;
        this.photoUrl = photoUrl;
    }


    public String getName() {
        return name;
    }

    public int getVacantSeats() { return vacantSeats; }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}