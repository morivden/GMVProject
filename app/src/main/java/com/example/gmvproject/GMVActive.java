package com.example.gmvproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.view.Window;

public class GMVActive extends Activity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_gmvactive);

        TitleView tv = new TitleView(this);
        setContentView(tv);
    }
    // test
    // console git test
    // takumi test
}
