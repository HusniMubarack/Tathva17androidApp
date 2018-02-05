package com.tathva17.tathva.tathva17.Other;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.tathva17.tathva.tathva17.R;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;

/**
 * Created by burgers on 7/10/17.
 */

public class exhibition_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exhibition_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Exhibitions");


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.exhibition_recycler_view);
        exhibition_adapter adapter = new exhibition_adapter(this, Exhibition.getObjectlist());
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
        alphaAdapter.setDuration(1000);
        recyclerView.setAdapter(alphaAdapter);
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
