package com.example.noah.smssendapp;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.SEND_SMS}, 1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mesaj = editText.getText().toString();
                SendSMS(mesaj);
            }
        });
    }
    private void SendSMS(String mesaj){

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("+905376028445", null, mesaj, null, null);
        Toast.makeText(getApplicationContext(),"wow",Toast.LENGTH_LONG).show();
    }
}
