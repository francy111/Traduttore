package com.example.traduttore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getWindow().setNavigationBarColor(Color.BLACK);
        SharedPreferences s = getSharedPreferences("lingue", MODE_PRIVATE);
        int a = s.getInt("origine", 0);
        int b = s.getInt("destinazione", 1);

        SharedPreferences s2 = getSharedPreferences("AUTHKEY", MODE_PRIVATE);
        ((EditText) findViewById(R.id.key)).setText(s2.getString("key", null));

        String[] lingue = getResources().getStringArray(R.array.lingue_traduzione);

        final Spinner spinner1 = findViewById(R.id.settingsor);
        final Spinner spinner2 = findViewById(R.id.settingsde);
        ArrayAdapter adapter1 = new ArrayAdapter(getApplicationContext(), R.layout.item_spinner3, Arrays.asList(lingue));
        ArrayAdapter adapter2 = new ArrayAdapter(getApplicationContext(), R.layout.item_spinner3, Arrays.asList(lingue));

        adapter1.setDropDownViewResource(R.layout.spinner_item_dropdown);
        adapter2.setDropDownViewResource(R.layout.spinner_item_dropdown);

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);

        spinner1.setSelection(a);
        spinner2.setSelection(b);

        findViewById(R.id.save1).setBackgroundColor(Color.WHITE);
        findViewById(R.id.save2).setBackgroundColor(Color.rgb(245, 247, 255));

        ((View)findViewById(R.id.save1)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if((a!=spinner1.getSelectedItemPosition()) || (b!=spinner2.getSelectedItemPosition())){
                    AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                    builder.setTitle("Conferma");
                    builder.setMessage("Vuoi modificare le lingue predefinite?");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            SharedPreferences s = getSharedPreferences("lingue", MODE_PRIVATE);
                            s = getSharedPreferences("lingue", MODE_PRIVATE);
                            SharedPreferences.Editor e = s.edit();
                            e.putInt("origine", spinner1.getSelectedItemPosition());
                            e.putInt("destinazione", spinner2.getSelectedItemPosition());
                            e.commit();
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            spinner1.setSelection(a);
                            spinner2.setSelection(b);
                            dialogInterface.cancel();
                        }
                    });
                    AlertDialog alertdialog = builder.create();
                    alertdialog.show();
                }
            }
        });

        ((View)findViewById(R.id.save2)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences s = getSharedPreferences("AUTHKEY", MODE_PRIVATE);
                String old_s = s.getString("key", "");
                String new_s = ((EditText) findViewById(R.id.key)).getText().toString();

                if (!old_s.equals(new_s)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                    builder.setTitle("Conferma");
                    builder.setMessage("Vuoi modificare il token di identificazione?");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String key = ((EditText) findViewById(R.id.key)).getText().toString();
                            SharedPreferences.Editor e = getSharedPreferences("AUTHKEY", MODE_PRIVATE).edit();
                            e.putString("key", key);
                            e.commit();
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AlertDialog alertdialog = builder.create();
                    alertdialog.show();
                }
            }
        });
    }
}