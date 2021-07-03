package com.example.responsi_covid19_124190025.datacovid19;

import com.google.gson.annotations.SerializedName;

public class CovidResponse {
    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("data")
    private Data data;

    public int getStatusCode(){
        return statusCode;
    }

    public Data getData(){
        return data;
    }
}

