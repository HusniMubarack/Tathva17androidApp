package com.tathva17.tathva.tathva17;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by VRUSHABH on 19-10-2016.
 */

public class MapFragment extends Fragment {

    private RecyclerView placeList;
    private EventRecyclerViewAdapter adapter;
    private ArrayList<String> places = new ArrayList<String>();
    private ArrayList<Double> lats = new ArrayList<Double>();
    private ArrayList<Double> lngs = new ArrayList<Double>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.map_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        placeList = (RecyclerView) view.findViewById(R.id.map_list);
        String str = DatabaseLoader.loadJSONFromAsset(getActivity(), "locations");
        try {
            JSONArray array = new JSONArray(str);
            for (int i = 0; i < array.length(); ++i) {
                JSONArray m = array.getJSONArray(i);
                places.add(i, m.getString(0));
                lats.add(i, Double.parseDouble(m.getString(1)));
                lngs.add(i, Double.parseDouble(m.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        adapter = new EventRecyclerViewAdapter(places, getActivity());
        placeList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        placeList.setAdapter(adapter);
        placeList.addOnItemTouchListener(new RecyclerViewItemClickListener(getActivity(), new RecyclerViewItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                double des_lat = lats.get(position);
                double des_ltg = lngs.get(position);
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=" + des_lat + "," + des_ltg));
                    intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }));
    }
}
