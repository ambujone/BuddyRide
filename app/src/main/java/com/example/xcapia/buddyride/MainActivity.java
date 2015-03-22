package com.example.xcapia.buddyride;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.parse.Parse;

import java.util.ArrayList;
import java.util.logging.Handler;

public class MainActivity extends FragmentActivity implements
        ActionBar.TabListener {

    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    private static Intent nextActivity;
    private Thread thread;

    //private ListViewAdapter listAdapter;
    // Tab titles
    private String[] tabs = {"Passenger", "Driver"};

    public final static String EXTRA_MESSAGE = "com.example.xcapia.buddyride.MESSAGE";
    public boolean driverAvailableBool = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Parse.initialize(this, "zr2HukvgEeEEI8Mvvt7GLMvx4livd4iakcahv38U", "vgJTN8Mr9go48gHKAYU153z7Am0yHOv9uSqalQ42");
        super.onCreate(savedInstanceState);




        setContentView(R.layout.activity_main);
        TextView registerScreen = (TextView) findViewById(R.id.link_to_register);
        // Listening to register new account link
//        registerScreen.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Switching to Register screen
//                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
//                startActivity(i);
//                }
//            });

//        Button button = (Button)findViewById(R.id.driverAvailablity);
//
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }

        nextActivity = new Intent(this, DisplayMessageActivity.class);

        thread=  new Thread(){
            @Override
            public void run(){
                try {
                    synchronized(this){
                        wait(3000);
                    }
                }
                catch(InterruptedException ex){
                }

                // TODO
            }
        };

        thread.start();
        /**
         * on swiping the viewpager make respective tab selected
         * */
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    /** RENDER THE LIST VIEW OF DRIVERS AVAILABLE TO THE PASSANGER
     *  LOAD XML FROM FILE AND MAKE ONE EACH FOR HENRIK'S DATA*/
    public void sendMessage(View view) {
        //listAdapter = new ListViewAdapter(getSupportFragmentManager());

        //ListView drivers = (ListView) findViewById(R.id.listviewdrivers);

        if(false) {
            synchronized (thread) {
                thread.notifyAll();
            }
        }
        ScrollView passengerView = (ScrollView) findViewById(R.id.passengerView);
        passengerView.removeAllViews();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.passengerView, new ListViewFragment())
                .commit();
        //temp

    }

    public void driverAvailable(View view) {
        Button button = (Button)findViewById(R.id.driverButton);

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        // build notification
        // the addAction re-use the same intent to keep the example short
        Notification n  = new Notification.Builder(this)
                .setContentTitle("You're cruisin'")
                .setContentText("BuddyRide")
                .setSmallIcon(R.drawable.abc_ab_bottom_solid_dark_holo)
                .setContentIntent(pIntent)
                .setAutoCancel(false).setOngoing(true).build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if(driverAvailableBool) {
            button.setText("Let\'s Cruise");
            driverAvailableBool = false;
            notificationManager.cancel(0);
        } else {
            button.setText("Stop Cruising");
            driverAvailableBool = true;
            //<string name="button_driverOption">Available as a Driver</string>
            notificationManager.notify(0, n);
        }
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // on tab selected
        // show respected fragment view
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    }

    public class ListViewFragment extends Fragment {

        private ListView myListView;
        private ArrayList<MockUser> data;
        private FragmentActivity parent;
        private ArrayList<Card> cards;
        //private Intent nextActivity;

        public ListViewFragment() {
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            parent = this.getActivity();
            data = (new MockUsers()).getData();

            View rootView = inflater.inflate(R.layout.listview, container, false);
            myListView = (ListView) rootView.findViewById(R.id.card_listView);

            CardArrayAdapter cardArrayAdapter = new CardArrayAdapter(getApplicationContext(), R.layout.list_item_card);

            for(MockUser user : data) {
                Card card = new Card(user.getName(),user.getPhoneNumber(),user.getPhotoUrl(),user.getAvailableSeats(),user.getEta());
                cardArrayAdapter.add(card);
            }

            myListView.setAdapter(cardArrayAdapter);

            myListView.setOnItemClickListener(new
              AdapterView.OnItemClickListener() {
                  @Override
                  public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                      startActivity(nextActivity);
                  }
              });

            return rootView;
        }


    }

}
