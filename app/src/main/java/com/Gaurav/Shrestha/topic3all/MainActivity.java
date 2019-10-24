package com.Gaurav.Shrestha.topic3all;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.Console;

public class MainActivity extends AppCompatActivity {
    private Handler handler = new Handler();
    private int  Pbinitialpoint =0;
    ProgressBar progressBar;
    TextView  textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.pw);
        textView=findViewById(R.id.tv);
new Thread(new Runnable() {
    @Override
    public void run() {
        while(Pbinitialpoint<100){
            Pbinitialpoint+=10;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    progressBar.setProgress(Pbinitialpoint);
                    textView.setText(String.valueOf(Pbinitialpoint));

                }
            });
            try{
                Thread.sleep(200);
            }catch(InterruptedException e){
                e.printStackTrace();
                //Thread.stop();

            }
        }if(Pbinitialpoint >=100){
            OnStop();

           }


    }
}).start();

    }
    protected void OnStop() {
                Intent intent= new Intent(MainActivity.this,SignUP.class);
        startActivity(intent);
        Pbinitialpoint=0;
    }

}
