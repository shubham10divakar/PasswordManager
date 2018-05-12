package com.example.subhamdivakar.passwordmanager;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public  class LoginActivity extends AppCompatActivity {


    private DatabaseReference mDatabase;
    private FirebaseUser mCurrentUser;
    TextInputLayout LoginMasterPassword;
    EditText e1;
    String passwordDatabase, passwordEntered;
    Button LogIn;
    String email;
    TextView forgotPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        int i,j;
        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
        email = mCurrentUser.getEmail().toString();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

        LoginMasterPassword = (TextInputLayout) findViewById(R.id.textInputLayoutLoginMasterPassword);
        LogIn = (Button) findViewById(R.id.buttonLogIn);
        forgotPassword = (TextView) findViewById(R.id.textViewForgotPassword2);
        e1 = (EditText) findViewById(R.id.editTextLogIn);

        final String current_uid = mCurrentUser.getUid();
        e1.setOnEditorActionListener(editorListener);


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                passwordDatabase = dataSnapshot.child(current_uid).getValue().toString();

                //Toast.makeText(getApplicationContext(), password, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });


        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordEntered = LoginMasterPassword.getEditText().getText().toString();

                try {
                    if (passwordDatabase.equals(passwordEntered)) {
                        LoginMasterPassword.getEditText().setText("");
                        startActivity(new Intent(LoginActivity.this, Main2Activity.class));


                    } else {
                        LoginMasterPassword.getEditText().setText("");
                        Toast.makeText(getApplicationContext(), "Password Incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
                catch(NullPointerException e)
                {

                    Toast.makeText(LoginActivity.this, "Check your Internet Connection or another error", Toast.LENGTH_SHORT).show();

                }
                catch (Exception e)
                {
                    Toast.makeText(LoginActivity.this, "Check your Internet Connection or another error", Toast.LENGTH_SHORT).show();
                }

            }
        });


        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Email Sent!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
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

                case EditorInfo.IME_ACTION_SEND: {
                    
                    passwordEntered = LoginMasterPassword.getEditText().getText().toString();

                    if(passwordEntered!=null) {
                        if (passwordDatabase.equals(passwordEntered)) {
                            LoginMasterPassword.getEditText().setText("");
                            startActivity(new Intent(LoginActivity.this, Main2Activity.class));

                            Toast.makeText(getApplicationContext(), "Logging In", Toast.LENGTH_SHORT).show();

                        } else {
                            LoginMasterPassword.getEditText().setText("");
                            Toast.makeText(getApplicationContext(), "Password Incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }else
                    {
                        Toast.makeText(getApplicationContext(), "Check your internet connection", Toast.LENGTH_SHORT).show();
                    }
                }


                break;
            }
            return false;

        }
    };




}
