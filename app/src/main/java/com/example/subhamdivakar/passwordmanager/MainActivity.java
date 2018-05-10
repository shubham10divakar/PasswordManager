package com.example.subhamdivakar.passwordmanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.subhamdivakar.passwordmanager.Bean.ContactSaving;
import com.example.subhamdivakar.passwordmanager.Bean.EmailClass;
import com.example.subhamdivakar.passwordmanager.UTILS.SqDB;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText inputEmail, inputPassword;
    private ProgressBar progressBar;
    private Button btnSignIn;
    String password,email;
    int i,pos;
    ImageView img;
    String headmails[]=new String[10];
    String passwords[]=new String[10],desc="Not Stored";
    String emails[]=new String[10];
    String head1="Not Stored";
    String head12="EMPTY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        headmail_loader();
        btnSignIn = (Button) findViewById(R.id.sign_up_button);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        img=(ImageView)findViewById(R.id.imageload);
         email = inputEmail.getText().toString().trim();
         password = inputPassword.getText().toString().trim();
         image_loader();
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPassword();
            }
        });

    }
    public void getPassword()
    {
        SqDB db=new SqDB(this);
        if(getIntent().hasExtra("list"))
        {
            //txt.setText(getIntent().getStringExtra("list"));
            String id=getIntent().getStringExtra("list");
            for(int i=0;i<10;i++)
            {
                if(id.equalsIgnoreCase(headmails[i]))
                {
                    pos=i+1;
                    break;
                }
            }
        }
        password_loader();
    }//getPassword

    public  void headmail_loader()
    {
        headmails[0]="GMAIL";
        headmails[1]="FACEBOOK";
        headmails[2]="TWITTER";
        headmails[3]="PAYTM";
        headmails[4]="UBER";
        headmails[5]="OLA";
        headmails[6]="MICROSOFT";
        headmails[7]="IRCTC";
        headmails[8]="LINKEDIN";
        headmails[9]="PHONEPAY";
    }//headmail
    private void image_loader() {
        String id=getIntent().getStringExtra("list");
        for(int i=0;i<10;i++)
        {
            if(id.equalsIgnoreCase(headmails[i]))
            {
                pos=i+1;
                break;
            }
        }

        switch (pos){
            case 1:
                img.setImageResource(R.drawable.gmail);
                break;
            case 2:
                img.setImageResource(R.drawable.facebook);
                break;
            case 3:
                img.setImageResource(R.drawable.twitter);
                break;
            case 4:
                img.setImageResource(R.drawable.paytm);
                break;
            case 5:
                img.setImageResource(R.drawable.uber);
                break;
            case 6:
                img.setImageResource(R.drawable.ola);
                break;
            case 7:
                img.setImageResource(R.drawable.microsoft);
                break;
            case 8:
                img.setImageResource(R.drawable.irctc);
                break;
            case 9:
                img.setImageResource(R.drawable.linkedin);
                break;
            case 10:
                img.setImageResource(R.drawable.phonepe);
                break;
        }

    }
    public void password_loader()
    {
        SqDB db=new SqDB(this);
        EmailClass obj1 = db.getEmail1();
        ContactSaving obj2=db.getPassword1();
        //progressBar.setVisibility(View.GONE);
        email = inputEmail.getText().toString().trim();
        password = inputPassword.getText().toString().trim();
        if(obj1!=null && obj2!=null) {
            switch (pos) {
                case 1:

                    if ((obj1 == null && obj2 == null) ) {
                        db.insertEmail1(email);
                        db.insertPassword1(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    } else {
                        db.delete1();
                        db.insertEmail1(email);
                        db.insertPassword1(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    }
                    finish();
                    break;
                case 2:
                    if ((obj1 == null && obj2 == null) ) {
                        db.insertEmail2(email);
                        db.insertPassword2(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    } else {
                        db.delete2();
                        db.insertEmail2(email);
                        db.insertPassword2(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    }
                    finish();
                    break;
                case 3:
                    if ((obj1 == null && obj2 == null) ) {
                        db.insertEmail3(email);
                        db.insertPassword3(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    } else {
                        db.delete3();
                        db.insertEmail3(email);
                        db.insertPassword3(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    }
                    finish();
                    break;
                case 4:
                    if ((obj1 == null && obj2 == null) ) {
                        db.insertEmail4(email);
                        db.insertPassword4(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    } else {
                        db.delete4();
                        db.insertEmail4(email);
                        db.insertPassword4(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    }
                    finish();
                    break;
                case 5:
                    if ((obj1 == null && obj2 == null) ) {
                        db.insertEmail5(email);
                        db.insertPassword5(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    } else {
                        db.delete5();
                        db.insertEmail5(email);
                        db.insertPassword5(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    }
                    finish();
                    break;
                case 6:
                    if ((obj1 == null && obj2 == null)) {
                        db.insertEmail6(email);
                        db.insertPassword6(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    } else {
                        db.delete6();
                        db.insertEmail6(email);
                        db.insertPassword6(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    }
                    finish();
                    break;
                case 7:
                    if ((obj1 == null && obj2 == null)) {
                        db.insertEmail7(email);
                        db.insertPassword7(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    } else {
                        db.delete7();
                        db.insertEmail7(email);
                        db.insertPassword7(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    }
                    finish();
                    break;
                case 8:
                    if ((obj1 == null && obj2 == null) ) {
                        db.insertEmail8(email);
                        db.insertPassword8(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    } else {
                        db.delete8();
                        db.insertEmail8(email);
                        db.insertPassword8(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    }
                    finish();
                    break;
                case 9:
                    if ((obj1 == null && obj2 == null) ) {
                        db.insertEmail9(email);
                        db.insertPassword9(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    } else {
                        db.delete9();
                        db.insertEmail9(email);
                        db.insertPassword9(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    }
                    finish();
                    break;
                case 10:
                    if ((obj1 == null && obj2 == null) ) {
                        db.insertEmail10(email);
                        db.insertPassword10(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    } else {
                        db.delete10();
                        db.insertEmail10(email);
                        db.insertPassword10(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    }
                    finish();
                    break;
            }
        }
        else
        {
            switch (pos) {
                case 1:

                    if ((obj1 == null && obj2 == null) ) {
                        db.insertEmail1(email);
                        db.insertPassword1(password);
                        Toast.makeText(getApplicationContext(), "Stored2", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    } else {
                        db.delete1();
                        db.insertEmail1(email);
                        db.insertPassword1(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    }
                    finish();
                    break;
                case 2:
                    if ((obj1 == null && obj2 == null) ) {
                        db.insertEmail2(email);
                        db.insertPassword2(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    } else {
                        db.delete2();
                        db.insertEmail2(email);
                        db.insertPassword2(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    }
                    finish();
                    break;
                case 3:
                    if ((obj1 == null && obj2 == null) ) {
                        db.insertEmail3(email);
                        db.insertPassword3(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    } else {
                        db.delete3();
                        db.insertEmail3(email);
                        db.insertPassword3(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    }
                    finish();
                    break;
                case 4:
                    if ((obj1 == null && obj2 == null) ) {
                        db.insertEmail4(email);
                        db.insertPassword4(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    } else {
                        db.delete4();
                        db.insertEmail4(email);
                        db.insertPassword4(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    }
                    finish();
                    break;
                case 5:
                    if ((obj1 == null && obj2 == null) ) {
                        db.insertEmail5(email);
                        db.insertPassword5(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    } else {
                        db.delete5();
                        db.insertEmail5(email);
                        db.insertPassword5(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    }
                    finish();
                    break;
                case 6:
                    if ((obj1 == null && obj2 == null) ) {
                        db.insertEmail6(email);
                        db.insertPassword6(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    } else {
                        db.delete6();
                        db.insertEmail6(email);
                        db.insertPassword6(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    }
                    finish();
                    break;
                case 7:
                    if ((obj1 == null && obj2 == null) ) {
                        db.insertEmail7(email);
                        db.insertPassword7(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    } else {
                        db.delete7();
                        db.insertEmail7(email);
                        db.insertPassword7(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    }
                    finish();
                    break;
                case 8:
                    if ((obj1 == null && obj2 == null)) {
                        db.insertEmail8(email);
                        db.insertPassword8(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    } else {
                        db.delete8();
                        db.insertEmail8(email);
                        db.insertPassword8(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    }
                    finish();
                    break;
                case 9:
                    if ((obj1 == null && obj2 == null)) {
                        db.insertEmail9(email);
                        db.insertPassword9(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    } else {
                        db.delete9();
                        db.insertEmail9(email);
                        db.insertPassword9(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    }
                    finish();
                    break;
                case 10:
                    if ((obj1 == null && obj2 == null) ) {
                        db.insertEmail10(email);
                        db.insertPassword10(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    } else {
                        db.delete10();
                        db.insertEmail10(email);
                        db.insertPassword10(password);
                        Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_SHORT).show();
                        Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(obj);
                    }
                    finish();
                    break;
            }
        }
    }//pass_word
}
