package com.example.gmvproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by YU-YA on 2016/11/04.
 */

public class Ground {

    private Rect srcRect;  // 描画元領域の矩形
    private Rect locRect;  // 描画先領域の矩形
    private Bitmap image;  // 地面画像

    private static final Paint paint;
    static { paint = new Paint(); }

    //======================================================================================
    //--  コンストラクタ
    //======================================================================================
    public Ground(Bitmap bitmap, int left, int top, int right, int bottom) {
        //---- 画像関連
        this.image = bitmap;
        //-- 画像サイズの格納
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        //-- 描画用矩形の作成
        this.srcRect = new Rect(0, 0, width, height);
        this.locRect = new Rect(left, top, right, bottom);
    }

    //======================================================================================
    //--  描画メソッド
    //======================================================================================
    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, srcRect, locRect, paint);
    }

    //======================================================================================
    //--  描画位置変更メソッド
    //======================================================================================
    public void setLocation(int left, int top, int right, int bottom) {
        this.srcRect.set(left, top, right, bottom);
        this.locRect.set(left, top, right, bottom);
    }

    //+ locRectの取得
    public Rect getLocRect() {
        return locRect;
    }
}
