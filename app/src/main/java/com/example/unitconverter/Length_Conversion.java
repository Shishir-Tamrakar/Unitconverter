package com.example.unitconverter;

import java.text.NumberFormat;

public class Length_Conversion {
    final double centimeters = 100;
    final double meters = 1;
    final double kilometers = 0.001;
    final double inches = 39.37;
    final double feet = 3.281;
    final double miles = 0.0006214;
    final double millimeters = 1000;
    final double yards = 1.093613;
    //variables for input data
    private double beginning_qty;
    private double ending_qty;
    private String beginning_unit_type;
    private String ending_unit_type;
    //constructor
    public Length_Conversion() {
        beginning_qty = 0;
        ending_qty = 0;
        beginning_unit_type = "";
        ending_unit_type = "";
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

    public String getBeginning_unit_type() {
        return beginning_unit_type;
    }

    public void setBeginning_unit_type(String beginning_unit_type) {
        this.beginning_unit_type = beginning_unit_type;
    }

    public String getEnding_unit_type() {
        return ending_unit_type;
    }

    public void setEnding_unit_type(String ending_unit_type) {
        this.ending_unit_type = ending_unit_type;
    }

    public double getUnitTypeConstant(String unit_type){
        if(unit_type == "meters") {return meters;}
        if(unit_type == "centimeters") {return centimeters;}
        if(unit_type == "kilometers") {return kilometers;}
        if(unit_type == "inches") {return inches;}
        if(unit_type == "feet") {return feet;}
        if(unit_type == "miles") {return miles;}
        if(unit_type == "millimeters") {return millimeters;}
        if(unit_type == "yards") {return yards;}
        return 0;
    }
    public double calculateResult(){
        double beginning_qty = getBeginning_qty();
        double ending_qty = getEnding_qty();
        double beginning_unit_type = getUnitTypeConstant(getBeginning_unit_type());
        double ending_unit_type = getUnitTypeConstant(getEnding_unit_type());
        //convert to meters
        ending_qty = meters/beginning_unit_type;
        ending_qty = ending_qty * ending_unit_type;
        ending_qty = ending_qty * beginning_qty;
        return ending_qty;
    }
    public String toString(){
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        return numberFormat.format(getEnding_qty()) + " "  + getEnding_unit_type();
    }
}
