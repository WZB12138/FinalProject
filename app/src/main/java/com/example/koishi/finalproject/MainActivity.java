package com.example.hp.app.stp.wheelview.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabWidget;

import com.example.hp.app.stp.wheelview.view.OnWheelChangedListener;
import com.example.hp.app.stp.wheelview.view.ArrayWheelAdapter;
import com.example.hp.app.stp.wheelview.view.WheelView;

import com.example.hp.app.R;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements OnWheelChangedListener {



    // Data
    private String[] mHour; // 小时
    private String[] mMinute; // 分钟
    // View
    private WheelView mWheelViewHour, mWheelViewMinute, mWheelViewHour2, mWheelViewMinute2;
    // TAG
    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWheelViewMinute.removeChangingListener(this);
    }

    private void initData() {
        // hour
        mHour = new String[24];
        for (int i = 0; i < 24; i++) {
            mHour[i] = String.valueOf(i);
        }
        // minute
        mMinute = new String[60];
        for (int i = 0; i < 60; i++) {
            mMinute[i] = String.valueOf(i);
        }
    }

    private void initView() {
        //创建 WheelView 组件
        mWheelViewHour = (WheelView) findViewById(R.id.wheelViewHour1);
        //设置 WheelView 组件最多显示 5 个元素
        mWheelViewHour.setVisibleItems(7);
        //设置 WheelView 元素是否循环滚动
        mWheelViewHour.setCyclic(true);
        mWheelViewHour.setLabel("小时");
        //设置 WheelView 适配器
        mWheelViewHour.setAdapter(new ArrayWheelAdapter<>(mHour));
        mWheelViewHour.setCurrentItem(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
        //设置右侧的 WheelView
        mWheelViewMinute = (WheelView) findViewById(R.id.wheelViewMinute1);
        //设置右侧 WheelView 显示个数
        mWheelViewMinute.setVisibleItems(7);
        //设置右侧 WheelView 元素是否循环滚动
        mWheelViewMinute.setCyclic(true);
        mWheelViewMinute.setLabel("分钟");
        //设置右侧 WheelView 的元素适配器
        mWheelViewMinute.setAdapter(new ArrayWheelAdapter<>(mMinute));
        mWheelViewMinute.setCurrentItem(Calendar.getInstance().get(Calendar.MINUTE));
        mWheelViewMinute.addChangingListener(this);

        //创建 WheelView 组件
        mWheelViewHour2 = (WheelView) findViewById(R.id.wheelViewHour2);
        //设置 WheelView 组件最多显示 5 个元素
        mWheelViewHour2.setVisibleItems(7);
        //设置 WheelView 元素是否循环滚动
        mWheelViewHour2.setCyclic(true);
        mWheelViewHour2.setLabel("小时");
        //设置 WheelView 适配器
        mWheelViewHour2.setAdapter(new ArrayWheelAdapter<>(mHour));
        mWheelViewHour2.setCurrentItem(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
        //设置右侧的 WheelView
        mWheelViewMinute2 = (WheelView) findViewById(R.id.wheelViewMinute2);
        //设置右侧 WheelView 显示个数
        mWheelViewMinute2.setVisibleItems(7);
        //设置右侧 WheelView 元素是否循环滚动
        mWheelViewMinute2.setCyclic(true);
        mWheelViewMinute2.setLabel("分钟");
        //设置右侧 WheelView 的元素适配器
        mWheelViewMinute2.setAdapter(new ArrayWheelAdapter<>(mMinute));
        mWheelViewMinute2.setCurrentItem(Calendar.getInstance().get(Calendar.MINUTE));
        mWheelViewMinute2.addChangingListener(this);

    }

    @Override
    public void onChanged(WheelView wheel, int oldValue, int newValue) {
        if (oldValue == 59 && newValue == 0) { // WheelView向下滚动
            mWheelViewHour.setCurrentItem(mWheelViewHour.getCurrentItem() + 1);
        } else if (oldValue == 0 && newValue == 59) { // WheelView向上滚动
            mWheelViewHour.setCurrentItem(mWheelViewHour.getCurrentItem() - 1);
        }
    }
}
