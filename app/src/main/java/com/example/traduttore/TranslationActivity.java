package com.example.traduttore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
                int l_a = spinner1.getSelectedItemPosition();
                int l_b = spinner2.getSelectedItemPosition();


                spinner1.setSelection(l_b);
                spinner2.setSelection(l_a);
                ((TextView)findViewById(R.id.lingua_a)).setText(spinner1.getSelectedItem().toString());
                ((TextView)findViewById(R.id.lingua_b)).setText(spinner2.getSelectedItem().toString());
            }
        });
        ((View)findViewById(R.id.frecciette)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int l_a = spinner1.getSelectedItemPosition();
                int l_b = spinner2.getSelectedItemPosition();


                spinner1.setSelection(l_b);
                spinner2.setSelection(l_a);
                ((TextView)findViewById(R.id.lingua_a)).setText(spinner1.getSelectedItem().toString());
                ((TextView)findViewById(R.id.lingua_b)).setText(spinner2.getSelectedItem().toString());
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
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView)findViewById(R.id.lingua_a)).setText(spinner1.getSelectedItem().toString());
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView)findViewById(R.id.lingua_b)).setText(spinner2.getSelectedItem().toString());
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
    }
    private void sendRequest(String source_lan, String target_lan, String text, String auth_key){
        String url ="https://api-free.deepl.com/v2/translate?auth_key="+auth_key+"&"+"text="+text+"&"+"source_lang="+source_lan+"&"+"target_lang="+target_lan;


        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference collezione = db.collection("traduzioni");
        ArrayList<String> txt = new ArrayList<>();

        Map<String, Object> traduzione = new HashMap<>();
        traduzione.put("source_lang", source_lan);
        traduzione.put("target_lang", target_lan);
        traduzione.put("text", text);
        collezione.add(traduzione)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("\"TAG\"", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("\"TAG\"", "Error adding document", e);
                    }
                });


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
                        ((TextView)findViewById(R.id.dtext)).setText(decode(traduzione));
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
    private static String decode(String val){
        try{
            return new String(val.getBytes("ISO-8859-1"),"UTF-8");
        } catch(Exception e){
            Log.e("ERROR", e.getMessage());
            return "trsl_error";
        }
    }
}