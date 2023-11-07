package com.vn.orderapp.item_menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;
import com.vn.orderapp.R;
import java.util.List;
public class item_menu_category extends RecyclerView.Adapter<item_menu_category.ItemViewHolder> {
    private List<item_category> item;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(item_category item);
    }
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView title;

        public ItemViewHolder(View view) {
            super(view);
            img  = view.findViewById(R.id.iv_categoryTitle);
            title = view.findViewById(R.id.lbl_categoryTitle);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(item.get(position));
                    }
                }
            });
        }
    }

    public item_menu_category(List<item_category> items, item_menu_category.OnItemClickListener listener) {
        this.item = items;
        this.listener = listener;
    }

    @Override
    public item_menu_category.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_catergory, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(item_menu_category.ItemViewHolder holder, int position) {
        item_category currentItem = item.get(position);
        holder.img.setImageResource(currentItem.getImg());
        holder.title.setText(currentItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}