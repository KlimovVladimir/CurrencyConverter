package com.example.currencyconverter.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class Valutes {
    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("PreviousDate")
    @Expose
    private String previousDate;
    @SerializedName("PreviousURL")
    @Expose
    private String previousURL;
    @SerializedName("Timestamp")
    @Expose
    private String timestamp;
    @SerializedName("Valute")
    @Expose
    private Map<String,Message> valute;

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setPreviousDate(String previousDate) {
        this.previousDate = previousDate;
    }

    public String getPreviousDate() {
        return previousDate;
    }

    public void setPreviousURL(String previousURL) {
        this.previousURL = previousURL;
    }

    public String getPreviousURL() {
        return previousURL;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setValute(Map<String, Message> valute) {
        this.valute = valute;
    }

    public Map<String, Message> getValute() {
        return valute;
    }
}
