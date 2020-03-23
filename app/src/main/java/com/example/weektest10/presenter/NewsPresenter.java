package com.example.weektest10.presenter;

import com.example.weektest10.bean.Data;
import com.example.weektest10.core.BasePresenter;
import com.example.weektest10.core.DataCall;
import com.example.weektest10.model.RequestModel;


public class NewsPresenter extends BasePresenter {
    public NewsPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Data getModel(Object...args) {
        return RequestModel.getNews((int)args[0]);
    }
}
