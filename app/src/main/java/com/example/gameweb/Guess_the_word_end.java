package com.example.gameweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Guess_the_word_end extends AppCompatActivity {

    private TextView tvscore;
    private TextView tvscoremessage;
    private Button btnBack;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_word_end);

        tvscore = findViewById(R.id.textView);
        tvscoremessage = findViewById(R.id.textView2);
        btnBack = findViewById(R.id.button);
        Bundle b = getIntent().getExtras();
        String score = b.getString("data1");

        handler.postDelayed(runnable, 500);

        btnBack.setTag(R.drawable.rounded_corners_red);

                if (score.equals("0")) {
                    tvscore.setTextColor(Color.parseColor("#ff0000"));
                    tvscore.setText("Your score is 0/5");
                    tvscoremessage.setTextColor(Color.parseColor("#ff0000"));
                    tvscoremessage.setText("You Failed");
                } else if (score.equals("1")) {
                    tvscore.setTextColor(Color.parseColor("#ffa500"));
                    tvscore.setText("Your score is 1/5");
                    tvscoremessage.setTextColor(Color.parseColor("#ffa500"));
                    tvscoremessage.setText("Better luck next time");
                } else if (score.equals("2")){
                    tvscore.setTextColor(Color.parseColor("#ffff00"));
                    tvscore.setText("Your score is 2/5");
                    tvscoremessage.setTextColor(Color.parseColor("#ffff00"));
                    tvscoremessage.setText("You could do better");
                } else if (score.equals("3")) {
                    tvscore.setTextColor(Color.parseColor("#00ff00"));
                    tvscore.setText("Your score is 3/5");
                    tvscoremessage.setTextColor(Color.parseColor("#00ff00"));
                    tvscoremessage.setText("Good Job");
                } else if (score.equals("4")) {
                    tvscore.setTextColor(Color.parseColor("#0000ff"));
                    tvscore.setText("Your score is 4/5");
                    tvscoremessage.setTextColor(Color.parseColor("#0000ff"));
                    tvscoremessage.setText("Excellent!");
                } else {
                    tvscore.setTextColor(Color.parseColor("#800080"));
                    tvscore.setText("Your score is 5/5");
                    tvscoremessage.setTextColor(Color.parseColor("#800080"));
                    tvscoremessage.setText("Amazing!");
                }



        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Guess_the_word_end.this, Guess_the_word_welcome.class);
                startActivity(i);
            }
        });
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            switch ((int)btnBack.getTag()){
                case R.drawable.rounded_corners_red:
                    btnBack.setBackgroundResource(R.drawable.rounded_corners_orange);
                    btnBack.setTag(R.drawable.rounded_corners_orange);
                    break;
                case R.drawable.rounded_corners_orange:
                    btnBack.setBackgroundResource(R.drawable.rounded_corners_yellow);
                    btnBack.setTag(R.drawable.rounded_corners_yellow);
                    break;
                case R.drawable.rounded_corners_yellow:
                    btnBack.setBackgroundResource(R.drawable.rounded_corners_green20);
                    btnBack.setTag(R.drawable.rounded_corners_green20);
                    break;
                case R.drawable.rounded_corners_green20:
                    btnBack.setBackgroundResource(R.drawable.rounded_corners_blue20);
                    btnBack.setTag(R.drawable.rounded_corners_blue20);
                    break;
                case R.drawable.rounded_corners_blue20:
                    btnBack.setBackgroundResource(R.drawable.rounded_corners_purple20);
                    btnBack.setTag(R.drawable.rounded_corners_purple20);
                    break;
                case R.drawable.rounded_corners_purple20:
                    btnBack.setBackgroundResource(R.drawable.rounded_corners_red);
                    btnBack.setTag(R.drawable.rounded_corners_red);
                    break;
            }
            handler.postDelayed(this, 500);

        }
    };
}