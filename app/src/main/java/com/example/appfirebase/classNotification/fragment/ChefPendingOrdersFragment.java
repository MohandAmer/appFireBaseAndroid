package com.example.appfirebase.classNotification.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.appfirebase.R;


public class ChefPendingOrdersFragment extends Fragment {


    public ChefPendingOrdersFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View view = inflater.inflate(R.layout.fragment_chef_pending_orders, container, false);
return view;
    }
}