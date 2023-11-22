package com.vn.orderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class PayActivity extends AppCompatActivity {
    private ImageButton btn_back_pay,btn_pay_edit_location;
    private Button btn_payment;

    private EditText txt_pay_location;
    private void initcontrl(){
        btn_back_pay = findViewById(R.id.btn_back_pay);
        btn_payment=findViewById(R.id.btn_payment);
        btn_pay_edit_location=findViewById(R.id.btn_pay_edit_location);
        txt_pay_location=findViewById(R.id.txt_pay_location);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        initcontrl();

        Intent getExtra = getIntent();
        int code_payment = getExtra.getIntExtra("code_payment",0);
        String string_location = getExtra.getStringExtra("string_location");
        if (code_payment==10){
            txt_pay_location.setText(String.valueOf(string_location));
        }


        btn_back_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (code_payment==1){
                    Intent intent = new Intent(PayActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else if(code_payment==2){
                    Intent intent = new Intent(PayActivity.this,MenuActivity.class);
                    startActivity(intent);
                }
                else if(code_payment==3){
                    Intent intent = new Intent(PayActivity.this,SaleActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(PayActivity.this,"Lỗi thao tác",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PayActivity.this,"Thanh toán không thành công",Toast.LENGTH_SHORT).show();
            }
        });
        btn_pay_edit_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PayActivity.this,LocationActivity.class);
                intent.putExtra("code_payment",3);
                startActivity(intent);
            }
        });
    }
}