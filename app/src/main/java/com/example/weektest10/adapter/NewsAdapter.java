package com.example.weektest10.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.weektest10.R;
import com.example.weektest10.bean.NewsInfo;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends BaseAdapter {

    private List<NewsInfo> list = new ArrayList<>();

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public NewsInfo getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    /**
     * 添加数据
     * @param data
     */
    public void addAll(List<NewsInfo> data){
        if (data!=null)
            list.addAll(data);
    }

    /**
     * 清除数据
     */
    public void clear(){
        list.clear();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler hodler;
        if (convertView==null){
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item,parent,false);

            hodler = new ViewHodler();//新建holder存放控件
            hodler.text = convertView.findViewById(R.id.text);
            convertView.setTag(hodler);
        }else{
            hodler = (ViewHodler) convertView.getTag();
        }

        NewsInfo info = list.get(position);
        hodler.text.setText(info.desc);
        return convertView;
    }

    class ViewHodler{
        TextView text;
    }
}
