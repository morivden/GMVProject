package com.example.gmvproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by 太田圭祐 on 2016/11/04
 */
public class StartView extends FrameLayout {
    //private final Paint paint = new Paint();

    private ImageView screenImage;    // 背景画像
    private Button buttonPush;        // 押された後のボタン
    private LayoutInflater inflater;
    private View rootView;
    private StartViewCallback startViewCallback;

    public interface StartViewCallback {
        void onChangeGameview();
    }

    public void setCallback(StartViewCallback callback) {
        startViewCallback = callback;
    }


    public StartView(Context context) {
        super(context);
        this.inflater = LayoutInflater.from(context);

        this.rootView = inflater.inflate(R.layout.start_screen, this);

        this.screenImage = (ImageView) findViewById(R.id.imageView3);

        this.buttonPush = (Button) findViewById(R.id.btn_start_button);

        this.buttonPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startViewCallback.onChangeGameview();
            }
        });
    }
}
