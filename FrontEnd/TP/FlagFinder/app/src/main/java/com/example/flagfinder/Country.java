package com.example.flagfinder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Country {
    public final String code;
    public final String name;
    private transient Bitmap cachedFlag = null;

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return code.equals(country.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }

    public static final String DATA_LOCATION = "data";

    public Bitmap getFlag(Context context) throws IOException {
        if (cachedFlag != null) return cachedFlag;
        InputStream is = context.getAssets().open(DATA_LOCATION + "/flags/" + code + ".png");
        try {
            Bitmap b = BitmapFactory.decodeStream(is);
            cachedFlag = b;
            return b;
        } finally {
            is.close();
        }
    }

    public static List<Country> loadList(Context context) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(context.getAssets().open(DATA_LOCATION + "/countries.json")));
        StringBuilder sb = new StringBuilder();
        for (String line = br.readLine(); line != null; line = br.readLine())
            sb.append(line + "\n");
        String text = sb.toString();
        return new Gson().fromJson(text, new TypeToken<List<Country>>() {}.getType());
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
