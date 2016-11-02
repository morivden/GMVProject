package com.example.gmvproject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by YU-YA on 2016/11/02.
 */

public class Player {

    private Rect rect;
    private static final Paint PAINT;
    private static final int MOVE_LEFT_SPEED = 1;
    static { PAINT = new Paint();  PAINT.setColor(Color.RED); }

    public Player(int left, int top, int width, int height) {
        rect = new Rect(left, top, width, height);
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(rect, PAINT);
    }

    public void move() {
        rect.offset(MOVE_LEFT_SPEED, 0);
    }
}
