package com.example.xcapia.buddyride;

/**
 * Created by hs on 21/03/15.
 */
public class MockUser {

    private int id,availableSeats;
    private String name,phoneNumber,photoUrl;

    public MockUser(
            int id,
            String name,
            String phoneNumber,
            String photoUrl,
            int availableSeats
    ) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.photoUrl = photoUrl;
        this.availableSeats = availableSeats;
    }

    public int getId() {
        return id;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
