package com.example.gmvproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by ito_takumi on 2016/11/04.
 */

public class TitleView extends FrameLayout {

    private Button buttonPush;
    private ImageView backgroundImage;
    private LayoutInflater inflater;
    private View rootView;

    public TitleView(Context context) {
        super(context);

        this.inflater = LayoutInflater.from(context);

        this.rootView = inflater.inflate(R.layout.title, this);

        this.backgroundImage = (ImageView) findViewById(R.id.imageView);

        this.buttonPush = (Button) findViewById(R.id.btn_push);
        this.buttonPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPush.setText("スタート画面に移動したよ!!");
            }
        });
    }
}
