package com.example.administrator.dongdongdemo.mvvmDemo.activity.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.dongdongdemo.mvvmDemo.activity.bean.ListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 筛选页面列表适配器
 * 显示首字母和包含的比赛信息
 */

public class MvvmAdapter extends RecyclerView.Adapter<MvvmAdapter.MyViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    //item 布局文件 id
    protected int mLayoutId;

    private List<ListBean> mDatas = new ArrayList<>();
    // mvvm绑定的viewModel引用
    private int mVariableId;

    public MvvmAdapter(Context context, int variableId, List<ListBean> datas, int mLayoutId) {
        this.mInflater = LayoutInflater.from(context);
        this.mDatas = datas;
        this.mLayoutId = mLayoutId;
        this.mVariableId = variableId;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),mLayoutId, parent, false);
        MyViewHolder holder = new MyViewHolder(binding.getRoot());
        holder.setBinding(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.getBinding().setVariable(mVariableId,mDatas.get(position));
        holder.getBinding().executePendingBindings();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public MyViewHolder(View itemView) {
            super(itemView);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }

        public void setBinding(ViewDataBinding binding) {
            this.binding = binding;
        }
    }


}
