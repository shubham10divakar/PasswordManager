package com.example.subhamdivakar.passwordmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.subhamdivakar.passwordmanager.Bean.ContactSaving;
import com.example.subhamdivakar.passwordmanager.UTILS.SqDB;

public class PasswordViewer extends AppCompatActivity {



    String headmails[]=new String[10];
    String passwords[]=new String[10],desc="Not Stored";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_viewer);
        headmail_loader();
        password_loader();
        getPassword();
    }
    public void getPassword()
    {
        TextView txt=(TextView)findViewById(R.id.txtview);
        if(getIntent().hasExtra("list"))
        {
            //txt.setText(getIntent().getStringExtra("list"));
            String id=getIntent().getStringExtra("list");
            for(int i=0;i<10;i++)
            {
               if(id.equalsIgnoreCase(headmails[i]))
               {
                   txt.setText(passwords[i]);
                   break;
               }
            }
        }
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

    public void password_loader()
    {
        SqDB db=new SqDB(this);
        ContactSaving obj2=db.getPassword();
        if (obj2.gmail!=null)
        {
            passwords[0]=obj2.gmail;
        }
        else
        {
            passwords[0]=desc;
        }
        if (obj2.fb!=null)
        {
            passwords[0]=obj2.fb;
        }
        else
        {
            passwords[0]=desc;
        }
        if (obj2.fb!=null)
        {
            passwords[1]=obj2.fb;
        }
        else
        {
            passwords[1]=desc;
        }
        if (obj2.twitter!=null)
        {
            passwords[2]=obj2.twitter;
        }
        else
        {
            passwords[2]=desc;
        }
        if (obj2.paytm!=null)
        {
            passwords[3]=obj2.paytm;
        }
        else
        {
            passwords[3]=desc;
        }
        if (obj2.uber!=null)
        {
            passwords[4]=obj2.uber;
        }
        else
        {
            passwords[4]=desc;
        }
        if (obj2.ola!=null)
        {
            passwords[5]=obj2.ola;
        }
        else
        {
            passwords[5]=desc;
        }
        if (obj2.microsoft!=null)
        {
            passwords[6]=obj2.microsoft;
        }
        else
        {
            passwords[6]=desc;
        }
        if (obj2.irctc!=null)
        {
            passwords[7]=obj2.irctc;
        }
        else
        {
            passwords[7]=desc;
        }
        if (obj2.linkedin!=null)
        {
            passwords[8]=obj2.linkedin;
        }
        else
        {
            passwords[8]=desc;
        }
        if (obj2.phonepay!=null)
        {
            passwords[9]=obj2.phonepay;
        }
        else
        {
            passwords[9]=desc;
        }
    }//pass_word

}
