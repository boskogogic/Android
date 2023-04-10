
package com.example.cubatouristguide.ui.cubatoday;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.cubatouristguide.R;
import com.example.cubatouristguide.databinding.FragmentCubaTodayBinding;
import com.example.cubatouristguide.ui.general.GeneralViewModel;

public class CubaTodayFragment extends Fragment {
    private FragmentCubaTodayBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GeneralViewModel galleryViewModel =
                new ViewModelProvider(this).get(GeneralViewModel.class);

        binding = FragmentCubaTodayBinding.inflate(inflater, container, false);
        requireActivity().setTitle(getString(R.string.menu_cuba_today));
        View root = binding.getRoot();

        // final TextView textView = binding.textGeneral;
        // galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
}
