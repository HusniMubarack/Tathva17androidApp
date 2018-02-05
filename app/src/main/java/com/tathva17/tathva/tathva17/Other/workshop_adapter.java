package com.tathva17.tathva.tathva17.Other;

/**
 * Created by burgers on 6/10/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tathva17.tathva.tathva17.R;
import com.vrjco.v.vtextview.VTextView;

import java.util.List;

/**
 * Created by burgers on 28/8/17.
 */

public class workshop_adapter extends RecyclerView.Adapter<workshop_adapter.MyViewHolder> {



    private List<Workshop> objectList;
    private LayoutInflater inflater;

    public workshop_adapter(Context context, List<Workshop> objectList) {
        this.objectList = objectList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.workshop_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Workshop current = objectList.get(position);
        holder.setData(current,position);

    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private VTextView name;

        private ImageView pic;
        private int position;
        private Workshop currentobject;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (VTextView) itemView.findViewById(R.id.workshop_name);

            pic = (ImageView) itemView.findViewById(R.id.workshop_img);
        }

        public void setData(Workshop currentobject, int position) {
            this.name.setText(currentobject.getName());

            this.pic.setImageResource(currentobject.getPic());
            this.position = position;
            this.currentobject = currentobject;
        }
    }
}
