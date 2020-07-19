package com.example.gameweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Sign_in extends AppCompatActivity {

    private Button btnLogin;
    private EditText etUsername;
    private EditText etPassword;
    DatabaseHelper databaseHelper;
    private ImageView imgback;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        databaseHelper = new DatabaseHelper(this);
        etUsername = findViewById(R.id.editTextTextPersonName);
        etPassword = findViewById(R.id.editTextTextPersonName2);
        btnLogin = findViewById(R.id.button);
        imgback = findViewById(R.id.imageView2);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                Boolean res = databaseHelper.checkUser(username, password);
                if (res){
                    Intent i = new Intent(Sign_in.this, Games_list.class);
                    startActivity(i);
                } else {
                    Toast.makeText(Sign_in.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Sign_in.this, Sign_Register.class);
                startActivity(i);
            }
        });



    }
}