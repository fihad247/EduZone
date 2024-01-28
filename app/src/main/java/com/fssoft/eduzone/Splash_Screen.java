package com.fssoft.eduzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);



        // ---------its  2 line for Fullscree code-------------
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // ----------hide action bar---------
        // getSupportActionBar().hide();

        //--------custom ---- navigationBarColor--------
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setNavigationBarColor(getResources().getColor(R.color.custom_navigation_bar_color));
        }


        //-------  Splash Screen Start  ----------------
        Thread td = new Thread() {

            public void run() {
                try {
                    sleep(2500);
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    Intent intent = new Intent(Splash_Screen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        td.start();
        //-------  Splash Screen Ends  ----------------







    }
}