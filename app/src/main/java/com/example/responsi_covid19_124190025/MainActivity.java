package com.example.responsi_covid19_124190025;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.responsi_covid19_124190025.datacovid19.CovidFragment;
import com.example.responsi_covid19_124190025.datahospitalmaps.HospitalMapsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView btnnavViewId;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       btnnavViewId = findViewById(R.id.bottomNavViewId);
        frameLayout = findViewById(R.id.frameLayoutId);

        btnnavViewId.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.hospitalmapsId:
                        btnnavViewId.setItemBackgroundResource(R.color.design_default_color_secondary_variant);
                        setFragment(new HospitalMapsFragment());
                        return true;

                    case R.id.covid19Id:
                        btnnavViewId.setItemBackgroundResource(R.color.design_default_color_on_primary);
                        setFragment(new CovidFragment());
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutId,fragment);
        fragmentTransaction.commit();

    }
}