package com.example.gmvproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GMVActive extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmvactive);

        GameView gameview = new GameView(this);
        setContentView(gameview);
    }
    // test
    // console git test
    // takumi test
}
