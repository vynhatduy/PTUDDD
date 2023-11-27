package com.vn.orderapp.item_menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.vn.orderapp.R;

import java.util.List;

public class item_adapter_selected_order extends BaseAdapter {
    List<item_selected_order> list;
    Context context;

    public item_adapter_selected_order(List<item_selected_order> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_selected_order, parent, false);
        }
        item_selected_order item =(item_selected_order) getItem(position);
        TextView lbl_title_item_selected_order= convertView.findViewById(R.id.lbl_title_item_selected_order);
        TextView lbl_note_item_selected_order=convertView.findViewById(R.id.lbl_note_item_selected_order);
        TextView lbl_cash_item_selected_order=convertView.findViewById(R.id.lbl_cash_item_selected_order);
        TextView lbl_num=convertView.findViewById(R.id.lbl_num);
        Button btn_add=convertView.findViewById(R.id.btn_add);
        Button btn_sub=convertView.findViewById(R.id.btn_sub);

        lbl_title_item_selected_order.setText(String.valueOf(item.getTitle()));
        lbl_note_item_selected_order.setText(String.valueOf(item.getNote()));
        lbl_cash_item_selected_order.setText(String.valueOf(item.getCash()));
        lbl_num.setText(String.valueOf(item.getNum()));
        btn_sub.setOnClickListener(v -> {
            if (Integer.valueOf(lbl_num.getText().toString())<=1){
                lbl_num.setText(String.valueOf(1));
                int cash = Integer.valueOf(lbl_cash_item_selected_order.getText().toString());
                int num=1;
                cash=cash*num;
                lbl_num.setText(String.valueOf(num));
                lbl_cash_item_selected_order.setText(String.valueOf(cash));
            }
            lbl_num.setText(String.valueOf(1));
            int cash = Integer.valueOf(lbl_cash_item_selected_order.getText().toString());
            int num =Integer.valueOf(lbl_num.getText().toString());
            num-=num;
            cash=cash*num;
            lbl_num.setText(String.valueOf(num));
            lbl_cash_item_selected_order.setText(String.valueOf(cash));
        });
        btn_add.setOnClickListener(v -> {
            lbl_num.setText(String.valueOf(1));
            int cash = Integer.valueOf(lbl_cash_item_selected_order.getText().toString());
            int num =Integer.valueOf(lbl_num.getText().toString());
            num+=num;
            cash=cash*num;
            lbl_num.setText(String.valueOf(num));
            lbl_cash_item_selected_order.setText(String.valueOf(cash));
        });

        return convertView;
    }
}
