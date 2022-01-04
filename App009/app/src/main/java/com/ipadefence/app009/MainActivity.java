package com.ipadefence.app009;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView act = (AutoCompleteTextView) findViewById(R.id.act);
        MultiAutoCompleteTextView mact = (MultiAutoCompleteTextView) findViewById(R.id.mact);

        String[] cihazlar = getResources().getStringArray(R.array.Cihazlar);
        ArrayAdapter<String> myarrayadapter =new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,cihazlar);
        act.setAdapter(myarrayadapter);
        mact.setAdapter(myarrayadapter);
        mact.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


    }
}
