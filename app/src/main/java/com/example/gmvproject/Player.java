package com.example.gmvproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.FrameLayout;

/**
 * Created by YU-YA on 2016/11/02.
 */

public class Player {

    //+ プレイヤーと地面の距離を取得するコールバック関数
    public interface FallCallback {
        int getDistanceFromGround(Player player);
    }
    //+ 落下速度設定
    private static final float GRAVITY = 0.8f;
    private static final float WEIGHT = GRAVITY * 60;

    private Bitmap image;   // キャラクター画像
    private static final int IMAGE_SIZE = 100;  // 描画時の画像サイズ
    private Rect srcRect;   // 描画元領域の矩形
    private Rect locRect;   // 描画先領域の矩形

    private static final Paint PAINT;
    private static final int MOVE_RIGHT_SPEED = 0;
    static { PAINT = new Paint();  PAINT.setColor(Color.RED); }

    //+ コールバック
    private final FallCallback fallcallback;


    //======================================================================================
    //--  コンストラクタ
    //======================================================================================
    //+
    public Player(Bitmap bitmap, int left, int top, FallCallback fallcallback) {
        //---- 画像関連
        this.image = bitmap;
        //-- 画像サイズの格納
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        //-- 描画用矩形の作成
        this.srcRect = new Rect(0, 0, width, height);
        this.locRect = new Rect(left, top, left + this.IMAGE_SIZE, top + this.IMAGE_SIZE);
        //+
        this.fallcallback = fallcallback;
    }

    //======================================================================================
    //--  Playerクラス描画用メソッド
    //======================================================================================
    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.image, this.srcRect, this.locRect, this.PAINT);
    }

    //+
    private float velocity = 0;

    public void jump(float power) {
        velocity = (power * WEIGHT);
    }

    //======================================================================================
    //--  Playerクラス移動用メソッド (仮)
    //======================================================================================
    public void move() {
        //+ 落下処理
        int distanceFromGround = fallcallback.getDistanceFromGround(this);
        //+ 地面との距離が落下速度より小さい場合の調整
        if (velocity < 0 && velocity < -distanceFromGround) {
            velocity = -distanceFromGround;
        }
        //+
        this.locRect.offset(0, Math.round(-1 * velocity));

        if (distanceFromGround == 0) {
            return;
        } else if (distanceFromGround < 0) {
            this.locRect.offset(0, distanceFromGround);
            return;
        }
        //+

        this.locRect.offset(this.MOVE_RIGHT_SPEED, 0);
        //+ 自機を試験的に落下
        //this.locRect.offset(0, 5);
        velocity -= GRAVITY;
    }

    //+ locRectの取得
    public Rect getLocRect() {
        return locRect;
    }
}
