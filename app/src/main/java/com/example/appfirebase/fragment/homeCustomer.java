package com.example.appfirebase.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.appfirebase.Adaptrs.CustomerHomeAdapter;
import com.example.appfirebase.Class.Customerclass;
import com.example.appfirebase.Class.MealDetailse;
import com.example.appfirebase.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class homeCustomer extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    RecyclerView recyclerView;
    private List<MealDetailse> updateDishModelList;
    private CustomerHomeAdapter adapter;
   // String State,City;
    DatabaseReference dataa,dataaa,databaseReference;
   SwipeRefreshLayout swipeRefreshLayout;
    SearchView searchView;
    TextView vvv;


    public homeCustomer() {
    }

    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View view =inflater.inflate(R.layout.fragment_home_customer, container, false);
        Log.e("hhhhhhhhhhhhhhhhhhhhhh","hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");

getActivity().setTitle("All dishes for the customer");
 setHasOptionsMenu(true);
recyclerView=view.findViewById(R.id.ercrecrec);
         vvv = view.findViewById(R.id.nna);

recyclerView.setHasFixedSize(true);
        Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.move);
        recyclerView.startAnimation(animation);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        updateDishModelList = new ArrayList<>();

        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipelayout);
        swipeRefreshLayout.setOnRefreshListener( this);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimaryDark, R.color.purple_500);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);

                String userid =FirebaseAuth.getInstance().getCurrentUser().getUid();
                dataaa=FirebaseDatabase.getInstance().getReference("Customer").child(userid);
                dataaa.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Customerclass cust =snapshot.getValue(Customerclass.class);

                        customermenu();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });






return view;
    }


    private void customermenu(){

        swipeRefreshLayout.setRefreshing(true);

        databaseReference=FirebaseDatabase.getInstance().getReference("FoodSupplyDetails");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot dataSnapshot) {
                updateDishModelList.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    for (DataSnapshot snapshot1:snapshot.getChildren()){
                        MealDetailse updatDishModel = snapshot1.getValue(MealDetailse.class);
                        updateDishModelList.add(updatDishModel);
                        if (updateDishModelList.size()==0){
                            vvv.setVisibility(View.VISIBLE);
                        }else {
                            vvv.setVisibility(View.GONE);
                        }
                    }
                }
                adapter = new CustomerHomeAdapter(getContext(),updateDishModelList);
                recyclerView.setAdapter(adapter);

                swipeRefreshLayout.setRefreshing(false);

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {
               swipeRefreshLayout.setRefreshing(false);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                search(s);
                return true;
            }
        });

    }

private void search(final String searchtext){
        ArrayList<MealDetailse> mylist =new ArrayList<>();
        for (MealDetailse object :updateDishModelList){
            if (object.getDishes().toLowerCase().contains(searchtext.toLowerCase())){
                mylist.add(object);
            }

        }
        adapter =new CustomerHomeAdapter(getContext(),mylist);
        recyclerView.setAdapter(adapter);
}
    @Override
    public void onRefresh() {
swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu,  MenuInflater inflater) {
       inflater.inflate(R.menu.searchmenu,menu);
       MenuItem menuItem=menu.findItem(R.id.search5050);
      searchView=(SearchView) menuItem.getActionView();
       searchView.setQueryHint("Search Dish");
    }
    //    private  void search(final  String searchtext){
//        ArrayList<MealDetailse> mylist = new ArrayList<>();
//        for (MealDetailse object : updateDishModelList) {
//            if (object.getDishes().toLowerCase().contains(searchtext.toLowerCase())) {
//                mylist.add(object);
//            }
//        }
//        adapter = new CustomerHomeAdapter(getContext() , mylist);
//       recyclerView.setAdapter(adapter);
//    }

 //   @Override
//    public void onCreateOptionsMenu(@NonNull  Menu menu, @NonNull  MenuInflater inflater) {
//        inflater.inflate(R.menu.searchmenu,menu);
//        MenuItem menuItem=menu.findItem(R.id.search);
//    searchView=(SearchView)menuItem.getActionView();
//       searchView.setQueryHint("Search Dish");
//
//    }
}