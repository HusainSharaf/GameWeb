package com.example.gameweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Minesweeper_welcome extends AppCompatActivity {

    private Button btn4by4;
    private Button btn6by5;
    private Button btn8by6;
    private ImageView imgback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minesweeper_welcome);

        btn4by4 = findViewById(R.id.button);
        btn6by5 = findViewById(R.id.button2);
        btn8by6 = findViewById(R.id.button3);
        imgback = findViewById(R.id.imageView2);

        btn4by4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Minesweeper_welcome.this, Minesweeper_easy.class);
                startActivity(i);
            }
        });

        btn6by5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Minesweeper_welcome.this, Minesweeper_normal.class);
                startActivity(i);
            }
        });

        btn8by6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Minesweeper_welcome.this, Minesweeper_hard.class);
                startActivity(i);
            }
        });

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Minesweeper_welcome.this, Games_list.class);
                startActivity(i);
            }
        });
    }
}