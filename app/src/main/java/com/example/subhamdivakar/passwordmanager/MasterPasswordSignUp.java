package com.example.subhamdivakar.passwordmanager;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MasterPasswordSignUp extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private FirebaseUser mCurrentUser;
    TextInputLayout MasterPassword,CnfMasterPassword;
    Button Save;
    TextView ForgotPassword,HaveAPassword;
    String password,cnfpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_password_sign_up);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mCurrentUser=FirebaseAuth.getInstance().getCurrentUser();

        final String current_uid=mCurrentUser.getUid();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");



        MasterPassword=(TextInputLayout)findViewById(R.id.textInputLayoutMasterPassword);
        CnfMasterPassword=(TextInputLayout)findViewById(R.id.textInputLayoutCnfrmMasterPassword);
        Save=(Button)findViewById(R.id.buttonSave);
        ForgotPassword=(TextView)findViewById(R.id.textViewForgotPassword);
        HaveAPassword=(TextView)findViewById(R.id.textViewAlreadyAccount);



        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password=MasterPassword.getEditText().getText().toString();
                cnfpassword=CnfMasterPassword.getEditText().getText().toString();

                if (TextUtils.isEmpty(password)||TextUtils.isEmpty(cnfpassword)) {
                    Toast.makeText(getApplicationContext(), "One of the field is missing", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    if (password.length() <= 6) {
                        Toast.makeText(getApplicationContext(), "Length must be greater than 6", Toast.LENGTH_SHORT).show();
                        return;

                    }
                    else
                    {
                    if (!(password.equals(cnfpassword))) {
                        Toast.makeText(getApplicationContext(), "Both passwords must be same", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        mDatabase.child(current_uid).setValue(password);
                        startActivity(new Intent(MasterPasswordSignUp.this,MainActivity.class));
                        finish();
                        return;
                    }}
                }



            }
        });







    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
