package com.vn.orderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ChitietMonanActivity extends AppCompatActivity {
    private ImageView iv_chitiet;
    private TextView lbl_Name;
    private TextView lbl_Cash;
    private int img;
    private String cap, cash;
    private ImageButton btn_chitiet_phanan_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_monan);
        Intent extras=getIntent();
        int img = extras.getIntExtra("img",0);
        String cap = extras.getStringExtra("cap");
        String cash =extras.getStringExtra("gia");
        iv_chitiet=findViewById(R.id.iv_chitiet);
        lbl_Name=findViewById(R.id.lbl_Name);
        lbl_Cash=findViewById(R.id.lbl_Cash);
        btn_chitiet_phanan_back=findViewById(R.id.btn_chitiet_phanan_back);
        iv_chitiet.setImageResource((int)img);
        lbl_Name.setText(String.valueOf(cap));
        lbl_Cash.setText(String.valueOf(cap));
        btn_chitiet_phanan_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChitietMonanActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}