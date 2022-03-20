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

public class FifthFragment extends Fragment {

    private Button send;
    private EditText text5;
    public final static String KEY_BUNDLE = "key_param.fifth";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fifth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        send = view.findViewById(R.id.btn);
        text5 = view.findViewById(R.id.text5);
        if (getArguments() != null) {
            String text = getArguments().getString(FourthFragment.KEY_BUNDLE);
            text5.setText(text);
        }
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle chemodean =  new Bundle();
                chemodean.putString(KEY_BUNDLE, text5.getText().toString());
                MainFragment fragment = new MainFragment();
                fragment.setArguments(chemodean);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            }
        });
    }
}