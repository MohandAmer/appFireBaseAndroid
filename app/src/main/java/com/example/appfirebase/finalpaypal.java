package com.example.appfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appfirebase.Class.ChefPaymentOrder1;
import com.example.appfirebase.Class.ChefPymentOrdera;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class finalpaypal extends AppCompatActivity {
    TextView OnlinPayment,CashPayment;
    String RandomUID,ChefId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalpaypal);

        CashPayment =findViewById(R.id.cachdelevery);
        RandomUID=getIntent().getStringExtra("RandomUID");
        CashPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders")
.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .child(RandomUID).child("Dishes");

                        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull  DataSnapshot dataSnapshot) {
                                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                                    final ChefPymentOrdera customerpaymentOrders = dataSnapshot1.getValue(ChefPymentOrdera.class);
                                    HashMap<String,String> hashMap = new HashMap<>();
                                    String dishid=customerpaymentOrders.getDishId();
                                    hashMap.put("ChefId",customerpaymentOrders.getChefId());
                                    hashMap.put("DishID",customerpaymentOrders.getDishId());
                                   hashMap.put("DishName",customerpaymentOrders.getDishname());
                                   hashMap.put("Price",customerpaymentOrders.getPrice());
                                   hashMap.put("dishQuantity",customerpaymentOrders.getDishQuntity());
                                   hashMap.put("RandomUID",RandomUID);
                                   hashMap.put("totalprice",customerpaymentOrders.getPrice());
                                   hashMap.put("UserId",customerpaymentOrders.getUserId());
                                   FirebaseDatabase.getInstance().getReference("CustomerFinalOrders")
                                           .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                           .child(RandomUID).child("Dishes")
                                           .child(dishid).setValue(hashMap);
                                }
                                DatabaseReference data = FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID)
                                        .child("OtherInformation");
                                        data.addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull  DataSnapshot dataSnapshot1) {
                                                final ChefPaymentOrder1 chefPaymentOrder1 =dataSnapshot1.getValue(ChefPaymentOrder1.class);
                                                HashMap<String,String> hashMap1 = new HashMap<>();
                                                hashMap1.put("Address",chefPaymentOrder1.getAddress());
                                                hashMap1.put("GrandTotalPrice",chefPaymentOrder1.getGrandTotalPrice());
                                                hashMap1.put("Mobilenumber",chefPaymentOrder1.getMobileNumber());
                                                hashMap1.put("Name",chefPaymentOrder1.getName());
                                                hashMap1.put("Note",chefPaymentOrder1.getNote());
                                                hashMap1.put("statues","Youre Order is waiting to be prpared by chef...");

                                                hashMap1.put("RandomUID",chefPaymentOrder1.getRandomUID());
                                                FirebaseDatabase.getInstance().getReference("CustomerFinalOrders")
                                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                        .child(RandomUID)
                                                        .child("OtherInformation").setValue(hashMap1).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(@NonNull @NotNull Void unused) {
                                                        DatabaseReference Reference=FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders")
                                                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID)
                                                                .child("Dishes");
                                                        Reference.addListenerForSingleValueEvent(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(@NonNull  DataSnapshot dataSnapshot2) {
                                                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                                                    final ChefPymentOrdera customerPaymentOrder =snapshot.getValue(ChefPymentOrdera.class);
                                                                    HashMap<String,String> hashMap2 =new HashMap<>();
                                                                    String dishid= customerPaymentOrder.getDishId();
                                                                    ChefId =customerPaymentOrder.getChefId();
                                                                    hashMap2.put("ChefId",customerPaymentOrder.getChefId());
                                                                    hashMap2.put("DishID",customerPaymentOrder.getDishId());
                                                                    hashMap2.put("dishname",customerPaymentOrder.getDishname());
                                                                    hashMap2.put("Price",customerPaymentOrder.getPrice());
                                                                    hashMap2.put("quantity",customerPaymentOrder.getDishQuntity());
                                                                    hashMap2.put("RandomUID",RandomUID);
                                                                    hashMap2.put("totalprice",customerPaymentOrder.getTotalprice());
                                                                    hashMap2.put("UserId",customerPaymentOrder.getUserId());
                                                                    FirebaseDatabase.getInstance().getReference("ChefWaitingOrders")
                                                                            .child(ChefId).child(RandomUID).child("Dishes").child(dishid).setValue(hashMap2);




                                                                }
                                                                DatabaseReference dataa = FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders")
                                                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                                        .child(RandomUID).child("OtherInformation");
                                                                dataa.addListenerForSingleValueEvent(new ValueEventListener() {
                                                                    @Override
                                                                    public void onDataChange(@NonNull  DataSnapshot dataSnapshot) {
                                                                        ChefPaymentOrder1 customerpaymentorder1=dataSnapshot.getValue(ChefPaymentOrder1.class);
                                                                        HashMap<String,String> hashMap3 =new HashMap<>();
                                                                        hashMap3.put("Address",customerpaymentorder1.getAddress());
                                                                        hashMap3.put("GrandTotalPrice",customerpaymentorder1.getGrandTotalPrice());
                                                                        hashMap3.put("Mobilenumber",customerpaymentorder1.getMobileNumber());
                                                                        hashMap3.put("Name",customerpaymentorder1.getName());
                                                                        hashMap3.put("Note",customerpaymentorder1.getNote());
                                                                        hashMap3.put("RandomUID",customerpaymentorder1.getRandomUID());
                                                                        hashMap3.put("statues","Youre Order is waiting to be prpared by chef...");
                                                                        FirebaseDatabase.getInstance().getReference("ChefWaitingOrders")
                                                                                .child(ChefId).child(RandomUID).child("OtherInformation")
                                                                                .setValue(hashMap3).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                            @Override
                                                                            public void onComplete(@NonNull  Task<Void> task) {

                                                                            FirebaseDatabase.getInstance().getReference("ChefPaymentOrders")
                                                                                    .child(ChefId).child(RandomUID).child("Dishes")
                                                                                    .removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                @Override
                                                                                public void onComplete(@NonNull  Task<Void> task) {
                                                                                    FirebaseDatabase.getInstance().getReference("ChefPaymentOrders")
                                                                                            .child(ChefId).child(RandomUID).child("OtherInformation")
                                                                                            .removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                        @Override
                                                                                        public void onComplete(@NonNull  Task<Void> task) {

                                                                                            FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders")
                                                                                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID)
                                                                                                    .child("Dishes").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                @Override
                                                                                                public void onComplete(@NonNull  Task<Void> task) {

                                                                                                    FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders")
                                                                                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                                                                            .child(RandomUID).child("OtherInformation").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                        @Override
                                                                                                        public void onComplete(@NonNull  Task<Void> task) {
                                                                                                            Toast.makeText(getApplicationContext(),"hahahahahaahahahdonee",Toast.LENGTH_SHORT).show();
                                                                                                        }
                                                                                                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                                                        @Override
                                                                                                        public void onSuccess(@NonNull  Void aVoid) {

                                                                                                            Toast.makeText(getApplicationContext(),"hahahahahaahahahdonee",Toast.LENGTH_SHORT).show();



                                                                                                        }
                                                                                                    });



                                                                                                }
                                                                                            });




                                                                                        }
                                                                                    });

                                                                                }
                                                                            });



                                                                            }
                                                                        });




                                                                    }

                                                                    @Override
                                                                    public void onCancelled(@NonNull  DatabaseError error) {

                                                                    }
                                                                });




















                                                            }

                                                            @Override
                                                            public void onCancelled(@NonNull @NotNull DatabaseError error) {

                                                            }
                                                        });



                                                    }
                                                });







                                            }

                                            @Override
                                            public void onCancelled(@NonNull @NotNull DatabaseError error) {

                                            }
                                        });


                            }

                            @Override
                            public void onCancelled(@NonNull  DatabaseError error) {

                            }
                        });
            }
        });
    }
}