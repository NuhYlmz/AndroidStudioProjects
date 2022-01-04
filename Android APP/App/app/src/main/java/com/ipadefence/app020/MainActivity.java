package com.ipadefence.app020;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
public class MainActivity extends AppCompatActivity {
    boolean check=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button= (Button) findViewById(R.id.button);
        final ProgressBar progressBar= (ProgressBar) findViewById(R.id.progressBar);
        final ObjectAnimator animation=ObjectAnimator.ofInt(progressBar,"progress",0,500);
        animation.setDuration(2500);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                button.setEnabled(true);
                animation.setCurrentPlayTime(0);
                if(check) {
                    button.setBackgroundResource(R.drawable.button_style2);
                    check=false;
                }
                else {
                    button.setBackgroundResource(R.drawable.button_style);
                    check=true;
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {


            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setEnabled(false);
                animation.start();
            }

        });



    }
}
