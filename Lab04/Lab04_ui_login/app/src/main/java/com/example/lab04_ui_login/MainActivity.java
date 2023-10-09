package com.example.lab04_ui_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
    }
    public void initControl(){
        EditText txtEmail,txtPassword;
        Button btnLogin;
        txtEmail=findViewById(R.id.txtEmail);
        txtPassword=findViewById(R.id.txtPassword);
        btnLogin=findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = String.format("Bạn đã đăng nhập thành công với email: "+ txtEmail.getText().toString() +" và mật khẩu: "+txtPassword.getText().toString());
                Toast.makeText(getApplicationContext(),txt,Toast.LENGTH_LONG).show();
                
            }
        });
    }
}