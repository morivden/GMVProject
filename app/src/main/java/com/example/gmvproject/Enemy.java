package com.example.gmvproject;

/**
 * Created by ito_takumi on 2017/01/20.
 */

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Enemy {

    private Bitmap image;   // 敵キャラの画像
    private static final int IMAGE_SIZE = 200;  // 画像サイズ
    private Rect srcRect;  // 描写元領域の矩形
    private Rect locRect;  // 描写元領域の矩形
    private static final Paint PAINT;
    private static final int MOVE_UP_SPEED = 0;
    static{ PAINT = new Paint(); PAINT.setColor(Color.GREEN); }

    // -- コンストラクタ -- //
    public Enemy(Bitmap bitmap, int left, int top) {
        // ---- 画像関連
        this.image = bitmap;
        // 画像サイズの格納
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        // 描画用矩形の作成
        this.srcRect = new Rect(0, 0, width, height);
        this.locRect = new Rect(left, top, left + this.IMAGE_SIZE, top + this.IMAGE_SIZE);
    }

    //--Enemyクラス描写メソッド--//
    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.image, this.srcRect, this.locRect, this.PAINT);
    }

}
