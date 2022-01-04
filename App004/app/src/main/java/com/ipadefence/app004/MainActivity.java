package com.ipadefence.app004;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    Button btn1,btn2,btn3,btn4,btn5;

    public void buttonclick(View v){
        switch (v.getId()){
            case(R.id.button):
                Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_LONG).show();
                break;
            case(R.id.button2):
                Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_LONG).show();
                break;
            case(R.id.button3):
                Toast.makeText(getApplicationContext(),"3",Toast.LENGTH_LONG).show();
                break;
            case(R.id.button4):
                Toast.makeText(getApplicationContext(),"4",Toast.LENGTH_LONG).show();
                break;
            case(R.id.button5):
                Toast.makeText(getApplicationContext(),"5",Toast.LENGTH_LONG).show();
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
