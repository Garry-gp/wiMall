package com.example.demo.model;

import java.util.Date;

public class City {

    private int cityId;
    private String city;
    private  String counttryId;
    private Date lastUpdate;


    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounttryId() {
        return counttryId;
    }

    public void setCounttryId(String counttryId) {
        this.counttryId = counttryId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
