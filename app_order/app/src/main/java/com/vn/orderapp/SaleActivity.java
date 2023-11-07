package com.vn.orderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.vn.orderapp.item_sale.Item_sale;
import com.vn.orderapp.item_sale.Item_sale_Adapter;

import java.util.ArrayList;

public class SaleActivity extends AppCompatActivity {
    private int[] img_sale = new int[]{R.drawable.img_item_sale, R.drawable.img_item_sale, R.drawable.img_item_sale, R.drawable.img_item_sale, R.drawable.img_item_sale, R.drawable.img_item_sale, R.drawable.img_item_sale};
    private String[] title_sale = new String[]{"Thứ 2 mua 1 tặng 1","Thứ 3 mua 1 tặng 2","Thứ 4 mua 2 tặng 3","Thứ 5 mua 3 tặng 4","Thứ 6 mua 1 tặng 1","Thứ 7 mua 2 tặng 1","Chủ nhật mua 1 tặng 2"};

    private String[] content_sale = new String[]{"Thứ 2 mua 1 tặng 1","Thứ 3 mua 1 tặng 2","Thứ 4 mua 2 tặng 3","Thứ 5 mua 3 tặng 4","Thứ 6 mua 1 tặng 1","Thứ 7 mua 2 tặng 1","Chủ nhật mua 1 tặng 2"};

    private String[] txt_button = new String[] {"Đặt ngay"};
    private ListView lv_Sale;

    private ImageButton btnHome,btnMenu,btnOrder,btnMore;
    private void initcontrol(){
        lv_Sale=findViewById(R.id.lv_Sale);
        btnHome=findViewById(R.id.btnHome);
        btnMenu=findViewById(R.id.btnMenu);
        btnOrder=findViewById(R.id.btnOrder);
        btnMore=findViewById(R.id.btnMore);

    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);
        initcontrol();

        ArrayList<Item_sale> itemSales = new ArrayList<>();
        for (int i = 0; i < title_sale.length; i++) {
            itemSales.add(new Item_sale(img_sale[i],title_sale[i],content_sale[i],txt_button[0]));
        }
        Item_sale_Adapter item_sale_adapter = new Item_sale_Adapter(itemSales, this, R.layout.item_sale);

        lv_Sale.setAdapter(item_sale_adapter);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaleActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaleActivity.this,MenuActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaleActivity.this,OrderActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaleActivity.this,MoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
    }
}
