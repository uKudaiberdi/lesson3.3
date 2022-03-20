package com.example.lesson33;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class MainFragment extends Fragment {

    private EditText editInputText;
    private Button btnSend;
    public final static String KEY_BUNDLE = "key.param.main";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editInputText = view.findViewById(R.id.text);
        btnSend = view.findViewById(R.id.btn);
        if (getArguments() != null) {
            String text = getArguments().getString(FifthFragment.KEY_BUNDLE);
            editInputText.setText(text);
        }

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle chemodean = new Bundle();
                chemodean.putString(KEY_BUNDLE, editInputText.getText().toString());
                SecondFragment fragment = new SecondFragment();
                fragment.setArguments(chemodean);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment ).addToBackStack(null).commit();
            }
        });
    }
}