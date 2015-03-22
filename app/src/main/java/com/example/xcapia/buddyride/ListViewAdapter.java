package com.example.xcapia.buddyride;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by filipt on 21/03/15.
 */
public class ListViewAdapter extends BaseAdapter {

    private List<MockUser> data;
    private Context ctxt;
    private LayoutInflater inflater;
    //private ImageLoader loader;

    private void loadBackupOctocat(ImageView img) {
        System.err.print("Failed to load image from INet");
        img.setImageResource(R.drawable.octocat1);
    }

    public ListViewAdapter(List<MockUser> data, Context ctxt) {
        this.data = data;
        this.ctxt = ctxt;
        inflater = (LayoutInflater)ctxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //loader = new ImageLoader();
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

        try {
            UrlImageViewHelper.setUrlDrawable(img, cur.getPhotoUrl());
        } catch (NullPointerException e) {
            loadBackupOctocat(img);
        }

        TextView name = (TextView)view.findViewById(R.id.textView3);
        TextView phone = (TextView)view.findViewById(R.id.textView4);
        TextView car = (TextView)view.findViewById(R.id.textView5);

        name.setText("Name: " + cur.getName());
        phone.setText("Phone: " + cur.getPhoneNumber());
        car.setText("Car Seats: " + cur.getAvailableSeats());

        return view;
    }
}
