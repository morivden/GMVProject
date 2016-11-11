package com.example.gmvproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.app.Activity;
import android.view.Window;
import android.widget.FrameLayout;


public class GMVActive extends Activity {
    Button button;

    FrameLayout viewList = new FrameLayout(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_gmvactive);

        TitleView tv = new TitleView(this);
        viewList.addView(tv);
        setContentView(viewList);

        //StartView sv = new StartView(this);
    }
    // test
    // console git test
    // takumi test
}
