package com.example.traduttore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setNavigationBarColor(Color.BLACK);
        SharedPreferences s = getSharedPreferences("avvio", MODE_PRIVATE);
        boolean check = s.getBoolean("settings", true);

        if(check){
            startActivity(new Intent(MainActivity.this, MenuActivity.class));
            startActivity(new Intent(MainActivity.this,SettingsActivity.class));
            finish();
        }else{
            startActivity(new Intent(MainActivity.this, MenuActivity.class));
            finish();
        }

    }
}