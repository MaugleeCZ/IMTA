package com.example.imta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Vylepseni extends AppCompatActivity {

    static int pocetBodiku = 0;
    static int pocetKritSance = 0;
    static int pocetKritBody = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vylepseni);

        final Intent in = new Intent(this, MainActivity.class);



        final Button kritSance = findViewById(R.id.btnKritSance);
        final Button kritBody = findViewById(R.id.btnKritBody);
        final Button bodiky = findViewById(R.id.btnBodiky);
        Button btnZpet = findViewById(R.id.btnZpatky);

        if(MainActivity.zakoupenBodiky) {
            bodiky.setEnabled(false);
        }
        if(MainActivity.zakoupenKritBody) {
            kritBody.setEnabled(false);
        }
        if(MainActivity.zakoupenKritSance) {
            kritSance.setEnabled(false);
        }

        bodiky.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                if (MainActivity.body < 200) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(Vylepseni.this);
                    builder.setTitle("MIKERROR!");
                    builder.setMessage("potřebuješ víc bodů");
                    AlertDialog alert = builder.create();
                    alert.show();
                } else if(pocetBodiku >= 10)    {
                    bodiky.setEnabled(false);
                    MainActivity.zakoupenBodiky = true;
                } else {
                    Toast.makeText(getApplicationContext(),"To se ty body posypou...",Toast.LENGTH_SHORT).show();
                    MainActivity.body -= 200;
                    MainActivity.pocetBodu.setText(Integer.toString(MainActivity.body));
                    MainActivity.tfVahaKliku.setText(Integer.toString(MainActivity.vahaKliku));
                    MainActivity.vahaKliku *= 2;
                    pocetBodiku++;
                }
            }
        });

        kritBody.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                if (MainActivity.body < 100) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Vylepseni.this);
                    builder.setTitle("MIKERROR!");
                    builder.setMessage("potřebuješ víc bodů");
                    AlertDialog alert = builder.create();
                    alert.show();
                } else if(pocetKritBody >= 4)    {
                    kritBody.setEnabled(false);
                    MainActivity.zakoupenKritBody = true;
                } else {
                    Toast.makeText(getApplicationContext(),"Když už se to povede, stojí to za to",Toast.LENGTH_SHORT).show();
                    MainActivity.body -= 100;
                    MainActivity.pocetBodu.setText(Integer.toString(MainActivity.body));
                    MainActivity.kritBody *= 2;
                    pocetKritBody++;
                }
            }
        });

        kritSance.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                if (MainActivity.body < 100) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Vylepseni.this);
                    builder.setTitle("MIKERROR!");
                    builder.setMessage("potřebuješ víc bodůi");
                    AlertDialog alert = builder.create();
                    alert.show();
                } else if(pocetKritSance >= 10)    {
                    kritSance.setEnabled(false);
                    MainActivity.zakoupenKritSance = true;
                } else {
                    Toast.makeText(getApplicationContext(),"dobrá podkova bráško",Toast.LENGTH_SHORT).show();
                    MainActivity.body -= 100;
                    MainActivity.pocetBodu.setText(Integer.toString(MainActivity.body));
                    MainActivity.kritSance +=0.05;
                   pocetKritSance++;
                }
            }
        });

        btnZpet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.pocetBodu.setText(Integer.toString(MainActivity.body));
                startActivity(in);
            }
        });
    }
}
