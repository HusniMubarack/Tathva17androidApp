package com.tathva17.tathva.tathva17;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vrjco.v.vtextview.VTextView;

import java.util.ArrayList;

/**
 * Created by VRUSHABH on 09-10-2016.
 */
public class EventRecyclerViewAdapter  extends RecyclerView.Adapter<EventRecyclerViewHolder>{

    private ArrayList<String> categoryTitles;
    private Context context;

    public EventRecyclerViewAdapter(ArrayList<String> categoryTitles, Context context) {
        this.categoryTitles = categoryTitles;
        this.context = context;
    }

    @Override
    public EventRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list_item, parent, false);
        return new EventRecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EventRecyclerViewHolder holder, int position) {
        holder.title.setText(categoryTitles.get(position));
    }

    @Override
        public int getItemCount() {
            return categoryTitles.size();
    }
}

class EventRecyclerViewHolder extends RecyclerView.ViewHolder{

    public VTextView title;

    public EventRecyclerViewHolder(View itemView) {
        super(itemView);
        title = (VTextView) itemView.findViewById(R.id.event_item_catagory_name);
    }
}