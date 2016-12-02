package com.example.gmvproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.app.Activity;
import android.view.Window;
import android.widget.FrameLayout;


public class GMVActive extends Activity implements TitleView.TitleViewCallback, StartView.StartViewCallback {
    Button button;

    FrameLayout viewList;

    @Override
    public void onChangeStartview() {
        viewList.removeAllViews();
        StartView sv = new StartView(this);
        sv.setCallback(this);
        viewList.addView(sv);
    }

    @Override
    public void onChangeGameview() {
        viewList.removeAllViews();
        GameView gv = new GameView(this);
        viewList.addView(gv);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_gmvactive);

        viewList = new FrameLayout(this);
        TitleView tv = new TitleView(this);
        viewList.addView(tv);
        tv.setCallback(this);

        setContentView(viewList);

        //StartView sv = new StartView(this);
    }
    // test
    // console git test
    // takumi test
}
