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
    FrameLayout frame1,frame2, frame3;
    Button btnSend1,btnSend2,btnSend3;
    ImageButton btnBack;
    EditText txtPass,txtPassAgain;
    TextView lblCountdown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        frame1 = findViewById(R.id.frame1);
        frame2 =findViewById(R.id.frame2);
        frame3=findViewById(R.id.frame3);

        txtPass=findViewById(R.id.txtPass);
        txtPassAgain=findViewById(R.id.txtPassAgain);
        lblCountdown = findViewById(R.id.lblCountdown);
        lblCountdown.setText("100 giây");

        btnSend1=findViewById(R.id.btnSend1);
        btnSend2=findViewById(R.id.btnSend2);
        btnSend3=findViewById(R.id.btnSend3);
        btnBack=findViewById(R.id.btnBack);

        btnSend1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frame1.setVisibility(View.GONE);
                frame2.setVisibility(View.VISIBLE);
                if (frame2.getVisibility()==View.VISIBLE){
                    CountDownTimer countDownTimer = new CountDownTimer(100000,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            lblCountdown.setText(String.format(Locale.getDefault(), "%d giây.", millisUntilFinished / 1000L));
                        }

                        @Override
                        public void onFinish() {
                            lblCountdown.setText("0 giây");
                        }
                    }.start();
                }
            }
        });
        btnSend2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frame2.setVisibility(View.GONE);
                frame3.setVisibility(View.VISIBLE);
            }
        });
        btnSend3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}