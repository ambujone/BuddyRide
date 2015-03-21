package com.example.xcapia.buddyride;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.parse.Parse;
import com.facebook.Session;

public class MainActivity extends FragmentActivity implements
        ActionBar.TabListener {

    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    // Tab titles
    private String[] tabs = {"Passenger", "Driver"};

    public final static String EXTRA_MESSAGE = "com.example.xcapia.buddyride.MESSAGE";
    public boolean driverAvailableBool = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Parse.initialize(this, "zr2HukvgEeEEI8Mvvt7GLMvx4livd4iakcahv38U", "vgJTN8Mr9go48gHKAYU153z7Am0yHOv9uSqalQ42");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        MockUsers mu = new MockUsers();
        while(mu.hasNext()) {
            Log.d("MOCK USER:", mu.next().);
        }*/


//        Button button = (Button)findViewById(R.id.driverAvailablity);
//
//        button.setOnClickListener(
//                new Button.OnClickListener() {
//                    public void onClick(View v) {
//                        if(driverAvailableBool)
//                            driverAvailableBool = false;
//                        else
//                            driverAvailableBool = true;
//                    }
//                }
//        );

//        final Button button = (Button) findViewById(R.id.driverAvailablity);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                        if(driverAvailableBool)
//                            driverAvailableBool = false;
//                        else
//                            driverAvailableBool = true;
//                    }
//            }
//        );

        // Initilization
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

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    public void driverAvailable(View view) {
        Button button = (Button)findViewById(R.id.driverButton);

        if(driverAvailableBool) {
            driverAvailableBool = false;
            button.setText("Set unavailable for drive");
        }

        else {
            driverAvailableBool = true;
            //<string name="button_driverOption">Available as a Driver</string>
            button.setText("Set available for drive");
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
}
