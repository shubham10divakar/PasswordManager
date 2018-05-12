package com.example.subhamdivakar.passwordmanager;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
    String head = "No Email Stored", desc = "No Password Stored";
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    //model object for our list data
    private List<MyList> list;
    String headmails[] = new String[12];
    String passwords[] = new String[12];
    String mails[] = new String[12];

    //popup
    Button copyPopupBtn;
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        headmail_loader();
        mail_loader();
        password_loader();
        //initializing views
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        list = new ArrayList<>();
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
        headmail_loader();
        mail_loader();
        password_loader();
        for (int i = 0; i <= 9; i++) {
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
            moveTaskToBack(true);
        }
        //finish();
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
        } else if (id == R.id.nav_rateus) {

            Uri uri = Uri.parse("market://details?id=" + getApplication().getPackageName());
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            // To count with Play market backstack, After pressing back button,
            // to taken back to our application, we need to add following flags to intent.
            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName())));
            }

        } else if (id == R.id.nav_feedback) {


            Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{"passwrap@gmail.com"});
            email.putExtra(Intent.EXTRA_SUBJECT, "Feedback from user");
            email.putExtra(Intent.EXTRA_TEXT, "Write your feedback here");
            email.setType("message/rfc822");
            startActivity(Intent.createChooser(email, "Choose an Email client :"));

        } else if (id == R.id.nav_passgen) {
            Intent intent=new Intent(Main2Activity.this,Passgen.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "PASS WRAP");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, " App link here ");
            startActivity(Intent.createChooser(sharingIntent, "Share via"));


        } else if (id == R.id.nav_exit) {

            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Closing Activity")
                    .setMessage("Are you sure you want to close this activity?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            

                            moveTaskToBack(true);

                        }

                    })
                    .setNegativeButton("No", null)
                    .show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void headmail_loader()
    {
        headmails[0] = "GMAIL";
        headmails[1] = "FACEBOOK";
        headmails[2] = "TWITTER";
        headmails[3] = "PAYTM";
        headmails[4] = "UBER";
        headmails[5] = "OLA";
        headmails[6] = "MICROSOFT";
        headmails[7] = "IRCTC";
        headmails[8] = "LINKEDIN";
        headmails[9] = "PHONEPAY";
        headmails[10]="AMAZON";
        headmails[11]="FLIPKART";
    }

    public void password_loader() {
        SqDB db = new SqDB(this);
        ContactSaving obj1 = db.getPassword1();
        if (obj1 != null) {
            if (obj1.gmail != null) {
                passwords[0] = obj1.gmail;
            } else {
                passwords[0] = desc;
            }
        } else {
            passwords[0] = desc;
        }

        ContactSaving obj2 = db.getPassword2();
        if (obj2 != null) {
            if (obj2.fb != null) {
                passwords[1] = obj2.fb;
            } else {
                passwords[1] = desc;
            }
        } else {
            passwords[1] = desc;
        }

     ContactSaving obj3 = db.getPassword3();
        if(obj3!=null) {
            if (obj3.twitter != null) {
                passwords[2] = obj3.twitter;
            } else {
                passwords[2] = desc;
            }
        }
        else
        {
            passwords[6] = desc;
        }
            ContactSaving obj4 = db.getPassword4();
            if(obj4!=null) {
                if (obj4.paytm != null) {
                    passwords[3] = obj4.paytm;
                } else {
                    passwords[3] = desc;
                }
            }
            else
            {
                passwords[6] = desc;
            }
            ContactSaving obj5 = db.getPassword5();
                if(obj5!=null) {
                    if (obj5.uber != null) {
                        passwords[4] = obj5.uber;
                    } else {
                        passwords[4] = desc;
                    }
                }else
                {
                    passwords[6] = desc;
                }

            ContactSaving obj6 = db.getPassword6();
                    if(obj6!=null) {
                        if (obj6.ola != null) {
                            passwords[5] = obj6.ola;
                        } else {
                            passwords[5] = desc;
                        }
                    }
                    else
                    {
                        passwords[5] = desc;
                    }
            ContactSaving obj7 = db.getPassword7();
                        if(obj7!=null) {
                            if (obj7.microsoft != null) {
                                passwords[6] = obj7.microsoft;
                            } else {
                                passwords[6] = desc;
                            }
                        }
                        else
                        {
                            passwords[6] = desc;
                        }
            ContactSaving obj8 = db.getPassword8();
                            if(obj8!=null) {
                                if (obj8.irctc != null) {
                                    passwords[7] = obj8.irctc;
                                } else {
                                    passwords[7] = desc;
                                }
                            }else{
                                passwords[7] = desc;
                            }
            ContactSaving obj9 = db.getPassword1();
                                if(obj9!=null) {
                                    if (obj9.linkedin != null) {
                                        passwords[8] = obj9.linkedin;
                                    } else {
                                        passwords[8] = desc;
                                    }
                                }
                                else
                                {
                                    passwords[8] = desc;
                                }
            ContactSaving obj10 = db.getPassword10();
                                    if(obj10!=null) {
                                        if (obj10.phonepay != null) {
                                            passwords[9] = obj10.phonepay;
                                        } else {
                                            passwords[9] = desc;
                                        }
                                    }else{
                                        passwords[9] = desc;
                                    }
    }//pass_word


    public void mail_loader() {
        SqDB db = new SqDB(this);
        EmailClass obj1 = db.getEmail1();
        if(obj1!=null) {
            if (obj1.gmail != null) {
                mails[0] = obj1.gmail;
            } else {
                mails[0] = head;
            }
        }else {
            mails[0] = head;
        }
            EmailClass obj2 = db.getEmail2();
            if(obj2!=null) {
                if (obj2.fb != null) {
                    mails[1] = obj2.fb;
                } else {
                    mails[1] = head;
                }
            }else {
                mails[1] = head;
            }
            EmailClass obj3 = db.getEmail3();
            if(obj3!=null) {
                if (obj3.twitter != null) {
                    mails[2] = obj3.twitter;
                } else {
                    mails[2] = head;
                }
            }
            else {
                mails[2]=head;
            }
            EmailClass obj4 = db.getEmail4();
        if(obj4!=null) {
            if (obj4.paytm != null) {
                mails[3] = obj4.paytm;
            } else {
                mails[3] = head;
            }
        }else {
            mails[3]=head;
        }
            EmailClass obj5 = db.getEmail5();
        if(obj5!=null) {
            if (obj5.uber != null) {
                mails[4] = obj5.uber;
            } else {
                mails[4] = head;
            }
        }
        else {
            mails[4]=head;
        }
            EmailClass obj6 = db.getEmail6();
        if(obj6!=null) {
            if (obj6.ola != null) {
                mails[5] = obj6.ola;
            } else {
                mails[5] = head;
            }
        }else {
            mails[5]=head;
        }
            EmailClass obj7 = db.getEmail7();
        if(obj7!=null) {
            if (obj7.microsoft != null) {
                mails[6] = obj7.microsoft;
            } else {
                mails[6] = head;
            }
        }
        else {
            mails[6]=head;
        }
            EmailClass obj8 = db.getEmail8();
        if(obj8!=null) {
            if (obj8.irctc != null) {
                mails[7] = obj8.irctc;
            } else {
                mails[7] = head;
            }
        }
        else {
            mails[7]=head;
        }
            EmailClass obj9 = db.getEmail9();
        if(obj9!=null) {
            if (obj9.linkedin != null) {
                mails[8] = obj9.linkedin;
            } else {
                mails[8] = head;
            }
        }
        else {
            mails[8]=head;
        }
            EmailClass obj10 = db.getEmail10();
        if(obj10!=null) {
            if (obj10.phonepay != null) {
                mails[9] = obj10.phonepay;
            } else {
                mails[9] = head;
            }
        }else
        {
            mails[9]=head;
        }
    }



}
