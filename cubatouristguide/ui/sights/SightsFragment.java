package com.example.cubatouristguide.ui.sights;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cubatouristguide.HelperTextReader;
import com.example.cubatouristguide.MapsSightsActivity;
import com.example.cubatouristguide.R;
import com.example.cubatouristguide.databinding.FragmentSightsBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class SightsFragment extends Fragment {

    private FragmentSightsBinding binding;
    private RecyclerView _recycler;
    private List<SightsItem> _sightsList;
    private SightsAdapter _adapter;
    private String _sights;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        Locale locale;
        if (!sharedPreferences.getString("language_pref", "English").equals("English")) {
            locale = new Locale("sr");
            _sights = "sights_sr.json";
        } else {
            locale = new Locale("en");
            _sights = "sights.json";
        }

        System.out.println("Sta se nalazi u sights " + _sights);

        Locale.setDefault(locale);
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());

        requireActivity().setTitle(getString(R.string.menu_sight));
        binding = FragmentSightsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        _recycler=binding.recyclerviewSights;
        _recycler.setHasFixedSize(true);
        _recycler.setLayoutManager(new LinearLayoutManager(getContext()));


        _sightsList=new ArrayList<>();
        getDataFromJSON(_sights);

        FloatingActionButton fab = binding.fabSightsMap;
        fab.setOnClickListener(view -> {
            Gson gson = new Gson();
            Intent intent = new Intent(getContext(), MapsSightsActivity.class);
            String intentData =gson.toJson(_sightsList);
            intent.putExtra("sightsList",intentData);
            startActivity(intent);
        });

        return root;
    }

    private void getDataFromJSON(String fileName) {
        _sightsList= Arrays.asList(new Gson().fromJson(HelperTextReader.getJSONFileFromAssets(requireContext(),fileName), SightsItem[].class));
        setUpDataFromJSON(_sightsList);
    }

    private void setUpDataFromJSON(List<SightsItem> _sightsList) {
        _adapter = new SightsAdapter(_sightsList,requireActivity().getApplicationContext());
        _recycler.setAdapter(_adapter);
    }

}
