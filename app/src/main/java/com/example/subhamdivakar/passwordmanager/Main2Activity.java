package com.example.subhamdivakar.passwordmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.subhamdivakar.passwordmanager.Bean.ContactSaving;
import com.example.subhamdivakar.passwordmanager.Bean.EmailClass;
import com.example.subhamdivakar.passwordmanager.UTILS.SqDB;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //recyclerview objects
    private RecyclerView recyclerView;
    String head="No Email Stored",desc="No Password Stored";
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    //model object for our list data
    private List<MyList> list;
    String headmails[]=new String[10];
    String passwords[]=new String[10];
    String mails[]=new String[10];

    //popup
    Button copyPopupBtn;
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        //initializing views
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        headmail_loader();
        mail_loader();
        password_loader();
        //loading list view item with this function
        loadRecyclerViewItem();
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void loadRecyclerViewItem() {
        //you can fetch the data from server or some apis
        //for this tutorial I am adding some dummy data directly
        //SqDB db = new SqDB(this);
        //EmailClass obj1=db.getEmail();
        //ContactSaving obj2=db.getPassword();
        //if(obj1==null || obj2==null) {
            for (int i = 0; i <=9; i++) {
                MyList myList = new MyList(
                        headmails[i],
                        mails[i]
                );
                list.add(myList);
            }

            adapter = new CustomAdapter(list, this);
            recyclerView.setAdapter(adapter);
        //}
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "PASS WRAP");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Click to contact us ");
            startActivity(Intent.createChooser(sharingIntent, "Share via"));



        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
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
        headmails[8]="LINKED IN";
        headmails[9]="PHONE PAY";
    }

    public void password_loader()
    {
        SqDB db=new SqDB(this);
        ContactSaving obj2=db.getPassword();
        if(obj2!=null) {
            if (obj2.gmail != null) {
                passwords[0] = obj2.gmail;
            } else {
                passwords[0] = desc;
            }
            if (obj2.fb != null) {
                passwords[0] = obj2.fb;
            } else {
                passwords[0] = desc;
            }
            if (obj2.fb != null) {
                passwords[1] = obj2.fb;
            } else {
                passwords[1] = desc;
            }
            if (obj2.twitter != null) {
                passwords[2] = obj2.twitter;
            } else {
                passwords[2] = desc;
            }
            if (obj2.paytm != null) {
                passwords[3] = obj2.paytm;
            } else {
                passwords[3] = desc;
            }
            if (obj2.uber != null) {
                passwords[4] = obj2.uber;
            } else {
                passwords[4] = desc;
            }
            if (obj2.ola != null) {
                passwords[5] = obj2.ola;
            } else {
                passwords[5] = desc;
            }
            if (obj2.microsoft != null) {
                passwords[6] = obj2.microsoft;
            } else {
                passwords[6] = desc;
            }
            if (obj2.irctc != null) {
                passwords[7] = obj2.irctc;
            } else {
                passwords[7] = desc;
            }
            if (obj2.linkedin != null) {
                passwords[8] = obj2.linkedin;
            } else {
                passwords[8] = desc;
            }
            if (obj2.phonepay != null) {
                passwords[9] = obj2.phonepay;
            } else {
                passwords[9] = desc;
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Empty emails", Toast.LENGTH_SHORT).show();
            for(int i=0;i<10;i++)
            {
                passwords[i]="null";
            }
            }
    }//pass_word

    public void mail_loader()
    {
        SqDB db=new SqDB(this);
        EmailClass obj2=db.getEmail();
        if(obj2!=null) {
            if (obj2.gmail != null) {
                mails[0] = obj2.gmail;
            } else {
                mails[0] = desc;
            }
            if (obj2.fb != null) {
                mails[1] = obj2.fb;
            } else {
                mails[1] = head;
            }
            if (obj2.twitter != null) {
                mails[2] = obj2.twitter;
            } else {
                mails[2] = head;
            }
            if (obj2.paytm != null) {
                mails[3] = obj2.paytm;
            } else {
                mails[3] = head;
            }
            if (obj2.uber != null) {
                mails[4] = obj2.uber;
            } else {
                mails[4] = head;
            }
            if (obj2.ola != null) {
                mails[5] = obj2.ola;
            } else {
                mails[5] = head;
            }
            if (obj2.microsoft != null) {
                mails[6] = obj2.microsoft;
            } else {
                mails[6] = head;
            }
            if (obj2.irctc != null) {
                mails[7] = obj2.irctc;
            } else {
                mails[7] = head;
            }
            if (obj2.linkedin != null) {
                mails[8] = obj2.linkedin;
            } else {
                mails[8] = head;
            }
            if (obj2.phonepay != null) {
                mails[9] = obj2.phonepay;
            } else {
                mails[9] = head;
            }
        }
        else{
        Toast.makeText(getApplicationContext(), "Empty emails", Toast.LENGTH_SHORT).show();
        for(int i=0;i<10;i++)
        {
            mails[i]="null";
        }
    }
    }//pass_word


}
