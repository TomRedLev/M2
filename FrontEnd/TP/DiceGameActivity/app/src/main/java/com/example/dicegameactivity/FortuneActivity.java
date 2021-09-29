package com.example.dicegameactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONTokener;

public class FortuneActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortune);

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(button -> {
            Toast t = Toast.makeText(this, getResources().getString(R.string.toast_text), Toast.LENGTH_SHORT);
            t.show();
            finish();
        });

        final TextView textView = (TextView) findViewById(R.id.textView2);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://fortuneapi.herokuapp.com/";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText(unescapeJSONString(response));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work because of this error: " + error);
            }
        });

        queue.add(stringRequest);
    }





    public static String unescapeJSONString(String v) {
        try {
            return new JSONTokener(v).nextValue().toString();
        } catch (JSONException e) {
            Log.v("json", e.toString());
            return "";
        }

    }

}