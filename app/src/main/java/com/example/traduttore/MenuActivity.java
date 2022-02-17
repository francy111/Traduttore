package com.example.traduttore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    private long mLastClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getWindow().setNavigationBarColor(Color.BLACK);
        SharedPreferences s = getSharedPreferences("avvio", MODE_PRIVATE);
        boolean check = s.getBoolean("settings", true);


        ((View)findViewById(R.id.binfo1)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                startActivity(new Intent(MenuActivity.this,InfoActivity.class));
            }
        });
        ((TextView)findViewById(R.id.binfo2)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                startActivity(new Intent(MenuActivity.this,InfoActivity.class));
            }
        });


        ((View)findViewById(R.id.btranslate1)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                startActivity(new Intent(MenuActivity.this,TranslationActivity.class));
            }
        });
        ((TextView)findViewById(R.id.btranslate2)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                startActivity(new Intent(MenuActivity.this,TranslationActivity.class));
            }
        });
        ((TextView)findViewById(R.id.btranslate3)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                startActivity(new Intent(MenuActivity.this,TranslationActivity.class));
            }
        });
        ((ImageView)findViewById(R.id.sett)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                startActivity(new Intent(MenuActivity.this,SettingsActivity.class));
            }
        });
        ((View)findViewById(R.id.sett2)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                startActivity(new Intent(MenuActivity.this,SettingsActivity.class));
            }
        });

        CheckBox cc = findViewById(R.id.loadingcheck);
        cc.setChecked(check);
        cc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor e = getSharedPreferences("avvio", MODE_PRIVATE).edit();
                e.putBoolean("settings", cc.isChecked());
                e.commit();
            }
        });
    }
}