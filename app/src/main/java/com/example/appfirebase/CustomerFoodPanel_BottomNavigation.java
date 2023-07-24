package com.example.appfirebase;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.appfirebase.Class.Token;
import com.example.appfirebase.fragment.customSearch;
import com.example.appfirebase.fragment.customerCart;
import com.example.appfirebase.fragment.customperson;
import com.example.appfirebase.fragment.homeCustomer;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class CustomerFoodPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_food_panel_bottom_navigation);
        BottomNavigationView navigationView =findViewById(R.id.chefbottom_nevigation123);
        navigationView.setOnNavigationItemSelectedListener(this);
        UpdateToken();
        String name =getIntent().getStringExtra("PAGE");
        if (name != null){
            if (name.equalsIgnoreCase("homeCustomer")){
               loadcheffragment(new homeCustomer());
            }else if (name.equalsIgnoreCase("customerCart")){
                loadcheffragment(new customerCart()) ;
            }else if (name.equalsIgnoreCase("customSearch")){
                loadcheffragment(new customSearch()) ;
            }else if (name.equalsIgnoreCase("customperson")){
                loadcheffragment(new customperson());
            }
        }else {
            loadcheffragment(new homeCustomer());
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.Home123:
               fragment = new homeCustomer();
                break;
            case  R.id.Cart:
                fragment= new customerCart();
                break;
            case R.id.search:
               fragment= new customSearch();
                break;
            case R.id.person:
                fragment=new customperson() ;
        }
        return loadcheffragment(fragment);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    private void UpdateToken(){
        String refreshToken = FirebaseInstanceId.getInstance().getToken();
        Log.e("Token",String.valueOf(refreshToken));
        Token token = new Token(String.valueOf(refreshToken));
        FirebaseDatabase.getInstance().getReference("Tokens").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(token);

    }
    private boolean loadcheffragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout2 , fragment).commit();
            return true;
        }
        return false;
    }
}