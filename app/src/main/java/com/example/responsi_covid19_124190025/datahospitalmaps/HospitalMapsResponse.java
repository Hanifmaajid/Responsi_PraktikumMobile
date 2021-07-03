package com.example.responsi_covid19_124190025.datahospitalmaps;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HospitalMapsResponse {

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("data")
    private List<DataItem> data;

    public int getStatusCode(){

        return statusCode;
    }

    public List<DataItem> getData(){

        return data;
    }
}
