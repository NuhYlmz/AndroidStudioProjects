package com.ipadefence.app003;

import android.graphics.Color;
import android.renderscript.RenderScript;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 =(Button)findViewById(R.id.button);
        Button btn2 =(Button)findViewById(R.id.button2);
        Button btn3 =(Button)findViewById(R.id.button3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Toast Message",Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView cat = new ImageView(getApplicationContext());
                cat.setImageResource(R.drawable.cat);
                Toast toast1 =new Toast(getApplicationContext());
                toast1.setView(cat);
                toast1.setDuration(Toast.LENGTH_LONG);
                //toast1.setGravity(Gravity.RIGHT|Gravity.RIGHT, 0, 0);
                toast1.show();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView text =new TextView(getApplicationContext());
                text.setText("Bla bla bla...");
                text.setBackgroundColor(Color.BLUE);
                text.setTextColor(Color.WHITE);
                text.setPadding(14,14,14,14);
                Toast toast =new Toast(getApplicationContext());
                toast.setView(text);
                toast.setDuration(Toast.LENGTH_LONG);
                //toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,0,0);
                toast.show();

            }
        });
    }
}
