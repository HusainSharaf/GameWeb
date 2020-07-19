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

import java.util.Random;

public class Tic_Tac_Toe_AI extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[3][3];
    private Button Resetbutton;
    private int roundcount = 0;
    private int humanpoints = 0;
    private int AIpoints = 0;
    private Button btnback;
    private TextView humantextview;
    private TextView AItextview;
    private boolean humanturn = true;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic__tac__toe__a_i);


        for (int i = 0; i < 3; i = i + 1){
            for (int j = 0; j < 3; j = j + 1){
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }

        humantextview = findViewById(R.id.player1);
        AItextview = findViewById(R.id.player2);
        Resetbutton = findViewById(R.id.Resetbutton);
        btnback = findViewById(R.id.button);



        Resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetboard();
                humanpoints = 0;
                AIpoints = 0;
                humantextview.setText("You" + ":");
                AItextview.setText("AI" + ":");
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tic_Tac_Toe_AI.this, Tic_Tac_Toe_welcome.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onClick(View view) {

        if (!((Button) view).getText().toString().equals("")) {
            return;
        } else {
            ((Button) view).setTextColor(Color.parseColor("#0000FF"));
            ((Button) view).setText("X");


            roundcount = roundcount + 1;

            if (checkforwin()) {
                if (humanturn) {
                    humanwins();
                } else {
                    AIwins();
                }
            } else if (roundcount == 9) {
                draw();
            } else {
                humanturn = !humanturn;
            }

                handler.postDelayed(runnable, 600);


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

    private void humanwins(){
        humanpoints = humanpoints + 1;
        Toast.makeText(this,   "You " + "Win!", Toast.LENGTH_LONG).show();
        updatepointstext();
        handler.postDelayed(runnable2, 500);
    }

    private void AIwins(){
        AIpoints = AIpoints + 1;
        Toast.makeText(this,  "AI " +  "Wins!", Toast.LENGTH_LONG).show();
        updatepointstext();
        handler.postDelayed(runnable2, 500);
    }

    private void draw(){
        Toast.makeText(this, "Draw!", Toast.LENGTH_LONG).show();
        resetboard();
    }



    private void updatepointstext(){
        if (humanpoints == 1) {
            humantextview.setText("You" + ":" + " " + String.valueOf(humanpoints) + " point");
        } else {
            humantextview.setText("You" + ":" + " " + String.valueOf(humanpoints) + " points");
        }

        if (AIpoints == 1) {
            AItextview.setText("AI" + ":" + " " + String.valueOf(AIpoints) + " point");
        } else {
            AItextview.setText("AI" + ":" + " " + String.valueOf(AIpoints) + " points");
        }
    }

    private void resetboard(){
        for (int i = 0; i < 3; i = i + 1){
            for (int j = 0; j < 3; j = j + 1){
                buttons[i][j].setText("");
            }
        }
        roundcount = 0;
        humanturn = true;

    }

    private void AImove(){
        int r1 = 0;
        int r2 = 0;

        while (!buttons[r1][r2].getText().toString().equals("")){

            Random randomGen = new Random();
            r1 = randomGen.nextInt(3);
            r2 = randomGen.nextInt(3);
        }

        buttons[r1][r2].setTextColor(Color.parseColor("#FF0000"));
        buttons[r1][r2].setText("O");
        roundcount = roundcount + 1;
    }

    private boolean SIT(){
        boolean a = true;
        for (int i = 0; i < 3; i = i + 1){
            for (int j = 0; j < 3; j = j + 1){

                a = a && buttons[i][j].getText().toString().equals("");
            }
        }

        return !a;
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            if (SIT()) {
                AImove();
                if (checkforwin()) {
                    if (humanturn) {
                        humanwins();
                    } else {
                        AIwins();
                    }
                } else if (roundcount == 9) {
                    draw();
                } else {
                    humanturn = !humanturn;
                }

            }
        }

    };

    Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            resetboard();
        }
    };
}