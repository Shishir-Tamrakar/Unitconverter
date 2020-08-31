package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.unitbutton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openUnitConverterActivity();
            }
        });
        button2 = (Button)findViewById(R.id.currencybutton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCurrencyConverterActivity();
            }
        });
    }
    public void openUnitConverterActivity(){
        Intent intent = new Intent(this, UnitConverter.class);
        startActivity(intent);
    }

    public void openCurrencyConverterActivity(){
        Intent intent = new Intent(this, CurrencyConverter.class);
        startActivity(intent);
    }
}