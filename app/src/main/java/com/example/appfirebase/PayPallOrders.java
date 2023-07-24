package com.example.appfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appfirebase.Adaptrs.PayPalOrderAdapter;
import com.example.appfirebase.Class.ChefPendingOrders;
import com.example.appfirebase.Class.ChefPymentOrdera;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PayPallOrders extends AppCompatActivity {
        RecyclerView recyclerView;
        private List<ChefPymentOrdera> customerPaymentOrderList;
        private PayPalOrderAdapter adapter;
        DatabaseReference databaseReference;
        private LinearLayout pay;
        Button payment;
        TextView grandTotal;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_pall_orders);

        recyclerView=findViewById(R.id.recayclpay);
        pay=findViewById(R.id._Tptalpay);
        grandTotal=findViewById(R.id.Rs);
        payment=(Button)findViewById(R.id.pay);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(PayPallOrders.this));
        customerPaymentOrderList=new ArrayList<>();

       // CustomerpaypalableOrders();
        adapter = new PayPalOrderAdapter(PayPallOrders.this,customerPaymentOrderList);
        recyclerView.setAdapter(adapter);

CustomerpaypalableOrders();

    }
    private void CustomerpaypalableOrders(){

        databaseReference = FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders")
        .child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    customerPaymentOrderList.clear();
                    for (final DataSnapshot snapshot :dataSnapshot.getChildren()){
                        final String randomuid=snapshot.getKey();
                        DatabaseReference data = FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders")
                                   .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .child(snapshot.getKey()).child("Dishes");
                        data.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull  DataSnapshot dataSnapshot) {
                                for (DataSnapshot snapshot1:dataSnapshot.getChildren()){
                                    ChefPymentOrdera customerpaymentOrder =snapshot1.getValue(ChefPymentOrdera.class);
                                    customerPaymentOrderList.add(customerpaymentOrder);

                                }
                                if (customerPaymentOrderList.size() == 0){
                                    pay.setVisibility(View.INVISIBLE);
                                    Toast.makeText(PayPallOrders.this,"kkkkkkk",Toast.LENGTH_SHORT).show();


                                }else {
                                    pay.setVisibility(View.VISIBLE);
                                    payment.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent=new Intent(PayPallOrders.this,finalpaypal.class);
                                            intent.putExtra("RandomUID",randomuid);
                                            startActivity(intent);
                                            finish();
                                        }
                                    });
                                }
                                adapter = new PayPalOrderAdapter(PayPallOrders.this,customerPaymentOrderList);
                                recyclerView.setAdapter(adapter);
                            }

                            @Override
                            public void onCancelled(@NonNull  DatabaseError error) {
                                Toast.makeText(getApplicationContext(),"kkkkkkvgvk",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {
                Toast.makeText(getApplicationContext(),"kkkkkkk",Toast.LENGTH_SHORT).show();

            }
        });
    }
}