package com.example.responsi_covid19_124190025;

import com.example.responsi_covid19_124190025.datacovid19.CovidResponse;
import com.example.responsi_covid19_124190025.datahospitalmaps.HospitalMapsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIConfig {
    @GET("rekapitulasi_v2/jabar/harian")
    Call<CovidResponse> getDataCovid19();

    @GET("sebaran_v2/jabar/faskes")
    Call<HospitalMapsResponse> getDataHospitalMaps();
}
