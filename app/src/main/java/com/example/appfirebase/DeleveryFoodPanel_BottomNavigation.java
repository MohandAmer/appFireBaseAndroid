package com.example.appfirebase;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.appfirebase.Class.Token;
import com.example.appfirebase.fragment.DeleveryPerson;
import com.example.appfirebase.fragment.DeleverySearch;
import com.example.appfirebase.fragment.Deleverycart;
import com.example.appfirebase.fragment.customSearch;
import com.example.appfirebase.fragment.customerCart;
import com.example.appfirebase.fragment.customperson;
import com.example.appfirebase.fragment.homeCustomer;
import com.example.appfirebase.fragment.homedelevery;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class DeleveryFoodPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delevery_food_panel_bottom_navigation);
        BottomNavigationView navigationView =findViewById(R.id.chefbottom_nevigation1231);

        navigationView.setOnNavigationItemSelectedListener(this);
        UpdateToken();
        String name =getIntent().getStringExtra("PAGE");
        if (name != null){
            if (name.equalsIgnoreCase("homedelevery")){
               loadcheffragment(new homedelevery());

            }else if (name.equalsIgnoreCase("Deleverycart")){
                loadcheffragment(new Deleverycart()) ;
            }else if (name.equalsIgnoreCase("DeleverySearch")){
                loadcheffragment(new DeleverySearch()) ;
            }else if (name.equalsIgnoreCase("DeleveryPerson")){
                loadcheffragment(new DeleveryPerson());
            }
        }else {
            loadcheffragment(new homedelevery());
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.Home1234:
               fragment = new homedelevery();
                break;
            case  R.id.Cart4:
                fragment= new Deleverycart();
                break;
            case R.id.search4:
               fragment= new DeleverySearch();
                break;
            case R.id.person4:
                fragment=new DeleveryPerson() ;
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