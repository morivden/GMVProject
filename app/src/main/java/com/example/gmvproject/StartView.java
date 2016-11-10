package com.example.gmvproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import android.content.Context;

/**
 * Created by 太田圭祐 on 2016/11/04.
 */
public class StartView extends View {
    //private final Paint paint = new Paint();

    private ImageView screenImage;

    //public final Bitmap bitmap;
    //public final Rect rect;

    public StartView(Context context) {
        super(context);
        /*
        int left = (width - bitmap.getWidth()) / 2;
        int top = (height - bitmap.getHeight()) / 2;
        int right = left + bitmap.getWidth();
        int bottom = top + bitmap.getHeight();
        rect = new Rect(left, top, right, bottom);
        */
    }

    @Override
    public void onDraw(Canvas canvas) {
        screenImage.draw(canvas);
    }
}
