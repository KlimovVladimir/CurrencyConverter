package com.example.currencyconverter.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.currencyconverter.App;
import com.example.currencyconverter.MainActivity;
import com.example.currencyconverter.R;

public class FragmentConvert extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_convert, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        MainActivity.getInstance().setTitle("Конвертация валюты");

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        MainActivity.getInstance().editTextFrom = (EditText) getView().findViewById(R.id.text_editFrom);
        MainActivity.getInstance().editTextTo = (EditText) getView().findViewById(R.id.text_editTo);
        MainActivity.getInstance().editTextFrom.setText("RUB");
        if(App.getInstance().currency_selected)
            MainActivity.getInstance().editTextTo.setText(App.getInstance().currencyTo);

        MainActivity.getInstance().editTextTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fTrans = MainActivity.getInstance().getSupportFragmentManager().beginTransaction();
                MainActivity.fTrans.replace(R.id.FrameLayoutMain, MainActivity.listFragment);
                MainActivity.fTrans.addToBackStack(null);
                MainActivity.fTrans.commit();
            }
        });
    }

}