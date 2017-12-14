package com.example.win81.project_advertinn_v2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    ProgressBar pb;
    ActionBar ab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ab=getSupportActionBar();
        ab.hide();
        new MyThread().start();
    }
    class MyThread extends Thread
    {
        public void run()
        {
            try {
                Thread.sleep(3000);
            }
            catch (Exception ex){}
            Intent in=new Intent(SplashActivity.this, LoginActivity.class);
            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|
                    Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(in);
        }
    }
}
