package com.doidodai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String[] units ={
            "Hải Lý","Dặm","Kilometer","Lý","Met","Yard","Foot","Inches"
    };
    private double[][] ratio ={
            {1.00000000,1.15077945,1.8520000,20.2537183,1852.0000,2025.37183,6076.11549,72913.38583},
            {0.86897624,1.00000000,1.6093440,17.6000000,1609.3440,1760.00000,5280.00000,63360.00000},
            {0.53995680,0.62137119,1.0000000,10.9361330,1000.0000,1093.61330,3280.83990,39370.07874},
            {0.04937365,0.05681818,0.0914400,1.00000000,91.440000,100.000000,300.000000,3600.000000},
            {0.00053996,0.00062137,0.0010000,0.01093610,1.0000000,1.09361000,3.28084000,39.37008000},
            {0.00049374,0.00056818,0.0009144,0.01000000,0.9144000,1.00000000,3.00000000,36.00000000},
            {0.00016458,0.00018939,0.0003048,0.00333330,0.3048000,0.33333000,1.00000000,12.00000000},
            {0.00001371,0.00001578,0.0000254,0.00002778,0.02540000,0.0277800,0.08333000,1.00000000},
    };
    private EditText txtNumber;
    private Spinner spnUnits;
    private TextView[] lblResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNumber=findViewById(R.id.txtNum);
        spnUnits=findViewById(R.id.spnUnit);
        lblResults= new  TextView[]{
                findViewById(R.id.lblDam),
                findViewById(R.id.lblFoot),
                findViewById(R.id.lblHaily),
                findViewById(R.id.lblInches),
                findViewById(R.id.lblKm),
                findViewById(R.id.lblLy),
                findViewById(R.id.lblMet),
                findViewById(R.id.lblYard)
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item,units
        );
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spnUnits.setAdapter(adapter);
        spnUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                changeUnit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        txtNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                changeUnit();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    private void changeUnit(){
        int rowId = spnUnits.getSelectedItemPosition();
        if(rowId<0) rowId=0;
        String input =txtNumber.getText().toString();
        if(input.isEmpty()) input="0";
        double number = Double.valueOf(input);

        for(int i=0;i<lblResults.length;i++){
            double temp = number*ratio[rowId][i];
            lblResults[i].setText(String.valueOf(temp));
        }
    }
}