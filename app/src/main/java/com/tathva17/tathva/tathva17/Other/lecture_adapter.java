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

public class lecture_adapter extends RecyclerView.Adapter<lecture_adapter.MyViewHolder> {



    private List<Lecturer> objectList;
    private LayoutInflater inflater;

    public lecture_adapter(Context context, List<Lecturer> objectList) {
        this.objectList = objectList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lecture_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Lecturer current = objectList.get(position);
        holder.setData(current,position);

    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private VTextView name;
        private VTextView desg;
        private ImageView pic;
        private VTextView time;
        private int position;
        private Lecturer currentobject;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (VTextView) itemView.findViewById(R.id.lec_name);
            desg = (VTextView) itemView.findViewById(R.id.lec_desc);
            pic = (ImageView) itemView.findViewById(R.id.lec_img);
            time = (VTextView) itemView.findViewById(R.id.lec_time);
        }

        public void setData(Lecturer currentobject, int position) {
            this.name.setText(currentobject.getName());
            this.desg.setText(currentobject.getDesc());
            this.time.setText(currentobject.getTime());
            this.pic.setImageResource(currentobject.getPic());
            this.position = position;
            this.currentobject = currentobject;
        }
    }
}
