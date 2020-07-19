package com.example.gameweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Guess_the_word_hard extends AppCompatActivity {

    private Button btnfirst;
    private Button btnsecond;
    private Button btnthird;
    private Button btnfourth;
    private Button btnnext;
    private Button btnback;
    private TextView tvanswer;
    private ImageView imgpicture;
    private int pagenumber = 1;
    private TextView tvtimer;
    int score = 0;
    Handler handler = new Handler();
    String[] ans = {"WRENCH", "BULBASAUR", "NEW ZEALAND", "CARAMBOLA", "GOOFY"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_word_hard);

        btnfirst = findViewById(R.id.button);
        btnsecond = findViewById(R.id.button2);
        btnthird = findViewById(R.id.button3);
        btnfourth = findViewById(R.id.button4);
        btnnext = findViewById(R.id.button5);
        btnback = findViewById(R.id.button6);
        tvanswer = findViewById(R.id.textView);
        imgpicture = findViewById(R.id.imageView1);
        tvtimer = findViewById(R.id.textView2);

        handler.postDelayed(runnable, 1000);

        btnfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvanswer.setText(btnfirst.getText().toString());
            }
        });

        btnsecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvanswer.setText(btnsecond.getText().toString());
            }
        });

        btnthird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvanswer.setText(btnthird.getText().toString());
            }
        });

        btnfourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvanswer.setText(btnfourth.getText().toString());
            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (check()) {
                    score = score + 1;
                    nextpage();
                } else {
                    Toast.makeText(Guess_the_word_hard.this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
                    nextpage();
                }

            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Guess_the_word_hard.this, Guess_the_word_welcome.class);
                startActivity(i);
            }
        });
    }

    private void nextpage(){
        switch (pagenumber) {
            case 1:
                imgpicture.setImageResource(R.drawable.bulbasaur);
                btnfirst.setTextSize(40);
                btnfirst.setText("CLEFABLE");
                btnsecond.setTextSize(35);
                btnsecond.setText("NINETALES");
                btnthird.setTextSize(30);
                btnthird.setText("BULBASAUR");
                btnfourth.setTextSize(35);
                btnfourth.setText("VENUSAUR");
                break;
            case 2:
                imgpicture.setImageResource(R.drawable.newzealandflag);
                btnfirst.setTextSize(35);
                btnfirst.setText("AUSTRALIA");
                btnsecond.setTextSize(40);
                btnsecond.setText("UNITED KINGDOM");
                btnthird.setTextSize(45);
                btnthird.setText("AUSTRIA");
                btnfourth.setTextSize(40);
                btnfourth.setText("NEW ZEALAND");
                break;
            case 3:
                imgpicture.setImageResource(R.drawable.carambola2);
                btnfirst.setTextSize(50);
                btnfirst.setText("MANGO");
                btnsecond.setTextSize(35);
                btnsecond.setText("NECTARINE");
                btnthird.setTextSize(45);
                btnthird.setText("DRAGON FRUIT");
                btnfourth.setTextSize(30);
                btnfourth.setText("CARAMBOLA");
                break;
            case 4:
                imgpicture.setImageResource(R.drawable.goofy2);
                btnfirst.setTextSize(50);
                btnfirst.setText("GOOFY");
                btnsecond.setTextSize(50);
                btnsecond.setText("PLUTO");
                btnthird.setTextSize(45);
                btnthird.setText("DONALD DUCK");
                btnfourth.setTextSize(50);
                btnfourth.setText("PETE");
                break;
            case 5:
                handler.removeCallbacks(runnable);
                Intent i = new Intent(Guess_the_word_hard.this, Guess_the_word_end.class);
                i.putExtra("data1", String.valueOf(score));
                startActivity(i);
                break;
        }

        if (pagenumber < 5) {
            pagenumber = pagenumber + 1;
        }
        tvanswer.setText("");
        tvtimer.setText("7 seconds left");
    }

    private boolean check(){
        switch (pagenumber){
            case 1:
                return correct(ans[0]);
            case 2:
                return correct(ans[1]);
            case 3:
                return correct(ans[2]);
            case 4:
                return correct(ans[3]);
            case 5:
                return correct(ans[4]);
        }
        return false;
    }

    private boolean correct(String string){
        if (tvanswer.getText().toString().equals(string)){
            return true;
        } else {
            return false;
        }
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int i = 0;
            String texttime = "";

            while (Character.isDigit(tvtimer.getText().toString().charAt(i))){
                texttime = texttime + String.valueOf(tvtimer.getText().toString().charAt(i));
                i = i + 1;
            }
            //the number of time left
            int numbertime = Integer.parseInt(texttime);
            int numbertime2 = numbertime - 1;
            tvtimer.setText(numbertime2 + " seconds left");
            if (numbertime2 > 0) {
                handler.postDelayed(this, 1000);
            } else {
                nextpage();
                handler.postDelayed(this, 1000);

            }
        }
    };
}