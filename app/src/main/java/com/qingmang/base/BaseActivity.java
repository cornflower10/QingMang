package com.qingmang.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.qingmang.baselibrary.utils.LogManager;


/**
 * Created by caomingyu on 2016/5/28.
 */
public class BaseActivity extends AppCompatActivity {
    private Toast toast = null;
    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        LogManager.i("新建"+this.getClass().getName());
        super.onCreate(savedInstanceState);
        mContext=this;
//        MyApplication.getInstance().addActivity(this);
//        PushAgent.getInstance(this).onAppStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        BaseActivity.getInstance().finishActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        MobclickAgent.onPause(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogManager.i("保存onSaveInstanceState");
        outState.putBoolean("recyle",true);
    }

    public void showToast(String msg){
        if(null!=toast){
            toast.setText(msg);
            toast.setDuration(Toast.LENGTH_SHORT);
        }else
        {
            toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        }
        toast.show();
    }

}
