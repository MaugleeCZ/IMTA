package com.example.imta;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Obchod extends AppCompatActivity {

    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obchod);

        mp = MediaPlayer.create(this, R.raw.fail_sound);

        final Intent intent = new Intent(this, MainActivity.class);

        final Button mikeDiteButton = findViewById(R.id.malejMike);
        final Button mikeSkolakButton = findViewById(R.id.rozumnejMike);
        final Button mikeAngryButton = findViewById(R.id.angyMike);

        if (MainActivity.zakoupenoBatole == true) {
            mikeDiteButton.setEnabled(false);
        }
        if (MainActivity.zakoupenSkolak == true) {
            mikeSkolakButton.setEnabled(false);
        }
        if (MainActivity.zakoupenAngry == true) {
            mikeAngryButton.setEnabled(false);
        }


        mikeDiteButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                if (MainActivity.body < 100) {
                    mp.start();
                    AlertDialog.Builder builder = new AlertDialog.Builder(Obchod.this);
                    builder.setTitle("ERRORMIKE!");
                   builder.setMessage("Ty blázne, vždyť nemáš dostatek chechtáků!");
                    AlertDialog alert = builder.create();
                    alert.show();
                } else {
                    Toast.makeText(getApplicationContext(),"Se na něj běž podívat",Toast.LENGTH_SHORT).show();
                    MainActivity.body -= 100;
                    MainActivity.pocetBodu.setText(Integer.toString(MainActivity.body));
                    mikeDiteButton.setEnabled(false);
                    MainActivity.zakoupenoBatole = true;
                }
            }
        });

        mikeSkolakButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                if (MainActivity.body < 1000) {
                    mp.start();
                    AlertDialog.Builder builder = new AlertDialog.Builder(Obchod.this);
                    builder.setTitle("ERRORMIKE!");
                    builder.setMessage("Ty blázne, vždyť nemáš dostatek chechtáků!");
                    AlertDialog alert = builder.create();
                    alert.show();
                } else {
                    Toast.makeText(getApplicationContext(),"Už povyrost, kluk ušatej",Toast.LENGTH_SHORT).show();
                    MainActivity.body -= 1000;
                    MainActivity.pocetBodu.setText(Integer.toString(MainActivity.body));
                    mikeSkolakButton.setEnabled(false);
                    MainActivity.zakoupenSkolak = true;
                }
            }
        });

        mikeAngryButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                if (MainActivity.body < 10000) {
                    mp.start();
                    AlertDialog.Builder builder = new AlertDialog.Builder(Obchod.this);
                    builder.setTitle("ERRORMIKE!");
                    builder.setMessage("Ty blázne, buď rád, že na něj nemáš kováky!");
                    AlertDialog alert = builder.create();
                    alert.show();
                } else {
                    Toast.makeText(getApplicationContext(),"Tohle se nemělo stát :(",Toast.LENGTH_SHORT).show();
                    MainActivity.body -= 10000;
                    MainActivity.pocetBodu.setText(Integer.toString(MainActivity.body));
                    mikeAngryButton.setEnabled(false);
                    MainActivity.zakoupenAngry = true;
                }
            }
        });

        Button zpet = findViewById(R.id.zpetNaKlikButton);
        zpet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MainActivity.pocetBodu.setText(Integer.toString(MainActivity.body));
                startActivity(intent);
            }
        });

    }
}
