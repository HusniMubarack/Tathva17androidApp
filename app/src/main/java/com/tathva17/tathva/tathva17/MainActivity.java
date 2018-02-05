package com.tathva17.tathva.tathva17;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;
import com.tathva17.tathva.tathva17.Other.Proshows;
import com.tathva17.tathva.tathva17.Other.exhibition_main;
import com.tathva17.tathva.tathva17.Other.lecture_main_activity;
import com.tathva17.tathva.tathva17.Other.workshop_main;


public class MainActivity extends AppCompatActivity {

//    private AHBottomNavigationViewPager mainViewPager;
////    private AHBottomNavigation bottomNavigation;
////
//    private MainViewPagerAdapter adapter;

    private ResideMenu resideMenu;
    private Context mContext;
    private ResideMenuItem itemHome;
    private ResideMenuItem itemProfile;
    private ResideMenuItem itemEvents;
    private ResideMenuItem itemNavigation;
    private ResideMenuItem itemAbout;
    private ResideMenuItem itemWorkshops;
    private ResideMenuItem itemLectures;
    private ResideMenuItem itemExhibitions;
    private ResideMenuItem itemProshows;

    private ImageView left;
    private ImageView right;
    private Fragment mainfragment;
    private Intent mIntent;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();
        left= (ImageView)findViewById(R.id.btn_left_arrow);
        right = (ImageView)findViewById(R.id.btn_right_arrow);

        setUpMenu();




//        mainViewPager = (AHBottomNavigationViewPager) findViewById(R.id.main_fragment);
//        adapter = new MainViewPagerAdapter(getSupportFragmentManager());
//        setupViewPager();

//        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
//        setupBottomBar();

    }




    private void setUpMenu() {

        // attach to current activity;
        resideMenu = new ResideMenu(this);

        resideMenu.setBackground(R.drawable.menu_background);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);
        //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip.
        resideMenu.setScaleValue(0.6f);

        // create menu items;
        itemHome     = new ResideMenuItem(this, R.drawable.home_tab,     "Home");
        itemProfile  = new ResideMenuItem(this, R.drawable.profile_tab,  "Profile");
        itemEvents   = new ResideMenuItem(this,R.drawable.event_tab, "Events");
        itemAbout   = new ResideMenuItem(this,R.drawable.about_tab, "About");
        itemNavigation = new ResideMenuItem(this,R.drawable.map_tab, "Navigation");
        itemLectures = new ResideMenuItem(this,R.drawable.ic_lectures,"Lectures");
        itemWorkshops = new ResideMenuItem(this,R.drawable.ic_workshops,"Workshops");
        itemProshows = new ResideMenuItem(this,R.drawable.ic_proshows,"Proshows");
        itemExhibitions = new ResideMenuItem(this,R.drawable.ic_exhibitions,"Exhibitions");

        itemHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainfragment = new HomeFragment();
                changeFragment(mainfragment);
                resideMenu.closeMenu();
                i = 0;
                left.setVisibility(View.GONE);
                right.setVisibility(View.GONE);

            }
        });

        itemEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainfragment = new EventFragment();
                changeFragment(mainfragment);
                resideMenu.closeMenu();
                i=1;
                left.setVisibility(View.VISIBLE);
                right.setVisibility(View.VISIBLE);

            }
        });

        itemAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainfragment = new AboutFragment();
                changeFragment(mainfragment);
                resideMenu.closeMenu();
                i=1;
                left.setVisibility(View.VISIBLE);
                right.setVisibility(View.VISIBLE);
            }
        });

        itemNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainfragment = new MapFragment();
                changeFragment(mainfragment);
                resideMenu.closeMenu();
                i=1;
                left.setVisibility(View.VISIBLE);
                right.setVisibility(View.VISIBLE);
            }
        });

        itemLectures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(getApplicationContext(),lecture_main_activity.class);
                resideMenu.closeMenu();
                startActivity(mIntent);

            }
        });

        itemWorkshops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(getApplicationContext(),workshop_main.class);
                startActivity(mIntent);
                resideMenu.closeMenu();
            }
        });
        itemProshows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(getApplicationContext(), Proshows.class);
                resideMenu.closeMenu();
                startActivity(mIntent);

            }
        });
        itemExhibitions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(getApplicationContext(), exhibition_main.class);
                resideMenu.closeMenu();
                startActivity(mIntent);
            }
        });




        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    itemProfile.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mainfragment = new ProfileFragment();
                            changeFragment(mainfragment);
                            resideMenu.closeMenu();
                            i=1;

                            left.setVisibility(View.VISIBLE);
                            right.setVisibility(View.VISIBLE);
                        }
                    });


                } else {
                    itemProfile.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mainfragment = new LoginFragment();
                            changeFragment(mainfragment);
                            resideMenu.closeMenu();
                            i=1;
                            left.setVisibility(View.GONE);
                            right.setVisibility(View.GONE);
                        }
                    });
                }
            }
        };

        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemProfile, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemAbout, ResideMenu.DIRECTION_LEFT);


        resideMenu.addMenuItem(itemEvents,ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemWorkshops,ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemLectures,ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemProshows,ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemExhibitions,ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemNavigation,ResideMenu.DIRECTION_RIGHT);





        // You can disable a direction by setting ->
        // resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);

        ((ImageView)findViewById(R.id.btn_left_arrow)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
        ((ImageView)findViewById(R.id.btn_right_arrow)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
            }
        });

        mainfragment = new HomeFragment();
        changeFragment(mainfragment);
        left.setVisibility(View.GONE);
        right.setVisibility(View.GONE);

        firstRunCheck();

    }

    @Override
    public void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthStateListener);

    }


    @Override
    protected void onStop() {
        super.onStop();
        if(mAuthStateListener != null){
            mAuth.removeAuthStateListener(mAuthStateListener);
        }
    }

    @Override
    public void onBackPressed() {
        if(i==0){
//            if(mAuthStateListener != null){
//                mAuth.removeAuthStateListener(mAuthStateListener);
//            }
//            super.onBackPressed();
//            System.exit(0);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Exit Application?");
            alertDialogBuilder
                    .setMessage("Click yes to exit!")
                    .setCancelable(false)
                    .setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    moveTaskToBack(true);
                                    android.os.Process.killProcess(android.os.Process.myPid());
                                    System.exit(1);
                                }
                            })

                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            dialog.cancel();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();


        }
        else {
            mainfragment = new HomeFragment();
            changeFragment(mainfragment);
            i=0;
            left.setVisibility(View.GONE);
            right.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
        }

        @Override
        public void closeMenu() {
            //  Toast.makeText(mContext, "Menu is closed!", Toast.LENGTH_SHORT).show();
        }
    };


public void firstRunCheck(){
    SharedPreferences runCheck = getSharedPreferences("hasRunBefore", 0); //load the preferences
    Boolean hasRun = runCheck.getBoolean("hasRun", false); //see if it's run before, default no
    if (!hasRun) {


        SharedPreferences settings = getSharedPreferences("hasRunBefore", 0);
        Toast.makeText(this,"welcome to tathva \n Swipe left to sign in", Toast.LENGTH_LONG).show();
        SharedPreferences.Editor edit = settings.edit();
        edit.putBoolean("hasRun", true); //set to has run
        edit.commit(); //apply
        //code for if this is the first time the app has run
    }
    else {
        //code if the app HAS run before
    }
}


    private void changeFragment(Fragment targetFragment){
        resideMenu.clearIgnoredViewList();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, targetFragment, "fragment")
                .commit();
    }

    public ResideMenu getResideMenu() {
        return resideMenu;
    }
}
