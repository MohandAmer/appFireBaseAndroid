package com.example.appfirebase;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.appfirebase.Class.Token;
import com.example.appfirebase.fragment.ChefHomeFragment;
import com.example.appfirebase.fragment.ChefMealFragment;
import com.example.appfirebase.fragment.ChefOrderFragment;
import com.example.appfirebase.fragment.ChefPendingOrdersFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class ChefFoodPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_food_panel_bottom_navigation);
        BottomNavigationView navigationView =findViewById(R.id.chefbottom_nevigation);
        navigationView.setOnNavigationItemSelectedListener(this);
        UpdateToken();
        String name =getIntent().getStringExtra("PAGE");
        if (name != null){
            if (name.equalsIgnoreCase("ChefPendingOrdersFragment")){
                loadcheffragment(new ChefPendingOrdersFragment());
            }else if (name.equalsIgnoreCase("ChefOrderFragment")){
               loadcheffragment(new ChefOrderFragment()) ;
            }else if (name.equalsIgnoreCase("ChefHomeFragment")){
               loadcheffragment(new ChefHomeFragment()) ;
            }else if (name.equalsIgnoreCase("ChefMealFragment")){
               loadcheffragment(new ChefMealFragment());
            }
        }else {
            loadcheffragment(new ChefHomeFragment());
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.Home:
                fragment = new ChefHomeFragment();
                break;
            case  R.id.pindingOerders:
                fragment= new ChefOrderFragment();
                break;
            case R.id.Orders:
                fragment= new ChefPendingOrdersFragment();
                break;
            case R.id.hh:
                fragment=new ChefMealFragment() ;
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
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout , fragment).commit();
            return true;
        }
        return false;
    }
}