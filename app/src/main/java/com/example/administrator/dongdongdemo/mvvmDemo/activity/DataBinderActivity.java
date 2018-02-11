package com.example.administrator.dongdongdemo.mvvmDemo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.dongdongdemo.BR;
import com.example.administrator.dongdongdemo.R;
import com.example.administrator.dongdongdemo.databinding.ActivityDataBinderBinding;
import com.example.administrator.dongdongdemo.mvvmDemo.activity.adapter.MvvmAdapter;
import com.example.administrator.dongdongdemo.mvvmDemo.activity.bean.ListBean;
import com.example.administrator.dongdongdemo.mvvmDemo.activity.bean.UserBean;

import java.util.ArrayList;
import java.util.List;


public class DataBinderActivity extends AppCompatActivity implements View.OnClickListener{

    private List<ListBean> mDatas = new ArrayList<>();
    private LinearLayoutManager manager;
    private MvvmAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBinderBinding binderBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binder);
        UserBean userBean = new UserBean();
        userBean.setName("绑定测试");
        binderBinding.setUser(userBean);
        binderBinding.setSt("dddddd");
        binderBinding.setImageUrls("https://www.baidu.com/img/bd_logo1.png");
        binderBinding.mBtn.setOnClickListener(this);

        for (int i = 0; i < 20; i++) {
            ListBean listbean = new ListBean();
            listbean.setAge(i);
            listbean.setName("dd"+i);
            listbean.setUrl("https://www.baidu.com/img/bd_logo1.png");
            mDatas.add(listbean);
        }

        manager = new LinearLayoutManager(this);

        RecyclerView recyclerView = binderBinding.rv;
        recyclerView.setLayoutManager(manager);

        adapter = new MvvmAdapter(this, BR.userList, mDatas, R.layout.adapter_mvvv);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mBtn:
                Toast.makeText(this, "afasgasfag", Toast.LENGTH_SHORT).show();
                mDatas.clear();
                for (int i = 0; i < 20; i++) {
                    ListBean listbean = new ListBean();
                    listbean.setAge(i+100);
                    listbean.setName("ddddddddd"+i);
                    listbean.setUrl("https://www.baidu.com/img/bd_logo1.png");
                    mDatas.add(listbean);
                }
                adapter.notifyDataSetChanged();
                break;
        }
    }
}
