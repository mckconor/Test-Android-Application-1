package com.example.mckennc9.testapplication;

import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient mFusedLocationClient;

    TextView totalTextView;
    EditText percentageText, numberText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        totalTextView = (TextView) findViewById(R.id.totalTextView);
        percentageText = (EditText) findViewById(R.id.percentageTxt);
        numberText = (EditText) findViewById(R.id.numberTxt);

        Button calcButton = (Button) findViewById(R.id.calcBtn);
        calcButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                float percentage = Float.parseFloat(percentageText.getText().toString());
                float dec = percentage / 100;
                float total = dec * Float.parseFloat((numberText.getText().toString()));
                totalTextView.setText(Float.toString(total));
            }
        });
    }

    private void addHeatMap() {
        List<LatLng> listOfLocations = null;

        //Get User locations
    }
}
