package com.example.cubatouristguide.ui.settings;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.example.cubatouristguide.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.main_preferences,rootKey);
        requireActivity().setTitle(getString(R.string.menu_settings));

    }

}
