package com.vn.orderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vn.orderapp.R.id;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private TextView lblForgot,lblNoAcc;
    private EditText txtUser,txtPass;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btnLogin= findViewById(R.id.btnLogin);
        lblNoAcc =findViewById(R.id.lblNoacc);
        lblForgot=findViewById(R.id.lblForgot);
        txtUser=findViewById(id.txtUser);
        txtPass=findViewById(id.txtPass);

        txtUser.getText().toString();
        txtPass.getText().toString();

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
        lblForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( LoginActivity.this,ForgotActivity.class);
                startActivity(intent);
            }
        });
        lblNoAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,LoginSignupActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
    }
}