package com.example.responsi_covid19_124190025.datacovid19;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsi_covid19_124190025.APIService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CovidViewModel extends ViewModel{
    private static final String TAG = "CovidViewModel";
    private MutableLiveData<List<ContentItem>> contentItems;

    public CovidViewModel() {
        contentItems = new MutableLiveData<>();
    }

    public MutableLiveData<List<ContentItem>> getContentItems() {
        return contentItems;
    }

    public void loadCovid(){
        APIService apiService = new APIService();
        apiService.getAPI().getDataCovid19().enqueue(new Callback<CovidResponse>() {
            @Override
            public void onResponse(Call<CovidResponse> call, Response<CovidResponse> response) {
                contentItems.setValue(response.body().getData().getContent());
            }

            @Override
            public void onFailure(Call<CovidResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: CASES API FAIL.....");
            }
        });
    }
}
