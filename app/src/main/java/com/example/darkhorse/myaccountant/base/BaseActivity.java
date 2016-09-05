package com.example.darkhorse.myaccountant.base;

import android.app.Activity;
import android.content.Context;

/**
 * Created by Administrator on 2016/9/5.
 */

public class BaseActivity extends Activity {

    protected Context context = this;
    protected Activity activity = this;
    public String TAG = this.getClass().getName();


}
