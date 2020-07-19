package com.example.gameweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Memory_hard extends AppCompatActivity {

    private ImageView[] Cards = new ImageView[12];
    private boolean[] Cardopen = new boolean[12];
    private int Numcardshow = 0;
    private Handler handler = new Handler();
    private int[] nums = {1, 3, 2, 2, 1, 3, 4, 6, 5, 5, 4, 6};
    private TextView tvtimer;
    private int numbertime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_hard);

        tvtimer = findViewById(R.id.textView2);
        shuffle(nums);

        for (int i = 0; i < 12; i = i + 1) {
            String imageID = "imageView" + String.valueOf(i + 1);
            int resID = getResources().getIdentifier(imageID, "id", getPackageName());
            Cards[i] = findViewById(resID);
        }


        for (int i = 0; i < 12; i = i + 1) {
            Cardopen[i] = false;
        }

        for (int i = 0; i < 12; i = i + 1) {
            Cards[i].setTag(R.drawable.playingcard);
        }

        handler.postDelayed(runnable2, 1000);


        Cards[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichcard(0);
                if (Numcardshow == 2) {
                    handler.postDelayed(runnable, 600);
                }
            }
        });
        Cards[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichcard(1);
                if (Numcardshow == 2) {
                    handler.postDelayed(runnable, 600);
                }
            }
        });
        Cards[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichcard(2);
                if (Numcardshow == 2) {
                    handler.postDelayed(runnable, 600);
                }
            }
        });
        Cards[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichcard(3);
                if (Numcardshow == 2) {
                    handler.postDelayed(runnable, 1000);
                }
            }
        });
        Cards[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichcard(4);
                if (Numcardshow == 2) {
                    handler.postDelayed(runnable, 600);
                }
            }
        });
        Cards[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichcard(5);
                if (Numcardshow == 2) {
                    handler.postDelayed(runnable, 600);
                }
            }
        });

        Cards[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichcard(6);
                if (Numcardshow == 2) {
                    handler.postDelayed(runnable, 600);
                }
            }
        });

        Cards[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichcard(7);
                if (Numcardshow == 2) {
                    handler.postDelayed(runnable, 600);
                }
            }
        });

        Cards[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichcard(8);
                if (Numcardshow == 2) {
                    handler.postDelayed(runnable, 600);
                }
            }
        });

        Cards[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichcard(9);
                if (Numcardshow == 2) {
                    handler.postDelayed(runnable, 600);
                }
            }
        });

        Cards[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichcard(10);
                if (Numcardshow == 2) {
                    handler.postDelayed(runnable, 600);
                }
            }
        });

        Cards[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichcard(11);
                if (Numcardshow == 2) {
                    handler.postDelayed(runnable, 600);
                }
            }
        });
    }


    private void checkformatch(){

        for (int i = 1; i <= 6; i = i + 1) {
            DO(getArrayIndex(nums, i), getArrayIndex2(nums, i));
        }
        if (NoCards()){
            handler.postDelayed(intentrunnable, 600);
        }

    }


    private void whichcard(int i) {

        if (Cards[i].getAlpha() != 0) {
            if ((int)Cards[i].getTag() == R.drawable.playingcard) {

                switch (nums[i]) {
                    case 1:
                        Cards[i].setImageResource(R.drawable.panda);
                        Cards[i].setTag(R.drawable.panda);
                        break;
                    case 2:
                        Cards[i].setImageResource(R.drawable.tiger);
                        Cards[i].setTag(R.drawable.tiger);
                        break;
                    case 3:
                        Cards[i].setImageResource(R.drawable.lion);
                        Cards[i].setTag(R.drawable.lion);
                        break;
                    case 4:
                        Cards[i].setImageResource(R.drawable.frog);
                        Cards[i].setTag(R.drawable.frog);
                        break;
                    case 5:
                        Cards[i].setImageResource(R.drawable.elephant);
                        Cards[i].setTag(R.drawable.tiger);
                        break;
                    case 6:
                        Cards[i].setImageResource(R.drawable.zebra);
                        Cards[i].setTag(R.drawable.zebra);
                        break;
                }
                Cardopen[i] = true;
                Numcardshow = Numcardshow + 1;
            } else {
                Cards[i].setImageResource(R.drawable.playingcard);
                Cards[i].setTag(R.drawable.playingcard);
                Cardopen[i] = false;
                Numcardshow = Numcardshow - 1;
            }

        } else {
            return;
        }

    }

    private void DO(int x, int y){
        if (!Cardopen[x] && !Cardopen[y]){
            return;
        } else if ((Cardopen[x] && ((int)Cards[x].getTag() != R.drawable.playingcard) && (Cards[x].getAlpha() != 0)) && (Cardopen[y] && ((int)Cards[y].getTag() != R.drawable.playingcard) && (Cards[y].getAlpha() != 0))) {
            Cards[x].setAlpha(0f);
            Cards[y].setAlpha(0f);
            Numcardshow = Numcardshow - 2;
        } else if ((Cardopen[x] && ((int)Cards[x].getTag() != R.drawable.playingcard) && (Cards[x].getAlpha() != 0)) || (Cardopen[y] && ((int)Cards[y].getTag() != R.drawable.playingcard) && (Cards[y].getAlpha() != 0))){
            Cards[x].setImageResource(R.drawable.playingcard);
            Cards[x].setTag(R.drawable.playingcard);
            Cardopen[x] = false;
            Cards[y].setImageResource(R.drawable.playingcard);
            Cards[y].setTag(R.drawable.playingcard);
            Cardopen[y] = false;
            Numcardshow = Numcardshow - 1;
        } else {
            return;
        }

    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            checkformatch();
        }
    };

    private int getArrayIndex2(int[] a2, int v2){
        int k = 0;
        for (int i = getArrayIndex(a2, v2) + 1; i < a2.length; i = i + 1){
            if (a2[i] == v2){
                k = i;
                break;
            }
        } return k;
    }

    private int getArrayIndex(int[] a, int v){
        int k = 0;
        for (int i = 0; i < a.length; i = i + 1){
            if (a[i] == v){
                k = i;
                break;
            }
        } return k;
    }

    private boolean NoCards(){
        boolean a = true;
        for (int i = 0; i < 12; i = i + 1){
            a = a && (Cards[i].getAlpha() == 0);
        }
        return a;
    }

    Runnable intentrunnable = new Runnable() {
        @Override
        public void run() {
            Intent j = new Intent(Memory_hard.this, Memory_end.class);
            j.putExtra("data1", numbertime);
            startActivity(j);
        }
    };

    Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            String timer = tvtimer.getText().toString();
            String texttime = "";
            for (int i = 0; i < timer.length(); i = i + 1){
                if (Character.isDigit(timer.charAt(i))){
                    texttime = texttime + timer.charAt(i);
                }
            }
            numbertime = Integer.parseInt(texttime);
            tvtimer.setText(" Time: " + String.valueOf(numbertime + 1) + " seconds ");
            handler.postDelayed(this, 1000);
        }
    };

    private void shuffle(int[] array){
        Random random = new Random();

        for (int i = 0; i < array.length; i = i + 1){
            int index = random.nextInt(array.length);
            int number = array[index];
            array[index] = array[i];
            array[i] = number;
        }
    }
}
