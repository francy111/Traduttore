package com.example.traduttore;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.HashMap;
import androidx.constraintlayout.widget.*;

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
        Guideline bluh = findViewById(R.id.blu1);
        Guideline bluv = findViewById(R.id.blu2);

        if(check){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bluh.setGuidelinePercent(Float.parseFloat("0.90"));
                    bluv.setGuidelinePercent(Float.parseFloat("0.98"));
                }
            }, 1500);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bluh.setGuidelinePercent(Float.parseFloat("0.85"));
                    bluv.setGuidelinePercent(Float.parseFloat("0.96"));
                }
            }, 1510);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bluh.setGuidelinePercent(Float.parseFloat("0.80"));
                    bluv.setGuidelinePercent(Float.parseFloat("0.94"));
                }
            }, 1520);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bluh.setGuidelinePercent(Float.parseFloat("0.75"));
                    bluv.setGuidelinePercent(Float.parseFloat("0.92"));
                }
            }, 1530);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bluh.setGuidelinePercent(Float.parseFloat("0.70"));
                    bluv.setGuidelinePercent(Float.parseFloat("0.90"));
                }
            }, 1540);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bluh.setGuidelinePercent(Float.parseFloat("0.65"));
                    bluv.setGuidelinePercent(Float.parseFloat("0.88"));
                }
            }, 1550);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bluh.setGuidelinePercent(Float.parseFloat("0.60"));
                    bluv.setGuidelinePercent(Float.parseFloat("0.87"));
                }
            }, 1560);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bluh.setGuidelinePercent(Float.parseFloat("0.55"));
                    bluv.setGuidelinePercent(Float.parseFloat("0.86"));
                }
            }, 1570);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bluh.setGuidelinePercent(Float.parseFloat("0.50"));
                    bluv.setGuidelinePercent(Float.parseFloat("0.85"));
                }
            }, 1580);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bluh.setGuidelinePercent(Float.parseFloat("0.45"));
                    bluv.setGuidelinePercent(Float.parseFloat("0.84"));
                }
            }, 1590);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bluh.setGuidelinePercent(Float.parseFloat("0.40"));
                    bluv.setGuidelinePercent(Float.parseFloat("0.83"));
                }
            }, 1600);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bluh.setGuidelinePercent(Float.parseFloat("0.35"));
                    bluv.setGuidelinePercent(Float.parseFloat("0.82"));
                }
            }, 1610);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bluh.setGuidelinePercent(Float.parseFloat("0.30"));
                    bluv.setGuidelinePercent(Float.parseFloat("0.81"));
                }
            }, 1620);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bluh.setGuidelinePercent(Float.parseFloat("0.25"));
                    bluv.setGuidelinePercent(Float.parseFloat("0.80"));
                }
            }, 1630);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bluh.setGuidelinePercent(Float.parseFloat("0.20"));
                    bluv.setGuidelinePercent(Float.parseFloat("0.79"));
                }
            }, 1640);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bluh.setGuidelinePercent(Float.parseFloat("0.15"));
                    bluv.setGuidelinePercent(Float.parseFloat("0.78"));

                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(0,0);

                    Intent intent2 = new Intent(MainActivity.this, SettingsActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent2);
                    overridePendingTransition(0,0);
                    finish();
                }
            }, 1650);
        }else{
            {
                findViewById(R.id.view34).setVisibility(View.GONE);
                findViewById(R.id.view38).setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bluh.setGuidelinePercent(Float.parseFloat("0.90"));
                        bluv.setGuidelinePercent(Float.parseFloat("0.97"));
                    }
                }, 1500);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bluh.setGuidelinePercent(Float.parseFloat("0.85"));
                        bluv.setGuidelinePercent(Float.parseFloat("0.94"));
                    }
                }, 1510);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bluh.setGuidelinePercent(Float.parseFloat("0.80"));
                        bluv.setGuidelinePercent(Float.parseFloat("0.91"));
                    }
                }, 1520);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bluh.setGuidelinePercent(Float.parseFloat("0.75"));
                        bluv.setGuidelinePercent(Float.parseFloat("0.88"));
                    }
                }, 1530);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bluh.setGuidelinePercent(Float.parseFloat("0.70"));
                        bluv.setGuidelinePercent(Float.parseFloat("0.86"));
                    }
                }, 1540);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bluh.setGuidelinePercent(Float.parseFloat("0.65"));
                        bluv.setGuidelinePercent(Float.parseFloat("0.84"));
                    }
                }, 1550);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bluh.setGuidelinePercent(Float.parseFloat("0.60"));
                        bluv.setGuidelinePercent(Float.parseFloat("0.82"));
                    }
                }, 1560);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bluh.setGuidelinePercent(Float.parseFloat("0.55"));
                        bluv.setGuidelinePercent(Float.parseFloat("0.80"));
                    }
                }, 1570);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bluh.setGuidelinePercent(Float.parseFloat("0.50"));
                        bluv.setGuidelinePercent(Float.parseFloat("0.78"));

                        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        finish();
                    }
                }, 1580);
            }
        }

    }
    public static String getLang(String fullName){
        return sigle.get(fullName);
    }

}