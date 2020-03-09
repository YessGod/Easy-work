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

public class Main2Activity extends AppCompatActivity {

    //declare variables
    private Questions mQuestions = new Questions();
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button quit;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    TextView welcome;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //initialize variables
        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        quit = (Button) findViewById(R.id.quit);


        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goback();
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



        updateQuestions();

        //start of button listener for button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //logic of button
                if (mButtonChoice1.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestions();

                    //correct answer
                    Toast.makeText(Main2Activity.this, "Correct answer!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Main2Activity.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                    updateQuestions();
                }
            }
        });
        //end of button listener for button1

        //start of button listener for button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //logic of button
                if (mButtonChoice2.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestions();

                    //correct answer
                    Toast.makeText(Main2Activity.this, "Correct answer!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Main2Activity.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                    updateQuestions();
                }
            }
        });
        //end of button listener for button2

        //start of button listener for button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //logic of button
                if (mButtonChoice3.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestions();

                    //correct answer
                    Toast.makeText(Main2Activity.this, "Correct answer!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Main2Activity.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                    updateQuestions();
                }
                //the last question
                if (mQuestionNumber == Questions.mQuestions.length) {
                    Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                    Main2Activity.this.finish();
                    startActivity(intent);
                }else{
                    updateQuestions();
                }
            }
        });
        //end of button listener for button3



        //using variables
        welcome = (TextView) findViewById(R.id.welcome);


        //color change animation
        manageBlinkEffect();
    }
    //animation method
    public void manageBlinkEffect(){
        ObjectAnimator anim = ObjectAnimator.ofInt(welcome, "backgroundColor", Color.WHITE, Color.GREEN, Color.RED);
        anim.setDuration(800);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        anim.start();
    }
    private void updateQuestions(){
        mQuestionView.setText(mQuestions.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestions.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestions.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestions.getChoice3(mQuestionNumber));

        mAnswer = mQuestions.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;

    }
    private void updateScore(int point){
        mScoreView.setText(""+ mScore);
    }
    private void goback(){
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
    }
}
