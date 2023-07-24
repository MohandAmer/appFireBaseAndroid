package com.example.appfirebase;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appfirebase.Class.Customerclass;
import com.example.appfirebase.Class.Deleveryclass;
import com.example.appfirebase.Class.RoleClass;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

import java.util.ArrayList;

public class Delevery_Registeration extends AppCompatActivity {

    TextInputLayout Fname, Lname, Email, Pass, cpass, mobileno, houseno, area;

    Button signup, emaill, Phone;
    CountryCodePicker Cpp;
    FirebaseAuth FAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String fname, lname, emailid, password, confermpassword, mobile, house, Area, statee, cityy;
    String role = "Delevery";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delevery_registeration);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        Fname = (TextInputLayout) findViewById(R.id.firstname1231);
        Lname = (TextInputLayout) findViewById(R.id.lastname1231);
        Email = (TextInputLayout) findViewById(R.id.Email1231);
        Pass = (TextInputLayout) findViewById(R.id.Password123451);
        cpass = (TextInputLayout) findViewById(R.id.confermPassword1231);
        mobileno = (TextInputLayout) findViewById(R.id.Mobileno1231);
        houseno = (TextInputLayout) findViewById(R.id.houseNo1231);

        area = (TextInputLayout) findViewById(R.id.Area1231);
        signup = (Button) findViewById(R.id._Signup1231);
        emaill = (Button) findViewById(R.id.email123451);
        Phone = (Button) findViewById(R.id.phone1231);

        Cpp = (CountryCodePicker) findViewById(R.id.countryCodepicker1231);


        Log.e("hh", "hh");


        databaseReference = firebaseDatabase.getInstance().getReference("Delevery");
        FAuth = FirebaseAuth.getInstance();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname = Fname.getEditText().getText().toString().trim();
                lname = Lname.getEditText().getText().toString().trim();
                emailid = Email.getEditText().getText().toString().trim();
                mobile = mobileno.getEditText().getText().toString().trim();
                password = Pass.getEditText().getText().toString().trim();
                confermpassword = cpass.getEditText().getText().toString().trim();
                Area = area.getEditText().getText().toString().trim();
                house = houseno.getEditText().getText().toString().trim();
                if (isValid()) {
                    final ProgressDialog mDialog = new ProgressDialog(Delevery_Registeration.this);
                    mDialog.setCancelable(false);
                    mDialog.setCanceledOnTouchOutside(false);
                    mDialog.setMessage("Registeraion in progress please waith...");
                    mDialog.show();
                    FAuth.createUserWithEmailAndPassword(emailid, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.e("Login SUCSEES", "Login SUCSEES");
                                String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                databaseReference = firebaseDatabase.getInstance().getReference("User").child(userid);
                                RoleClass roleClass = new RoleClass(role);
                                databaseReference.setValue(roleClass).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Deleveryclass chefClass = new Deleveryclass(fname, lname, emailid, password, confermpassword, mobile, house, Area);
                                        firebaseDatabase.getInstance().getReference("Delevery").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                .setValue(chefClass).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        mDialog.dismiss();
                                                        FAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                if (task.isSuccessful()) {
                                                                    AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                                                                    builder.setMessage("you have Registeration make shur to virivication");
                                                                    builder.setCancelable(false);
                                                                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                        @Override
                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                            dialog.dismiss();
                                                                        }
                                                                    });
                                                                }

                                                            }
                                                        });

                                                    }
                                                });
                                    }
                                });


                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });


                }
            }
        });


    }

    String emailpatterrn = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    public boolean isValid() {
        Email.setErrorEnabled(false);
        Email.setError("");
        Fname.setErrorEnabled(false);
        Fname.setError("");
        Lname.setErrorEnabled(false);
        Lname.setError("");
        Pass.setErrorEnabled(false);
        Pass.setError("");
        mobileno.setErrorEnabled(false);
        mobileno.setError("");
        cpass.setErrorEnabled(false);
        cpass.setError("");
        area.setErrorEnabled(false);
        area.setError("");
        houseno.setErrorEnabled(false);
        houseno.setError("");
        boolean isValid = false,
                isValidhouseno = false,
                isValidlname = false,
                isValidname = false,
                isValidemail = false,
                isValidpassword = false,
                isValidconfermpassword = false,
                isValidmobilenum = false,
                isValidarea = false,
                isValidnumber = false;
        if (TextUtils.isEmpty(fname)) {
            Fname.setErrorEnabled(true);
            Fname.setError("Enter First Name");
        } else {
            isValidname = true;
        }
        if (TextUtils.isEmpty(lname)) {
            Lname.setErrorEnabled(true);
            Lname.setError("Enter Last Name");
        } else {

            isValidlname = true;
        }
        if (TextUtils.isEmpty(emailid)) {
            Email.setErrorEnabled(true);
            Email.setError("Enter Email please");
        } else {
            if (emailid.matches(emailpatterrn)) {
                isValidemail = true;
            } else {
                Email.setErrorEnabled(true);
                Email.setError("Enter a Valied Email Id");
            }

        }
        if (TextUtils.isEmpty(password)) {
            Pass.setErrorEnabled(true);
            Pass.setError("Enter Password ");
        } else {
            if (password.length() < 8) {
                Pass.setErrorEnabled(true);
                Pass.setError("Enter Password is requred");

            } else {
                isValidpassword = true;
            }

        }

        if (TextUtils.isEmpty(confermpassword)) {
            cpass.setErrorEnabled(true);
            cpass.setError("Enter password conferm");
        } else {
            if (!password.equals(confermpassword)) {
                cpass.setErrorEnabled(true);
                cpass.setError("password dosents Matches");
            } else {
                isValidconfermpassword = true;
            }
        }
        if (TextUtils.isEmpty(mobile)) {
            mobileno.setErrorEnabled(true);
            mobileno.setError("Enter mobile ");
        } else {
            isValidmobilenum = true;
        }

        if (TextUtils.isEmpty(Area)) {
            area.setErrorEnabled(true);
            area.setError("Enter Area is requred");
        } else {
            isValidarea = true;
        }
        if (TextUtils.isEmpty(house)) {
            houseno.setErrorEnabled(true);
            houseno.setError("Enter house is requred");
        } else {
            isValidhouseno = true;
        }
        isValid = (isValidarea && isValidconfermpassword && isValidemail && isValidhouseno && isValidlname && isValidmobilenum && isValidname && isValidpassword);
        return isValid;
    }
}