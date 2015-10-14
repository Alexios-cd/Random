package com.fwj.random.activity;

import android.view.View;
import android.widget.TextView;

import com.fwj.random.R;
import com.fwj.random.base.BaseActivity;
import com.fwj.random.utils.RandomUtils;

/**
 * ================================
 * 文件名：AddressActivity.java
 * <p/>
 * 描    述：
 * <p/>
 * 作    者：傅文江
 * <p/>
 * 时    间：2015/10/13 23:06
 * <p/>
 * 版    权：©个人开发者 傅文江 版权所有
 * ================================
 */
public class SJBRandomActivity extends BaseActivity implements View.OnClickListener {
    private TextView resultTextView;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_sjbrandom);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void initFindViewById() {
        resultTextView = (TextView) findViewById(R.id.result_textView);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {
        findViewById(R.id.random_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.random_button:
                getResult();
                break;
        }
    }

    private void getResult() {
        int random = RandomUtils.getRandom(0, 3);
        if (0 == random) {
            resultTextView.setText("石头");
        } else if (1 == random) {
            resultTextView.setText("剪刀");
        } else if (2 == random) {
            resultTextView.setText("布");
        }

    }
}
