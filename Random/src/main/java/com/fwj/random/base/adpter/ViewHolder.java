package com.fwj.random.base.adpter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * ===================================================
 * 包名：xjy_application_com.xjy.base.adpter
 * <p/>
 * 描述：通用适配器的ViewHolder（与CommonAdater搭配使用）
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
public class ViewHolder {
	private SparseArray<View> mViews;
	private int mPosition;
	private View mConvertView;

	public View getmConvertView() {
		return mConvertView;
	}

	public ViewHolder(Context context, ViewGroup parent, int layoutId,
			int position) {
		this.mPosition = position;
		this.mViews = new SparseArray<View>();
		mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
				false);
		mConvertView.setTag(this);
	}

	public static ViewHolder get(Context context, View convertView,
			ViewGroup parent, int position, int layoutId) {
		if (null == convertView) {
			return new ViewHolder(context, parent, layoutId, position);
		} else {
			ViewHolder holder = (ViewHolder) convertView.getTag();
			holder.mPosition = position;
			return holder;
		}
	}

	/**
	 * 通过viewId获取控件
	 * 
	 * @param viewId
	 * @return
	 */
	public <T extends View> T getView(int viewId) {
		View view = mViews.get(viewId);
		if (null == view) {
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T) view;
	}

	/**
	 * 通过viewId获取控件
	 *
	 * @param viewId
	 * @return
	 */
	public ImageView getImageView(int viewId) {
		View view = mViews.get(viewId);
		if (null == view) {
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return  (ImageView)view;
	}

	/**
	 * 设置TextView的值
	 * 
	 * @param viewId
	 * @param text
	 * @return
	 */
	public ViewHolder setText(int viewId, String text) {
		TextView tv = getView(viewId);
		tv.setText(text);
		return this;
	}

	/**
	 * 设置 ImageView
	 * @param viewId
	 * @param resId
	 * @return
	 */
	public ViewHolder setImageView(int viewId, int resId) {
		ImageView imageView = getView(viewId);
		imageView.setImageResource(resId);
		return this;
	}

}
