package com.example.currencyconverter.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencyconverter.App;
import com.example.currencyconverter.MainActivity;
import com.example.currencyconverter.R;

public class FragmentList extends Fragment {

    private RecyclerView recyclerView;
    public AdapterList adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        MainActivity.getInstance().setTitle("Выбор валюты");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setHasOptionsMenu(true);
        recyclerView = view.findViewById(R.id.RecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AdapterList(App.getInstance().valute);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                MainActivity.fTrans = MainActivity.getInstance().getSupportFragmentManager().beginTransaction();
                MainActivity.fTrans.replace(R.id.FrameLayoutMain, MainActivity.convertFragment);
                MainActivity.fTrans.addToBackStack(null);
                MainActivity.fTrans.commit();
        }
        return super.onOptionsItemSelected(item);
    }
}