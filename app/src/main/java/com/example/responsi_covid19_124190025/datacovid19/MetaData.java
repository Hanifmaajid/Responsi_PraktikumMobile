package com.example.responsi_covid19_124190025.datacovid19;

import com.google.gson.annotations.SerializedName;

public class MetaData {
    @SerializedName("last_update")
    private Object lastUpdate;

    public Object getLastUpdate(){
        return lastUpdate;
    }
}
