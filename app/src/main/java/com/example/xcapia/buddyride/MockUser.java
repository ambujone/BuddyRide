package com.example.xcapia.buddyride;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by hs on 21/03/15.
 */
public class MockUser implements Serializable {

    private int id,availableSeats;
    private String name,phoneNumber,photoUrl;
    private String eta;

    public MockUser(MockUser m) {
        this(m.getId(), m.getName(), m.getPhoneNumber(), m.getPhoneNumber(), m.getAvailableSeats(), m.getEta());
    }

    public MockUser(
            int id,
            String name,
            String phoneNumber,
            String photoUrl,
            int availableSeats,
            String eta
    ) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.photoUrl = photoUrl;
        this.availableSeats = availableSeats;
        this.eta = eta;
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

    public String getEta() {
        return eta;
    }
}
