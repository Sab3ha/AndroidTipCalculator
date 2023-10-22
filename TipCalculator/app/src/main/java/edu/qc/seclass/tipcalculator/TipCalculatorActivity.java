package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {
    private EditText checkAmountValue,partySizeValue,fifteenPercentTipValue,twentyPercentTipValue,
            twentyfivePercentTipValue,fifteenPercentTotalValue,twentyPercentTotalValue,
            twentyfivePercentTotalValue;
    private Button buttonCompute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setting the title on the Action Bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("TipCalculator");

        checkAmountValue = findViewById(R.id.checkAmountValue);
        partySizeValue = findViewById(R.id.partySizeValue);
        buttonCompute = findViewById(R.id.buttonCompute);
        fifteenPercentTipValue = findViewById(R.id.fifteenPercentTipValue);
        twentyPercentTipValue = findViewById(R.id.twentyPercentTipValue);
        twentyfivePercentTipValue = findViewById(R.id.twentyfivePercentTipValue);
        fifteenPercentTotalValue = findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTotalValue = findViewById(R.id.twentyPercentTotalValue);
        twentyfivePercentTotalValue = findViewById(R.id.twentyfivePercentTotalValue);
        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //user inputs
                String checkAmount = checkAmountValue.getText().toString();
                String partySize = partySizeValue.getText().toString();
                //toast
                if (checkAmount.matches("") || partySize.matches("") || Integer.parseInt(checkAmount)<=0|| Integer.parseInt(partySize)<=0) {
                    Toast.makeText(TipCalculatorActivity.this, "Empty or incorrect value(s)!", Toast.LENGTH_SHORT).show();
                }
                else{
                    //calculating the subtotal to be paid by each person before adding the tip
                    int subTotal = Integer.parseInt(checkAmount)/Integer.parseInt(partySize);
                    //calculating the tip according to percentage of the subtotal
                    int fifteenPercentTip = Math.round(subTotal*0.15f);
                    int twentyPercentTip = Math.round(subTotal*0.20f);
                    int twentyfivePercentTip = Math.round(subTotal*0.25f);
                    //calculating the total to be paid by each person after adding the tip
                    int fifteenPercentTotal = subTotal + fifteenPercentTip;
                    int twentyPercentTotal = subTotal + twentyPercentTip;
                    int twentyfivePercentTotal = subTotal + twentyfivePercentTip;
                    //changing the text to display the results of the calculated tips
                    fifteenPercentTipValue.setText(String.valueOf(fifteenPercentTip));
                    twentyPercentTipValue.setText(String.valueOf(twentyPercentTip));
                    twentyfivePercentTipValue.setText(String.valueOf(twentyfivePercentTip));
                    //changing the text to display the results of the calculated totals
                    fifteenPercentTotalValue.setText(String.valueOf(fifteenPercentTotal));
                    twentyPercentTotalValue.setText(String.valueOf(twentyPercentTotal));
                    twentyfivePercentTotalValue.setText(String.valueOf(twentyfivePercentTotal));
                }

            }
        });

        
    }
}