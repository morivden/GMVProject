package com.example.gmvproject;

/**
 * Created by マグネシウム on 2016/11/02.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.concurrent.atomic.AtomicBoolean;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private Player player;  // 自機

    private Ground ground;  // ステージ
    private Bitmap groundImage;  // ステージ用画像

    private static final long DRAW_INTERVAL = 1000 / 100;  // 描画間隔

    private class DrawThread extends Thread {
        private final AtomicBoolean isFinished = new AtomicBoolean(false);

        public void finish() {
            isFinished.set(true);
        }

        @Override
        public void run() {
            SurfaceHolder holder = getHolder();

            while (!isFinished.get()) {
                if (holder.isCreating()) {
                    continue;
                }
                Canvas canvas = holder.lockCanvas();
                if (canvas == null) {
                    continue;
                }

                drawGame(canvas);

                holder.unlockCanvasAndPost(canvas);

                synchronized (this) {
                    try {
                        wait(DRAW_INTERVAL);
                    } catch (InterruptedException e) {

                    }
                }
            }
        }
    }

    private DrawThread drawThread;

    public void startDrawThread() {
        stopDrawThread();

        drawThread = new DrawThread();
        drawThread.start();
    }

    public boolean stopDrawThread() {
        if (drawThread == null) {
            return false;
        }
        drawThread.finish();
        drawThread = null;

        return true;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(
            SurfaceHolder holder, int format, int width, int height) {
        System.out.println("draw");
        startDrawThread();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        stopDrawThread();
    }

    public GameView(Context context) {
        super(context);

        SurfaceHolder holder = getHolder();
        Bitmap image = BitmapFactory.decodeResource(context.getResources(), R.drawable.tmp_image01);

        this.player = new Player(image, 100, 100);

        this.groundImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.tmp_image01);

        holder.addCallback(this);

        // 背景色の設定
        setBackgroundColor(Color.rgb(255,255,255));
        //ビューの背景を透過させる
        getHolder().setFormat(PixelFormat.TRANSLUCENT);
        //最前面に描画する
        setZOrderOnTop(true);
    }

    private void drawGame(Canvas canvas) {

        // ステージの初期化
        if ( ground == null ) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            int groundHeight = height/3;
            this.ground = new Ground(this.groundImage, 0, height-groundHeight, width, height);
        }

        /* 以下に描画処理を記述 */
        this.player.draw(canvas);  // 自機の描画

        this.ground.draw(canvas);  // ステージの描画
    }
}

/*
test
test
 */