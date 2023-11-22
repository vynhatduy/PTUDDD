package com.vn.orderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity {


    private String[] getDays() {
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = String.valueOf(i + 1);
        }
        return days;
    }

    private String[] getMonths() {
        String[] months = new String[12];
        for (int i = 0; i < 12; i++) {
            months[i] = String.valueOf(i + 1);
        }
        return months;
    }

    private String[] getYears() {
        String[] years = new String[61];
        for (int i = 0; i < 61; i++) {
            years[i] = String.valueOf(1970 + i);
        }
        return years;
    }

    private ImageButton btn_back_info,btn_info_next;
    private Button btn_info_save;
    private TextView txt_info_location;
    private Spinner sp_info_day,sp_info_month,sp_info_year;
    private RelativeLayout rl_location_manager;


    private void initcontrol(){
        btn_back_info = findViewById(R.id.btn_back_info);
        btn_info_save=findViewById(R.id.btn_info_save);
        txt_info_location=findViewById(R.id.txt_info_location);
        sp_info_day =findViewById(R.id.sp_info_day);
        sp_info_month=findViewById(R.id.sp_info_month);
        sp_info_year=findViewById(R.id.sp_info_year);
        txt_info_location.setKeyListener(null);
        rl_location_manager=findViewById(R.id.rl_location_manager);
        btn_info_next=findViewById(R.id.btn_info_next);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initcontrol();

        // add data for spinner

        ArrayAdapter<String> dayAdapter=new ArrayAdapter<>(InfoActivity.this, android.R.layout.simple_spinner_item,getDays());
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_info_day.setAdapter(dayAdapter);
        ArrayAdapter<String> monthAdapter=new ArrayAdapter<>(InfoActivity.this, android.R.layout.simple_spinner_item,getMonths());
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_info_month.setAdapter(monthAdapter);
        ArrayAdapter<String> yearAdapter=new ArrayAdapter<>(InfoActivity.this, android.R.layout.simple_spinner_item,getYears());
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_info_year.setAdapter(yearAdapter);

        btn_back_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn_info_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InfoActivity.this,"Lưu thay đổi không thành công",Toast.LENGTH_SHORT).show();
            }
        });
        rl_location_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this,LocationActivity.class);
                intent.putExtra("code_payment",4);
                startActivity(intent);
            }
        });
        txt_info_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this,LocationActivity.class);
                intent.putExtra("code_payment",4);
                startActivity(intent);
            }
        });
        btn_info_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this,LocationActivity.class);
                intent.putExtra("code_payment",4);
                startActivity(intent);
            }
        });
    }


}