package com.example.subhamdivakar.passwordmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PasswordViewer extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_viewer);
        getPassword();
    }
    public void getPassword()
    {
        TextView txt=(TextView)findViewById(R.id.txtview);
        if(getIntent().hasExtra("list"))
        {
            txt.setText(getIntent().getStringExtra("list"));
        }
    }
}
