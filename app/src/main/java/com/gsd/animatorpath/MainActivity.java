package com.gsd.animatorpath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_main_test;
    private AnimatorPath path;
    private Button btn_main_start;
    private float x = -1;
    private float y = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_main_test = (ImageView) findViewById(R.id.iv_main_test);
        btn_main_start = (Button) findViewById(R.id.btn_main_start);
    }

    public void start(View v) {
        if (x == -1 || y == -1) {
            x = iv_main_test.getX();
            y = iv_main_test.getY();
        }
        path = new AnimatorPath(iv_main_test);
        path.moveTo(0, 0);
        path.lineTo(300, 300);
        path.curveTo(600, 0, 500, 100, -x, -y);
        path.getAnimator().setDuration(2000).start();

    }
}
