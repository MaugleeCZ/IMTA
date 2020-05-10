package com.example.imta;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static TextView pocetBodu;
    static int body = 0;
    static boolean zakoupenoBatole = false;
    static boolean zakoupenSkolak = false;
    static boolean zakoupenAngry = false;
    private ImageView mike;
    private int vahaKliku = 1;
    static TextView tfVahaKliku;
    private MediaPlayer mp;
    static int kritBody = 2;
    static double kritSance = 0.05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this, R.raw.click_sound);
        tfVahaKliku = findViewById(R.id.vahaKlikutf);
        tfVahaKliku.setText(Integer.toString(vahaKliku));

        pocetBodu = findViewById(R.id.pocetKliku);
        pocetBodu.setText(Integer.toString(body));
        mike = findViewById(R.id.obrazek);

        otevriObchod();
        pridejBody();

        while(true) {
            if (zakoupenAngry) {
                    mike.setImageResource(R.drawable.mike);
                    break;
                } else if (zakoupenSkolak){
                    mike.setImageResource(R.drawable.mike_skolak);
                    break;
                } else if (zakoupenoBatole) {
                    mike.setImageResource(R.drawable.mike_batole);
                break;
            } else {
                break;
            }
        }
    }

    private void otevriObchod() {
        Button but = findViewById(R.id.buttonObchod);
        but.setOnClickListener(new View.OnClickListener() {

        @Override
            public void onClick(View v) {
                obchod();
            }
        });

    }

    private void obchod() {
        Intent intent = new Intent(this, Obchod.class);
        startActivity(intent);
    }

    private void pridejBody() {
        mike = findViewById(R.id.obrazek);
        mike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                mikeClick();
            }
        });
    }

    private void mikeClick() {
        double sance = Math.random();
        if (sance < kritSance) {
            showToast("CRITICAL HIT!");
            body = kritBody*vahaKliku + body;
            pocetBodu.setText(Integer.toString(body));
        } else {
            body += vahaKliku;
            pocetBodu.setText(Integer.toString(body));
        }
    }

    private void showToast(String stringID) {
        Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        TextView textView = new TextView(this);
        textView.setText(stringID);
        textView.setTextSize(40f);
        textView.setTextColor(Color.BLACK);
        toast.setView(textView);
        toast.show();
    }


}
