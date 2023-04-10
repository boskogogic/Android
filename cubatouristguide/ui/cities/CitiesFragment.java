package com.example.cubatouristguide.ui.cities;

import static com.example.cubatouristguide.R.string;

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
import com.example.cubatouristguide.MapsCitiesActivity;
import com.example.cubatouristguide.databinding.FragmentCitiesBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CitiesFragment extends Fragment{

    private FragmentCitiesBinding binding;
    private List<CityItem> _cityList;
    private RecyclerView _recycler;
    private CitiesAdapter _adapter;
    private String _cities;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        Locale locale;
        if (!sharedPreferences.getString("language_pref", "English").equals("English")) {
            locale = new Locale("sr");
            _cities = "cities_sr.json";
        } else {
            locale = new Locale("en");
            _cities = "cities.json";
        }

        Locale.setDefault(locale);
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());

        requireActivity().setTitle(getString(string.menu_city));
        binding = FragmentCitiesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        _recycler=binding.recyclerviewCities;
        _recycler.setHasFixedSize(true);
        _recycler.setLayoutManager(new LinearLayoutManager(getContext()));


        _cityList=new ArrayList<>();
        getDataFromJSON(_cities);

        FloatingActionButton fab = binding.fabCitiesMap;
        fab.setOnClickListener(view -> {
            Gson gson = new Gson();
            Intent intent = new Intent(getContext(), MapsCitiesActivity.class);
            String intentData =gson.toJson(_cityList);
            intent.putExtra("citiesList",intentData);
            startActivity(intent);
        });

      //  (CitiesScrollingActivity)getActivity().getSupportActionBar.setDisplayHomeAsUpEnabled(true);

        return root;
    }

    private void getDataFromJSON(String fileName) {
       _cityList= Arrays.asList(new Gson().fromJson(HelperTextReader.getJSONFileFromAssets(requireContext(),fileName),CityItem[].class));
        setUpDataFromJSON(_cityList);
    }

    private void setUpDataFromJSON(List<CityItem> cityList) {
        _adapter = new CitiesAdapter(_cityList,requireActivity().getApplicationContext());
        _recycler.setAdapter(_adapter);
    }



}
