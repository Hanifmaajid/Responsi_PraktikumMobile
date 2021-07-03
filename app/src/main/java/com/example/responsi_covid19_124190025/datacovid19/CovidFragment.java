package com.example.responsi_covid19_124190025.datacovid19;

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
public class CovidFragment extends Fragment{

    private CovidViewModel covidViewModel;
    private CovidListAdapter covidListAdapter;
    private RecyclerView rvCovid;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_covid, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        covidViewModel = new ViewModelProvider(this).get(CovidViewModel.class);
        rvCovid = view.findViewById(R.id.rv_covid);

        covidListAdapter = new CovidListAdapter(getActivity(), new ArrayList<>());
        progressBar = view.findViewById(R.id.progressbar1);

        rvCovid.setHasFixedSize(true);
        rvCovid.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, true));
        rvCovid.setAdapter(covidListAdapter);

        covidViewModel.getContentItems().observe(requireActivity(), contentItems -> {
            covidListAdapter.setContentItems(contentItems);
            covidListAdapter.notifyDataSetChanged();
            rvCovid.scrollToPosition(covidListAdapter.getItemCount()-1);

            progressBar.setVisibility(contentItems.size() > 1 ? View.INVISIBLE : View.VISIBLE);
        });
        covidViewModel.loadCovid();
    }
}
