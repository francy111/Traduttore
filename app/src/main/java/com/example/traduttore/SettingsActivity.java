package com.example.traduttore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Arrays;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getWindow().setNavigationBarColor(Color.BLACK);

        String[] test = getResources().getStringArray(R.array.lingue_traduzione);
        String[] lingue = new String[test.length-1];
        for(int i = 0; i < lingue.length; i++){
            lingue[i] = test[i+1];
        }

        final Spinner spinner1 = findViewById(R.id.settingsor);
        final Spinner spinner2 = findViewById(R.id.settingsde);
        ArrayAdapter adapter1 = new ArrayAdapter(getApplicationContext(), R.layout.item_spinner3, Arrays.asList(lingue));
        ArrayAdapter adapter2 = new ArrayAdapter(getApplicationContext(), R.layout.item_spinner3, Arrays.asList(lingue));

        adapter1.setDropDownViewResource(R.layout.spinner_item_dropdown);
        adapter2.setDropDownViewResource(R.layout.spinner_item_dropdown);

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);

        spinner1.setSelection(0);
        spinner2.setSelection(1);

       findViewById(R.id.save1).setBackgroundColor(Color.WHITE);
       findViewById(R.id.save2).setBackgroundColor(Color.rgb(245, 247, 255));


        ((View)findViewById(R.id.save1)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences s = getSharedPreferences("lingue", MODE_PRIVATE);
                SharedPreferences.Editor e = s.edit();
                e.putString("origine", );
            }
        });

        ((View)findViewById(R.id.save2)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
    }
}