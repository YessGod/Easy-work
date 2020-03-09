package com.example.nazim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3, quit;
    TextView color;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        quit = (Button) findViewById(R.id.quit);
        color = (TextView) findViewById(R.id.show_color);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                //btn1 selected
                color.setText("Oh, you like the " + btn1.getText() + " color!");
                break;
            case  R.id.btn2:
                //btn2 selected
                color.setText("Oh, you like the " + btn2.getText() + " color!");
                break;
            case R.id.btn3:
                //btn3 selected
                color.setText("Oh, you like the " + btn3.getText() + " color!");
                break;
                default:
                    break;


        }
    }
    private void goback(){
        Intent intent = new Intent(Main3Activity.this, MainActivity.class);
        startActivity(intent);
    }
}
