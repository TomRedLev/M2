package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ContactDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_display);

        String name = "Bugdroid";
        String number = "33758596061";

        TextView tv1 = (TextView) findViewById(R.id.textViewName2);
        TextView tv2 = (TextView) findViewById(R.id.textViewNumber2);
        tv1.setText(name);
        tv2.setText(number);
    }
}