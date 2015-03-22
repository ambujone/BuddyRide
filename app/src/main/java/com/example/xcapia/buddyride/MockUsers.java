package com.example.xcapia.buddyride;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hs on 21/03/15.
 */
public class MockUsers {

    private int counter = 0;

    private ArrayList<MockUser> userlist = new ArrayList<MockUser>();

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public MockUsers() {

        this.userlist.add(new MockUser(1,"Rene Birkeland","123456789","http://i.imgur.com/18Ez95B.jpg", 4));
        this.userlist.add(new MockUser(2,"Yoachim Levey","123456789","http://i.imgur.com/4DlYHcS.jpg", 3));
        this.userlist.add(new MockUser(3,"Ilayda Çoruk","123456789","http://i.imgur.com/AfdXeUj.jpg", 4));

    }

    public MockUser next() {
        MockUser user = this.userlist.get(this.counter++);
        //VERY BAD
        //this.counter = this.counter + 1;
        return user;
    }

    public void reset() {
        this.counter = 0;
    }

    public boolean hasNext() {
        try {
            MockUser foo = userlist.get(this.counter);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public ArrayList<MockUser> getData() {
        return userlist;
    }

}
