package com.example.appfirebase.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.appfirebase.Class.SharedViewModel;
import com.example.appfirebase.R;

public class customperson extends Fragment {
    RatingBar ratingBar;
    Button button;
    private SharedViewModel viewModel;


    public customperson() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View v = inflater.inflate(R.layout.fragment_customperson, container, false);
ratingBar=v.findViewById(R.id.ratiobutton);
button=v.findViewById(R.id.submit);

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        String value =String.valueOf(ratingBar.getRating());
       Bundle bundle = new Bundle();
        bundle.putString("df1",value);
        getParentFragmentManager().setFragmentResult("dataForm1",bundle);
        ChefPendingOrdersFragment cfbof = new ChefPendingOrdersFragment();
        cfbof.setArguments(bundle);
        Toast.makeText(getContext(),"تم التقييم",Toast.LENGTH_SHORT).show();

        ratingBar.setRating(0);


    }
});


        return v;
    }
    public void submitStars(View view){

    }
}