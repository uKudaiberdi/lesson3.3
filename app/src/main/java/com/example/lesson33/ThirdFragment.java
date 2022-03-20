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

public class ThirdFragment extends Fragment {

    private Button send;
    public final static String KEY_BUNDLE = "key_param.third";
    private EditText text3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        send = view.findViewById(R.id.btn);
        text3 = view.findViewById(R.id.text3);
        if (getArguments() != null) {
            String text = getArguments().getString(SecondFragment.KEY_BUNDLE);
            text3.setText(text);
        }
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle chemodean = new Bundle();
                chemodean.putString(KEY_BUNDLE, text3.getText().toString());
                FourthFragment fragment = new FourthFragment();
                fragment.setArguments(chemodean);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();
            }
        });
    }
}