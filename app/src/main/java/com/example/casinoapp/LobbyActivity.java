package com.example.casinoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LobbyActivity extends AppCompatActivity {

    ImageButton btnChips, btnWar, btnBJ, btnSlots, logOut;
    TextView txtUser, txtBalance;
    //User user;
    //DBHelper db = new DBHelper(this);
    //private SharedPreferences savedValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lobby_activity);

        //savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
        //logOut = findViewById(R.id.btnLogOut);
        btnChips = (ImageButton) findViewById(R.id.btnChips);
        btnWar = (ImageButton) findViewById(R.id.btnWar);
        btnBJ = (ImageButton) findViewById(R.id.btnBj);
        btnSlots = (ImageButton) findViewById(R.id.btnSlots);
        txtUser = (TextView) findViewById(R.id.txtUsername);
        txtBalance = (TextView) findViewById(R.id.txtBalance);

        //set text for username and balance
        txtUser.setText("Username"); //call from DB
        txtBalance.setText("1000");

        //int id = savedValues.getInt("ID", -1);

        /*
        try {
            if (id == -1)
                throw new RuntimeException();
            user = db.GetUser(id);
        } catch (ParseException | RuntimeException e) {
            e.printStackTrace();
        }
        */

        //showUserCoins();

        btnChips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if timer is activate and turns chipadd boolean to true

                // add chip

                //if boolean is false

                //toast and say chips arnt ready
            }
        });

        //SharedPreferences.Editor editor = savedValues.edit();
        btnWar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //startActivity(new Intent(LobbyActivity.this, WarActivity.class));
                //editor.putInt("ID",  user.getU_id());
                //editor.apply();
            }
        });

        btnBJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(LobbyActivity.this, BlackJackActivity.class));
                //editor.putInt("ID",  user.getU_id());
                //editor.apply();
            }
        });

        btnSlots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LobbyActivity.this, SlotsActivity.class));
                //editor.putInt("ID",  user.getU_id());
                //editor.apply();
            }
        });
    }

    /*
    private void showUserCoins() {
        FragmentManager fm = getSupportFragmentManager();
        UserCoinsFragment editNameDialogFragment = UserCoinsFragment.newInstance("Your Coins: $" + user.getNum_chips());
        editNameDialogFragment.show(fm, "fragment_user_coins");
    }

     */
}
