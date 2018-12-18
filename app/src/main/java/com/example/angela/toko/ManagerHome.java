package com.example.angela.toko;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ManagerHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_home);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button Logout=findViewById(R.id.btn_lgt);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ManagerHome.this, Login.class);
                startActivity(i);
            }
        });

        ImageButton Stokp=findViewById(R.id.img_stk_rpt);
        Stokp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ManagerHome.this, ManagerStok.class);
                startActivity(i);
            }
        });
        TextView StokP=findViewById(R.id.txt_stk_rpt);
        StokP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ManagerHome.this, ManagerStok.class);
                startActivity(i);
            }
        });

        ImageButton LapP=findViewById(R.id.img_sls_rpt);
        LapP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ManagerHome.this, ManagerLap.class);
                startActivity(i);
            }
        });
        TextView Lapp=findViewById(R.id.txt_sls_rpt);
        Lapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ManagerHome.this, ManagerLap.class);
                startActivity(i);
            }
        });

        ImageButton Edit=findViewById(R.id.img_edt_lgn);
        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ManagerHome.this, ManagerEdit.class);
                startActivity(i);
            }
        });
        TextView Edit1=findViewById(R.id.txt_edt_lgn);
        Edit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ManagerHome.this, ManagerEdit.class);
                startActivity(i);
            }
        });

        ImageButton LapK=findViewById(R.id.img_absent);
        LapK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ManagerHome.this, ManagerLapKar.class);
                startActivity(i);
            }
        });
        TextView Lapk=findViewById(R.id.txt_absent);
        Lapk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ManagerHome.this, ManagerLapKar.class);
                startActivity(i);
            }
        });

        ImageButton Menu=findViewById(R.id.img_edt_menu);
        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ManagerHome.this, ManagerEditMenu.class);
                startActivity(i);
            }
        });
        TextView Menue=findViewById(R.id.txt_edt_menu);
        Menue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ManagerHome.this, ManagerEditMenu.class);
                startActivity(i);
            }
        });
    }
}

