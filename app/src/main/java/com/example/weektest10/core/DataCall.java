package com.example.weektest10.core;

import com.example.weektest10.bean.Data;


public interface DataCall<T> {
    public void success(Data<T> data);
    public void fail();
}
