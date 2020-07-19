package com.example.gameweb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter {

    ArrayList<Game> gArray;
    Context C;

    public Adapter(ArrayList<Game> gArray, Context c){
        this.gArray = gArray;
        C = c;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.games_item_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((ViewHolder) holder).Image.setImageResource(gArray.get(position).getGameImage());
        ((ViewHolder) holder).Title.setText(gArray.get(position).getGameTitle());
        ((ViewHolder) holder).Title.setTextSize(gArray.get(position).getGameTitleSize());
        ((ViewHolder) holder).Description.setText(gArray.get(position).getGameDescription());
        ((ViewHolder) holder).Layout.setBackgroundColor(gArray.get(position).getGameColor());
        ((ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
                        Intent i = new Intent(C, Tic_Tac_Toe_welcome.class);
                        C.startActivity(i);
                        break;
                    case 1:
                        Intent j = new Intent(C, Guess_the_word_welcome.class);
                        C.startActivity(j);
                        break;
                    case 2:
                        Intent k = new Intent(C, Memory_welcome.class);
                        C.startActivity(k);
                        break;
                    case 3:
                        Intent l = new Intent(C, Minesweeper_welcome.class);
                        C.startActivity(l);
                        break;

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return gArray.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView Image;
        public TextView Title;
        public TextView Description;
        public RelativeLayout Layout;
        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            Image = view.findViewById(R.id.imageView1);
            Title = view.findViewById(R.id.textView);
            Description = view.findViewById(R.id.textView2);
            Layout = view.findViewById(R.id.layout);
        }
    }
}
