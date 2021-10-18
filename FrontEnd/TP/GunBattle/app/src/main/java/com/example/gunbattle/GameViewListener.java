package com.example.gunbattle;

import android.content.Context;

public interface GameViewListener {
    public void onGunClick(int gunIndex);

    public GunShot onGunShot(int gunIndex, float angle, int elem_size);

    public void setContext(Context context);

    public void setModel(GameModel model);
}
