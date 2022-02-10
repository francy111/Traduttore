package com.example.traduttore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getWindow().setNavigationBarColor(Color.BLACK);


        ((View)findViewById(R.id.binfo1)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,InfoActivity.class));
            }
        });
        ((TextView)findViewById(R.id.binfo2)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,InfoActivity.class));
            }
        });


        ((View)findViewById(R.id.btranslate1)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,TranslationActivity.class));
            }
        });
        ((TextView)findViewById(R.id.btranslate2)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,TranslationActivity.class));
            }
        });
        ((TextView)findViewById(R.id.btranslate3)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,TranslationActivity.class));
            }
        });
        ((ImageView)findViewById(R.id.sett)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,SettingsActivity.class));
            }
        });
    }
}