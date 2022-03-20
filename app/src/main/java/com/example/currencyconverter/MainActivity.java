package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import com.example.currencyconverter.fragments.FragmentConvert;
import com.example.currencyconverter.fragments.FragmentList;
import com.example.currencyconverter.json.Message;

public class MainActivity extends AppCompatActivity {

    private static MainActivity instance;
    public static FragmentList listFragment;
    public static FragmentConvert convertFragment;
    public static FragmentTransaction fTrans;
    public EditText editTextFrom, editTextTo, editTextCountFrom, getEditTextCountTo;
    public Button updateButton;

    public static MainActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        listFragment = new FragmentList();
        convertFragment = new FragmentConvert();

        Runnable runnable = new Runnable() {
            public void run() {
                while (!App.getInstance().initFinish) {
                    SystemClock.sleep(100);}
                fTrans = getSupportFragmentManager().beginTransaction();
                fTrans.add(R.id.FrameLayoutMain, MainActivity.convertFragment);
                fTrans.commit();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}