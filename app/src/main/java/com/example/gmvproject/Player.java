package com.example.gmvproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by YU-YA on 2016/11/02.
 */

public class Player {

    private Bitmap image;   // キャラクター画像
    private static final int IMAGE_SIZE = 100;
    private Rect srcRect;   // 描画元領域の矩形
    private Rect locRect;   // 描画先領域の矩形

    private static final Paint PAINT;
    private static final int MOVE_RIGHT_SPEED = 1;
    static { PAINT = new Paint();  PAINT.setColor(Color.RED); }

    public Player(Bitmap bitmap, int left, int top) {
        this.image = bitmap;

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        this.srcRect = new Rect(0, 0, width, height);
        this.locRect = new Rect(left, top, left + this.IMAGE_SIZE, top + this.IMAGE_SIZE);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.image, this.srcRect, this.locRect, this.PAINT);
    }

    public void move() {
        this.locRect.offset(this.MOVE_RIGHT_SPEED, 0);
    }
}
