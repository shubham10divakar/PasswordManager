package com.example.subhamdivakar.passwordmanager;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.subhamdivakar.passwordmanager.Bean.EmailClass;
import com.example.subhamdivakar.passwordmanager.UTILS.SqDB;

import java.io.Serializable;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<MyList> list;
    private Context mCtx;
    String mails[] = new String[10];
    String headmails[]=new String[10];
    String passwords[]=new String[10],desc="Not Stored";
    String head="Not Stored";

    public CustomAdapter(List<MyList> list, Context mCtx) {
        this.list = list;
        this.mCtx = mCtx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_items, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CustomAdapter.ViewHolder holder, final int position) {
        final MyList myList = list.get(position);
        holder.textViewHead.setText(myList.getHead());
        holder.textViewDesc.setText(myList.getDesc());
        final String d=myList.getHead();

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d.equals("No Email Stored")) {

                }else{
                    Intent intent = new Intent(mCtx, PasswordViewer.class);
                    intent.putExtra("list", d);
                    mCtx.startActivity(intent);
                }
            }
        });

        holder.buttonViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //creating a popup menu
                PopupMenu popup = new PopupMenu(mCtx, holder.buttonViewOption);
                //inflating menu from xml resource
                popup.inflate(R.menu.options_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu1:
                                //handle menu1 click
                                if(check(d)==false) {
                                    Intent intent = new Intent(mCtx, MainActivity.class);
                                    intent.putExtra("list", d);
                                    mCtx.startActivity(intent);
                                }
                                else
                                {
                                    //toast
                                }
                                break;
                            case R.id.menu2:
                                //handle menu2 click
                                //db.execSQL("delete from "+ TABLE_NAME);
                                Intent intent2 = new Intent(mCtx, MainActivity.class);
                                intent2.putExtra("list", d);
                                mCtx.startActivity(intent2);
                                break;
                            case R.id.menu3:
                                //handle menu2 click
                                break;

                        }
                        return false;
                    }
                });
                //displaying the popup
                popup.show();

            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHead;
        public TextView textViewDesc;
        public TextView buttonViewOption;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            buttonViewOption = (TextView) itemView.findViewById(R.id.textViewOptions);
            parentLayout=itemView.findViewById(R.id.parent_layout);

        }

    }
    int pos;
    public boolean check(String id)
    {
        headmail_loader();
        mail_loader();
        boolean flag= false;
        for(int i=0;i<10;i++)
        {
            if(id.equalsIgnoreCase(headmails[i]))
            {
                if(mails[i]==head) {
                flag=false;
                }
                else
                {
                    flag=true;
                }
                break;
            }
        }
        return flag;
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
        headmails[8]="LINKEDIN";
        headmails[9]="PHONEPAY";
    }//headmail
    public void mail_loader() {
        SqDB db = new SqDB(this.mCtx);
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
