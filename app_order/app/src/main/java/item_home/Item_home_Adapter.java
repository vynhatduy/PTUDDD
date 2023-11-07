package item_home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.vn.orderapp.R;

import java.util.List;

public class Item_home_Adapter extends RecyclerView.Adapter<Item_home_Adapter.ItemViewHolder> {
    private List<Item_home> items;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Item_home item);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView titleView;
        public TextView contentView;

        public ItemViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.img_item);
            titleView = view.findViewById(R.id.lblCaptionItem);
            contentView = view.findViewById(R.id.lblGia);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(items.get(position));
                    }
                }
            });
        }
    }

    public Item_home_Adapter(List<Item_home> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item_home currentItem = items.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.titleView.setText(currentItem.getTitle());
        holder.contentView.setText(currentItem.getContent());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}