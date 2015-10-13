package com.fwj.random.base;

import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * 包名：xjy_application_com.xjy.base
 * <p>
 * 描述：应用中ViewPager适配器的基础共性代码代码，减少冗余
 * <p>
 * 作者：傅文江
 * <p>
 * 时间：2015/7/16 13:25
 * <p>
 * 版权：Copyright © 2013-2015 北京兜子科技有限公司
 */
public abstract class MBaseViewPager<T> extends PagerAdapter {
    protected List<T> data;

    public MBaseViewPager(List<T> data) {
        if (null == data) {
            throw new IllegalArgumentException("MyBaseViewPager中数据源不能为空");
        }
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}