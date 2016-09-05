package com.example.darkhorse.myaccountant.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2016/9/5.
 */

public class HackyViewPager extends ViewPager {
    private boolean isLocked;

    public HackyViewPager(Context context) {
        super(context);
        isLocked = false;
    }

    public HackyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        isLocked = false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (!isLocked) {
            try {
                return super.onInterceptTouchEvent(ev);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    int x, y;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:

                x = (int) event.getRawX();
                y = (int) event.getRawY();
                Log.i("onTouch", String.format("HackyViewPager ACTION_DOWN x %s y %s", x, y));


            case MotionEvent.ACTION_UP:

                x = (int) event.getRawX();
                y = (int) event.getRawY();
                Log.i("onTouch", String.format("HackyViewPager ACTION_UP x %s y %s", x, y));

                break;
            case MotionEvent.ACTION_MOVE:

                x = (int) event.getRawX();
                y = (int) event.getRawY();
                Log.i("onTouch", String.format("HackyViewPager ACTION_MOVE x %s y %s", x, y));

                break;
            case MotionEvent.ACTION_CANCEL:

                x = (int) event.getRawX();
                y = (int) event.getRawY();
                Log.i("onTouch", String.format("HackyViewPager ACTION_CANCEL x %s y %s", x, y));

                break;
            case MotionEvent.ACTION_OUTSIDE:

                x = (int) event.getRawX();
                y = (int) event.getRawY();
                Log.i("onTouch", String.format("HackyViewPager ACTION_OUTSIDE x %s y %s", x, y));

                break;
        }

        if (!isLocked) {// false 的 话
            return super.onTouchEvent(event);
        }
        return false;
    }

    public void toggleLock() {
        isLocked = !isLocked;
    }

    public void setLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public boolean isLocked() {
        return isLocked;
    }
}
