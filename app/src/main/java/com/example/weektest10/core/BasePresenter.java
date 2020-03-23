package com.example.weektest10.core;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;

import com.example.weektest10.bean.Data;


public abstract class BasePresenter {

    private DataCall dataCall;
    public BasePresenter(DataCall dataCall){
        this.dataCall = dataCall;
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.obj==null){
                dataCall.fail();
            }else {
                dataCall.success((Data)msg.obj);
            }
        }
    };

    public void request(final Object...args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Data data = getModel(args);
                Message message = Message.obtain();
                message.obj = data;
                handler.sendMessage(message);
            }
        }).start();
    }

    protected abstract Data getModel(Object...args);

    public void destory(){
        dataCall = null;
    }
}
