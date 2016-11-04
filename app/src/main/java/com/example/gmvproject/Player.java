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
    private static final int IMAGE_SIZE = 100;  // 描画時の画像サイズ
    private Rect srcRect;   // 描画元領域の矩形
    private Rect locRect;   // 描画先領域の矩形

    private static final Paint PAINT;
    private static final int MOVE_RIGHT_SPEED = 0;
    static { PAINT = new Paint();  PAINT.setColor(Color.RED); }



    //======================================================================================
    //--  コンストラクタ
    //======================================================================================
    public Player(Bitmap bitmap, int left, int top) {
        //---- 画像関連
        this.image = bitmap;
        //-- 画像サイズの格納
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        //-- 描画用矩形の作成
        this.srcRect = new Rect(0, 0, width, height);
        this.locRect = new Rect(left, top, left + this.IMAGE_SIZE, top + this.IMAGE_SIZE);
    }

    //======================================================================================
    //--  Playerクラス描画用メソッド
    //======================================================================================
    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.image, this.srcRect, this.locRect, this.PAINT);
    }

    //======================================================================================
    //--  Playerクラス移動用メソッド (仮)
    //======================================================================================
    public void move() {
        this.locRect.offset(this.MOVE_RIGHT_SPEED, 0);
    }
}
