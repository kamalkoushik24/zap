package edu.harvard.cs50.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.jar.Attributes;

public class PokemonActivity extends AppCompatActivity {
    private class DownloadSpriteTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                return BitmapFactory.decodeStream(url.openStream());
            } catch (IOException e) {
                Log.e("cs50", "Download sprite error", e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
            imageView.setContentDescription("Image of " + pokemonName);
        }
    }
    private TextView nameTextView;
    private TextView numberTextView;
    private TextView type1TextView;
    private TextView type2TextView;
    private String url;
    private RequestQueue requestQueue;
    private Button crbutton;
    private boolean caught = false;
    private String text;
    private String pokemonName;
    private ImageView imageView;
    private TextView descTextView;
    private String descURL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        url = getIntent().getStringExtra("url");
        nameTextView = findViewById(R.id.pokemon_name);
        numberTextView = findViewById(R.id.pokemon_number);
        type1TextView = findViewById(R.id.pokemon_type1);
        type2TextView = findViewById(R.id.pokemon_type2);
        crbutton = findViewById(R.id.crbutton);
        descTextView = findViewById(R.id.pokemon_desc);
        imageView = findViewById(R.id.image);
        text = crbutton.getText().toString();
        load();

    }

    public void load() {
        type1TextView.setText("");
        type2TextView.setText("");

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {


                    nameTextView.setText(response.getString("name"));
                    numberTextView.setText(String.format("#%03d", response.getInt("id")));
                    String imageURL = response.getJSONObject("sprites").getString("front_default");
                    new DownloadSpriteTask().execute(imageURL);


                    JSONArray typeEntries = response.getJSONArray("types");
                    for (int i = 0; i < typeEntries.length(); i++) {
                        JSONObject typeEntry = typeEntries.getJSONObject(i);
                        int slot = typeEntry.getInt("slot");
                        String type = typeEntry.getJSONObject("type").getString("name");

                        if (slot == 1) {
                            type1TextView.setText(type);
                        }
                        else if (slot == 2) {
                            type2TextView.setText(type);
                        }
                    }

                    checkCatchStatus();

                    int id = response.getInt("id");
                    descURL = "https://pokeapi.co/api/v2/pokemon-species/" + id;
                    getDescription();


                } catch (JSONException e) {
                    Log.e("cs50", "Pokemon json error", e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("cs50", "Pokemon details error", error);
            }
        });

        requestQueue.add(request);
    }

    private void getDescription() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, descURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray descEntries = response.getJSONArray("flavor_text_entries");

                    for (int i = 0; i < descEntries.length(); i++) {
                        JSONObject entry = descEntries.getJSONObject(i);

                        if (entry.getJSONObject("language").getString("name").equals("en")) {
                            String description = entry.getString("flavor_text");
                            descTextView.setText(description.replaceAll("\\r\\n|\\r|\\n", " "));
                            break;
                        }
                    }
                } catch (JSONException e) {
                    Log.e("cs50", "pokemon description json error", e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("cs50", "pokemon description details error");
            }
        });
        requestQueue.add(request);
    }


    public void toggleCatch(View view) {

            if (!caught) {
                caught = true;
                crbutton.setText("Release");
                getPreferences(Context.MODE_PRIVATE).edit().putString(pokemonName, "caught").apply();
            }
            else {
                caught = false;
                crbutton.setText("Catch");
                getPreferences(Context.MODE_PRIVATE).edit().remove(pokemonName).apply();
            }


    }
    private void checkCatchStatus() {
        String catchStatus = getPreferences(Context.MODE_PRIVATE).getString(pokemonName, "");
        if (catchStatus.equals("caught") && !caught) {
            caught = true;
            crbutton.setText("Release");
        } else {
            crbutton.setText("Catch");
        }
    }
}
