package com.proximastudio.sos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class lima_2 extends AppCompatActivity {
    private AdView mAdView;
    boolean player=true;
    byte winner=3;
    boolean draw=false;
    TextView pemain;
    Button a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,
            a21,a22,a23,a24,a25,a26,a27,a28,a29,a30,a31,a32,a33,a34,a35,a36,restart;
    int[][] kotak={
            {R.id.a1,R.id.a2,R.id.a3,R.id.a4,R.id.a5,R.id.a6},
            {R.id.a7,R.id.a8,R.id.a9,R.id.a10,R.id.a11,R.id.a12},
            {R.id.a13,R.id.a14,R.id.a15,R.id.a16,R.id.a17,R.id.a18},
            {R.id.a19,R.id.a20,R.id.a21,R.id.a22,R.id.a23,R.id.a24},
            {R.id.a25,R.id.a26,R.id.a27,R.id.a28,R.id.a29,R.id.a30},
            {R.id.a31,R.id.a32,R.id.a33,R.id.a34,R.id.a35,R.id.a36}


    };
    byte[][] val= {
            {3, 3, 3, 3, 3, 3},
            {3, 3, 3, 3, 3, 3},
            {3, 3, 3, 3, 3, 3},
            {3, 3, 3, 3, 3, 3},
            {3, 3, 3, 3, 3, 3},
            {3, 3, 3, 3, 3, 3}

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lima_2);

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
        a1 = (Button) findViewById(kotak[0][0]);
        a2 = (Button) findViewById(kotak[0][1]);
        a3 = (Button) findViewById(kotak[0][2]);
        a4 = (Button) findViewById(kotak[0][3]);
        a5 = (Button) findViewById(kotak[0][4]);
        a6 = (Button) findViewById(kotak[0][5]);
        a7 = (Button) findViewById(kotak[1][0]);
        a8 = (Button) findViewById(kotak[1][1]);
        a9 = (Button) findViewById(kotak[1][2]);
        a10 = (Button) findViewById(kotak[1][3]);
        a11 = (Button) findViewById(kotak[1][4]);
        a12 = (Button) findViewById(kotak[1][5]);
        a13 = (Button) findViewById(kotak[2][0]);
        a14 = (Button) findViewById(kotak[2][1]);
        a15 = (Button) findViewById(kotak[2][2]);
        a16 = (Button) findViewById(kotak[2][3]);
        a17 = (Button) findViewById(kotak[2][4]);
        a18 = (Button) findViewById(kotak[2][5]);
        a19 = (Button) findViewById(kotak[3][0]);
        a20 = (Button) findViewById(kotak[3][1]);
        a21 = (Button) findViewById(kotak[3][2]);
        a22 = (Button) findViewById(kotak[3][3]);
        a23 = (Button) findViewById(kotak[3][4]);
        a24 = (Button) findViewById(kotak[3][5]);
        a25 = (Button) findViewById(kotak[4][0]);
        a26 = (Button) findViewById(kotak[4][1]);
        a27 = (Button) findViewById(kotak[4][2]);
        a28 = (Button) findViewById(kotak[4][3]);
        a29 = (Button) findViewById(kotak[4][4]);
        a30 = (Button) findViewById(kotak[4][5]);
        a31 = (Button) findViewById(kotak[5][0]);
        a32 = (Button) findViewById(kotak[5][1]);
        a33 = (Button) findViewById(kotak[5][2]);
        a34 = (Button) findViewById(kotak[5][3]);
        a35 = (Button) findViewById(kotak[5][4]);
        a36 = (Button) findViewById(kotak[5][5]);



        restart = (Button) findViewById(R.id.restart);
        restart.setEnabled(false);

    }



    void cek(){

        for(int i=0;i<=5;i++){
            for(int j=0;j<=5;j++){

                //koreksi horizontal
                if (j < 3) {
                    if(val[i][j]!=3 && val[i][j]==val[i][j+1] && val[i][j]==val[i][j+2] && val[i][j]==val[i][j+3]){
                        winner=val[i][j];
                        Button x1 = (Button) findViewById(kotak[i][j]) ;
                        Button x2 = (Button) findViewById(kotak[i][j+1]) ;
                        Button x3 = (Button) findViewById(kotak[i][j+2]) ;
                        Button x4 = (Button) findViewById(kotak[i][j+3]) ;
                        x1.setBackground(getDrawable(R.drawable.bg_win));
                        x2.setBackground(getDrawable(R.drawable.bg_win));
                        x3.setBackground(getDrawable(R.drawable.bg_win));
                        x4.setBackground(getDrawable(R.drawable.bg_win));
                        stop(winner);
                        break;

                    }
                }



                //koeksi vertikal
                if (i <3) {


                    if (val[i][j] != 3 && val[i][j] == val[i+1][j] && val[i][j] == val[i+2][j] && val[i][j] == val[i+3][j]) {
                        winner = val[i][j];
                        Button x1 = (Button) findViewById(kotak[i][j]) ;
                        Button x2 = (Button) findViewById(kotak[i+1][j]) ;
                        Button x3 = (Button) findViewById(kotak[i+2][j]) ;
                        Button x4 = (Button) findViewById(kotak[i+3][j]) ;
                        x1.setBackground(getDrawable(R.drawable.bg_win));
                        x2.setBackground(getDrawable(R.drawable.bg_win));
                        x3.setBackground(getDrawable(R.drawable.bg_win));
                        x4.setBackground(getDrawable(R.drawable.bg_win));
                        stop(winner);
                        break;
                    }
                }



                //koreksi diagonal 1
                if(i<3 && j<3){

                    if(val[i][j] != 3 && val[i][j] == val[i+1][j+1] && val[i][j] == val[i + 2][j+2] && val[i][j] == val[i + 3][j+3]) {
                        winner = val[i][j];
                        Button x1 = (Button) findViewById(kotak[i][j]) ;
                        Button x2 = (Button) findViewById(kotak[i+1][j+1]) ;
                        Button x3 = (Button) findViewById(kotak[i+2][j+2]) ;
                        Button x4 = (Button) findViewById(kotak[i+3][j+3]) ;
                        x1.setBackground(getDrawable(R.drawable.bg_win));
                        x2.setBackground(getDrawable(R.drawable.bg_win));
                        x3.setBackground(getDrawable(R.drawable.bg_win));
                        x4.setBackground(getDrawable(R.drawable.bg_win));
                        stop(winner);
                        break;
                    }
                }



                //koreksi diagonal 2
                if(i<3 && j>2){

                    if(val[i][j] != 3 && val[i][j] == val[i+1][j-1] && val[i][j] == val[i + 2][j-2] && val[i][j] == val[i + 3][j-3]) {
                        winner = val[i][j];
                        Button x1 = (Button) findViewById(kotak[i][j]) ;
                        Button x2 = (Button) findViewById(kotak[i+1][j-1]) ;
                        Button x3 = (Button) findViewById(kotak[i+2][j-2]) ;
                        Button x4 = (Button) findViewById(kotak[i+3][j-3]) ;
                        x1.setBackground(getDrawable(R.drawable.bg_win));
                        x2.setBackground(getDrawable(R.drawable.bg_win));
                        x3.setBackground(getDrawable(R.drawable.bg_win));
                        x4.setBackground(getDrawable(R.drawable.bg_win));
                        stop(winner);
                        break;
                    }
                }


            }





            if(winner==3) {
                for (int k= 0; k <= 5; k++) {
                    for (int l = 0; l <= 5; l++) {
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
        for(int i=0;i<=5;i++){
            for(int j=0;j<=5;j++) {
                val[i][j] = 3;
                Button xr = (Button) findViewById(kotak[i][j]);
                xr.setEnabled(false);
            }}

        restart.setEnabled(true);
        winner=3;

        if(x==1){
            pemain.setText("Player 1 Win !");
        }

        else if(x==0){
            pemain.setText("Player 2 Win !");
        }


    }

    public void a1(View view) {
        player(0,0);
    }

    public void a2(View view) {
        player(0,1);
    }

    public void a3(View view) {
        player(0,2);
    }

    public void a4(View view) {
        player(0,3);
    }

    public void a5(View view) {
        player(0,4);
    }

    public void a6(View view) {
        player(0,5);
    }
    public void a7(View view) {
        player(1,0);
    }

    public void a8(View view) {
        player(1,1);
    }

    public void a9(View view) {
        player(1,2);
    }

    public void a10(View view) {
        player(1,3);
    }

    public void a11(View view) {
        player(1,4);
    }

    public void a12(View view) {
        player(1,5);
    }
    public void a13(View view) {
        player(2,0);
    }

    public void a14(View view) {
        player(2,1);
    }

    public void a15(View view) {
        player(2,2);
    }

    public void a16(View view) {
        player(2,3);
    }

    public void a17(View view) {
        player(2,4);
    }

    public void a18(View view) {
        player(2,5);
    }
    public void a19(View view) {
        player(3,0);
    }

    public void a20(View view) {
        player(3,1);
    }

    public void a21(View view) {
        player(3,2);
    }

    public void a22(View view) {
        player(3,3);
    }

    public void a23(View view) {
        player(3,4);
    }

    public void a24(View view) {
        player(3,5);
    }

    public void a25(View view) {
        player(4,0);
    }

    public void a26(View view) {
        player(4,1);
    }

    public void a27(View view) {
        player(4,2);
    }

    public void a28(View view) {
        player(4,3);
    }

    public void a29(View view) {
        player(4,4);
    }

    public void a30(View view) {
        player(4,5);
    }

    public void a31(View view) {
        player(5,0);
    }

    public void a32(View view) {
        player(5,1);
    }

    public void a33(View view) {
        player(5,2);
    }

    public void a34(View view) {
        player(5,3);
    }

    public void a35(View view) {
        player(5,4);
    }

    public void a36(View view) {
        player(5,5);
    }








    public void restart(View view) {

        for(int i=0;i<=5;i++){
            for(int j=0;j<=5;j++){
                val[i][j]=3;
                Button xr=(Button) findViewById(kotak[i][j]);
                xr.setEnabled(true);
                xr.setText(" ");
                xr.setBackground(getDrawable(R.drawable.bg_boxes));
            }
        }
        player=true;
        pemain.setText("Player 1");
        restart.setEnabled(false);
    }
}
