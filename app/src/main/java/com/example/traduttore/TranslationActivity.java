package com.example.traduttore;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Arrays;

public class TranslationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);
        getWindow().setNavigationBarColor(Color.BLACK);

        String[] test = getResources().getStringArray(R.array.lingue_traduzione);


        final Spinner spinner1 = findViewById(R.id.lingue_origine);
        final Spinner spinner2 = findViewById(R.id.lingue_destinazione);

        ArrayAdapter adapter1 = new ArrayAdapter(getApplicationContext(), R.layout.item_spinner, Arrays.asList(test));
        ArrayAdapter adapter2 = new ArrayAdapter(getApplicationContext(), R.layout.item_spinner2, Arrays.asList(test));

        adapter1.setDropDownViewResource(R.layout.spinner_item_dropdown);
        adapter2.setDropDownViewResource(R.layout.spinner_item_dropdown);

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
    }
}