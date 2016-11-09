package com.example.gmvproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by 太田圭祐 on 2016/11/04.
 */
public class StartView {
    private final Paint paint = new Paint();

    public final Bitmap bitmap;
    public final Rect rect;

    public StartView( Bitmap bitmap, int width, int height )
    {
        this.bitmap = bitmap;

        int left = (width - bitmap.getWidth()) / 2;
        int top = (height - bitmap.getHeight()) / 2;
        int right = left + bitmap.getWidth();
        int bottom = top + bitmap.getHeight();
        rect = new Rect(left, top, right, bottom);
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(bitmap, rect.left, rect.top, paint);
    }
}
