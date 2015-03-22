package com.example.xcapia.buddyride;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.List;

/**
 * Created by filipt on 21/03/15.
 */
public class ListViewAdapter extends BaseAdapter {


    private List<MockUser> data;
    Context ctxt;
    LayoutInflater inflater;


    public ListViewAdapter(List<MockUser> data, Context ctxt) {
        this.data = data;
        this.ctxt = ctxt;
        inflater = (LayoutInflater)ctxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object getItem(int idx) {
       try {
           return data.get(idx);
       } catch (NullPointerException e) {
           return null;
       }

    }

    @Override
    public long getItemId(int n) {
        return n;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public View getView(int arg0, View view, ViewGroup vg) {

        if (view == null) {
            view = inflater.inflate(R.layout.driver_tab, vg, false);
        }

        MockUser cur = data.get(arg0);
        ImageView img = (ImageView)view.findViewById(R.id.imageView);
        img.setImageResource(R.drawable.octocat1);

        TextView name = (TextView)view.findViewById(R.id.textView3);
        TextView phone = (TextView)view.findViewById(R.id.textView4);
        TextView car = (TextView)view.findViewById(R.id.textView5);

        name.setText("Name: " + cur.getName());
        phone.setText("Phone: " + cur.getPhoneNumber());
        car.setText("Car Seats: " + cur.getAvailableSeats());

        return view;
    }
}
