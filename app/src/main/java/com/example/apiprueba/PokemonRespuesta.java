package com.example.apiprueba;

import java.io.Serializable;
import java.util.ArrayList;

public class PokemonRespuesta implements Serializable {


    private ArrayList<Pokemon> results;

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
