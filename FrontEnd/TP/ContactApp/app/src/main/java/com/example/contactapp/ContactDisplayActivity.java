package com.example.contactapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ContactDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_display);

        String name = "Bugdroid";
        String number = "33758596061";

        Intent intent = new Intent(this, ContactEditActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("number", number);

        Button b = findViewById(R.id.Edit);
        b.setOnClickListener( (v) -> {
            startActivityForResult(intent, 1);
        });

        TextView tv1 = (TextView) findViewById(R.id.textViewName2);
        TextView tv2 = (TextView) findViewById(R.id.textViewNumber2);
        tv1.setText(name);
        tv2.setText(number);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String name = data.getStringExtra("name");
        String number = data.getStringExtra("number");

        TextView tv1 = (TextView) findViewById(R.id.textViewName2);
        TextView tv2 = (TextView) findViewById(R.id.textViewNumber2);
        tv1.setText(name);
        tv2.setText(number);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // load the menu from the XML file
        getMenuInflater().inflate(R.menu.menu, menu);
        return true; // do not forget to return true to display the menu
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.call) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            TextView tv2 = (TextView) findViewById(R.id.textViewNumber2);
            intent.setData(Uri.parse("tel:" + tv2.getText().toString()));
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.message) {
            TextView tv2 = (TextView) findViewById(R.id.textViewNumber2);
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:" + tv2.getText().toString()));
            startActivity(intent);
        }
        else {
                return false;
        }
        return true;
    }
}