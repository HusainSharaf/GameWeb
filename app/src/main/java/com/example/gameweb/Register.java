package com.example.gameweb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class Register extends AppCompatActivity {

    private EditText etName;
    private EditText etUsername;
    private EditText etAge;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirm;
    private Button btnRegister;
    private DatabaseHelper databaseHelper;
    private ImageView imgBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseHelper = new DatabaseHelper(this);
        etName = findViewById(R.id.editTextTextPersonName);
        etUsername = findViewById(R.id.editTextTextPersonName2);
        etAge = findViewById(R.id.editTextTextPersonNameage);
        etEmail = findViewById(R.id.editTextTextPersonName3);
        etPassword = findViewById(R.id.editTextTextPersonName4);
        etConfirm = findViewById(R.id.editTextTextPersonName5);
        btnRegister = findViewById(R.id.button);
        imgBack = findViewById(R.id.imageView1);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String cnfpassword = etConfirm.getText().toString().trim();

                if (hastext(etName) && hastext(etUsername) && hastext(etPassword) && hastext(etAge)) {
                    if (password.equals(cnfpassword)) {
                        double val = databaseHelper.addUser(username, password);

                        if (val > 0) {
                            Toast.makeText(Register.this, "You have registered", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Register.this, Robot_confirmation.class);
                            String name = etName.getText().toString();
                            i.putExtra("data1", name);
                            startActivity(i);
                        } else {
                            Toast.makeText(Register.this, "Registeration Error", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(Register.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Register.this, "Please fill all required information", Toast.LENGTH_SHORT).show();
                }
            }
        });




        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this, Sign_Register.class);
                startActivity(i);
            }
        });
    }

    private boolean hastext(EditText editText){
        if (editText.getText().toString().equals("")){
            return false;
        }
        return true;
    }
}
