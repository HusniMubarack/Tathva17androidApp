package com.tathva17.tathva.tathva17;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;

import pl.droidsonroids.gif.GifTextView;

public class HomeFragment extends Fragment {
    private int i = 0;
    private ScrollView mainBodyScroll;
    private int x=0;

    private RecyclerViewPager topViewRVP;
    private TopViewRecyclerViewAdapter topViewAdapter;
    private ImageView treeImg;
    private RelativeLayout down;


    private String[] topTitles = {
            "tathva\'17 brings you",
            "60+ Events",
            "10 Workshops",
            "Lectures",
            "ProShows",
            "Adizya",
            "Blitzkrieg",
            "Aavishkaar",
            "Wheels",
            "Informals",
            "Exhibitions",
            "Merchandise"
    };


    private int[] topBgs = {
            R.drawable.brings,//
            R.drawable.events1,
            R.drawable.workshops,
            R.drawable.lectures,
            R.drawable.pronites,
            R.drawable.adizya,
            R.drawable.blitz,
            R.drawable.aavishkaar,
            R.drawable.wheels,
            R.drawable.informals_bg,//
            R.drawable.exhibitions,
            R.drawable.merchen

    };

    //dot view
    private Drawable NOT_SELECTED_IMAGE;
    private Drawable SELECTED_IMAGE;
    private int dotCount = 0;
    private ImageView[] dots;
    private int currentAutoScrollPage = 0;
    private LinearLayout dottedViewHolder;

    public static Runnable runnable;
    public static Handler handler;


    private GifTextView left;
    private GifTextView right;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.home_page, container, false);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

        setupHighlightView();



        final int speedScroll = 2000;
         handler = new Handler();
         runnable = new Runnable() {
            int count = 0;
            @Override
            public void run() {
                if(count <= topTitles.length){
                    topViewRVP.smoothScrollToPosition(count++);
                    handler.postDelayed(this,speedScroll);
                    if(count == topTitles.length)
                        count=0;
                }
            }
        };

        handler.postDelayed(runnable,speedScroll);




        ScrollView scrollView = (ScrollView) view.findViewById(R.id.home_body_holder);
        scrollView.setFocusableInTouchMode(true);
        scrollView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
    }


    private void initViews(View view) {
        mainBodyScroll = (ScrollView) view.findViewById(R.id.home_body_holder);
        topViewRVP = (RecyclerViewPager) view.findViewById(R.id.main_highlight_rvp);

        final TextView Maintitle = (TextView) view.findViewById(R.id.mainTitle);
        left = (GifTextView)view.findViewById(R.id.arrow1);
        right = (GifTextView)view.findViewById(R.id.arrow2);

        treeImg = (ImageView)view.findViewById(R.id.mainTreeImg);
        treeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Welcome to tathva17\nSwipe to explore", Toast.LENGTH_SHORT).show();
            }
        });

        down = (RelativeLayout)view.findViewById(R.id.down_arrow);
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Login to your tathva account for new updates", Toast.LENGTH_SHORT).show();
            }
        });


    }


    private void setupHighlightView() {
        topViewAdapter = new TopViewRecyclerViewAdapter(topTitles, topBgs, getActivity());
        topViewRVP.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        topViewRVP.setAdapter(topViewAdapter);
        i = 1;
    }


}
