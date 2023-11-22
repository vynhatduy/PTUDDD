package com.vn.orderapp;

import static com.vn.orderapp.R.id.btnBack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class ForgotActivity extends AppCompatActivity {
    Button btn_send_sdt;
    ImageButton btn_back_sdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdt);
        btn_send_sdt=findViewById(R.id.btn_send_sdt);
        btn_back_sdt=findViewById(R.id.btn_back_sdt);

        btn_send_sdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotActivity.this,EnterOTPActivity.class);
                intent.putExtra("code",1);
                startActivity(intent);
            }
        });

        btn_back_sdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}