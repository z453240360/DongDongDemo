package com.example.administrator.dongdongdemo.mvvmDemo.activity.utils;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2018/1/23.
 */

public class ImageLoadUtils {

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String urls) {
        Glide.with(imageView.getContext())
                .load(urls)
                .into(imageView);
    }

}
