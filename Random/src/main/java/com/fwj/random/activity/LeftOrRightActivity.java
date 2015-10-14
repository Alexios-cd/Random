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
 * 描    述：左右随机页面
 * <p/>
 * 作    者：傅文江
 * <p/>
 * 时    间：2015/10/13 22:33
 * <p/>
 * 版    权：©个人开发者 傅文江 版权所有
 * ================================
 */
public class LeftOrRightActivity extends BaseActivity implements View.OnClickListener {

    private TextView resultTextView;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_leftorright);
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
        int random = RandomUtils.getRandom(0, 2);
        if (0 == random) {
            resultTextView.setText("左");
        } else if (1 == random) {
            resultTextView.setText("右");
        }
    }


}
