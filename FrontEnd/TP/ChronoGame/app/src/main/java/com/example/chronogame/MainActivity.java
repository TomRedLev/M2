package com.example.chronogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.chromium.base.Log;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    public class State implements Serializable {
        private long time_choose;
        private long timer_start;
        private long timer_current;
        private Toast t;
        private Handler hd = new Handler();
        private Runnable r = new Runnable() {
            @Override
            public void run() {
                timer_current = System.currentTimeMillis() - timer_start;
                TextView tv = findViewById(R.id.displayView);
                tv.setText(String.valueOf(timer_current/1000 + ":" + timer_current % 1000));
                Log.d("ModifiedTime", "The time has been modified");
                if (timer_current/1000 > time_choose * 1.5) {
                    t.show();
                    return ;
                }
                hd.postDelayed(this, 10);
            }
        };

        public void setTimer_current(long timer_current) {
            this.timer_current = timer_current;
        }

        public void setTimer_start(long timer_start) {
            this.timer_start = timer_start;
        }

        public void setTime_choose(int time) {
            this.time_choose = time;
        }

        public void setT(Toast t) {
            this.t = t;
        }

        public Handler getHd() {
            return hd;
        }

        public long getTimer_start() {
            return timer_start;
        }

        public long getTimer_current() {
            return timer_current;
        }

        public long getTime_choose() {
            return time_choose;
        }

        public Runnable getR() {
            return r;
        }
    }

    private State state = new State();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            state = (State) savedInstanceState.getSerializable("state");
        }
        setContentView(R.layout.activity_main);

        state.setT(Toast.makeText(this, "Defeat", Toast.LENGTH_SHORT));

        Button b = findViewById(R.id.startButton);
        b.setOnClickListener( (v) -> {
            state.setTimer_start(System.currentTimeMillis());
            state.getHd().postDelayed(state.getR(), 10);
            TextView tv = findViewById(R.id.textView);
            state.setTime_choose(Integer.valueOf(tv.getText().toString()));
            ImageView iv = findViewById(R.id.imageView);
            iv.setVisibility(View.VISIBLE);
        });

        Button b2 = findViewById(R.id.stopButton);
        b2.setOnClickListener( (v) -> {
            ImageView iv = findViewById(R.id.imageView);
            iv.setVisibility(View.INVISIBLE);
            state.setTimer_current(System.currentTimeMillis() - state.getTimer_start());
            TextView tv = findViewById(R.id.displayView);
            tv.setText(String.valueOf(state.getTimer_current()/1000 + ":" + state.getTimer_current() % 1000) + "\n"
                    + String.valueOf((((state.getTimer_current()/1000) - state.getTime_choose()) / (double) state.getTime_choose()) * 100.0));
            state.getHd().removeCallbacks(state.getR());

        });
    }

    @Override
    protected void onRestart() {
        state.getHd().postDelayed(state.getR(), 10);
        super.onRestart();
    }

    @Override
    protected void onStop() {
        state.getHd().removeCallbacks(state.getR());
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("state", state);
        super.onSaveInstanceState(outState);
    }
}