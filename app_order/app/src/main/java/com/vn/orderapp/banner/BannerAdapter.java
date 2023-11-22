package com.vn.orderapp.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.vn.orderapp.R;

public class BannerAdapter extends PagerAdapter {
    private Context mContext;
    private int[] mImg;

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_banner,container,false);
        ImageView imageView = view.findViewById(R.id.iv_banner);
        imageView.setImageResource(mImg[position]);
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public int getCount() {
        return mImg.length;
    }

    public BannerAdapter(Context mContext, int[] mImg) {
        this.mContext = mContext;
        this.mImg = mImg;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
