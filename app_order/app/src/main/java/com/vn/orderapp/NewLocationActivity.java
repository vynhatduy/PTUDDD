package com.vn.orderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class NewLocationActivity extends AppCompatActivity {
    private ImageButton btn_back_new_location;
    private Button btn_finish;
    private Spinner spinner_tinh,spinner_huyen,spinner_xa;
   String[] tinh = new String[]{"Lâm Đồng"};
String[] huyen = new String[]{"Bảo Lộc","Đà Lạt","Đạ Huoai","Cát Tiên", "Lâm Hà", "Đức Trọng", "Di Linh", "Đơn Dương", "Đạ Tẻ", "Lạc Dương"};

    private void initcontrol(){
        btn_back_new_location = findViewById(R.id.btn_back_new_location);
        btn_finish=findViewById(R.id.btn_finish);
        spinner_tinh=findViewById(R.id.spinner_tinh);
        spinner_huyen=findViewById(R.id.spinner_huyen);
        spinner_xa=findViewById(R.id.spinner_xa);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_location);
        initcontrol();
        btn_back_new_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewLocationActivity.this,LocationActivity.class);
                startActivity(intent);
            }
        });
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewLocationActivity.this,LocationActivity.class);
                Toast.makeText(NewLocationActivity.this,"Bạn đã thêm thành công địa chỉ: ",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tinh);
        spinner_tinh.setAdapter(adapter);
        spinner_tinh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter adapterHuyen = new ArrayAdapter<>(NewLocationActivity.this, android.R.layout.simple_spinner_dropdown_item,huyen);
                spinner_huyen.setAdapter(adapterHuyen);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_huyen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectHuyen = spinner_huyen.getSelectedItem().toString();
                String[] xa;
                switch (selectHuyen){
                    case "Đà Lạt":
                        xa = new String[]{"Phường 1","Phường 2","Phường 3","Phường 4","Phường 5","Phường 6","Phường 7","Phường 8","Phường 9","Phường 10","Phường 12"};
                        break;
                    case "Bảo Lộc":
                        xa = new String[]{"Phường Lộc Phát","Phường Lộc Tiến","Phường Lộc Sơn"};
                        break;
                    case "Đức Trọng":
                        xa = new String[]{""};
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}