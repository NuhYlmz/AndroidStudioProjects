package com.ipadefence.test001;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    @TargetApi(19)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button= (Button) findViewById(R.id.button);
        ProgressBar progressBar= (ProgressBar) findViewById(R.id.progressBar);
        final ObjectAnimator animation=ObjectAnimator.ofInt(progressBar,"progress",0,500);
        animation.setDuration(5000);
        animation.setInterpolator(new DecelerateInterpolator());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!animation.isStarted())
                    animation.start();
                else{
                    animation.pause();
                }
                animation.addPauseListener(new Animator.AnimatorPauseListener() {
                    @Override
                    public void onAnimationPause(Animator animator) {
                        animation.pause();
                        animation.resume();
                    }
                    @Override
                    public void onAnimationResume(Animator animator) {
                        animation.reverse();
                    }
                });
            }

        });

    }
}
