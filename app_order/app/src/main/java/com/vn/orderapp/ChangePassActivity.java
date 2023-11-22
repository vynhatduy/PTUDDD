package com.vn.orderapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChangePassActivity extends AppCompatActivity {
    private ImageButton btn_back,btn_show_1,btn_show_2,btn_show_3;
    private EditText txtCurrentPass,txtNewPass,txt_NewPassAgain;
    private Button btn_sen_pass;

    private  void initcontrol(){
        btn_back=findViewById(R.id.btn_back_change_pass);
        btn_show_1=findViewById(R.id.btn_show_1);
        btn_show_2=findViewById(R.id.btn_show_2);
        btn_show_3=findViewById(R.id.btn_show_3);
        txtCurrentPass=findViewById(R.id.txtCurrentPass);
        txtNewPass=findViewById(R.id.txtNewPass);
        txt_NewPassAgain=findViewById(R.id.txt_NewPassAgain);
        btn_sen_pass =findViewById(R.id.btn_sen_pass);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
        initcontrol();

        Intent intent = getIntent();
        int code_intent =intent.getIntExtra("code",0);

        btn_show_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_show_1.setBackgroundResource(R.drawable.ic_show);
                txtCurrentPass.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                txt_NewPassAgain.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                txtNewPass.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });
        btn_show_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_show_2.setBackgroundResource(R.drawable.ic_show);
                txtCurrentPass.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                txt_NewPassAgain.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                txtNewPass.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });
        btn_show_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_show_3.setBackgroundResource(R.drawable.ic_show);
                txtCurrentPass.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                txt_NewPassAgain.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                txtNewPass.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (code_intent){
                    case 0:
                        Toast.makeText(ChangePassActivity.this,"Không có dữ liệu nào được intent qua",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                       Intent intent1 = new Intent(ChangePassActivity.this,EnterOTPActivity.class);
                       intent1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent1);
                        finish();
                        break;
                    case 2:
                        Intent intent2 = new Intent(ChangePassActivity.this,UserActivity.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent2);
                        finish();
                        break;
                }
            }
        });
        btn_sen_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (code_intent==1){
                    Intent intent1 = new Intent(ChangePassActivity.this,LoginActivity.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent1);
                    finish();
                }
                else if(code_intent==2){
                    Intent intent1 = new Intent(ChangePassActivity.this,UserActivity.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    Toast.makeText(ChangePassActivity.this,"Đổi mật khẩu không thành công",Toast.LENGTH_SHORT).show();
                    startActivity(intent1);
                    finish();
                }
            }
        });
    }


}
