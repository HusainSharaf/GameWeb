package com.example.gameweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Robot_confirmation extends AppCompatActivity {

    private ImageView[] images = new ImageView[9];
    private Button btnConfirm;
    private boolean[] selected = new boolean[9];
    private Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot_confirmation);

        btnConfirm = findViewById(R.id.button);
        btnback = findViewById(R.id.button2);

        for (int i = 0; i < 9; i = i + 1){
            String StringID = "imageView" + String.valueOf(i + 1);
            int resID = getResources().getIdentifier(StringID, "id", getPackageName());
            images[i] = findViewById(resID);

        }

        for (int i = 0; i < 9; i = i + 1){
            selected[i] = false;
        }

        for (int h = 0; h < 9; h = h + 1){
            final int i = h;
            images[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selected[i] = !selected[i];
                    if (selected[i]) {
                        images[i].setBackgroundResource(R.drawable.border_yellow);
                    } else {
                        images[i].setBackgroundResource(R.drawable.border_white);
                    }
                }
            });
        }

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selected[2] && selected[3] && selected[4] && selected[7]){
                    Intent i = new Intent(Robot_confirmation.this, Congratulation.class);
                    Bundle b = getIntent().getExtras();
                    String name = b.getString("data1");
                    i.putExtra("data2", name);
                    startActivity(i);
                    for (int j = 0; j < 9; j = j + 1){
                        selected[j] = false;
                        images[j].setBackgroundResource(R.drawable.border_white);
                    }
                } else {
                    Toast.makeText(Robot_confirmation.this, "Information is invalid", Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < 9; i = i + 1){
                        selected[i] = false;
                        images[i].setBackgroundResource(R.drawable.border_white);
                    }


                }
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Robot_confirmation.this, Register.class);
                startActivity(i);
            }
        });
    }

}