package com.vn.orderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vn.orderapp.item_menu.Item_Adapter_MonNgonPhaiThu;
import com.vn.orderapp.item_menu.Item_MonNgonPhaiThu;
import com.vn.orderapp.item_menu.item_category;
import com.vn.orderapp.item_menu.item_menu_category;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private int[] imgs_title_menu = new int[]{R.drawable.ic_all, R.drawable.ic_fire, R.drawable.ic_sale, R.drawable.ic_new};
    private String[] caps_title_menu=new String[]{"Tất cả","Món ngon phải thử","Khuyến mãi","Món mới"};

    private int[] imgs = new int[]{R.drawable.com_chien_la_sen, R.drawable.goi_bon_bon_thit_tom, R.drawable.goi_cuon_thit_tom, R.drawable.ha_cao_xiu_mai, R.drawable.tom_coctail, R.drawable.ngheu_hap_thai, R.drawable.oc_dua_xao_bo, R.drawable.salad_pho_mai_xong_khoi, R.drawable.so_huyet_xao_me};
    private String[] caps=new String[]{"Cơm chiên lá sen","Gỏi bồn bồn tôm thịt","Gỏi cuốn tôm thịt, bánh phồng","Há cảo, xíu mại","Tôm coctail","Nghêu hấp thái","Ốc dừa xào bơ","Salad phô mai thịt xông khói"};
    private String[] gias= new String[]{"65000đ","120000đ","72000đ","45000đ","75000đ","40000đ","75000đ","99000đ"};
    RecyclerView rcv_Menu;
    private Item_Adapter_MonNgonPhaiThu item_AdapterMonNgonPhaiThu;
    private GridView gv_MonNgon;
    private ImageButton btnHome,btnSale,btnOrder,btnMore;
    private LinearLayout ln_cart;

    private void initcontrol(){
        rcv_Menu=findViewById(R.id.rcv_Menu);
        gv_MonNgon=findViewById(R.id.gv_MonNgonPhaiThu);
        btnHome=findViewById(R.id.btnHome);
        btnSale=findViewById(R.id.btnSale);
        btnOrder=findViewById(R.id.btnOrder);
        btnMore=findViewById(R.id.btnMore);
        ln_cart=findViewById(R.id.ln_cart);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initcontrol();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
         rcv_Menu.setLayoutManager(linearLayoutManager);

        List<item_category> list_category = new ArrayList<>();
        for (int i =0;i<caps_title_menu.length;i++){
            list_category.add(new item_category(imgs_title_menu[i],caps_title_menu[i]));
        }
        item_menu_category adapter_menu = new item_menu_category(list_category, new item_menu_category.OnItemClickListener() {
            @Override
            public void onItemClick(item_category item) {
                int img = item.getImg();
                String title = item.getTitle();
                Toast.makeText(MenuActivity.this,"Bạn chọn: "+img+" "+title,Toast.LENGTH_SHORT).show();
            }
        });
        rcv_Menu.setAdapter(adapter_menu);

        List<Item_MonNgonPhaiThu> item_monNgonPhaiThu= new ArrayList<>();
        for (int i=0;i<caps.length;i++){
            item_monNgonPhaiThu.add(new Item_MonNgonPhaiThu(imgs[i],caps[i],gias[i]));
        }
        item_AdapterMonNgonPhaiThu= new Item_Adapter_MonNgonPhaiThu(item_monNgonPhaiThu,this);
        gv_MonNgon.setAdapter(item_AdapterMonNgonPhaiThu);

        gv_MonNgon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int img = imgs[position];
                String cap = caps[position];
                String cash = gias[position];

                Intent intent = new Intent(MenuActivity.this,ChitietMonanActivity.class);
                intent.putExtra("img",img);
                intent.putExtra("cap",cap);
                intent.putExtra("gia",cash);
                startActivity(intent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        btnSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,SaleActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,OrderActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,MoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        ln_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,PayActivity.class);
                intent.putExtra("code_payment",2);
                startActivity(intent);
            }
        });
    }
}
