package com.example.dicegameactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private int last_value = 0;
    private int value = 1;
    private int nb_throw = 0;
    private int[] tab = new int[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        for (int i = 0; i < 6; i++) {
            tab[i] = Color.rgb(0.05f * i, 0.1f * i, 0.2f * i);
        }

        Button b = (Button) findViewById(R.id.quitButton);
        b.setOnClickListener(button -> {
            Toast t = Toast.makeText(this, getResources().getString(R.string.toast_text), Toast.LENGTH_SHORT);
            t.show();
            Intent intent = new Intent(this, FortuneActivity.class);
            startActivity(intent);
            finish();
            /*
            Log.v(this.getClass().getName(), "error");
            throw new NullPointerException();
             */
        });

        TextView tv = (TextView) findViewById(R.id.textView);
        String s2 = getResources().getString(R.string.value_of_the_dice, value);
        tv.setText(s2);
        tv.setBackgroundColor(tab[value - 1]);
        tv.setOnClickListener(textview -> {
            last_value = value;
            value = 1 + (int) (Math.random() * (7 - 1));
            nb_throw += 1;
            String s = getResources().getString(R.string.value_of_the_dice, value);
            tv.setText(s);
            tv.setBackgroundColor(tab[value - 1]);
            if (value == 6 && value == last_value) {
                Toast t = Toast.makeText(this, getResources().getString(R.string.toast_text_second, nb_throw), Toast.LENGTH_SHORT);
                t.show();
                Intent intent = new Intent(this, FortuneActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}