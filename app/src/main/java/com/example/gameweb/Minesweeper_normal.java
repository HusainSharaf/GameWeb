package com.example.gameweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Minesweeper_normal extends AppCompatActivity {

    private int height = 6;
    private int width = 5;
    private int bombs = 5;
    private ImageView[][] blocks = new ImageView[height][width];
    private TextView[][] numbertext = new TextView[height][width];
    private Button btnreset;
    private Button btnback;
    private Handler handler = new Handler();
    private boolean[][] brown = new boolean[height][width];
    private boolean[][] flagset = new boolean[height][width];
    private ImageView flag;
    private boolean flagclicked = false;
    private int brownnum;
    private int[][] Map = {{-1, 0, 0, 0, 0},
                           {0, -1, 0, 0, 0},
                           {0, 0, 0, -1, 0},
                           {0, 0, -1, 0, 0},
                           {0, -1, 0, 0, 0},
                           {0, 0, 0, 0, 0}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minesweeper_normal);

        btnreset = findViewById(R.id.button_reset);
        btnback = findViewById(R.id.button_back);
        flag = findViewById(R.id.imageViewflag);

        for (int g = 0; g < blocks.length; g++){
            for (int h = 0; h < blocks[0].length; h++){
                final int i = g;
                final int j = h;

                flagset[i][j] = false;

                String stringID = "textView" + i + j;
                int resID = getResources().getIdentifier(stringID, "id", getPackageName());
                numbertext[i][j] = findViewById(resID);
                numbertext[i][j].setTextSize(65);
                numbertext[i][j].setTypeface(Typeface.DEFAULT_BOLD);
                numbertext[i][j].setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                String stringID2 = "imageView" + i + j;
                int resID2 = getResources().getIdentifier(stringID2, "id", getPackageName());
                blocks[i][j] = findViewById(resID2);
                blocks[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        assign();
                        switch (Map[i][j]){
                            case 0:
                                //there has NOT been a change to the flag
                                if (!changeflag(i, j)) {
                                    blocks[i][j].setImageResource(R.drawable.dirt);
                                    brown[i][j] = true;
                                    brownnum = brownnum + 1;
                                }
                                break;
                            case 1:
                                if (!changeflag(i, j)) {
                                    blocks[i][j].setImageResource(R.drawable.dirt);
                                    numbertext[i][j].setTextColor(Color.parseColor("#1354E3"));
                                    numbertext[i][j].setText("1");
                                    brown[i][j] = true;
                                    brownnum = brownnum + 1;
                                }
                                break;
                            case 2:
                                if (!changeflag(i, j)) {
                                    blocks[i][j].setImageResource(R.drawable.dirt);
                                    numbertext[i][j].setTextColor(Color.parseColor("#13E3A3"));
                                    numbertext[i][j].setText("2");
                                    brown[i][j] = true;
                                    brownnum = brownnum + 1;
                                }
                                break;
                            case 3:
                                if (!changeflag(i, j)) {
                                    blocks[i][j].setImageResource(R.drawable.dirt);
                                    numbertext[i][j].setTextColor(Color.parseColor("#3AE313"));
                                    numbertext[i][j].setText("3");
                                    brown[i][j] = true;
                                    brownnum = brownnum + 1;
                                }
                                break;
                            case 4:
                                if (!changeflag(i, j)) {
                                    blocks[i][j].setImageResource(R.drawable.dirt);
                                    numbertext[i][j].setTextColor(Color.parseColor("#A9E62C"));
                                    numbertext[i][j].setText("4");
                                    brown[i][j] = true;
                                    brownnum = brownnum + 1;
                                }
                                break;
                            case 5:
                                if (!changeflag(i, j)) {
                                    blocks[i][j].setImageResource(R.drawable.dirt);
                                    numbertext[i][j].setTextColor(Color.parseColor("#FFFF00"));
                                    numbertext[i][j].setText("5");
                                    brown[i][j] = true;
                                    brownnum = brownnum + 1;
                                }
                                break;
                            case 6:
                                if (!changeflag(i, j)) {
                                    blocks[i][j].setImageResource(R.drawable.dirt);
                                    numbertext[i][j].setTextColor(Color.parseColor("#FFA500"));
                                    numbertext[i][j].setText("6");
                                    brown[i][j] = true;
                                    brownnum = brownnum + 1;
                                }
                                break;
                            case 7:
                                if (!changeflag(i, j)) {
                                    blocks[i][j].setImageResource(R.drawable.dirt);
                                    numbertext[i][j].setTextColor(Color.parseColor("#FF0000"));
                                    numbertext[i][j].setText("7");
                                    brown[i][j] = true;
                                    brownnum = brownnum + 1;
                                }
                                break;
                            case 8:
                                if (!changeflag(i, j)) {
                                    blocks[i][j].setImageResource(R.drawable.dirt);
                                    numbertext[i][j].setTextColor(Color.parseColor("#6D1300"));
                                    numbertext[i][j].setText("8");
                                    brown[i][j] = true;
                                    brownnum = brownnum + 1;
                                }
                                break;
                            case -1:
                                if (!changeflag(i, j)) {
                                    for (int a = 0; a < blocks.length; a++) {
                                        for (int b = 0; b < blocks[0].length; b++) {
                                            if (Map[a][b] == -1) {
                                                blocks[a][b].setImageResource(R.drawable.bomb);
                                                numbertext[a][b].setText("");
                                            }
                                        }
                                    }
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(Minesweeper_normal.this, "You Lost", Toast.LENGTH_SHORT).show();
                                            reset();
                                        }
                                    }, 900);
                                }
                                break;

                        }
                        if (checkforwin()){
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(Minesweeper_normal.this, "You Won!", Toast.LENGTH_SHORT).show();
                                    reset();
                                }
                            }, 1000);
                        }
                    }
                });
            }
        }

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Minesweeper_normal.this, Minesweeper_welcome.class);
                startActivity(i);
            }
        });

        flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if flag is not clicked
                if (!flagclicked){
                    flag.setBackgroundResource(R.drawable.border_white);
                    //if flag is clicked
                } else {
                    flag.setBackgroundResource(R.drawable.border_lightgreen);
                }
                flagclicked = !flagclicked;
            }
        });

        reset();
    }

    private void assign(){
        for (int i = 0; i < Map.length; i++){
            for (int j = 0; j < Map[0].length; j++){
                Map[i][j] = compute(i, j);
            }
        }
    }

    private int compute(int i, int j){
        int number = 0;
        if (Map[i][j] == -1){
            number = -1;
            return number;
        }
        if (i > 0){
            if (Map[i - 1][j] == -1){
                number = number + 1;
            }
        }

        if (j < Map[0].length - 1){
            if (Map[i][j + 1] == -1){
                number = number + 1;
            }
        }

        if (i < Map.length - 1){
            if (Map[i + 1][j] == -1){
                number = number + 1;
            }
        }

        if (j > 0){
            if (Map[i][j - 1] == -1){
                number = number + 1;
            }
        }

        //if the block on the top right is -1
        if (i > 0 && j < Map[0].length - 1){
            if (Map[i - 1][j + 1] == -1){
                number = number + 1;
            }
        }
        //if the block on the bottom right is -1
        if (i < Map.length - 1 && j < Map[0].length - 1){
            if (Map[i + 1][j + 1] == -1){
                number = number + 1;
            }
        }
        //if the block on the bottom left is -1
        if (i < Map.length - 1 && j > 0){
            if (Map[i + 1][j +-1] == -1){
                number = number + 1;
            }
        }
        //if the block on the top left is -1
        if (i > 0 && j > 0){
            if (Map[i - 1][j -1] == -1){
                number = number + 1;
            }
        }

        return  number;
    }

    private void reset(){
        for (int i = 0; i < blocks.length; i++){
            for (int j = 0; j < blocks[0].length; j++){
                //if i + j is even
                if (((i + j) % 2) == 0){
                    blocks[i][j].setImageResource(R.drawable.grass);
                    numbertext[i][j].setText("");
                    //if i + j is not even
                } else {
                    blocks[i][j].setImageResource(R.drawable.darkgrass);
                    numbertext[i][j].setText("");
                }
                brown[i][j] = false;
                flagset[i][j] = false;
            }
        }
        flag.setBackgroundResource(R.drawable.border_lightgreen);
        flagclicked = false;
        shuffle(Map);
        brownnum = 0;
    }

    private boolean checkforwin(){

        if (brownnum == (height * width) - bombs){
            return true;
        }
        return false;

    }

    private void shuffle(int[][] array){
        Random random = new Random();

        for (int i = 0; i < array.length; i = i + 1){
            for (int j = 0; j < array[0].length; j = j + 1) {
                int index = random.nextInt(array.length);
                int index2 = random.nextInt(array[0].length);
                int number = array[index][index2];
                array[index][index2] = array[i][j];
                array[i][j] = number;
            }
        }
    }

    private boolean changeflag(int i, int j){
        //if the flag sign is clicked and the block is green and there is no flag
        if (flagclicked && !brown[i][j] && !flagset[i][j]){
            if (((i + j) % 2) == 0){
                blocks[i][j].setImageResource(R.drawable.grassredflag);
                numbertext[i][j].setText("");
            } else {
                blocks[i][j].setImageResource(R.drawable.darkgrassredflag);
                numbertext[i][j].setText("");
            }
            flagset[i][j] = true;
            return true;
            //if the flag sign is clicked and the block is green and there is a flag
        } else if (flagclicked && !brown[i][j] && flagset[i][j]){
            if (((i + j) % 2) == 0){
                blocks[i][j].setImageResource(R.drawable.grass);
                numbertext[i][j].setText("");
            } else {
                blocks[i][j].setImageResource(R.drawable.darkgrass);
                numbertext[i][j].setText("");
            }
            flagset[i][j] = false;
            return true;
        }

        return false;
    }
}