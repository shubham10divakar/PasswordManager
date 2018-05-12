package com.example.subhamdivakar.passwordmanager;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
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
    EditText e1,e2;
    String current_uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_password_sign_up);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mCurrentUser=FirebaseAuth.getInstance().getCurrentUser();

        current_uid=mCurrentUser.getUid();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");



        MasterPassword=(TextInputLayout)findViewById(R.id.textInputLayoutMasterPassword);
        CnfMasterPassword=(TextInputLayout)findViewById(R.id.textInputLayoutCnfrmMasterPassword);
        Save=(Button)findViewById(R.id.buttonSave);
        ForgotPassword=(TextView)findViewById(R.id.textViewForgotPassword);
        HaveAPassword=(TextView)findViewById(R.id.textViewAlreadyAccount);
        HaveAPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MasterPasswordSignUp.this,LoginActivity.class));
            }
        });

        e1 = (EditText) findViewById(R.id.editTextMasterPassword);
        e2=(EditText) findViewById(R.id.editTextCnfrmMasterPassword);

        e1.setOnEditorActionListener(editorListener);
        e2.setOnEditorActionListener(editorListener);



        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password = MasterPassword.getEditText().getText().toString();
                cnfpassword = CnfMasterPassword.getEditText().getText().toString();
                if (password != null) {
                    if (TextUtils.isEmpty(password) || TextUtils.isEmpty(cnfpassword)) {
                        Toast.makeText(getApplicationContext(), "One of the field is missing", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        if (password.length() <= 6) {
                            Toast.makeText(getApplicationContext(), "Length must be greater than 6", Toast.LENGTH_SHORT).show();
                            return;

                        } else {
                            if (!(password.equals(cnfpassword))) {
                                Toast.makeText(getApplicationContext(), "Both passwords must be same", Toast.LENGTH_SHORT).show();
                                return;
                            } else {
                                mDatabase.child(current_uid).setValue(password);
                                startActivity(new Intent(MasterPasswordSignUp.this, Main2Activity.class));
                                finish();
                                return;
                            }
                        }
                    }
                }else
                {
                    Toast.makeText(getApplicationContext(), "Check your internet connection", Toast.LENGTH_SHORT).show();
                }
            }
        });







    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }


    private TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            switch (actionId) {
                case EditorInfo.IME_ACTION_NEXT:
                    Toast.makeText(getApplicationContext(), "Enter confirm master password", Toast.LENGTH_SHORT).show();
                    break;
                case EditorInfo.IME_ACTION_SEND: {
                    password = MasterPassword.getEditText().getText().toString();
                    cnfpassword = CnfMasterPassword.getEditText().getText().toString();

                    if (TextUtils.isEmpty(password) || TextUtils.isEmpty(cnfpassword)) {
                        Toast.makeText(getApplicationContext(), "One of the field is missing", Toast.LENGTH_SHORT).show();

                    } else {
                        if (password.length() <= 6) {
                            Toast.makeText(getApplicationContext(), "Length must be greater than 6", Toast.LENGTH_SHORT).show();


                        } else {
                            if (!(password.equals(cnfpassword))) {
                                Toast.makeText(getApplicationContext(), "Both passwords must be same", Toast.LENGTH_SHORT).show();

                            } else {
                                mDatabase.child(current_uid).setValue(password);
                                Toast.makeText(getApplicationContext(), "Welcome to Pass Wrap", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MasterPasswordSignUp.this, Main2Activity.class));
                                finish();
                            }
                        }
                    }


                    break;
                }
            }
            return false;
        }
    };
}
