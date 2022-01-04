package com.ipadefence.app010;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    Button btn;
    CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn =(Button) findViewById(R.id.button);
        cb =(CheckBox)findViewById(R.id.checkBox);
        /*
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean check=cb.isChecked();
                if(check){
                    btn.setEnabled(true);
                }
                else {
                    btn.setEnabled(false);
                }
            }
        });
        */
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb.setChecked(false);
                btn.setEnabled(false);
            }
        });



    }
    public void tiklendi(View v){
        Boolean check = ((CheckBox)v).isChecked();
        if(check){
            btn.setEnabled(true);
        }
        else {
            btn.setEnabled(false);
        }
    }
}
