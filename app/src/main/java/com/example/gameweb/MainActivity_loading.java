package com.example.gameweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity_loading extends AppCompatActivity {

    private ProgressBar circleprogressBar;
    private ProgressBar horizontalprogressBar;
    private TextView tvpercent;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_loading);

        circleprogressBar = findViewById(R.id.progressBar);
        horizontalprogressBar = findViewById(R.id.progressBar2);
        tvpercent = findViewById(R.id.textView);


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                String textpercent = "";
                while (Character.isDigit(tvpercent.getText().toString().charAt(i))){
                    textpercent = textpercent + tvpercent.getText().toString().charAt(i);
                    i = i + 1;
                }
                int numberpercent = Integer.parseInt(textpercent);
                int numberpercent2 = numberpercent + 1;
                tvpercent.setText(numberpercent2 + " %");
                if (numberpercent2 < 100){
                    handler.postDelayed(this, 40);
                } else {
                    handler.removeCallbacks(this);
                    Intent j = new Intent(MainActivity_loading.this, MainActivity.class);
                    startActivity(j);
                }
            }
        }, 40);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int i = horizontalprogressBar.getProgress();
                horizontalprogressBar.setProgress(i + 1);
                handler.postDelayed(this, 40);
            }
        }, 40);
    }
}