package com.progsoft.table_list_demo;

public class DataItem {
    private String address, LL, distance;

    public DataItem(String address, String LL, String distance) {
        this.address = address;
        this.LL = LL;
        this.distance = distance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLL() {
        return LL;
    }

    public void setLL(String LL) {
        this.LL = LL;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
