package com.example.gracewellchurchbotnav.ui.Volunteer;

public class VolunteerData {
    private int maxVolunteers;
    private int totalVolunteers;
    private String volOpportunityName;
    private String volAddress;
    private String volDate;
    private String volStartTime;
    private String volEndTime;
    private String volPlaceName;
    private int volImage;
    private int volArrow;

    public VolunteerData(int maxVolunteers, int totalVolunteers, int volImage, int volArrow, String volOpportunityName, String volAddress, String volDate, String volStartTime, String volEndTime, String volPlaceName) {
        this.maxVolunteers = maxVolunteers;
        this.totalVolunteers = totalVolunteers;
        this.volOpportunityName = volOpportunityName;
        this.volAddress = volAddress;
        this.volDate = volDate;
        this.volStartTime = volStartTime;
        this.volEndTime = volEndTime;
        this.volPlaceName = volPlaceName;
        this.volImage = volImage;
        this.volArrow = volArrow;
    }

    public int getMaxVolunteers() {
        return maxVolunteers;
    }

    public void setMaxVolunteers(int maxVolunteers) {
        this.maxVolunteers = maxVolunteers;
    }

    public int getTotalVolunteers() {
        return totalVolunteers;
    }

    public void setTotalVolunteers(int totalVolunteers) {
        this.totalVolunteers = totalVolunteers;
    }

    public String getVolOpportunityName() {
        return volOpportunityName;
    }

    public void setVolOpportunityName(String volOpportunityName) {
        this.volOpportunityName = volOpportunityName;
    }

    public String getVolAddress() {
        return volAddress;
    }

    public void setVolAddress(String volAddress) {
        this.volAddress = volAddress;
    }

    public String getVolDate() {
        return volDate;
    }

    public void setVolDate(String volDate) {
        this.volDate = volDate;
    }

    public String getVolStartTime() {
        return volStartTime;
    }

    public void setVolStartTime(String volStartTime) {
        this.volStartTime = volStartTime;
    }

    public String getVolEndTime() {
        return volEndTime;
    }

    public void setVolEndTime(String volEndTime) {
        this.volEndTime = volEndTime;
    }

    public String getVolPlaceName() {
        return volPlaceName;
    }

    public void setVolPlaceName(String volPlaceName) {
        this.volPlaceName = volPlaceName;
    }

    public int getVolImage() {
        return volImage;
    }

    public void setVolImage(int volImage) {
        this.volImage = volImage;
    }

    public int getVolArrow() {
        return volArrow;
    }

    public void setVolArrow(int volArrow) {
        this.volArrow = volArrow;
    }
}
