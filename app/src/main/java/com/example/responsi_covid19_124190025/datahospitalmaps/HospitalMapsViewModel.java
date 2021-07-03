package com.example.responsi_covid19_124190025.datahospitalmaps;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsi_covid19_124190025.APIService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HospitalMapsViewModel extends ViewModel{
    private static final String TAG = "HospitalMapsViewModel";
    private MutableLiveData<List<DataItem>> dataItems;

    public HospitalMapsViewModel() {
        dataItems = new MutableLiveData<>();
    }

    public MutableLiveData<List<DataItem>> getDataItems() {
        return dataItems;
    }

    public void loadHospital(){
        APIService apiService = new APIService();
        apiService.getAPI().getDataHospitalMaps().enqueue(new Callback<HospitalMapsResponse>() {

            @Override
            public void onResponse(Call<HospitalMapsResponse> call, Response<HospitalMapsResponse> response) {
                dataItems.setValue(response.body().getData());
            }

            @Override
            public void onFailure(Call<HospitalMapsResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: HOSPITAL API FAIL.....");
            }
        });
    }
}
