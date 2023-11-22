package com.vn.orderapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {
    private ImageButton btnMenu,btnSale,btnOrder,btnMore,btnBack,btn_cancel;
    private LinearLayout lnTichDiem;
    private TableRow tr_info,tr_change_pass,tr_Uu_Dai,tr_history,tr_location,tr_remove;
    private Button btnClose,btn_remove;
    private TextView lbl_info_more;
    public void initcontrol(){
        btnMenu=findViewById(R.id.btnMenu);
        btnSale=findViewById(R.id.btnSale);
        btnOrder=findViewById(R.id.btnOrder);
        btnMore=findViewById(R.id.btnMore);
        btnBack=findViewById(R.id.btn_back_user);
        lnTichDiem=findViewById(R.id.lnTichDiem);
        tr_info=findViewById(R.id.tr_info);
        tr_change_pass=findViewById(R.id.tr_change_pass);
        tr_Uu_Dai=findViewById(R.id.tr_Uu_Dai);
        tr_history=findViewById(R.id.tr_history);
        tr_location=findViewById(R.id.tr_location);
        tr_remove=findViewById(R.id.tr_remove);
        lbl_info_more=findViewById(R.id.lbl_info_more);
    }
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initcontrol();

        lbl_info_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, SaleActivity.class);
                startActivity(intent);
            }
        });

        tr_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });
        tr_change_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, ChangePassActivity.class);
                intent.putExtra("code", 2);
                startActivity(intent);
            }
        });
        tr_Uu_Dai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, SaleActivity.class);
                startActivity(intent);
            }
        });
        tr_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });
        tr_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, LocationActivity.class);
                intent.putExtra("code_payment",2);
                startActivity(intent);
            }
        });
        tr_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(UserActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_remove);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                btn_cancel=dialog.findViewById(R.id.btn_cancel);
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btn_remove=dialog.findViewById(R.id.btn_remove);
                btn_remove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(UserActivity.this,"Bạn đã xóa tài khoản không thành công",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
            }
        });


        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this,MenuActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        btnSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this,SaleActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this,OrderActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this,MoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        lnTichDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(UserActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_tichdiem);

                ImageView ivQR = dialog.findViewById(R.id.ivQR);
                TextView txt_sdt = dialog.findViewById(R.id.lblSDT);
                btnClose=dialog.findViewById(R.id.btnClose);
                String s = txt_sdt.getText().toString();

                QRCodeGenerator.generateQrCode(UserActivity.this,s,ivQR);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}
