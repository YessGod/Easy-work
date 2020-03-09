package com.example.nazim;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView welcome;
    Button quiz,switchcase;

    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declaring variables
        welcome = (TextView) findViewById(R.id.welcome);
        quiz = (Button) findViewById(R.id.quiz);
        switchcase = (Button) findViewById(R.id.switchcase);

        manageBlinkEffect();

        //when quiz button is clicked
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToActivity2();
            }
        });

        //when switchcase button is clicked
        switchcase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToActivity3();
            }
        });

        //creating a timer
        final TextView textView = (TextView) findViewById(R.id.time);
        Thread t = new Thread(){
            @Override
            public void run(){
                while (!isInterrupted()){
                    try {
                        Thread.sleep(1000); //1000millis = 1sec
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count++;
                                textView.setText(String.valueOf(count));
                            }
                        });
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }

    //animation method
    public void manageBlinkEffect() {
        ObjectAnimator anim = ObjectAnimator.ofInt(welcome, "backgroundColor", Color.WHITE, Color.GREEN, Color.RED);
        anim.setDuration(800);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        anim.start();
    }
    public void moveToActivity2(){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }
    public void moveToActivity3(){
        Intent intent = new Intent(MainActivity.this, Main3Activity.class);
        startActivity(intent);
    }
}
