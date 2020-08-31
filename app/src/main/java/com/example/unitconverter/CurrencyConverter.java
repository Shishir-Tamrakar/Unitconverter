package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CurrencyConverter extends AppCompatActivity {
    public Button convertButton;
    //variables for spinner
    Spinner convertFromSpinner;
    Spinner convertToSpinner;
    String[] currencyTypes = {"USD", "EUR", "NPR", "INR", "GBP"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);
        convertFromSpinner = (Spinner) findViewById(R.id.convertFromSpinner);
        convertToSpinner = (Spinner) findViewById(R.id.convertToSpinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, currencyTypes);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        convertFromSpinner.setAdapter(spinnerAdapter);
        convertToSpinner.setAdapter(spinnerAdapter);
        convertButton = (Button) findViewById(R.id.convertButton);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickConvertButton();
            }
        });
    }

    public void onClickConvertButton() {
        double beginning_qty;
        double ending_qty;
        String beginning_currency_type;
        String ending_currency_type;

        EditText enteredText = (EditText) findViewById(R.id.userInputText);
        EditText outputText = (EditText) findViewById(R.id.resultOutput);
        Currency_Conversion currencyConversion = new Currency_Conversion();
        if (!enteredText.getText().toString().equals("")) {
            beginning_qty = Double.parseDouble(enteredText.getText().toString());
            beginning_currency_type = convertFromSpinner.getSelectedItem().toString();
            ending_currency_type = convertToSpinner.getSelectedItem().toString();
            //entering the data through object
            currencyConversion.setBeginning_qty(beginning_qty);
            currencyConversion.setBeginning_currency_type(beginning_currency_type);
            currencyConversion.setEnding_currency_type(ending_currency_type);
            //calculating the endingqty
            ending_qty = currencyConversion.calculateResult();
            currencyConversion.setEnding_qty(ending_qty);
            outputText.setText(currencyConversion.toString());

        }
        else{
            Context context = getApplicationContext();
            CharSequence text = "Enter Quantity";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}