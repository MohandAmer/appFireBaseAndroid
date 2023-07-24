package com.example.appfirebase.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.appfirebase.R;


public class ChefPendingOrdersFragment extends Fragment {
    TextView textView ;


    public ChefPendingOrdersFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View view = inflater.inflate(R.layout.fragment_chef_pending_orders, container, false);
textView=view.findViewById(R.id.ddaa);

        Bundle bundle = new Bundle();



return view;
    }
}