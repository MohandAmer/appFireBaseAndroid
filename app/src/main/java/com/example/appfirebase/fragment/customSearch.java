package com.example.appfirebase.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.appfirebase.PayPallOrders;
import com.example.appfirebase.R;

public class customSearch extends Fragment {
TextView textView,textView1;

    public customSearch() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View view = inflater.inflate(R.layout.fragment_custom_search, container, false);
textView1=view.findViewById(R.id.PaypalText);
textView1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), PayPallOrders.class);
        startActivity(intent);

    }
});






return view;
    }
}