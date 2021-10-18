package com.example.gunbattle;

import static android.view.KeyEvent.ACTION_DOWN;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

/**
 * TODO: document your custom view class.
 */
public class GameView extends View {
    private Paint paint_canon;
    private Paint paint_stronghold;
    private Paint paint_rect;
    private Paint paint_ball;

    private GameModel model;
    private GameViewListener gvl;
    private Date date = new Date();
    private GunShot gs;

    private int[] gs_xy = new int[2];
    private Handler hd = new Handler();
    private Runnable r = new Runnable() {
        @Override
        public void run() {
            gs_xy = gs.computePosition(date.getTime());
            if (gs_xy[1] <= 0) {
                gs_xy[0] = 0;
                gs_xy[1] = 0;
                hd.removeCallbacks(this);
                return ;
            }
            invalidate();
            hd.postDelayed(this, 10);
        }
    };

    public GameView(Context context) {
        super(context);
        init(null, 0);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.GameView, defStyle, 0);
        a.recycle();
        paint_canon = new Paint();
        paint_stronghold = new Paint();
        paint_rect = new Paint();
        paint_rect.setColor(Color.RED);
        paint_rect.setStyle(Paint.Style.STROKE);
        paint_rect.setStrokeWidth(5);
        paint_ball = new Paint();
        paint_ball.setColor(Color.BLACK);
        paint_ball.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int contentWidth = getWidth();
        int contentHeight = getHeight();
        Bitmap bm_gun = BitmapFactory.decodeResource(getResources(), R.drawable.canon);
        Bitmap bm_stronghold = BitmapFactory.decodeResource(getResources(), R.drawable.fort);
        int[] positions = model.getPositions();
        int elem_size = contentWidth / positions.length;
        int x1 = 0;
        int y1 = contentHeight - elem_size;
        int x2 = elem_size;
        int y2 = contentHeight;

        for (int i = 0; i < positions.length; i++) {
            if (positions[i] == 1) {
                canvas.drawBitmap(bm_gun, null, new Rect(x1, y1, x2, y2), paint_canon);
                if (model.getSelectedGun() == i) {
                    canvas.drawRect(new Rect(x1, y1, x2, y2), paint_rect);
                }
            }
            if (positions[i] == 2) {
                canvas.drawBitmap(bm_stronghold, null, new Rect(x1, y1, x2, y2), paint_stronghold);
            }
            x1 = x2;
            x2 += elem_size;
        }

        if (gs_xy[0] != 0 && gs_xy[1] != 0) {
            canvas.drawCircle(gs_xy[0], gs_xy[1], 100, paint_ball);
            if (gs_xy[1] >= getHeight() - elem_size && gs_xy[1] <= getHeight()) {
                if (model.destructCheck((int) gs_xy[0], elem_size) != 2) {
                    Toast t = Toast.makeText(getContext(), "Defeat", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        }
    }

    public void setModel(GameModel model) {
        this.model = model;
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        int[] positions = model.getPositions();
        int elem_size = getWidth() / positions.length;
        if (event.getActionMasked() == ACTION_DOWN) {
            if (y >= getHeight() - elem_size && y <= getHeight()) {
                for (int i = 0; i < positions.length; i++) {
                    if (x >= i * elem_size && x <= (i+1) * elem_size && positions[i] == 1) {
                        gvl.onGunClick(i);
                        invalidate();
                    }
                }
            } else if (model.getSelectedGun() != -1) {
                gs = gvl.onGunShot(model.getSelectedGun(), (float) Math.atan(Math.sqrt((getHeight() - y) * (getHeight() - y)) / Math.sqrt((elem_size * model.getSelectedGun() - x) * (elem_size * model.getSelectedGun() - x))), elem_size);
                hd.postDelayed(r, 10);
            }
        }
        return super.onTouchEvent(event);
    }

    public void setGameViewListener(GameViewListener gvl) {
        this.gvl = gvl;
        gvl.setContext(getContext());
        gvl.setModel(model);
    }
}