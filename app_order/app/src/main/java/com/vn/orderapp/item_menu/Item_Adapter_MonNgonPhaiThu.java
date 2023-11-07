package com.vn.orderapp.item_menu;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vn.orderapp.R;

import java.util.List;
import java.util.Locale;

public class Item_Adapter_MonNgonPhaiThu extends BaseAdapter {
    private List<Item_MonNgonPhaiThu> item;
    private LayoutInflater inflater;
    private Context context;

    public Item_Adapter_MonNgonPhaiThu(List<Item_MonNgonPhaiThu> item, Context context) {
        this.item = item;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_monngonphaithu, null);
        }

        ImageView img = view.findViewById(R.id.iv_MonNgonPhaiThu);
        TextView cap = view.findViewById(R.id.tv_cap_MonNgonPhaiThu);
        TextView cash = view.findViewById(R.id.tv_cash_MonNgonPhaiThu);

        Item_MonNgonPhaiThu items = item.get(position);

        img.setImageResource(items.getImg());
        cap.setText(items.getCap());
        cash.setText(items.getCash());
        return view;
    }
}