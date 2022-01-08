package com.example.flagfinder;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlagGridActivity extends AppCompatActivity {
    private List<Country> countrylist = new ArrayList<>();
    private CustomAdapterFlag adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new CustomAdapterFlag(this);

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