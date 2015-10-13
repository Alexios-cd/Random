package com.fwj.random.base.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * ===================================================
 * 包名：xjy_application_com.xjy.base.adpter
 * <p/>
 * 描述：ListView & GridView 通用适配器（与ViewHolder搭配使用）
 * <p/>
 * 作者：傅文江
 * <p/>
 * 创建时间：2015/7/29 16:30
 * <p/>
 * 最后修正：2015/7/29 16:30  傅文江
 * <p/>
 * 版权：Copyright © 2013-2015 北京兜子科技有限公司
 * ===================================================
 */
public abstract class CommonAdater<T> extends BaseAdapter {
	protected Context mContext;
	protected List<T> mDatas;
	protected LayoutInflater mInflater;

	private int mLayoutItemt;

	public CommonAdater(Context context, int layoutItemt, List<T> datas) {
		this.mContext = context;
		this.mDatas = datas;
		this.mInflater = LayoutInflater.from(context);
		this.mLayoutItemt = layoutItemt;
	}

	@Override
	public int getCount() {
		return mDatas.size();
	}


	public void notifyDataSetChanged(List<T> datas) {
		this.mDatas =datas;
		notifyDataSetChanged();
	}

	@Override
	public T getItem(int position) {
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder = ViewHolder.get(mContext, convertView, parent,
				position, mLayoutItemt);
		convert(holder, getItem(position),position);
		return holder.getmConvertView();
	}

	/**
	 * 进行数据的设置<br>
	 * eg:holder.setText(R.id.item_title, bean.title).setText(
	 * R.id.item_content, bean.content);
	 * 
	 * @param holder
	 * @param bean
	 */
	public abstract void convert(ViewHolder holder, T bean,int position);

}
