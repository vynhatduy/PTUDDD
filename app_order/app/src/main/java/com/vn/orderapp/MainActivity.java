package com.vn.orderapp;

import static com.vn.orderapp.R.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.vn.orderapp.banner.BannerAdapter;

import java.util.ArrayList;
import java.util.List;

import item_home.Item_home;
import item_home.Item_home_Adapter;


public class MainActivity extends AppCompatActivity {
    private int currentIndex =0;
    private final Handler handler= new Handler();
    private LinearLayout lnTichDiem,ln_cart;
    private Button btnClose;
    private ImageButton btnMenu,btnSale,btnOrder,btnMore,btnShowAll,btnUser,btn_back_info;
    private EditText txtLocation;
    private TableRow tr_location;
    private int[] imgs = new int[]{drawable.com_chien_la_sen,drawable.goi_bon_bon_thit_tom,drawable.goi_cuon_thit_tom,drawable.ha_cao_xiu_mai,drawable.tom_coctail,drawable.ngheu_hap_thai,drawable.oc_dua_xao_bo,drawable.salad_pho_mai_xong_khoi,drawable.so_huyet_xao_me};
    private String[] caps=new String[]{"Cơm chiên lá sen","Gỏi bồn bồn tôm thịt","Gỏi cuốn tôm thịt, bánh phồng","Há cảo, xíu mại","Tôm coctail","Nghêu hấp thái","Ốc dừa xào bơ","Salad phô mai thịt xông khói"};
    private String[] gias= new String[]{"65000đ","120000đ","72000đ","45000đ","75000đ","40000đ","75000đ","99000đ"};

    private int[] mImg_banner=new int[]{drawable.com_chien_la_sen,drawable.goi_bon_bon_thit_tom,drawable.goi_cuon_thit_tom,drawable.ha_cao_xiu_mai,drawable.tom_coctail,drawable.ngheu_hap_thai,drawable.oc_dua_xao_bo,drawable.salad_pho_mai_xong_khoi,drawable.so_huyet_xao_me};



    RecyclerView rcv_Main;
    LinearLayoutManager linearLayoutManager;
    private ViewPager banner;
    public void initcontrol(){
        rcv_Main=findViewById(id.rcv_Main);
        lnTichDiem=findViewById(id.lnTichDiem);
        btnMenu=findViewById(id.btnMenu);
        btnSale=findViewById(id.btnSale);
        btnOrder=findViewById(id.btnOrder);
        btnMore=findViewById(id.btnMore);
        btnShowAll=findViewById(id.btnShowAll);
        btnUser=findViewById(id.btnUser);
        banner=findViewById(id.banner);
        ln_cart=findViewById(R.id.ln_cart);
        txtLocation=findViewById(R.id.txtLocation);
        tr_location=findViewById(R.id.tr_location);
        txtLocation.setKeyListener(null);
    }

    private Runnable mAuto= new Runnable() {
        @Override
        public void run() {
            int current =banner.getCurrentItem();
            int itemCount=banner.getAdapter().getCount();
            if(current<itemCount-1){
                banner.setCurrentItem(current+1);
            }else {
                banner.setCurrentItem(0);
            }
            handler.postDelayed(this,2000);
        }
    };

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
                ImageView ivQR = dialog.findViewById(R.id.ivQR);
                TextView txt_sdt = dialog.findViewById(id.lblSDT);
                String s = txt_sdt.getText().toString();
                QRCodeGenerator.generateQrCode(MainActivity.this,s,ivQR);

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
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        ln_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PayActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                intent.putExtra("code_payment",1);
                startActivity(intent);
            }
        });

        txtLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LocationActivity.class);
                intent.putExtra("code_payment",1);
                startActivity(intent);
            }
        });


        // animation chuyển hình ảnh banner
        BannerAdapter bannerAdapter = new BannerAdapter(this,mImg_banner);
        banner.setAdapter(bannerAdapter);
        handler.postDelayed(mAuto,2000);
        banner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                        // dừng khi người dùng vuốt
                        handler.removeCallbacks(mAuto);
                    case MotionEvent.ACTION_UP:
                        //tiếp tục thực hiện khi người dùng kết thúc vuốt
                        handler.postDelayed(mAuto,2000);
                        break;
                }
                return false;
            }
        });

    }

}
