package com.example.weektest10.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;



public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destoryPresenter();
    }

    protected abstract void destoryPresenter();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract int getLayoutId();

}
