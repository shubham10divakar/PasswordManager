package com.example.subhamdivakar.passwordmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MasterPasswordSignUp extends AppCompatActivity {

    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_password_sign_up);

        t1=(TextView)findViewById(R.id.textViewPassWrap);
    }
}
