package com.ipadefence.app014;
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText =(EditText) findViewById(R.id.editText);
        ImageView call= (ImageView) findViewById(R.id.imageView);

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CALL_PHONE},3);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(editText.getText())){
                    Toast.makeText(getApplicationContext(),"Numara Giriniz..",Toast.LENGTH_SHORT);
                }
                else {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + editText.getText().toString()));
                    startActivity(intent);
                }
            }
        });
    }
}
