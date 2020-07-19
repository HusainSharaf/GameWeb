package com.example.gameweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tic_Tac_Toe extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[3][3];
    private Button Resetbutton;
    private boolean player1turn = true;
    private int roundcount = 0;
    private int player1points = 0;
    private int player2points = 0;
    private Button btnback;
    private TextView player1textview;
    private TextView player2textview;
    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic__tac__toe);

        for (int i = 0; i < 3; i = i + 1){
            for (int j = 0; j < 3; j = j + 1){
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }

        player1textview = findViewById(R.id.player1);
        player2textview = findViewById(R.id.player2);
        Resetbutton = findViewById(R.id.Resetbutton);
        btnback = findViewById(R.id.button);

        Bundle b = getIntent().getExtras();
        final String player1textname = b.getString("data1");
        final String player2textname = b.getString("data2");
        player1textview.setText(player1textname + ":");
        player2textview.setText(player2textname + ":");

        Resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetboard();
                player1points = 0;
                player2points = 0;
                player1textview.setText(player1textname + ":");
                player2textview.setText(player2textname + ":");
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tic_Tac_Toe.this, Tic_Tac_Toe_names.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (!((Button) view).getText().toString().equals("")) {
            return;
        } else {
            if (player1turn) {
                ((Button) view ).setTextColor(Color.parseColor("#ADD8E6"));
                ((Button) view).setText("X");
            } else {
                ((Button) view ).setTextColor(Color.parseColor("#FF0000"));
                ((Button) view).setText("O");
            }
        }

        roundcount = roundcount + 1;

        if (checkforwin()){
            if (player1turn) {
                player1wins();
            } else {
                player2wins();
            }
        } else if (roundcount == 9) {
            draw();
        } else {
            player1turn = !player1turn;
        }

    }

    private boolean checkforwin(){
        String[][] field = new String[3][3];

        for (int i = 0; i < 3; i = i + 1){
            for (int j = 0; j < 3; j = j + 1){
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i = i + 1){
            if (field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2])  && !field[i][0].equals("")){
                return true;
            }
        }
        for (int i = 0; i < 3; i = i + 1){
            if (field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i])  && !field[0][i].equals("")){
                return true;
            }
        }
        if (field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2])  && !field[0][0].equals("")){
            return true;
        }
        if (field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0])  && !field[0][2].equals("")){
            return true;
        }

        return false;
    }

    private void player1wins(){
        player1points = player1points + 1;
        Bundle b = getIntent().getExtras();
        String player1textname = b.getString("data1");
        Toast.makeText(this, player1textname + " " + "Wins!", Toast.LENGTH_SHORT).show();
        updatepointstext();
        handler.postDelayed(runnable, 600);
    }

    private void player2wins(){
        player2points = player2points + 1;
        Bundle b = getIntent().getExtras();
        String player2textname = b.getString("data2");
        Toast.makeText(this, player2textname + " " +  "Wins!", Toast.LENGTH_SHORT).show();
        updatepointstext();
        handler.postDelayed(runnable, 600);
    }

    private void draw(){
        Toast.makeText(this, "Draw!", Toast.LENGTH_LONG).show();
        handler.postDelayed(runnable, 600);
    }

    private void updatepointstext(){

        Bundle b = getIntent().getExtras();
        String player1textname = b.getString("data1");
        String player2textname = b.getString("data2");
        if (player1points == 1) {
            player1textview.setText(player1textname + ":" +  " " + player1points + " point");
        } else {
            player1textview.setText(player1textname + ":" + " " + player1points + " points");
        }

        if (player2points == 1) {
            player2textview.setText(player2textname + ":" + " " + player2points + " point");
        } else {
            player2textview.setText(player2textname + ":" + " " + player2points + " points");
        }
    }

    private void resetboard(){
        for (int i = 0; i < 3; i = i + 1){
            for (int j = 0; j < 3; j = j + 1){
                buttons[i][j].setText("");
            }
        }
        roundcount = 0;
        player1turn = true;

    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            resetboard();
        }
    };


}