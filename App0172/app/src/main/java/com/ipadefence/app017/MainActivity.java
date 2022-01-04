package com.ipadefence.app017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText mailaddress =(EditText) findViewById(R.id.editText);
        final EditText mailkonu=(EditText) findViewById(R.id.editText2);
        final EditText mailicerik=(EditText) findViewById(R.id.editText5);
        Button buton =(Button) findViewById(R.id.button);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mailGondor(mailaddress.getText().toString(),mailkonu.getText().toString(),mailicerik.getText().toString());
            }
        });

    }
    private void mailGondor(String adress, String konu, String icerik) {
        Intent mailintent=new Intent(Intent.ACTION_SEND);
        mailintent.setType("message/rfc822");
        mailintent.putExtra(Intent.EXTRA_EMAIL,new String[]{adress});
        mailintent.putExtra(Intent.EXTRA_SUBJECT,konu);
        mailintent.putExtra(Intent.EXTRA_TEXT,icerik);
        startActivity(mailintent);
    }
}