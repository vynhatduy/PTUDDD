package com.vn.orderapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class EnterOTPActivity extends AppCompatActivity {
    private Button btn_send_otp;
    private ImageButton btn_back_otp;
    private TextView lblCoutdown;
    private void initcontrol(){
        btn_send_otp=findViewById(R.id.btn_send_otp);
        btn_back_otp=findViewById(R.id.btn_back_otp);
        lblCoutdown=findViewById(R.id.lblCountdown);
        lblCoutdown.setText("100 giây");


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        initcontrol();


        Intent intent = getIntent();
        int code_intent = intent.getIntExtra("code",0);

        CountDownTimer countDownTimer = new CountDownTimer(100000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                lblCoutdown.setText(String.format(Locale.getDefault(), "%d giây", millisUntilFinished / 1000L));
            }

            @Override
            public void onFinish() {
                lblCoutdown.setText("0 giây ");
            }
        }.start();
        btn_send_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (code_intent==2){
                    Intent intent = new Intent(EnterOTPActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(EnterOTPActivity.this, ChangePassActivity.class);
                    intent.putExtra("code", 1);
                    startActivity(intent);
                }
            }
        });

        btn_back_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (code_intent){
                    case 0:
                        Toast.makeText(EnterOTPActivity.this,"Lỗi",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Intent intent1 = new Intent(EnterOTPActivity.this,ForgotActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(EnterOTPActivity.this,LoginSignupActivity.class);
                        startActivity(intent2);
                        break;
                }
            }
        });
    }
}
