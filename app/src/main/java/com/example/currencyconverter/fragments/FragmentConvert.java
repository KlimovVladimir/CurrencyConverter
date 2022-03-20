package com.example.currencyconverter.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.currencyconverter.App;
import com.example.currencyconverter.MainActivity;
import com.example.currencyconverter.R;
import com.example.currencyconverter.json.Message;

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
        MainActivity.getInstance().editTextCountFrom = (EditText) getView().findViewById(R.id.text_editCountFrom);
        MainActivity.getInstance().getEditTextCountTo = (EditText) getView().findViewById(R.id.text_editCountTo);
        MainActivity.getInstance().updateButton = (Button) getView().findViewById(R.id.button);
        MainActivity.getInstance().editTextFrom.setText("RUB");

        MainActivity.getInstance().editTextTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fTrans = MainActivity.getInstance().getSupportFragmentManager().beginTransaction();
                MainActivity.fTrans.replace(R.id.FrameLayoutMain, MainActivity.listFragment);
                MainActivity.fTrans.addToBackStack(null);
                MainActivity.fTrans.commit();
            }
        });
        MainActivity.getInstance().editTextCountFrom.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(App.getInstance().currency_selected && MainActivity.getInstance().editTextCountFrom.getText().length() > 0) {
                    Double countRub = Double.parseDouble(MainActivity.getInstance().editTextCountFrom.getText().toString());
                    Message selectedValute = App.getInstance().valute.get(App.getInstance().currencyTo);
                    countRub *= selectedValute.getNominal();
                    countRub /= selectedValute.getValue();
                    countRub = Math.round(countRub*100.0)/100.0;
                    MainActivity.getInstance().getEditTextCountTo.setText(Double.toString(countRub));
                }
            }
        });

        MainActivity.getInstance().updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.getInstance().updateFlagCurrency = true;
            }
        });
    }

    @Override
    public void onResume() {
        MainActivity.getInstance().editTextTo.setText(App.getInstance().currencyTo);
        if(MainActivity.getInstance().editTextCountFrom.getText().length() > 0) {
            Double countRub = Double.parseDouble(MainActivity.getInstance().editTextCountFrom.getText().toString());
            Message selectedValute = App.getInstance().valute.get(App.getInstance().currencyTo);
            countRub *= selectedValute.getNominal();
            countRub /= selectedValute.getValue();
            countRub = Math.round(countRub*100.0)/100.0;
            MainActivity.getInstance().getEditTextCountTo.setText(Double.toString(countRub));
        }
        super.onResume();
    }

}