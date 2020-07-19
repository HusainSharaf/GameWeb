package com.example.gameweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Tic_Tac_Toe_names extends AppCompatActivity {

    private EditText player1name;
    private EditText player2name;
    private Button Startgame;
    private ImageView imgback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic__tac__toe_names);

        player1name = findViewById(R.id.edittext1);
        player2name = findViewById(R.id.edittext2);
        Startgame = findViewById(R.id.button);
        imgback = findViewById(R.id.imageView);

        Startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String player1textname =player1name.getText().toString();
                String player2textname =player2name.getText().toString();
                Intent i = new Intent(Tic_Tac_Toe_names.this, Tic_Tac_Toe.class);
                i.putExtra("data1", player1textname);
                i.putExtra("data2", player2textname);
                startActivity(i);
            }
        });

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tic_Tac_Toe_names.this, Tic_Tac_Toe_welcome.class);
                startActivity(i);
            }
        });
    }
}