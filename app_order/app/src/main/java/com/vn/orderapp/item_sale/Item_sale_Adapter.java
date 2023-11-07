package com.vn.orderapp.item_sale;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.vn.orderapp.InfoSaleActivity;
import com.vn.orderapp.MainActivity;
import com.vn.orderapp.R;

import java.util.ArrayList;

public class Item_sale_Adapter extends BaseAdapter {
    private ArrayList<Item_sale> list;
    private Context  mContext;
    private  int resource;

    public Item_sale_Adapter(ArrayList<Item_sale> list, Context mContext, int resource) {
        this.list = list;
        this.mContext = mContext;
        this.resource = resource;
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView =inflater.inflate(resource,parent,false);
        }
        View view= convertView;
        ImageView img = view.findViewById(R.id.iv_item_sale);
        TextView title = view.findViewById(R.id.tv_title_sale);
        TextView content = view.findViewById(R.id.tv_content_sale);
        Button btn = view.findViewById(R.id.btn_item_sale);

        Item_sale itemSale = list.get(position);
        img.setImageResource(itemSale.getImg());
        title.setText(itemSale.getTitle());
        content.setText(itemSale.getContent());
        btn.setText(itemSale.getText_btn());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, InfoSaleActivity.class);
                intent.putExtra("img",itemSale.getImg());
                intent.putExtra("title",itemSale.getTitle());
                intent.putExtra("content",itemSale.getContent());
                mContext.startActivity(intent);
            }
        });
        return view;
    }
}
