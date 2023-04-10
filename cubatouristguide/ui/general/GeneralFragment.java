package com.example.cubatouristguide.ui.general;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.cubatouristguide.R;
import com.example.cubatouristguide.databinding.FragmentGeneralBinding;


public class GeneralFragment extends Fragment {

    private FragmentGeneralBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GeneralViewModel galleryViewModel =
                new ViewModelProvider(this).get(GeneralViewModel.class);

        binding = FragmentGeneralBinding.inflate(inflater, container, false);
        requireActivity().setTitle(getString(R.string.menu_general));
        View root = binding.getRoot();

       // final TextView textView = binding.textGeneral;
       // galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
