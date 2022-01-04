package com.example.noah.gpsapplication;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GPS();
            }
        });

    }
    private void GPS() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        mylocation mylocation = new mylocation();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "permission ERROR", Toast.LENGTH_LONG).show();
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mylocation);
        Location a = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        a.getLatitude();
        a.getLongitude();
        String myLocation = "Enlem: " + a.getLatitude() + "Boylam: " + a.getLongitude();
        SendSMS(myLocation);

    }
    private void SendSMS(String mesaj){

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("+905376028445", null, mesaj, null, null);
        Toast.makeText(getApplicationContext(),"wow",Toast.LENGTH_LONG).show();
    }
}
class mylocation implements android.location.LocationListener{
    @Override
    public void onLocationChanged(Location location) {
        location.getLatitude();
        location.getLongitude();
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
