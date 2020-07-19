package com.example.gameweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Congratulation extends AppCompatActivity {

    private Button btnContinue;
    private ImageView btnback;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulation);

        btnContinue = findViewById(R.id.button);
        btnback = findViewById(R.id.imageView3);
        tvName = findViewById(R.id.textView3);

        Bundle b = getIntent().getExtras();
        String name = b.getString("data2");
        tvName.setText(name);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Congratulation.this, Sign_in.class);
                startActivity(i);
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Congratulation.this, Robot_confirmation.class);
            }
        });
    }
}