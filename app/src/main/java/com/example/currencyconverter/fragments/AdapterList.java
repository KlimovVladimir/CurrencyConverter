package com.example.currencyconverter.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencyconverter.App;
import com.example.currencyconverter.MainActivity;
import com.example.currencyconverter.R;
import com.example.currencyconverter.json.Message;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Map;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ListViewHolder> {
    private Map<String,Message> items;


    public AdapterList(Map<String,Message> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.currency_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        int type = getItemViewType(position);
        int i = 0;
        Message currency = items.get("USD");
        for (Map.Entry<String,Message> entry : items.entrySet()) {
            if(i == position) {
                currency = entry.getValue();
                break;
            }
            i++;
        }
        String name = currency.getName();
        holder.currency_name.setText(name);

        Message finalCurrency = currency;
        holder.currency_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.getInstance().currencyTo = finalCurrency.getCharCode();
                App.getInstance().currency_selected = true;
                MainActivity.fTrans = MainActivity.getInstance().getSupportFragmentManager().beginTransaction();
                MainActivity.fTrans.replace(R.id.FrameLayoutMain, MainActivity.convertFragment);
                MainActivity.fTrans.addToBackStack(null);
                MainActivity.fTrans.commit();
            }
        });
        holder.currency_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.getInstance().currencyTo = finalCurrency.getCharCode();
                App.getInstance().currency_selected = true;
                MainActivity.fTrans = MainActivity.getInstance().getSupportFragmentManager().beginTransaction();
                MainActivity.fTrans.replace(R.id.FrameLayoutMain, MainActivity.convertFragment);
                MainActivity.fTrans.addToBackStack(null);
                MainActivity.fTrans.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {

        TextView currency_name;
        FrameLayout currency_back;

        public ListViewHolder(View itemView) {
            super(itemView);
            currency_name = itemView.findViewById(R.id.currency);
            currency_back = itemView.findViewById(R.id.currency_back);
        }
    }
}
