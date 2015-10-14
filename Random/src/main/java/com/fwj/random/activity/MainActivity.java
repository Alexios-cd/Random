package com.fwj.random.activity;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;

import com.fwj.random.R;
import com.fwj.random.base.BaseActivity;

import java.lang.reflect.Field;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void initView() {
        getOverflowMenu();
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
                startActivity(new Intent(MainActivity.this, SJBRandomActivity.class));
                break;
        }
    }

    private void goLeftOrRightRandom() {
        startActivity(new Intent(MainActivity.this, LeftOrRightActivity.class));
    }

    /**
     * 强制显示ActionBar三个小点
     */
    private void getOverflowMenu() {
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if(menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
                openSearch();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openSettings() {

    }

    private void openSearch() {

    }
}
