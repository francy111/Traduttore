package com.example.traduttore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
            sigle.put("Olandese","NL");
            sigle.put("Polacco","PL");
            sigle.put("Portoghese","PT");
            sigle.put("Rumeno","RO");
            sigle.put("Russo","RU");
            sigle.put("Slovacco","SK");
            sigle.put("Sloveno","SL");
            sigle.put("Spagnolo","ES");
            sigle.put("Svedese","SV");
            sigle.put("Tedesco","DE");
            sigle.put("Ungherese","HU");
        }

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