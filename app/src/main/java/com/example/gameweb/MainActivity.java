package com.example.gameweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnJoin;
    private Handler handler = new Handler();
    private Button btnback;
    private TextView tvaboutus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJoin = findViewById(R.id.button);
        btnJoin.setTag(R.drawable.rounded_corners_red);
        btnback = findViewById(R.id.button2);
        tvaboutus = findViewById(R.id.textView5);

        handler.postDelayed(runnable, 500);

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sign_Register.class);
                startActivity(i);
            }
        });


        tvaboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, About_GameWeb.class);
                startActivity(i);
            }
        });
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            switch ((int)btnJoin.getTag()){
                case R.drawable.rounded_corners_red:
                    btnJoin.setBackgroundResource(R.drawable.rounded_corners_orange);
                    btnJoin.setTag(R.drawable.rounded_corners_orange);
                    break;
                case R.drawable.rounded_corners_orange:
                    btnJoin.setBackgroundResource(R.drawable.rounded_corners_yellow);
                    btnJoin.setTag(R.drawable.rounded_corners_yellow);
                    break;
                case R.drawable.rounded_corners_yellow:
                    btnJoin.setBackgroundResource(R.drawable.rounded_corners_green20);
                    btnJoin.setTag(R.drawable.rounded_corners_green20);
                    break;
                case R.drawable.rounded_corners_green20:
                    btnJoin.setBackgroundResource(R.drawable.rounded_corners_blue20);
                    btnJoin.setTag(R.drawable.rounded_corners_blue20);
                    break;
                case R.drawable.rounded_corners_blue20:
                    btnJoin.setBackgroundResource(R.drawable.rounded_corners_purple20);
                    btnJoin.setTag(R.drawable.rounded_corners_purple20);
                    break;
                case R.drawable.rounded_corners_purple20:
                    btnJoin.setBackgroundResource(R.drawable.rounded_corners_red);
                    btnJoin.setTag(R.drawable.rounded_corners_red);
                    break;
            }
            handler.postDelayed(this, 500);

        }
    };
}