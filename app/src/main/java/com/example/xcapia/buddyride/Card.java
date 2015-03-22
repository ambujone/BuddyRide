package com.example.xcapia.buddyride;

/**
 * Created by hs on 22/03/15.
*/
public class Card {
    private String name;
    private int vacantSeats;
    private String phonenumber;
    private String photoUrl;
    private String eta;

    public Card(String name, String phonenumber, String photoUrl, int vacantSeats, String eta) {
        this.name = name;
        this.vacantSeats = vacantSeats;
        this.phonenumber = phonenumber;
        this.photoUrl = photoUrl;
        this.eta = eta;

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

    public String getEta() {
        return eta;
    }
}