package com.ews.thediviner;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashDivinerActivity extends AppCompatActivity {

    public static final int SPLASH_DISPLAY_LENGTH = 3500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_diviner);

        loadLogSplash();
    }


    public void loadLogSplash() {

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_splash);
        animation.reset();

        ImageView imageView = (ImageView) findViewById(R.id.imgLogo);
        imageView.clearAnimation();
        imageView.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashDivinerActivity.this, MainActivity.class);
                startActivity(intent);

            }
        }, SPLASH_DISPLAY_LENGTH);

    }

}
