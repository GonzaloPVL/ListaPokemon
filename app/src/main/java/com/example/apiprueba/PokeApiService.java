package com.example.apiprueba;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeApiService {

    @GET("pokemon")
    Call<PokemonRespuesta> obtenerListaPokemon();
}
