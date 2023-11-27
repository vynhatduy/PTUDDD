package com.vn.orderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.vn.orderapp.item_sale.Item_sale;
import com.vn.orderapp.item_sale.Item_sale_Adapter;

import java.util.ArrayList;

public class SaleActivity extends AppCompatActivity {
    private int[] img_sale = new int[]{R.drawable.img_item_sale, R.drawable.img_item_sale, R.drawable.img_item_sale, R.drawable.img_item_sale, R.drawable.img_item_sale, R.drawable.img_item_sale, R.drawable.img_item_sale};
    private String[] title_sale = new String[]{"Khám phá ẩm thực với voucher giảm 20%","Voucher mừng ngày Phụ nữ Quốc tế","Voucher giảm giá mùa hè","Voucher giảm giá cuối tuần","Voucher giảm giá sinh nhật","Voucher giảm giá cho người mới"};

    private String[] content_sale = new String[]{"Sử dụng mã ‘FOODIE20’ để nhận ưu đãi giảm 20% cho đơn hàng đầu tiên của bạn","Chúc mừng ngày Phụ nữ Quốc tế! Nhập mã ‘WOMENSDAY’ để nhận ưu đãi giảm 30% cho tất cả các món ăn","Mùa hè đã đến! Nhập mã ‘SUMMERFUN’ để nhận ưu đãi giảm 15% cho tất cả các món ăn","Cuối tuần thật vui với ưu đãi giảm 10% cho tất cả các món ăn. Sử dụng mã 'WEEKEND10'","Chúc mừng sinh nhật! Nhập mã ‘BIRTHDAY’ để nhận ưu đãi giảm 25% cho đơn hàng của bạn","Chào mừng bạn đến với ứng dụng của chúng tôi! Nhập mã ‘NEWUSER’ để nhận ưu đãi giảm 20% cho đơn hàng đầu tiên"};

    private String[] txt_button = new String[] {"Đặt ngay"};
    private ListView lv_Sale;
    private LinearLayout ln_cart;

    private ImageButton btnHome,btnMenu,btnOrder,btnMore;
    private void initcontrol(){
        lv_Sale=findViewById(R.id.lv_Sale);
        btnHome=findViewById(R.id.btnHome);
        btnMenu=findViewById(R.id.btnMenu);
        btnOrder=findViewById(R.id.btnOrder);
        btnMore=findViewById(R.id.btnMore);
        ln_cart=findViewById(R.id.ln_cart);
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
        ln_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaleActivity.this,PayActivity.class);
                intent.putExtra("code_payment",3);
                startActivity(intent);
            }
        });
    }
}
