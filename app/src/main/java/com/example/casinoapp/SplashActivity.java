package com.example.casinoapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        Thread thread = new Thread(){
            @Override
            public void run(){
                try{
                    sleep(4000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashActivity.this, LobbyActivity.class));
                }
            }
        };
        thread.start();
    }
}
