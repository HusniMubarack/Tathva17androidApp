package com.tathva17.tathva.tathva17.EventsData;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huxq17.swipecardsview.BaseCardAdapter;
import com.tathva17.tathva.tathva17.R;

import java.util.List;

/**
 * Created by Husni Mubarack on 29-Sep-17.
 */

public class EventsCardAdapter extends BaseCardAdapter {

    private List<EventsModel> eventsModelList;
    private Context context;

    public EventsCardAdapter(List<EventsModel> eventsModelList, Context context) {
        this.eventsModelList = eventsModelList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return eventsModelList.size();
    }

    @Override
    public int getCardLayoutId() {
        return R.layout.event_item_card;
    }

    @Override
    public void onBindData(int i, View view) {
        if(eventsModelList == null || eventsModelList.size()==0){
            return;
        }

        TextView title = (TextView)view.findViewById(R.id.eventTitleView);
        TextView description = (TextView)view.findViewById(R.id.eventDescription);
        ImageView cardImage = (ImageView)view.findViewById(R.id.card_image);
        TextView venue = (TextView)view.findViewById(R.id.eventVenue);


        EventsModel model = eventsModelList.get(i);
        title.setText(model.getTitle());
        description.setText(model.getDescription());
        venue.setText(model.getVenue());
        cardImage.setBackgroundResource(model.getImage());

    }
}
