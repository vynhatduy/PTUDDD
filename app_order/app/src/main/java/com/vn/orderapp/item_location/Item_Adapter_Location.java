package com.vn.orderapp.item_location;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vn.orderapp.R;
import com.vn.orderapp.item_sale.Item_sale;

import java.util.List;

public class Item_Adapter_Location extends BaseAdapter {
    private List<Item_Location> list;
    ///private Context mContext;
    private  int resource;

    public Item_Adapter_Location(List<Item_Location> list /*, Context mContext*/, int resource) {
        this.list = list;
        //this.mContext = mContext;
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= View.inflate(parent.getContext(),R.layout.item_location,null);
        TextView name = view.findViewById(R.id.lbl_name_location);
        TextView sdt = view.findViewById(R.id.lbl_sdt_location);
        TextView location = view.findViewById(R.id.lbl_info_location);
        //LinearLayout linearLayout = view.findViewById(R.id.ln_item);

        Item_Location item = list.get(position);
        name.setText(item.getName());
        sdt.setText(item.getSdt());
        location.setText(item.getInfo());
        //linearLayout.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {
                //Toast.makeText(mContext,item.getName()+" "+item.getSdt()+" "+item.getInfo()+ "",Toast.LENGTH_SHORT).show();
            //}
       // });
        return view;
    }
}
