package com.vn.orderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.vn.orderapp.item_menu.item_adapter_selected_order;
import com.vn.orderapp.item_menu.item_selected_order;

import java.util.ArrayList;
import java.util.List;

public class PayActivity extends AppCompatActivity {
    private ImageButton btn_back_pay,btn_pay_edit_location;
    private Button btn_payment,btn_add,btn_sub;
    private TextView lbl_cash_item_selected_order,lbl_num;
    private ListView lv_pay;
    String[] title,note;
    int cash,num;

    private EditText txt_pay_location;
    private void initcontrol(){
        btn_back_pay = findViewById(R.id.btn_back_pay);
        btn_payment=findViewById(R.id.btn_payment);
        btn_pay_edit_location=findViewById(R.id.btn_pay_edit_location);
        txt_pay_location=findViewById(R.id.txt_pay_location);
        lv_pay=findViewById(R.id.lv_pay);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        initcontrol();

        Intent getExtra = getIntent();
        int code_payment = getExtra.getIntExtra("code_payment",0);
        String string_location = getExtra.getStringExtra("string_location");
        if (code_payment==10){
            txt_pay_location.setText(String.valueOf(string_location));
        }

        List<item_selected_order> list = new ArrayList<>();
        list.add(new item_selected_order("Cơm chiên lá sen","Cơm chiên lá sen thêm nhiều hạt sen",1,65000));
        item_adapter_selected_order adapter = new item_adapter_selected_order(list,this);
        lv_pay.setAdapter(adapter);
        btn_back_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (code_payment==1){
                    Intent intent = new Intent(PayActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else if(code_payment==2){
                    Intent intent = new Intent(PayActivity.this,MenuActivity.class);
                    startActivity(intent);
                }
                else if(code_payment==3){
                    Intent intent = new Intent(PayActivity.this,SaleActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(PayActivity.this,"Lỗi thao tác",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PayActivity.this,"Thanh toán không thành công",Toast.LENGTH_SHORT).show();
            }
        });
        btn_pay_edit_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PayActivity.this,LocationActivity.class);
                intent.putExtra("code_payment",3);
                startActivity(intent);
            }
        });
    }
}