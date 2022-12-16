package com.example.casinoapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.casinoapp.ImgViewScrolling.IEventEnd;
import com.example.casinoapp.ImgViewScrolling.ImgViewScrolling;

import java.util.Random;

public class SlotsActivity extends AppCompatActivity implements IEventEnd {

    ImgViewScrolling img, img2, img3;
    TextView balance;
    Button btnPlay, btnHome;

    int count_done = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slots_activity);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        img = (ImgViewScrolling) findViewById(R.id.image);
        img2 = (ImgViewScrolling) findViewById(R.id.image2);
        img3 = (ImgViewScrolling) findViewById(R.id.image3);
        balance = (TextView) findViewById(R.id.txtBalance);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnHome = (Button) findViewById(R.id.btnBack);

        //set event
        img.setEventEnd(SlotsActivity.this);
        img2.setEventEnd(SlotsActivity.this);
        img3.setEventEnd(SlotsActivity.this);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // run
                if (Common.BALANCE >= 100){
                    img.setRandomValue(new Random().nextInt(6),new Random().nextInt((15-5)+1)+5);
                    img2.setRandomValue(new Random().nextInt(6),new Random().nextInt((15-5)+1)+5);
                    img3.setRandomValue(new Random().nextInt(6),new Random().nextInt((15-5)+1)+5);

                    Common.BALANCE -= 50;
                    balance.setText(String.valueOf(Common.BALANCE));
                }
                else {
                    Toast.makeText(SlotsActivity.this, "Insufficient Funds", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SlotsActivity.this, LobbyActivity.class));
                //persist the points
            }
        });
    }

    @Override
    public void eventEnd(int result, int count) {
        if (count_done < 2){
            count_done++;
        }
        else{
            count_done = 0; //reset

            if (img.getValue() == img2.getValue() && img2.getValue() == img3.getValue()){
                Common.BALANCE += 1000;
                Toast.makeText(this, "Jackpot baby!", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "+1000!", Toast.LENGTH_SHORT).show();
                balance.setText(String.valueOf(Common.BALANCE));
            }
            else if (img.getValue() == img2.getValue() || img2.getValue() == img3.getValue() || img.getValue() == img3.getValue()){
                Common.BALANCE += 250;
                Toast.makeText(this, "Congratulations!", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "+250!", Toast.LENGTH_SHORT).show();
                balance.setText(String.valueOf(Common.BALANCE));
            }
            else{
                Toast.makeText(this, "Better luck next time!", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "-50", Toast.LENGTH_SHORT).show();
            }

            balance.setText(String.valueOf(Common.BALANCE));
            //update balance on DB

        }
    }
}
