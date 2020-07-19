package com.example.gameweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Memory_welcome extends AppCompatActivity {

    private Button btneasy;
    private Button btnhard;
    private ImageView imgback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_welcome);

        btneasy = findViewById(R.id.button);
        btnhard = findViewById(R.id.button2);
        imgback = findViewById(R.id.imageView2);

        btneasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Memory_welcome.this, Memory_easy.class);
                startActivity(i);
            }
        });

        btnhard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Memory_welcome.this, Memory_hard.class);
                startActivity(i);
            }
        });

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Memory_welcome.this, Games_list.class);
                startActivity(i);
            }
        });
    }
}