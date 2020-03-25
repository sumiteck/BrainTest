package com.example.braintest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    Button start;
    TextView timer;
    TextView sum;
    Timer tim;
    ArrayList<Integer> answers =  new ArrayList<Integer>(); ;
    int ansloc;
    public void start(View view){

        start.setVisibility(View.INVISIBLE);
    }

    public void timer(){
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText(""+ millisUntilFinished / 1000);
            }

            public void onFinish() {
                timer.setTextSize(14);
                timer.setText("done!");
            }
        }.start();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button)findViewById(R.id.startButton);
        timer = (TextView)findViewById(R.id.timer);
        sum = (TextView)findViewById(R.id.sum);

        Button grid1 = (Button)findViewById(R.id.grid1);
        Button grid2 = (Button)findViewById(R.id.grid2);
        Button grid3 = (Button)findViewById(R.id.grid3);
        Button grid4 = (Button)findViewById(R.id.grid4);
        Random rand = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        sum.setText(Integer.toString(a)+"+"+(Integer.toString(b)));
        ansloc = rand.nextInt(4);

        int incorrectans;
        for(int i=0; i<=4; i++){
            if(i==ansloc){
                answers.add(a+b);
            }
            else
            {
                incorrectans = rand.nextInt(41);
                while(incorrectans == a+b){

                    incorrectans = rand.nextInt(41);
                }
                answers.add(incorrectans);
            }



        }
        grid1.setText(Integer.toString(answers.get(0)));
        grid2.setText(Integer.toString(answers.get(1)));
        grid3.setText(Integer.toString(answers.get(2)));
        grid4.setText(Integer.toString(answers.get(3)));
        timer();
    }


}
