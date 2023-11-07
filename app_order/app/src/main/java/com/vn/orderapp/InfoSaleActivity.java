package com.vn.orderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoSaleActivity extends AppCompatActivity {
    private ImageView img;
    private TextView title,content,dieukien;
    private Button btn_add;
    private ImageButton btn_Back;
    private int iv_img;
    private String tv_title,tv_content,tv_dieukien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_sale);
        img =findViewById(R.id.iv_info_sale);
        title=findViewById(R.id.tv_title_info_sale);
        content=findViewById(R.id.tv_content_info_sale);
        dieukien=findViewById(R.id.tv_dieukien_info_sale);
        btn_add=findViewById(R.id.btn_add_order);
        btn_Back=findViewById(R.id.btn_back_info_sale);


        Intent intent= getIntent();
        iv_img=intent.getIntExtra("img",0);
        tv_title=intent.getStringExtra("title");
        tv_content=intent.getStringExtra("content");


        img.setImageResource((int)iv_img);
        title.setText(String.valueOf(tv_title));
        content.setText(String.valueOf(tv_content));
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(InfoSaleActivity.this,MenuActivity.class);
                startActivity(intent1);
            }
        });
        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoSaleActivity.this,SaleActivity.class);
                startActivity(intent);
            }
        });
    }
}