package com.example.gunbattle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameModel model = new GameModel();
        model.create(10, 2, 6);

        GameViewListenerImpl gvl = new GameViewListenerImpl();

        GameView view = (GameView) findViewById(R.id.view);
        view.setModel(model);
        view.setGameViewListener(gvl);
    }
}