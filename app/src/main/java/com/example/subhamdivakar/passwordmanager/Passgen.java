package com.example.subhamdivakar.passwordmanager;

import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Passgen extends AppCompatActivity {
    Button okbtn;
    TextView hint;
    TextView passview;
    EditText passlenth;
    int length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passgen);
        okbtn = (Button) findViewById(R.id.passgen_okbtn);
        hint=(TextView)findViewById(R.id.textView4);
        passlenth = (EditText) findViewById(R.id.passgen_len);
        passview = (TextView) findViewById(R.id.passgen_show);

        try {
            okbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    length = Integer.parseInt(passlenth.getText().toString());
                    if (length >= 6 && length <= 30) {

                        String password = generatePassword(length);
                        passview.setText(password);
                        hint.setVisibility(View.VISIBLE);

                    } else {
                        Toast.makeText(Passgen.this, "Enter length between 6 to 30", Toast.LENGTH_LONG).show();
                    }
                }
            });
            passview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    registerForContextMenu(passview);
                }
            });
        }catch (Exception e){
            Toast.makeText(Passgen.this, (CharSequence) e,Toast.LENGTH_SHORT).show();
        }

    }


    private static String generatePassword(int len) {
        System.out.println("Generating password using random() : ");
        System.out.print("Your new password is : ");

        // A strong password has Cap_chars, Lower_chars,
        // numeric value and symbols. So we are using all of
        // them to generate our password
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";


        String values = Capital_chars + Small_chars +
                numbers + symbols;

        // Using random method
        Random rndm_method = new Random();

        char[] password = new char[len];

        for (int i = 0; i < len; i++) {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            password[i] =
                    values.charAt(rndm_method.nextInt(values.length()));

        }
        String mpassword = password.toString();
        return mpassword;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        // user has long pressed your TextView
        menu.add(0, v.getId(), 0,
                "Copy");

        // cast the received View to TextView so that you can get its text
        TextView passview = (TextView) v;

        // place your TextView's text in clipboard
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        clipboard.setText(passview.getText());
    }
}


