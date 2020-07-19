package com.example.gameweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Tic_Tac_Toe_welcome extends AppCompatActivity {

    private Button btnmulti;
    private Button btnsingul;
    private ImageView imgback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_welcome);

        btnmulti = findViewById(R.id.button);
        btnsingul = findViewById(R.id.button2);
        imgback = findViewById(R.id.imageView2);

        btnmulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tic_Tac_Toe_welcome.this, Tic_Tac_Toe_names.class);
                startActivity(i);
            }
        });

        btnsingul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tic_Tac_Toe_welcome.this, Tic_Tac_Toe_AI.class);
                startActivity(i);
            }
        });

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tic_Tac_Toe_welcome.this, Games_list.class);
                startActivity(i);
            }
        });

    }
}