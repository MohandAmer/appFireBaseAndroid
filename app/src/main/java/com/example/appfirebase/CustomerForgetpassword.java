package com.example.appfirebase;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appfirebase.Class.ReusableCodeForAll;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class CustomerForgetpassword extends AppCompatActivity {
    TextInputLayout forgetpassword;
    Button Reset;
    FirebaseAuth FAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_forgetpassword);
        forgetpassword=(TextInputLayout)findViewById(R.id.Email13456);
        Reset =(Button)findViewById(R.id.NEXT123);
        FAuth=FirebaseAuth.getInstance();
        String forgetPassword1= forgetpassword.getEditText().getText().toString().trim();
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(CustomerForgetpassword.this);
                mDialog.setCancelable(false);
                mDialog.setCanceledOnTouchOutside(false);
                mDialog.setMessage("Loding in ...");
                mDialog.show();
                FAuth.sendPasswordResetEmail(forgetPassword1).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            mDialog.dismiss();
                            ReusableCodeForAll.ShowAlert(CustomerForgetpassword.this,"","done,Please check your mail");

                        }else {
                            mDialog.dismiss();
                            ReusableCodeForAll.ShowAlert(CustomerForgetpassword.this,"Error","Sorry,please try later");

                        }
                    }
                });
            }
        });

    }
}