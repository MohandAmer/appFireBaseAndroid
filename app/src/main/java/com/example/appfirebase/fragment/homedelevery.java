package com.example.appfirebase.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appfirebase.R;


public class homedelevery extends Fragment {

TextView textView1,textView2;

    public homedelevery() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homedelevery, container, false);


        textView1 = view.findViewById(R.id.devloc);
        textView2=view.findViewById(R.id.devstate);
        getParentFragmentManager().setFragmentResultListener("datafram1", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String data = result.getString("df1");
              textView1.setText(data);
            }
        });
        return view;
    }
}