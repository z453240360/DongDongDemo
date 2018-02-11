package com.example.administrator.dongdongdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.dongdongdemo.mvvmDemo.activity.DataBinderActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mBtn_mvvm)
    Button mBtnMvvm;
    @BindView(R.id.mBtn_2)
    Button mBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.mBtn_mvvm, R.id.mBtn_2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBtn_mvvm:
                startActivity(DataBinderActivity.class);
                break;
            case R.id.mBtn_2:
                break;
        }
    }


    public void startActivity(Class t){
        startActivity(new Intent(this,t));
        overridePendingTransition(R.anim.screen_zoom_in, 0);
    }

}
