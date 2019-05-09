package com.example.apiprueba;

import android.net.UrlQuerySanitizer;
import android.nfc.Tag;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "POKEDEX";

    private Retrofit retrofit;

    private RecyclerView recyclerView;
    private ListaPokemonAdapter listaPokemonAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         layoutManager = new GridLayoutManager(this, 3);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Debug", "onStart");
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);





        retrofit = new Retrofit.Builder().baseUrl("http://pokeapi.co/api/v2/").addConverterFactory(GsonConverterFactory.create()).build();
        Log.e("Debug", "retrofit");

        obtenerDatos();
    }

    private void seteaDatos(PokemonRespuesta pokemonRespuesta){
        ArrayList<Pokemon> listaPokemon =  pokemonRespuesta.getResults();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListaPokemonAdapter listaPersonasAdapter = new ListaPokemonAdapter(listaPokemon);
        recyclerView.setAdapter(listaPersonasAdapter);
    }

    private void obtenerDatos() {
        Log.e("Debug", "obtenerDatos");

        PokeApiService service = retrofit.create(PokeApiService.class);
        Call<PokemonRespuesta> pokemonRespuestaCall = service.obtenerListaPokemon();

        pokemonRespuestaCall.enqueue(new Callback<PokemonRespuesta>() {
            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {

                PokemonRespuesta pokemonRespuesta = response.body();
                seteaDatos(pokemonRespuesta);
                


            }

            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {

                Log.e("Debug", "onFailure");

                Toast.makeText(getApplicationContext(), "On failure", Toast.LENGTH_LONG);

                Log.e(TAG, "onFailure" + t.getMessage());

            }
        });

    }


}
