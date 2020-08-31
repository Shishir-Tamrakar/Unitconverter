package com.example.unitconverter;

import java.text.NumberFormat;

public class Currency_Conversion {
    //declaring variables and taking 1 USD
    final double USD = 1;
    final double EUR = 0.85;
    final double NPR = 119.66;
    final double INR = 74.93;
    final double GBP = 0.76;
    //variables of input data
    private double beginning_qty;
    private double ending_qty;
    private String beginning_currency_type;
    private String ending_currency_type;

    //constructor
    public Currency_Conversion() {
        beginning_qty = 0;
        ending_qty = 0;
        beginning_currency_type = "";
        ending_currency_type = "";
    }

    public double getBeginning_qty() {

        return beginning_qty;
    }

    public void setBeginning_qty(double beginning_qty) {
        this.beginning_qty = beginning_qty;
    }

    public double getEnding_qty() {
        return ending_qty;
    }

    public void setEnding_qty(double ending_qty) {
        this.ending_qty = ending_qty;
    }

    public String getBeginning_currency_type() {
        return beginning_currency_type;
    }

    public void setBeginning_currency_type(String beginning_currency_type) {
        this.beginning_currency_type = beginning_currency_type;
    }

    public String getEnding_currency_type() {
        return ending_currency_type;
    }

    public void setEnding_currency_type(String ending_currency_type) {
        this.ending_currency_type = ending_currency_type;
    }

    public double getCurrencyTypeConstant(String currency_type){
        if(currency_type == "USD") {return USD;}
        if(currency_type == "EUR") {return EUR;}
        if(currency_type == "NPR") {return NPR;}
        if(currency_type == "INR") {return INR;}
        if(currency_type == "GBP") {return GBP;}
        return 0;
    }

    public double calculateResult(){
        double beginning_qty = getBeginning_qty();
        double ending_qty = getEnding_qty();
        double beginning_currency_type = getCurrencyTypeConstant(getBeginning_currency_type());
        double ending_currency_type = getCurrencyTypeConstant(getEnding_currency_type());
        //converting
        ending_qty = USD/beginning_currency_type;
        ending_qty = ending_qty * ending_currency_type;
        ending_qty = ending_qty * beginning_qty;
        return ending_qty;
    }
    public String toString(){
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        return numberFormat.format(getEnding_qty()) + " "  + getEnding_currency_type();
    }
}
