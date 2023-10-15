package com.example.mymethodistapplication;

public class MainModel {
    String eventDate;
    String eventLocation;
    String eventName;


    MainModel()
    {

    }
    public MainModel(String eventDate, String eventLocation, String eventName, String eventTime) {
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventName = eventName;
        this.eventTime = eventTime;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    String eventTime;

}
