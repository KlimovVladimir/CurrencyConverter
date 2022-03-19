package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.SystemClock;

public class MainActivity extends AppCompatActivity {

    private static MainActivity instance;
    //public static ListFragment listFragment;
    //public static FilmFragment filmFragment;
    public static FragmentTransaction fTrans;

    public static MainActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_main);
        //listFragment = new ListFragment();
        //filmFragment = new FilmFragment();

        Runnable runnable = new Runnable() {
            public void run() {
                while (!App.getInstance().initFinish) {
                    SystemClock.sleep(100);}
                //fTrans = getSupportFragmentManager().beginTransaction();
                //fTrans.add(R.id.ListFragment, MainActivity.listFragment);
                //fTrans.commit();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}