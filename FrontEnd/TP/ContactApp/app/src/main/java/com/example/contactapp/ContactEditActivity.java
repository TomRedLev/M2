package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ContactEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_edit);

        final int[] DIGIT_BUTTONS = new int[]{ R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};

        for (final int id: DIGIT_BUTTONS) {
            Button b = findViewById(id);
            b.setOnClickListener( (v) -> {
                TextView tv = findViewById(R.id.textView2);
                tv.setText(tv.getText().toString() + b.getText().toString());
            });
        }

        Button b2 = findViewById(R.id.backButton);
        b2.setOnClickListener((v) -> {
            TextView tv = findViewById(R.id.textView2);
            String str = tv.getText().toString();
            if (str.length() > 0) {
                tv.setText(str.substring(0, str.length() - 1));
            }
        });

        Button b3 = findViewById(R.id.modifyButton);
        b3.setOnClickListener((v) -> {
            TextView tvNam = findViewById(R.id.EditText);
            TextView tvNum = findViewById(R.id.textView2);
            //Toast t = Toast.makeText(this, tvNam.getText().toString() + "\n" + tvNum.getText().toString(), Toast.LENGTH_SHORT);
            //t.show();
            Intent intent = new Intent();
            intent.putExtra("name", tvNam.getText().toString());
            intent.putExtra("number", tvNum.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        });

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String number = intent.getStringExtra("number");
        TextView tvNam = findViewById(R.id.EditText);
        TextView tvNum = findViewById(R.id.textView2);
        tvNam.setText(name);
        tvNum.setText(number);
    }
}