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

public class lima extends AppCompatActivity {

    private AdView mAdView;

    boolean player=true;
    byte winner=3;
    boolean draw=false;
    TextView pemain;
    Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,restart;
    int[][] kotak={
            {R.id.a,R.id.b,R.id.c,R.id.d,R.id.e},
            {R.id.f,R.id.g,R.id.h,R.id.i,R.id.j},
            {R.id.k,R.id.l,R.id.m,R.id.n,R.id.o},
            {R.id.p,R.id.q,R.id.r,R.id.s,R.id.t},
            {R.id.u,R.id.v,R.id.w,R.id.x,R.id.y}

    };
    byte[][] val= {
            {3, 3, 3, 3, 3},
            {3, 3, 3, 3, 3},
            {3, 3, 3, 3, 3},
            {3, 3, 3, 3, 3},
            {3, 3, 3, 3, 3},

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lima);

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
        a = (Button) findViewById(kotak[0][0]);
        b = (Button) findViewById(kotak[0][1]);
        c = (Button) findViewById(kotak[0][2]);
        d = (Button) findViewById(kotak[0][3]);
        e = (Button) findViewById(kotak[0][4]);
        f = (Button) findViewById(kotak[1][0]);
        g = (Button) findViewById(kotak[1][1]);
        h = (Button) findViewById(kotak[1][2]);
        i = (Button) findViewById(kotak[1][3]);
        j = (Button) findViewById(kotak[1][4]);
        k = (Button) findViewById(kotak[2][0]);
        l = (Button) findViewById(kotak[2][1]);
        m = (Button) findViewById(kotak[2][2]);
        n = (Button) findViewById(kotak[2][3]);
        o = (Button) findViewById(kotak[2][4]);
        p = (Button) findViewById(kotak[3][0]);
        q = (Button) findViewById(kotak[3][1]);
        r = (Button) findViewById(kotak[3][2]);
        s = (Button) findViewById(kotak[3][3]);
        t = (Button) findViewById(kotak[3][4]);
        u = (Button) findViewById(kotak[4][0]);
        v = (Button) findViewById(kotak[4][1]);
        w = (Button) findViewById(kotak[4][2]);
        x = (Button) findViewById(kotak[4][3]);
        y = (Button) findViewById(kotak[4][4]);


        restart = (Button) findViewById(R.id.restart);
        restart.setEnabled(false);

    }



    void cek(){

        for(int i=0;i<=4;i++){
            for(int j=0;j<=4;j++){

                //koreksi horizontal
                if (j < 2) {
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
                if (i <2) {


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
                if(i<2 && j<2){

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
                if(i<2 && j>2){

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
                for (int k= 0; k <= 4; k++) {
                    for (int l = 0; l <= 4; l++) {
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
        for(int i=0;i<=4;i++){
            for(int j=0;j<=4;j++) {
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
        player(0,3);
    }

    public void e(View view) {
        player(0,4);
    }

    public void f(View view) {
        player(1,0);
    }

    public void g(View view) {
        player(1,1);
    }

    public void h(View view) {
        player(1,2);
    }
    public void i(View view) {
        player(1,3);
    }

    public void j(View view) {
        player(1,4);
    }

    public void k(View view) {
        player(2,0);
    }

    public void l(View view) {
        player(2,1);
    }

    public void m(View view) {
        player(2,2);
    }

    public void n(View view) {
        player(2,3);
    }

    public void o(View view) {
        player(2,4);
    }

    public void p(View view) {
        player(3,0);
    }

    public void q(View view) {
        player(3,1);
    }

    public void r(View view) {
        player(3,2);
    }

    public void s(View view) {
        player(3,3);
    }

    public void t(View view) {
        player(3,4);
    }

    public void u(View view) {
        player(4,0);
    }

    public void v(View view) {
        player(4,1);
    }

    public void w(View view) {
        player(4,2);
    }
    public void x(View view) {
        player(4,3);
    }

    public void y(View view) {
        player(4,4);
    }




    public void restart(View view) {

        for(int i=0;i<=4;i++){
            for(int j=0;j<=4;j++){
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
