package com.example.responsi_covid19_124190025;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {
    private Retrofit retrofit = null;
    public String BASE_URL = "https://covid19-public.digitalservice.id/api/v1/";

    public APIConfig getAPI(){
        if (retrofit == null){
            retrofit =new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(APIConfig.class);
    }
}

