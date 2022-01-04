package com.ipadefence.app013;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;
    @Override
    protected void onPostResume() {
        super.onPostResume();
        Toast.makeText(getApplicationContext(),"onResume",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Toast.makeText(getApplicationContext(),"back",Toast.LENGTH_LONG);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void on_click(View view){
        if(view.getId()==R.id.button){
            //2.ekran
            Intent intent=new Intent(getApplicationContext(),ikinciEkran.class);
            startActivity(intent);
        }
        else if(view.getId()==R.id.button2){
            //3.ekran
            CharSequence charSequence = et.getText();
            if(TextUtils.isEmpty(charSequence)){
                Toast.makeText(getApplicationContext(),"Text Boş..",Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent(getApplicationContext(), Ucuncuekran.class);
                intent.putExtra("anahtar", charSequence);
                startActivity(intent);
            }
        }
    }
}
