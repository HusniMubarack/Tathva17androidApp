package com.tathva17.tathva.tathva17.EventsData;

/**
 * Created by Husni Mubarack on 06-Oct-17.
 */

public class EventsModel {
    public String title,description,venue;
    int image;


    public EventsModel(String title, String venue, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.venue = venue;
    }

    public String getVenue() {
        return venue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
