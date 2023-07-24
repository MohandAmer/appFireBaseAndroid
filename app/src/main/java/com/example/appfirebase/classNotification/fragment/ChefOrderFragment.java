package com.example.appfirebase.classNotification.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.appfirebase.Adaptrs.ChefPendingOrderAdapter;
import com.example.appfirebase.Class.ChefpendingOrder1;
import com.example.appfirebase.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ChefOrderFragment extends Fragment {
private RecyclerView recyclerView;
private List<ChefpendingOrder1> chefPendingOrdersList;
private ChefPendingOrderAdapter adapter;
private DatabaseReference databaseReference;
private SwipeRefreshLayout swipeRefreshLayout;
private View v;


    public ChefOrderFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View view = inflater.inflate(R.layout.fragment_chef_order, container, false);
recyclerView=view.findViewById(R.id.recayclerviewhh);
recyclerView.setHasFixedSize(true);
recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
chefPendingOrdersList=new ArrayList<>();
//swipeRefreshLayout=view.findViewById(R.id.Swip_layout);
//swipeRefreshLayout.setColorSchemeColors(R.color.colorPrimaryDark,R.color.black);
adapter=new ChefPendingOrderAdapter(getContext(),chefPendingOrdersList);
recyclerView.setAdapter(adapter);

        cheforders();
        return view;
    }
    private void cheforders(){
        databaseReference= FirebaseDatabase.getInstance().getReference("ChefPendingOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()){
                chefPendingOrdersList.clear();
                for (DataSnapshot snapshot :dataSnapshot.getChildren()){
                    String key=snapshot.getKey();
                    DatabaseReference data = FirebaseDatabase.getInstance().getReference("ChefPendingOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(snapshot.getKey()).child("OtherInformation");
                    data.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull  DataSnapshot snapshot) {
                            ChefpendingOrder1 chefpendingOrder1 = snapshot.getValue(ChefpendingOrder1.class);
                            chefPendingOrdersList.add(chefpendingOrder1);
                            adapter=new ChefPendingOrderAdapter(getContext(),chefPendingOrdersList);
                            recyclerView.setAdapter(adapter);
//                            swipeRefreshLayout.setRefreshing(false);
                        }

                        @Override
                        public void onCancelled(@NonNull  DatabaseError error) {

                        }
                    });


                }
            }
            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });

        adapter=new ChefPendingOrderAdapter(getContext(),chefPendingOrdersList);
        recyclerView.setAdapter(adapter);

    }
}