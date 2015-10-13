package com.fwj.random.activity;

import android.content.Intent;
import android.view.View;

import com.fwj.random.R;
import com.fwj.random.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initFindViewById() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {
        findViewById(R.id.leftOrrightRandom_button).setOnClickListener(this);
        findViewById(R.id.sjbRandom_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.leftOrrightRandom_button:
                goLeftOrRightRandom();
                break;
            case R.id.sjbRandom_button:
                startActivity(new Intent(MainActivity.this,SJBRandomActivity.class));
                break;
        }
    }

    private void goLeftOrRightRandom() {
        startActivity(new Intent(MainActivity.this,LeftOrRightActivity.class));
    }
}
