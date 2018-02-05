package com.tathva17.tathva.tathva17;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;


public class SplashScreenActivity extends AppCompatActivity {
    private ImageView startIcon;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_splash_screen);
        startIcon = (ImageView) findViewById(R.id.splashscreenIcon);

        getSupportActionBar().hide();
        Test start = new Test();
        animate();
        start.execute();
    }

        public class Test extends AsyncTask<Void,Void,Void> {

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(1500);
                    Intent main_intent;

                    main_intent = new Intent(SplashScreenActivity.this, MainActivity.class);

                    startActivity(main_intent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

        }





    public void animate(){
        startIcon.setImageResource(R.drawable.tathva_17ic);
        Animator ofFloat = ObjectAnimator.ofFloat(this.startIcon, "scaleX", new float[]{5.0f, 1.0f});
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(1000);
        Animator ofFloat2 = ObjectAnimator.ofFloat(this.startIcon, "scaleY", new float[]{5.0f, 1.0f});
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setDuration(1000);
        Animator ofFloat3 = ObjectAnimator.ofFloat(this.startIcon, "alpha", new float[]{0.0f, 1.0f});
        ofFloat3.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat3.setDuration(1000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setStartDelay(0);
        animatorSet.start();
    }
}
