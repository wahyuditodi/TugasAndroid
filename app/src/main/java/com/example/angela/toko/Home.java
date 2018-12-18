package com.example.angela.toko;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button Logout=findViewById(R.id.btn_lgt);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this, Login.class);
                startActivity(i);
            }
        });


        ImageButton Transaksi=findViewById(R.id.img_trs);
        Transaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this, Transaksi.class);
                startActivity(i);
            }
        });
        TextView Transaks=findViewById(R.id.txt_trs);
        Transaks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this, Transaksi.class);
                startActivity(i);
            }
        });

        ImageButton Stock=findViewById(R.id.img_stk);
        Stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this, Stok.class);
                startActivity(i);
            }
        });
        TextView Stok=findViewById(R.id.txt_stk);
        Stok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this, Stok.class);
                startActivity(i);
            }
        });

        ImageButton StokMasuk=findViewById(R.id.img_stk_msk);
        StokMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this, StokMasuk.class);
                startActivity(i);
            }
        });
        TextView StokMask=findViewById(R.id.txt_stk_msk);
        StokMask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this, StokMasuk.class);
                startActivity(i);
            }
        });

        ImageButton Laporan=findViewById(R.id.img_lap_pjl);
        Laporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this, LaporanP.class);
                startActivity(i);
            }
        });
        TextView LaporanPen=findViewById(R.id.txt_lap_pjl);
        LaporanPen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this, LaporanP.class);
                startActivity(i);
            }
        });

        ImageButton Absensi=findViewById(R.id.img_abs);
        Absensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this, Absensi.class);
                startActivity(i);
            }
        });
        TextView Absen=findViewById(R.id.txt_abs);
        Absen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this, Absensi.class);
                startActivity(i);
            }
        });
    }
}
