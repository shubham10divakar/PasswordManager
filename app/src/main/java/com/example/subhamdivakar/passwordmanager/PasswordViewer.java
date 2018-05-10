package com.example.subhamdivakar.passwordmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.subhamdivakar.passwordmanager.Bean.ContactSaving;
import com.example.subhamdivakar.passwordmanager.UTILS.SqDB;

public class PasswordViewer extends AppCompatActivity {



    String headmails[]=new String[10];
    String passwords[]=new String[10],desc="Not Stored";
    int pos=0;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_viewer);
        headmail_loader();
        password_loader();
        image_loader();
        getPassword();
        img=(ImageView)findViewById(R.id.img);
    }

    private void image_loader() {
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
        headmails[9]="PHONEPE";
    }//headmail

    public void password_loader() {
        SqDB db = new SqDB(this);
        ContactSaving obj1 = db.getPassword1();
        if (obj1 != null) {
            if (obj1.gmail != null) {
                pos++;
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
                pos++;
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
                pos++;
                passwords[2] = obj3.twitter;
            } else {
                passwords[2] = desc;
            }
        }
        else
        {
            passwords[2] = desc;
        }
        ContactSaving obj4 = db.getPassword4();
        if(obj4!=null) {
            if (obj4.paytm != null) {
                pos++;
                passwords[3] = obj4.paytm;
            } else {
                passwords[3] = desc;
            }
        }
        else
        {
            passwords[3] = desc;
        }
        ContactSaving obj5 = db.getPassword5();
        if(obj5!=null) {
            if (obj5.uber != null) {
                pos++;
                passwords[4] = obj5.uber;
            } else {
                passwords[4] = desc;
            }
        }else
        {
            passwords[4] = desc;
        }

        ContactSaving obj6 = db.getPassword6();
        if(obj6!=null) {
            if (obj6.ola != null) {
                pos++;
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
                pos++;
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
                pos++;
                passwords[7] = obj8.irctc;
            } else {
                passwords[7] = desc;
            }
        }else{
            passwords[7] = desc;
        }
        ContactSaving obj9 = db.getPassword9();
        if(obj9!=null) {
            if (obj9.linkedin != null) {
                pos++;
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
                pos++;
                passwords[9] = obj10.phonepay;
            } else {
                passwords[9] = desc;
            }
        }else{
            passwords[9] = desc;
        }
    }//pass_word

}
