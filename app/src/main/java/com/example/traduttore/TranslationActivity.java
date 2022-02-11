package com.example.traduttore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

public class TranslationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);
        getWindow().setNavigationBarColor(Color.BLACK);

        SharedPreferences s = getSharedPreferences("lingue", MODE_PRIVATE);
        int origine, destinazione;
        origine = s.getInt("origine", 1);
        destinazione = s.getInt("destinazione", 2);

        String[] test = getResources().getStringArray(R.array.lingue_traduzione);


        final Spinner spinner1 = findViewById(R.id.lingue_origine);
        final Spinner spinner2 = findViewById(R.id.lingue_destinazione);

        ArrayAdapter adapter1 = new ArrayAdapter(getApplicationContext(), R.layout.item_spinner, Arrays.asList(test));
        ArrayAdapter adapter2 = new ArrayAdapter(getApplicationContext(), R.layout.item_spinner2, Arrays.asList(test));

        adapter1.setDropDownViewResource(R.layout.spinner_item_dropdown);
        adapter2.setDropDownViewResource(R.layout.spinner_item_dropdown);

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);

        spinner1.setSelection(origine+1);
        spinner2.setSelection(destinazione+1);

        ((TextView)findViewById(R.id.lingua_a)).setText(spinner1.getSelectedItem().toString());
        ((TextView)findViewById(R.id.lingua_b)).setText(spinner2.getSelectedItem().toString());

        ((View)findViewById(R.id.swap)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences s = getSharedPreferences("lingue", MODE_PRIVATE);
                SharedPreferences.Editor e = s.edit();

                int a = s.getInt("origine", 0);
                int b = s.getInt("destinazione", 1);

                e.putInt("origine", b);
                e.putInt("destinazione", a);

                spinner1.setSelection(b);
                spinner2.setSelection(a);

                ((TextView)findViewById(R.id.lingua_a)).setText(spinner1.getSelectedItem().toString());
                ((TextView)findViewById(R.id.lingua_b)).setText(spinner2.getSelectedItem().toString());
            }
        });
        ((View)findViewById(R.id.frecciette)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences s = getSharedPreferences("lingue", MODE_PRIVATE);
                SharedPreferences.Editor e = s.edit();

                int a = s.getInt("origine", 1) ;
                int b = s.getInt("destinazione", 2) ;


                e.putInt("origine", b);
                e.putInt("destinazione", a);

                spinner1.setSelection(b+1);
                spinner2.setSelection(a+1);

                ((TextView)findViewById(R.id.lingua_a)).setText(spinner1.getSelectedItem().toString());
                ((TextView)findViewById(R.id.lingua_b)).setText(spinner2.getSelectedItem().toString());
                e.commit();
            }
        });


        ((View)findViewById(R.id.translate1)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });

        ((TextView)findViewById(R.id.translate2)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
    }
}