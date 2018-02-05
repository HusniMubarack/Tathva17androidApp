package com.tathva17.tathva.tathva17;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.vrjco.v.vtextview.VTextView;

/**
 * Created by VRUSHABH on 08-10-2016.
 */
public class TopViewRecyclerViewAdapter extends RecyclerView.Adapter<TopViewViewHolder> {

    private String[] titles;
    private int[] images;
    private Context context;

    public TopViewRecyclerViewAdapter(String[] titles, int[] images, Context context) {
        this.titles = titles;
        this.images = images;
        this.context = context;
    }

    @Override
    public TopViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_top_view_item, parent, false);
        return new TopViewViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(TopViewViewHolder holder, int position) {
        holder.makeView(titles[position], images[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}

class TopViewViewHolder extends RecyclerView.ViewHolder {
    private Context context;
    private ImageView bg;
    private VTextView title;

    public TopViewViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        bg = (ImageView) itemView.findViewById(R.id.top_view_item_bg);
        title = (VTextView) itemView.findViewById(R.id.top_view_item_title_text);

    }

    public void makeView(String Title, int drawable) {
        title.setText(Title);
        Glide.with(context).fromResource().load(drawable).crossFade(100).into(bg);
    }

}