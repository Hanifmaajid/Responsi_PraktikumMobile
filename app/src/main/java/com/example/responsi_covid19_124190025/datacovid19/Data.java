package com.example.responsi_covid19_124190025.datacovid19;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("metadata")
    private MetaData metadata;

    @SerializedName("content")
    private List<ContentItem> content;

    public MetaData getMetadata(){
        return metadata;
    }

    public List<ContentItem> getContent(){
        return content;
    }
}
