package com.tathva17.tathva.tathva17;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tathva17.tathva.tathva17.EventsData.EventsDetailsActivity;
import com.vrjco.v.vtextview.VTextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by VRUSHABH on 09-10-2016.
 */
public class EventFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.event_page, container, false);



        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


        final ArrayList<String> categories = new ArrayList<>();
        categories.add("General");
        categories.add("Envision");
        categories.add("Electronics");
        categories.add("Electrical");
        categories.add("Computer Science");
        categories.add("Civil");
        categories.add("Chemical");
        categories.add("Physics");
        categories.add("Mechanical");
        categories.add("Quizzing");
        categories.add("Bizspark");
        categories.add("Robotics");
        categories.add("Young Engineer");


        CategoryAdapter categoryAdapter = new CategoryAdapter(getActivity(),categories);

        ListView listView =(ListView) view.findViewById(R.id.event_page_listview);
        listView.setAdapter(categoryAdapter);

        listView.setDividerHeight(0);
        listView.setFadingEdgeLength(0);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent in;
                switch(position){
                    case 0:
                        in = new Intent(getActivity(),EventsDetailsActivity.class);
                        in.putExtra("Cat",0);
                        startActivity(in);
                        break;
                    case 1:
                        in = new Intent(getActivity(),EventsDetailsActivity.class);
                        in.putExtra("Cat",1);
                        startActivity(in);
                        break;
                    case 2:
                        in = new Intent(getActivity(),EventsDetailsActivity.class);
                        in.putExtra("Cat",2);
                        startActivity(in);
                        break;
                    case 3:
                        in = new Intent(getActivity(),EventsDetailsActivity.class);
                        in.putExtra("Cat",3);
                        startActivity(in);
                        break;
                    case 4:
                        in = new Intent(getActivity(),EventsDetailsActivity.class);
                        in.putExtra("Cat",4);
                        startActivity(in);
                        break;
                    case 5:
                        in = new Intent(getActivity(),EventsDetailsActivity.class);
                        in.putExtra("Cat",5);
                        startActivity(in);
                        break;
                    case 6:
                        in = new Intent(getActivity(),EventsDetailsActivity.class);
                        in.putExtra("Cat",6);
                        startActivity(in);
                        break;
                    case 7:
                        in = new Intent(getActivity(),EventsDetailsActivity.class);
                        in.putExtra("Cat",7);
                        startActivity(in);
                        break;
                    case 8:
                        in = new Intent(getActivity(),EventsDetailsActivity.class);
                        in.putExtra("Cat",8);
                        startActivity(in);
                        break;
                    case 9:
                        in = new Intent(getActivity(),EventsDetailsActivity.class);
                        in.putExtra("Cat",9);
                        startActivity(in);
                        break;
                    case 10:
                        in = new Intent(getActivity(),EventsDetailsActivity.class);
                        in.putExtra("Cat",10);
                        startActivity(in);
                        break;
                    case 11:
                        in = new Intent(getActivity(),EventsDetailsActivity.class);
                        in.putExtra("Cat",11);
                        startActivity(in);
                        break;
                    case 12:
                        in = new Intent(getActivity(),EventsDetailsActivity.class);
                        in.putExtra("Cat",12);
                        startActivity(in);
                        break;
                }
            }
        });
    }

    public class CategoryAdapter extends ArrayAdapter<String> {
        public CategoryAdapter(@NonNull Context context, @NonNull List<String> objects) {
            super(context,0,objects);
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            String current=getItem(position);
            View listItemView = convertView;
            if(listItemView == null){
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.event_list_item,parent,false);
            }
            VTextView vTextView = (VTextView) listItemView.findViewById(R.id.event_item_catagory_name);
            vTextView.setText(current);

            Animation animation = null;
            animation = AnimationUtils.loadAnimation(getContext(),R.anim.fade_in);
            animation.setDuration(500);
            listItemView.startAnimation(animation);

            return listItemView;
        }
    }

}
