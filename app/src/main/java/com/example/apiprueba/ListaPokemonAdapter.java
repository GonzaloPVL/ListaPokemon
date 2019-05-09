package com.example.apiprueba;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaPokemonAdapter extends RecyclerView.Adapter<ListaPokemonAdapter.ViewHolder>{

    private ArrayList<Pokemon> dataset;

    public ListaPokemonAdapter(){
        dataset = new ArrayList<>();
    }

    public ListaPokemonAdapter(ArrayList<Pokemon> listaPokemon) {
        this.dataset = listaPokemon;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pokemon, viewGroup, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Pokemon p = dataset.get(i);
        viewHolder.nombreTextView.setText(p.getName());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    /*public void adicionarListaPokemon(ArrayList<Pokemon> listaPokemon) {
        dataset.addAll(listaPokemon);
        notifyDataSetChanged();
    }*/

    public class ViewHolder extends RecyclerView.ViewHolder{


        private ImageView fotoImageView;
        private TextView nombreTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoImageView = (ImageView) itemView.findViewById(R.id.fotoImageView);
            nombreTextView = (TextView) itemView.findViewById(R.id.nombreTextView);
        }
    }



}
