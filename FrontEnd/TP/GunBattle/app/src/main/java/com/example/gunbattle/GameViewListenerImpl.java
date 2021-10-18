package com.example.gunbattle;

import android.content.Context;
import android.widget.Toast;

import java.util.Date;

public class GameViewListenerImpl implements GameViewListener {

    private Context context;
    private GameModel model;

    public GameViewListenerImpl() {
    }

    @Override
    public void onGunClick(int gunIndex) {
        Toast toast = Toast.makeText(context, "Position : " + gunIndex, Toast.LENGTH_SHORT);
        toast.show();
        model.setSelectedGun(gunIndex);
    }

    @Override
    public GunShot onGunShot(int gunIndex, float angle, int elem_size) {
        Date date = new Date();
        return new GunShot(date.getTime(), 9.81f, 30, angle, gunIndex * elem_size);
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void setModel(GameModel model) {
        this.model = model;
    }
}
