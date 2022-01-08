package com.example.flagfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CountryListActivity extends AppCompatActivity {
    private List<Country> countrylist = new ArrayList<>();
    private CustomAdapter adapter = new CustomAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerview);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        try {
           countrylist = Country.loadList(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < countrylist.size(); i++) {
            adapter.addCountry(countrylist.get(i));
        }
    }
}