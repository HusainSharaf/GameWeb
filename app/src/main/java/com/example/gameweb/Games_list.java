package com.example.gameweb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Games_list extends AppCompatActivity {

    private Button btnlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_list);

        btnlogout = findViewById(R.id.button);

        Game tictactoe = new Game("Tic Tac Toe", "You can play with person or with AI. Every win is a point.", R.drawable.greentictactoe, Color.parseColor("#008000"), 30);
        Game guess_the_word = new Game("Guess the Word", "Test your knowledge by guessing the word.", R.drawable.guesstheword, Color.parseColor("#FF0000"), 30);
        Game memory = new Game("Memory cards", "Test your memory by picking similar cards.", R.drawable.playingcard2, Color.parseColor("#0000FF"), 30);
        Game minesweeper = new Game("Minesweeper", "Click on the squares to sweep. Beware of EXPLOSIVE mines.", R.drawable.grassbackground2, Color.parseColor("#ffa500"), 30);

        ArrayList<Game> myGames = new ArrayList<Game>();
        myGames.add(tictactoe);
        myGames.add(guess_the_word);
        myGames.add(memory);
        myGames.add(minesweeper);


        RecyclerView recyclerview = findViewById(R.id.recyclerview);

        //For neatness
        recyclerview.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(lm);
        /////////////////////////////////

        Adapter myadapter = new Adapter(myGames, this);
        recyclerview.setAdapter(myadapter);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Games_list.this, Sign_Register.class);
                startActivity(i);
            }
        });

    }
}