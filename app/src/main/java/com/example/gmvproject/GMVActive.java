package com.example.gmvproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.view.Window;
import android.widget.FrameLayout;


public class GMVActive extends Activity implements TitleView.TitleViewCallback, StartView.StartViewCallback {

    FrameLayout viewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        viewList = new FrameLayout(this);
        TitleView tv = new TitleView(this);
        tv.setTitleViewCallback(this);
        viewList.addView(tv);
        setContentView(viewList);
    }

    @Override
    public void switchStartView() {
        int viewCnt;  // 格納されているViewの数
        StartView sv = new StartView(this);
        sv.setStartViewCallback(this);
        viewList.addView(sv);  // 追加

        if ( (viewCnt = viewList.getChildCount()) > 1 ) {   // 削除
            viewList.removeViews(0, viewCnt-1);
        }
    }

    @Override
    public void switchGameView() {
        int viewCnt;  // 格納されているViewの数
        GameView gv = new GameView(this);

        viewList.addView(gv);  // 追加

        if ( (viewCnt = viewList.getChildCount()) > 1 ) {   // 削除
            viewList.removeViews(0, viewCnt-1);
        }
    }
}
