package com.example.appfirebase;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Choseone extends AppCompatActivity {
Button Chef,Customer,DeliveryPerson;
Intent intent;
String type;
ConstraintLayout bgimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choseone);
        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img2),3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img3),3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img4),3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img5),3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img6),3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img7),3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img8),3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img9),3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img10),3000);
        animationDrawable.setOneShot(false);
        animationDrawable.setEnterFadeDuration(850);
        animationDrawable.setExitFadeDuration(1600);
        bgimage=findViewById(R.id.back3);
        bgimage.setBackgroundDrawable(animationDrawable);
        animationDrawable.start();
        intent=getIntent();
        type=intent.getStringExtra("Home").toString().trim();
        Chef= (Button)findViewById(R.id.Signeithchef);
        Customer=(Button)findViewById(R.id.Signeithcustomer);
        DeliveryPerson=(Button)findViewById(R.id.Sigidelevery);
        Chef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.equals("Email")){
                    Intent loginemsil = new Intent(Choseone.this, ChefLogin.class);
                    startActivity(loginemsil);
                 //   finish();
                }
                if (type.equals("Phone")){
                    Intent loginemsil = new Intent(Choseone.this, phonelogin.class);
                    startActivity(loginemsil);
                 //   finish();
                }
                if (type.equals("Signup")){
                    Intent loginemsil = new Intent(Choseone.this, Registeration.class);
                    startActivity(loginemsil);
               //     finish();
                }
            }
        });

        Customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.equals("Email")){
                    Intent logincust = new Intent(Choseone.this, Login.class);
                    startActivity(logincust);
              //      finish();
                }
                if (type.equals("Phone")){
                    Intent logincust = new Intent(Choseone.this, Loginphone.class);
                    startActivity(logincust);
             //       finish();
                }
                if (type.equals("Signup")){
                    Intent logincust = new Intent(Choseone.this, cusRegisteration.class);
                    startActivity(logincust);
               //     finish();
                }
            }
        });
        DeliveryPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.equals("Email")){
                    Intent logincust = new Intent(Choseone.this, Delevery_Login.class);
                    startActivity(logincust);
              //      finish();
                }
                if (type.equals("Phone")){
                    Intent logincust = new Intent(Choseone.this, Delevery_Loginphone.class);
                    startActivity(logincust);
             //       finish();
                }
                if (type.equals("Signup")){
                    Intent logincust = new Intent(Choseone.this, Delevery_Registeration.class);
                    startActivity(logincust);
              //      finish();
                }
            }
        });








    }
}