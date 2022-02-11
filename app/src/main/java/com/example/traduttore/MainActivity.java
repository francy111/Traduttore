package com.example.traduttore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public static HashMap<String, String> sigle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setNavigationBarColor(Color.BLACK);
        SharedPreferences s = getSharedPreferences("avvio", MODE_PRIVATE);
        boolean check = s.getBoolean("settings", true);

        sigle = new HashMap<String, String>();
        {

            sigle.put("Bulgaro","BG");
            sigle.put("Ceco","CS");
            sigle.put("Cinese","ZH");
            sigle.put("Danese","DA");
            sigle.put("Estone","ET");
            sigle.put("Finlandese","FI");
            sigle.put("Francese","FR");
            sigle.put("Giapponese","JA");
            sigle.put("Greco","EL");
            sigle.put("Inglese","EN");
            sigle.put("Italiano","IT");
            sigle.put("Lettone","LV");
            sigle.put("Lituano","LT");
            sigle.put(" Olandese","NL");
            sigle.put(" Polacco","PL");
            sigle.put("Portoghese","PT");
            sigle.put(" Rumeno","RO");
            sigle.put(" Russo","RU");
            sigle.put(" Slovacco","SK");
            sigle.put("Sloveno","SL");
            sigle.put("Spagnolo","ES");
            sigle.put("Svedese","SV");
            sigle.put(" Tedesco","DE");
            sigle.put("Ungherese","HU");
        }

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        if(check){
            startActivity(new Intent(MainActivity.this, MenuActivity.class));
            startActivity(new Intent(MainActivity.this,SettingsActivity.class));
            finish();
        }else{
            startActivity(new Intent(MainActivity.this, MenuActivity.class));
            finish();
        }

    }
    public static String getLang(String fullName){
        return sigle.get(fullName);
    }
}