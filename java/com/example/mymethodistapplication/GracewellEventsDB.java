package com.example.mymethodistapplication;

public class GracewellEventsDB {

    String EName;

    String EDate;
    String ETime;

    String ELocation;

    public GracewellEventsDB(String eventName, String eventDate, String eventTime, String eventLocation) {
        this.EName = eventName;
        this.EDate = eventDate;
        this.ETime = eventTime;
        this.ELocation = eventLocation;
    }


    public String getEventName() {
        return EName;
    }

    public String getEventDate() {
        return EDate;
    }

    public String getEventTime() {
        return ETime;
    }

    public String getEventLocation() {
        return ELocation;
    }

}
