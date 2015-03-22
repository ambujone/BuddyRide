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

        this.userlist.add(new MockUser(1,"Rene Birkeland","07448378204","http://i.imgur.com/18Ez95B.jpg", 4, "12 min"));
        this.userlist.add(new MockUser(2,"Yoachim Levey","123456789","http://i.imgur.com/4DlYHcS.jpg", 3, "18 min"));
        this.userlist.add(new MockUser(3,"Ilayda Çoruk","123456789","http://i.imgur.com/AfdXeUj.jpg", 4, "21 min"));
        this.userlist.add(new MockUser(4,"Catherine Sanft","123456789","http://i.imgur.com/0clAEfw.jpg", 2, "27 min"));
        this.userlist.add(new MockUser(5,"Ben Steer","123456789","http://i.imgur.com/WL5QA4e.jpg", 3,"30 min"));
        this.userlist.add(new MockUser(6,"Ivan Tan","123456789","http://i.imgur.com/MA1WYqi.jpg", 3, "31 min"));

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
