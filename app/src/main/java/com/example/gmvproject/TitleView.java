package com.example.gmvproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.zip.Inflater;

/**
 * Created by ito_takumi on 2016/11/04.
 */

public class TitleView extends View {

    private Button buttonPush;
    private ImageView backgroundImage;
    private LayoutInflater inflater;
    View view;

    public TitleView(Context context) {
        super(context);

        this.inflater = LayoutInflater.from(context);

        view = inflater.inflate(R.layout.title, null);

        backgroundImage = (ImageView) view.findViewById(R.id.imageView);

        buttonPush = (Button) view.findViewById(R.id.btn_push);
        buttonPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPush.setText("スタート画面に移動したよ!!");
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        invalidate();
    }
}
