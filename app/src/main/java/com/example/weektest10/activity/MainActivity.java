package com.example.weektest10.activity;



import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.weektest10.R;
import com.example.weektest10.adapter.NewsAdapter;
import com.example.weektest10.bean.Data;
import com.example.weektest10.bean.NewsInfo;
import com.example.weektest10.core.BaseActivity;
import com.example.weektest10.core.DataCall;
import com.example.weektest10.presenter.NewsPresenter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class MainActivity extends BaseActivity implements DataCall<NewsInfo> {

    NewsPresenter presenter;
    private PullToRefreshListView listView;
    private int page = 1;
    private NewsAdapter adapter;

    @Override
    protected void destoryPresenter() {
        presenter.destory();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        presenter = new NewsPresenter(this);
        listView = findViewById(R.id.list);
        adapter = new NewsAdapter();
        listView.setAdapter(adapter);
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page = 1;
                presenter.request(page);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
                presenter.request(page);
            }
        });
        presenter.request(page);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void success(Data<NewsInfo> data) {
        listView.onRefreshComplete();
        if (data!=null){
            if (page==1){
                adapter.clear();
            }
            adapter.addAll(data.result);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void fail() {
        Toast.makeText(this,"请求失败",Toast.LENGTH_LONG).show();
    }
}
