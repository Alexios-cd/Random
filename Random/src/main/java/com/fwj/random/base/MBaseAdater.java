package com.fwj.random.base;

import android.widget.BaseAdapter;

import java.util.List;

/**
 * 包名：xjy_application_com.xjy.base
 * <p/>
 * 描述：应用中ListView，GridView适配器的基础共性代码代码，减少冗余
 * <p/>
 * 作者：傅文江
 * <p/>
 * 时间：2015/7/16 13:23
 * <p/>
 * 版权：Copyright © 2013-2015 北京兜子科技有限公司
 */
public abstract class MBaseAdater<T> extends BaseAdapter {
    protected List<T> data;

    public MBaseAdater(List<T> data) {
        if(null==data){
            throw new IllegalArgumentException("Adater中数据源不能为空");
        }
        this.data = data;

    }

    public void notifyDataSetChanged(List<T> data) {
        this.data=data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}
