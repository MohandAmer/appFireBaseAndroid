package com.example.appfirebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.appfirebase.fragment.DeleveryPerson;
import com.example.appfirebase.fragment.DeleverySearch;
import com.example.appfirebase.fragment.Deleverycart;
import com.example.appfirebase.fragment.homedelevery;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;


public class navibardelev extends AppCompatActivity {
    private final int ID_HOME=1;
    private final int ID_MESSAGE=2;
    private final int ID_NOTIFICATION=3;
    private final int ID_ACCOUNT=4;
    private  MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navibardelev);
        bottomNavigation= findViewById(R.id.bottom_navi);

bottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME,R.drawable.baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_MESSAGE,R.drawable.baseline_message_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_NOTIFICATION,R.drawable.baseline_notifications_none_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_ACCOUNT,R.drawable.ic_baseline_person_24));
        bottomNavigation.setCount(3,"5");
   //     bottomNavigation.show(ID_HOME,true);

//bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
//    @Override
//    public void onClickItem(MeowBottomNavigation.Model item) {
//        Fragment fragment=null;
//        if (item.getId()==1){
//            fragment=new homedelevery();
//        }else if(item.getId()==2){
//            fragment = new Deleverycart();
//
//        }else if(item.getId()==3){
//            fragment=new DeleveryPerson();
//        }else if(item.getId()==4){
//            fragment= new DeleverySearch();
//        }else fragment=new homedelevery();
//
//
//        LoadAndReplaceFragment1(fragment);
//    }
//});
bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
    @Override
    public void onShowItem(MeowBottomNavigation.Model item) {
        Fragment fragment=null;
        if (item.getId()==1){
            fragment=new homedelevery();
        }else if(item.getId()==2){
            fragment = new Deleverycart();

        }else if(item.getId()==3){
            fragment=new DeleveryPerson();
        }else if(item.getId()==4){
            fragment= new DeleverySearch();
        }else fragment=new homedelevery();


        LoadAndReplaceFragment1(fragment);
    }
});   
    bottomNavigation.show(1,true);
    bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
        @Override
        public void onClickItem(MeowBottomNavigation.Model item) {

        }
    });
    bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
        @Override
        public void onReselectItem(MeowBottomNavigation.Model item) {

        }
    });
    }

    private void LoadAndReplaceFragment1(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.containerr,fragment,null).commit();
    }
}