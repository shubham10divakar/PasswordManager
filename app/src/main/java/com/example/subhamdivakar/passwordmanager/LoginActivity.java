package com.example.subhamdivakar.passwordmanager;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

public class LoginActivity extends AppCompatActivity {


    private DatabaseReference mDatabase;
    private FirebaseUser mCurrentUser;
    TextInputLayout LoginMasterPassword;
    String passwordDatabase,passwordEntered;
    Button LogIn;
    String email;
    TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
        email=mCurrentUser.getEmail().toString();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

        LoginMasterPassword = (TextInputLayout) findViewById(R.id.textInputLayoutLoginMasterPassword);
        LogIn=(Button)findViewById(R.id.buttonLogIn);
        forgotPassword=(TextView)findViewById(R.id.textViewForgotPassword2);

        final String current_uid = mCurrentUser.getUid();

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

                passwordEntered=LoginMasterPassword.getEditText().getText().toString();

                if(passwordDatabase.equals(passwordEntered))
                {
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Password Incorrect", Toast.LENGTH_SHORT).show();
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
}
