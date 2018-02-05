package com.tathva17.tathva.tathva17.Other;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.tathva17.tathva.tathva17.R;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;


public class lecture_main_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lecture_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Lectures");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lec_recycler_view);


        lecture_adapter adapter = new lecture_adapter(this, Lecturer.getObjectlist());
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
        alphaAdapter.setDuration(1000);
        recyclerView.setAdapter(alphaAdapter);
        //recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
