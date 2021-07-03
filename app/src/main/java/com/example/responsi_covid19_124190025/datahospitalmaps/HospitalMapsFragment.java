package com.example.responsi_covid19_124190025.datahospitalmaps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi_covid19_124190025.R;

import java.util.ArrayList;

public class HospitalMapsFragment extends Fragment{

    private HospitalMapsViewModel hospitalmapsViewModel;
    private HospitalMapsListAdapter hospitalmapsListAdapter;
    private RecyclerView rvHospital;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hospitalmaps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hospitalmapsViewModel = new ViewModelProvider(this).get(HospitalMapsViewModel.class);
        rvHospital = view.findViewById(R.id.rv_hospital);

        hospitalmapsListAdapter = new HospitalMapsListAdapter(getActivity(), new ArrayList<>());
        progressBar = view.findViewById(R.id.progressbar2);

        rvHospital.setHasFixedSize(true);
        rvHospital.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        rvHospital.setAdapter(hospitalmapsListAdapter);

        hospitalmapsViewModel.getDataItems().observe(requireActivity(), dataItems -> {
            hospitalmapsListAdapter.setDataItems(dataItems);
            hospitalmapsListAdapter.notifyDataSetChanged();

            progressBar.setVisibility(dataItems.size() > 1 ? View.INVISIBLE : View.VISIBLE);
        });
        hospitalmapsViewModel.loadHospital();
    }
}
