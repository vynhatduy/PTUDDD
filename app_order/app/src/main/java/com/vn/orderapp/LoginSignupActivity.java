package com.vn.orderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginSignupActivity extends AppCompatActivity {
    private Button btn_continute;
    private void initcontrol(){
        btn_continute=findViewById(R.id.btn_continute);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        initcontrol();


        btn_continute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginSignupActivity.this,EnterOTPActivity.class);
                intent.putExtra("code",2);
                startActivity(intent);
            }
        });
    }
}