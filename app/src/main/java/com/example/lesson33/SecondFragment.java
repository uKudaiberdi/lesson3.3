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

public class SecondFragment extends Fragment {

    private Button send;
    public final static String KEY_BUNDLE = "key.param.second";
    private EditText text1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        send = view.findViewById(R.id.btn);
        text1 = view.findViewById(R.id.text1);
        if (getArguments() != null) {
            String text = getArguments().getString(MainFragment.KEY_BUNDLE);
            text1.setText(text);
        }
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle chemodean = new Bundle();
                chemodean.putString(KEY_BUNDLE, text1.getText().toString());
                ThirdFragment fragment = new ThirdFragment();
                fragment.setArguments(chemodean);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();
            }
        });
    }
}