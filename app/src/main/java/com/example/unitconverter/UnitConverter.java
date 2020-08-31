package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class UnitConverter extends AppCompatActivity {
    private Button convertButton;

    //variables for spinner
    Spinner convertFromUnitTypeSpinner;
    Spinner convertToUnitTypeSpinner;
    String[] unitTypes = {"centimeters","feet","inches","kilometers","meters","miles","millimeters","yards"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);
        convertFromUnitTypeSpinner = (Spinner)findViewById(R.id.convertFromUnitTypeSpinner);
        convertToUnitTypeSpinner = (Spinner)findViewById(R.id.convertToUnitTypeSpinner);
        ArrayAdapter<String> SpinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, unitTypes);
        SpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        convertFromUnitTypeSpinner.setAdapter(SpinnerAdapter);
        convertToUnitTypeSpinner.setAdapter(SpinnerAdapter);
        convertButton = (Button)findViewById(R.id.convertButton);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickConvertButton();
            }
        });
    }
    public void onClickConvertButton(){
        double beginning_qty;
        double ending_qty;
        String beginning_unit_type;
        String ending_unit_type;

        EditText enteredText = (EditText)findViewById(R.id.editTextNumber);
        TextView outputText = (TextView)findViewById(R.id.convertedValueTextView);

        // creating object of length conversion class
        Length_Conversion lengthconverter = new Length_Conversion();
        // checking if user has input some value or not
        if(!enteredText.getText().toString().equals("")){
            beginning_qty = Double.parseDouble(enteredText.getText().toString());
            beginning_unit_type = convertFromUnitTypeSpinner.getSelectedItem().toString();
            ending_unit_type = convertToUnitTypeSpinner.getSelectedItem().toString();

            //input the above data to object
            lengthconverter.setBeginning_qty(beginning_qty);
            lengthconverter.setBeginning_unit_type(beginning_unit_type);
            lengthconverter.setEnding_unit_type(ending_unit_type);

            //calculating the input
            ending_qty = lengthconverter.calculateResult();
            lengthconverter.setEnding_qty(ending_qty);
            outputText.setText(lengthconverter.toString());
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