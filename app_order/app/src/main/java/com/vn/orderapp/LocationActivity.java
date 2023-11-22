package com.vn.orderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.vn.orderapp.item_location.Item_Adapter_Location;
import com.vn.orderapp.item_location.Item_Location;

import java.util.ArrayList;
import java.util.List;

public class LocationActivity extends AppCompatActivity {
    private ImageButton btn_back_location,btn_add_location;
    private String[] names=new String[]{"Duy","Lộc","Thùy Linh","Bảo Linh"};
    private String sdt = "123456789";
    private String[] locations = new String[]{"95 Lý Nam Đế, Phường 8, Đà Lạt, Lâm Đồng","265/13 Bùi Thị Xuân, P8, Thành phố"+"Đà Lạt, Lâm Đồng ","95 Lý Nam Đế, Phường 8, Đà Lạt, Lâm Đồng","265/13 Bùi Thị Xuân, P8, Thành phố \n" +
            "Đà Lạt, Lâm Đồng "};

    private ListView lv_location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        btn_add_location=findViewById(R.id.btn_add_location);
        btn_back_location=findViewById(R.id.btn_back_location);
        lv_location = findViewById(R.id.lv_location);

        Intent getExtra = getIntent();
        int code_payment=getExtra.getIntExtra("code_payment",0);

        List<Item_Location> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            list.add(new Item_Location(names[i],sdt,locations[i]));
        }
        Item_Adapter_Location adapter = new Item_Adapter_Location(list,R.layout.item_location);
        lv_location.setAdapter(adapter);
        lv_location.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (code_payment==3){
                    Intent intent = new Intent(LocationActivity.this,PayActivity.class);
                    intent.putExtra("code_payment",10);
                    String info = locations[position];
                    intent.putExtra("string_location",info);
                    startActivity(intent);
                }
            }
        });
        btn_back_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (code_payment==1){
                    Intent intent=new Intent(LocationActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else if (code_payment==2){
                    Intent intent=new Intent(LocationActivity.this, UserActivity.class);
                    startActivity(intent);
                }
                else if (code_payment==3){
                    Intent intent=new Intent(LocationActivity.this, PayActivity.class);
                    startActivity(intent);
                } else if (code_payment==4) {
                    Intent intent = new Intent(LocationActivity.this,InfoActivity.class);
                    startActivity(intent);
                }
            }
        });
        btn_add_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LocationActivity.this, NewLocationActivity.class);
                startActivity(intent);
            }
        });

    }
}