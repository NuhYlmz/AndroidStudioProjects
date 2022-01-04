package com.ipadefence.app002;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv =(TextView) findViewById(R.id.textView);
        final Button btn = (Button) findViewById(R.id.button);
        final EditText text1 =(EditText) findViewById(R.id.editText);
        final EditText text2 =(EditText) findViewById(R.id.editText2);
        Button btn2=(Button) findViewById(R.id.button2);
        final TextView tv2 = (TextView) findViewById(R.id.textView4);
        final Button btn3 = (Button) findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("Text");
                Handler handler1=new Handler();
                for (int a = 1; a<=10 ;a++) {
                    handler1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText(tv.getText()+"*");
                        }
                    }, 1000 * a);
                }
            }
        });
//************
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv2.setText(text1.getText()+" "+text2.getText());
            }
        });

        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);

//**************
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rl.setBackgroundColor(Color.RED);
            }
        });




    }
}

