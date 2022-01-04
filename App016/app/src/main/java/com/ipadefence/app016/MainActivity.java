package com.ipadefence.app016;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.acl.Permission;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);


        ActivityCompat.requestPermissions(this,
                new String[]{
                        Manifest.permission.SEND_SMS,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence mesaj = editText.getText();
                ShareMassage(mesaj);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mesaj = editText.getText().toString();
                SendSMS(mesaj);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GPS();
            }
        });

    }

    private void GPS() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        mylocation mylocation = new mylocation();
        EditText editText = (EditText) findViewById(R.id.editText);
       // if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
       //     Intent gpsOptionsIntent = new Intent(
       //             android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
       //     startActivity(gpsOptionsIntent);
       // } else {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getApplicationContext(), "permission ERROR", Toast.LENGTH_LONG).show();
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mylocation);
            Location a = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            a.getLatitude();
            a.getLongitude();
            String myLocation = "Enlem: " + a.getLatitude() + "Boylam: " + a.getLongitude();
            editText.setText(myLocation);
            //SendSMS(myLocation);
        //}
    }


    private void SendSMS(String mesaj){

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("+905376028445", null, mesaj, null, null);
            Toast.makeText(getApplicationContext(),"wow",Toast.LENGTH_LONG).show();
    }
    private void ShareMassage(CharSequence mesaj){
        String shareBody = mesaj.toString();
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        //sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Başlık");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "PAYLAŞ!!"));
    }

}


class mylocation implements android.location.LocationListener{
    @Override
    public void onLocationChanged(Location location) {
        location.getLatitude();
        location.getLongitude();
        //String myLocation="Enlem: "+location.getLatitude()+" Boylam: "+location.getLongitude();
        //Log.e("MYLOCATION", myLocation);

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
