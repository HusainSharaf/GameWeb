package com.example.gameweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Guess_the_word_welcome extends AppCompatActivity {

    private Button btneasy;
    private Button btnnormal;
    private ImageView imgback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_word_welcome);

        btneasy = findViewById(R.id.button);
        btnnormal = findViewById(R.id.button2);
        imgback = findViewById(R.id.imageView2);


        btneasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Guess_the_word_welcome.this, Guess_the_word_easy.class);
                startActivity(i);
            }
        });

        btnnormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Guess_the_word_welcome.this, Guess_the_word_hard.class);
                startActivity(i);
            }
        });

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Guess_the_word_welcome.this, Games_list.class);
                startActivity(i);
            }
        });

    }
}