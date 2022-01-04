package com.ipadefence.app013;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Ucuncuekran extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucuncuekran);
        tv =(TextView) findViewById(R.id.textView);
        Bundle gelenveri=getIntent().getExtras();
        CharSequence charSequence=gelenveri.getCharSequence("anahtar");
        tv.setText(charSequence);
    }
}
