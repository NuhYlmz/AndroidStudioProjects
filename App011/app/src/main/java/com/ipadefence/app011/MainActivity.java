package com.ipadefence.app011;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String []colors =getResources().getStringArray(R.array.renkler);
        Spinner sp= (Spinner) findViewById(R.id.spinner);
        Spinner sp2= (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> aa =new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_tasarim,colors);
        sp2.setAdapter(aa);
        final RelativeLayout rl= (RelativeLayout) findViewById(R.id.rl);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0: rl.setBackgroundColor(Color.WHITE); break;
                    case 1: rl.setBackgroundColor(Color.RED); break;
                    case 2: rl.setBackgroundColor(Color.BLUE); break;
                    case 3: rl.setBackgroundColor(Color.GREEN); break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Seçilen Renk : "+colors[i],Toast.LENGTH_LONG).show();
                switch(i){
                    case 0: rl.setBackgroundColor(Color.WHITE); break;
                    case 1: rl.setBackgroundColor(Color.RED); break;
                    case 2: rl.setBackgroundColor(Color.BLUE); break;
                    case 3: rl.setBackgroundColor(Color.GREEN); break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
