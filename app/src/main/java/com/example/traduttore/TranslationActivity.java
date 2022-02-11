package com.example.traduttore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Arrays;

public class TranslationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);
        getWindow().setNavigationBarColor(Color.BLACK);

        SharedPreferences s = getSharedPreferences("lingue", MODE_PRIVATE);
        int origine, destinazione;
        origine = s.getInt("origine", 0);
        destinazione = s.getInt("destinazione", 1);

        String[] lingue = getResources().getStringArray(R.array.lingue_traduzione);


        final Spinner spinner1 = findViewById(R.id.lingue_origine);
        final Spinner spinner2 = findViewById(R.id.lingue_destinazione);

        ArrayAdapter adapter1 = new ArrayAdapter(getApplicationContext(), R.layout.item_spinner, Arrays.asList(lingue));
        ArrayAdapter adapter2 = new ArrayAdapter(getApplicationContext(), R.layout.item_spinner2, Arrays.asList(lingue));

        adapter1.setDropDownViewResource(R.layout.spinner_item_dropdown);
        adapter2.setDropDownViewResource(R.layout.spinner_item_dropdown);

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);

        spinner1.setSelection(origine);
        spinner2.setSelection(destinazione);

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

                int a = s.getInt("origine", 0) ;
                int b = s.getInt("destinazione", 1) ;


                e.putInt("origine", b);
                e.putInt("destinazione", a);

                spinner1.setSelection(b);
                spinner2.setSelection(a);

                ((TextView)findViewById(R.id.lingua_a)).setText(spinner1.getSelectedItem().toString());
                ((TextView)findViewById(R.id.lingua_b)).setText(spinner2.getSelectedItem().toString());
                e.commit();
            }
        });


        ((View)findViewById(R.id.translate1)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences s = getSharedPreferences("AUTHKEY", MODE_PRIVATE);
                String auth_key = s.getString("key", null);
                if(auth_key  == null){
                    AlertDialog.Builder builder = new AlertDialog.Builder(TranslationActivity.this);
                    builder.setTitle("Attenzione");
                    builder.setMessage("Per utilizzare questa funzione è necessario inserire il token di autenticazione nelle impostazioni, vuoi aprire le impostazioni?");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startActivity(new Intent(TranslationActivity.this, SettingsActivity.class));
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) { }
                    });
                    AlertDialog alertdialog = builder.create();
                    alertdialog.show();
                }else {
                    String text = ((TextView) findViewById(R.id.otext)).getText().toString();
                    String source = MainActivity.getLang(spinner1.getSelectedItem().toString());
                    String target = MainActivity.getLang(spinner2.getSelectedItem().toString());
                    sendRequest(source, target, text, auth_key);
                }
            }
        });

        ((TextView)findViewById(R.id.translate2)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences s = getSharedPreferences("AUTHKEY", MODE_PRIVATE);
                String auth_key = s.getString("key", null);
                if(auth_key == null){
                    AlertDialog.Builder builder = new AlertDialog.Builder(TranslationActivity.this);
                    builder.setTitle("Attenzione");
                    builder.setMessage("Per utilizzare questa funzione è necessario inserire il token di autenticazione nelle impostazioni, vuoi aprire le impostazioni?");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startActivity(new Intent(TranslationActivity.this, SettingsActivity.class));
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) { }
                    });
                    AlertDialog alertdialog = builder.create();
                    alertdialog.show();
                }else {
                    String text = ((TextView) findViewById(R.id.otext)).getText().toString();
                    String source = MainActivity.getLang(spinner1.getSelectedItem().toString());
                    String target = MainActivity.getLang(spinner2.getSelectedItem().toString());
                    sendRequest(source, target, text, auth_key);
                }
            }
        });
    }
    private void sendRequest(String source_lan, String target_lan, String text, String auth_key){
        String url ="https://api-free.deepl.com/v2/translate?auth_key="+auth_key+"&"+"text="+text+"&"+"source_lang="+source_lan+"&"+"target_lang="+target_lan;

        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest richiesta = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        String traduzione = response.substring(response.indexOf("\"text\":\"")+8, response.indexOf("\"}]}"));
                        ((TextView)findViewById(R.id.dtext)).setText(traduzione);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Log.e("API_error",error.getLocalizedMessage());
                    }
                }
        );
        queue.add(richiesta);
    }
}