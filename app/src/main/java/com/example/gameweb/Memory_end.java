package com.example.gameweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Memory_end extends AppCompatActivity {

    private Handler handler = new Handler();
    private Button btnBack;
    private TextView tvtime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_end);

        btnBack = findViewById(R.id.button);
        tvtime = findViewById(R.id.textView);
        handler.postDelayed(runnable, 500);
        btnBack.setTag(R.drawable.rounded_corners_red);

        Bundle b = getIntent().getExtras();
        int numbertime = b.getInt("data1");
        tvtime.setText("You took " + String.valueOf(numbertime + 1) + " seconds to finish the game");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Memory_end.this, Memory_welcome.class);
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