package com.example.weektest10.model;

import com.example.weektest10.bean.Data;
import com.example.weektest10.bean.NewsInfo;
import com.example.weektest10.util.NetUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;

public class RequestModel {

    /**
     * 获取新闻请求结果，调用网络工具类
     * @return
     */
    public static Data<NewsInfo> getNews(int page){
        String json = NetUtil.getInstance()
                .doGet("http://47.94.132.125/baweiapi/gank_android?page="+page+"&pageSize=5");
        if (json==null){
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Data<NewsInfo>>(){}.getType();
        Data<NewsInfo> data = gson.fromJson(json,type);
        return data;
    }
}
