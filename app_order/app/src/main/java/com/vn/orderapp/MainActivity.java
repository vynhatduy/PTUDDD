package com.vn.orderapp;

import static com.vn.orderapp.R.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.vn.orderapp.item_menu.Item_Adapter_MonNgonPhaiThu;
import com.vn.orderapp.item_menu.Item_MonNgonPhaiThu;
import com.vn.orderapp.item_sale.Item_sale_Adapter;
import com.vn.orderapp.item_menu.item_category;
import com.vn.orderapp.item_menu.item_menu_category;
import com.vn.orderapp.item_sale.Item_sale;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import item_home.Item_home;
import item_home.Item_home_Adapter;


public class MainActivity extends AppCompatActivity {
    private ImageView ivBanner;
    private TableRow tr_change_pass;
    private final int[] imgBanner = {drawable.img_banner1,drawable.img_banner2,drawable.img_banner3,drawable.img_banner4};
    private int currentIndex =0;
    private final Handler handler= new Handler();
    private LinearLayout lnTichDiem;
    private Button btnClose;
    private ImageButton btnMenu,btnSale,btnOrder,btnMore,btnShowAll,btnUser,btn_back_info;
    private EditText txtLocation;
    private int[] imgs = new int[]{R.drawable.item_1,R.drawable.item_1,R.drawable.item_1,R.drawable.item_1,R.drawable.item_1,R.drawable.item_1};
    private String[] caps=new String[]{"Bánh canh cá lóc","Bánh canh thập cẩm","Bánh canh chả cá cá lóc","Bánh canh cá lóc","Bánh canh chả cá","Bánh canh cá lóc"};
    private String[] gias= new String[]{"50000đ","50000đ","50000đ","50000đ","50000đ","50000đ"};



    RecyclerView rcv_Main;
    LinearLayoutManager linearLayoutManager;
    public void initcontrol(){
        rcv_Main=findViewById(id.rcv_Main);
        lnTichDiem=findViewById(id.lnTichDiem);
        ivBanner=findViewById(id.ivBanner);
        btnMenu=findViewById(id.btnMenu);
        btnSale=findViewById(id.btnSale);
        btnOrder=findViewById(id.btnOrder);
        btnMore=findViewById(id.btnMore);
        btnShowAll=findViewById(id.btnShowAll);
        btnUser=findViewById(id.btnUser);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        initcontrol();


        linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rcv_Main.setLayoutManager(linearLayoutManager);
        List<Item_home> list= new ArrayList<>();
        for (int i = 0; i < caps.length; i++) {
            list.add(new Item_home(imgs[i],caps[i],gias[i]));
        }
        Item_home_Adapter adapter = new Item_home_Adapter(list, new Item_home_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(Item_home item) {
                int img = item.getImageResource();
                String cap = item.getTitle();
                String gia = item.getContent();
                Intent intent = new Intent(MainActivity.this,ChitietMonanActivity.class);
                intent.putExtra("img",img);
                intent.putExtra("cap",cap);
                intent.putExtra("gia",gia);
                startActivity(intent);
            }
        });
        rcv_Main.setAdapter(adapter);


        lnTichDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(layout.dialog_tichdiem);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                btnClose=dialog.findViewById(id.btnClose);
                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });


        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        btnSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SaleActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,InfoActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });


        // animation chuyển hình ảnh banner
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(()->{
                    ivBanner.setImageResource(imgBanner[currentIndex]);
                    currentIndex=(currentIndex+1)%imgBanner.length;
                    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), anim.anim_banner);
                    ivBanner.startAnimation(animation);
                });
            }
        },0,3000);

    }

}
