package com.proximastudio.sos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {


    private AdView mAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.spanduk);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }


    public void a(View view) {
        Intent intent = new Intent(MainActivity.this,tiga.class);
        startActivity(intent);
    }

    public void b(View view) {
        Intent intent = new Intent(MainActivity.this,empat.class);
        startActivity(intent);
    }

    public void c(View view) {
        Intent intent = new Intent(MainActivity.this,lima.class);
        startActivity(intent);
    }

    public void d(View view) {
        Intent intent = new Intent(MainActivity.this,lima_2.class);
        startActivity(intent);
    }
}
