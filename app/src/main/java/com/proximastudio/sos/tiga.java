package com.proximastudio.sos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class tiga extends AppCompatActivity {

    private AdView mAdView;

    boolean player=true;
    byte winner=3;
    boolean draw=false;
    TextView pemain;
    Button a,b,c,d,e,f,g,h,i,restart;
    int[][] kotak={
            {R.id.a,R.id.b,R.id.c},
            {R.id.d,R.id.e,R.id.f},
            {R.id.g,R.id.h,R.id.i}
    };
    byte[][] val= {
            {3, 3, 3},
            {3, 3, 3},
            {3, 3, 3}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiga);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.spanduk);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        pemain=(TextView) findViewById(R.id.player);
        pemain.setText("Player 1");

        restart = (Button) findViewById(R.id.restart);
        restart.setEnabled(false);

    }



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    void cek(){

        for(int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){

                //koreksi horizontal
                if (j < 1) {
                    if(val[i][j]!=3 && val[i][j]==val[i][j+1] && val[i][j]==val[i][j+2]){
                        winner=val[i][j];
                        Button x1 = (Button) findViewById(kotak[i][j]) ;
                        Button x2 = (Button) findViewById(kotak[i][j+1]) ;
                        Button x3 = (Button) findViewById(kotak[i][j+2]) ;
                        x1.setBackground(getDrawable(R.drawable.bg_win));
                        x2.setBackground(getDrawable(R.drawable.bg_win));
                        x3.setBackground(getDrawable(R.drawable.bg_win));
                        stop(winner);
                        break;

                    }
                }



                //koeksi vertikal
                if (i < 1) {


                    if (val[i][j] != 3 && val[i][j] == val[i+1][j] && val[i][j] == val[i+2][j]) {
                        winner = val[i][j];
                        Button x1 = (Button) findViewById(kotak[i][j]) ;
                        Button x2 = (Button) findViewById(kotak[i+1][j]) ;
                        Button x3 = (Button) findViewById(kotak[i+2][j]) ;
                        x1.setBackground(getDrawable(R.drawable.bg_win));
                        x2.setBackground(getDrawable(R.drawable.bg_win));
                        x3.setBackground(getDrawable(R.drawable.bg_win));
                        stop(winner);
                        break;
                    }
                }



                //koreksi diagonal 1
                if(i<1 && j<1){

                    if(val[i][j] != 3 && val[i][j] == val[i+1][j+1] && val[i][j] == val[i + 2][j+2]) {
                        winner = val[i][j];
                        Button x1 = (Button) findViewById(kotak[i][j]) ;
                        Button x2 = (Button) findViewById(kotak[i+1][j+1]) ;
                        Button x3 = (Button) findViewById(kotak[i+2][j+2]) ;
                        x1.setBackground(getDrawable(R.drawable.bg_win));
                        x2.setBackground(getDrawable(R.drawable.bg_win));
                        x3.setBackground(getDrawable(R.drawable.bg_win));
                        stop(winner);
                        break;
                    }
                }



                //koreksi diagonal 2
                if(i<1 && j>1){

                    if(val[i][j] != 3 && val[i][j] == val[i+1][j-1] && val[i][j] == val[i + 2][j-2]) {
                        winner = val[i][j];
                        Button x1 = (Button) findViewById(kotak[i][j]) ;
                        Button x2 = (Button) findViewById(kotak[i+1][j-1]) ;
                        Button x3 = (Button) findViewById(kotak[i+2][j-2]) ;
                        x1.setBackground(getDrawable(R.drawable.bg_win));
                        x2.setBackground(getDrawable(R.drawable.bg_win));
                        x3.setBackground(getDrawable(R.drawable.bg_win));
                        stop(winner);
                        break;
                    }
                }


        }





        if(winner==3) {
            for (int k= 0; k <= 2; k++) {
                for (int l = 0; l <= 2; l++) {
                    if (val[k][l] != 3) {
                        draw = true;
                    } else {
                        draw = false;
                        break;
                    }

                }
                if(!draw){
                    break;
                }

            }
            if (draw) {
                pemain.setText("Draw !");
                restart.setEnabled(true);
                winner = 3;
              }
            }

        }
    }



    void player(int a,int b) {
        Button y = (Button) findViewById(kotak[a][b]);
        y.setEnabled(false);
        if (player) {
            y.setText("O");
            val[a][b]=1;
            player=false;
            pemain.setText("Player 2");
        } else {
            y.setText("X");
            val[a][b]=0;
            player=true;
            pemain.setText("Player 1");
        }
        cek();
    }

    void stop(byte x){

        for(int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                val[i][j]=3;
                Button xr=(Button) findViewById(kotak[i][j]);
                xr.setEnabled(false);}}

        restart.setEnabled(true);
        winner=3;

        if(x==1){
            pemain.setText("Player 1 Win !");
        }

        else if(x==0){
            pemain.setText("Player 2 Win !");
        }


    }

    public void a(View view) {
        player(0,0);
    }

    public void b(View view) {
        player(0,1);
    }

    public void c(View view) {
        player(0,2);
    }

    public void d(View view) {
        player(1,0);
    }

    public void e(View view) {
        player(1,1);
    }

    public void f(View view) {
        player(1,2);
    }

    public void g(View view) {
        player(2,0);
    }

    public void h(View view) {
        player(2,1);
    }

    public void i(View view) {
        player(2,2);
    }

    public void restart(View view) {


        for(int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                val[i][j]=3;
                Button xr=(Button) findViewById(kotak[i][j]);
                xr.setEnabled(true);
                xr.setBackground(getDrawable(R.drawable.bg_boxes));
                xr.setText(" ");
            }
        }
        player=true;
        pemain.setText("Player 1");
        restart.setEnabled(false);
    }
}

