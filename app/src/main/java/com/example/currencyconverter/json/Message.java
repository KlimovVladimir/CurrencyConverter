package com.example.currencyconverter.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {
    @SerializedName("ID")
    @Expose
    private String id;
    @SerializedName("NumCode")
    @Expose
    private String numCode;
    @SerializedName("CharCode")
    @Expose
    private String charCode;
    @SerializedName("Nominal")
    @Expose
    private Integer nominal;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Value")
    @Expose
    private double value;
    @SerializedName("Previous")
    @Expose
    private double previous;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setPrevious(double previous) {
        this.previous = previous;
    }

    public double getPrevious() {
        return previous;
    }
}
