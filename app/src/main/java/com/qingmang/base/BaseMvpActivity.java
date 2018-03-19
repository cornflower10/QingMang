package com.qingmang.base;


import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.qingmang.baselibrary.utils.LogManager;


/**
 * Created by xiejingbao on 2018/1/9.
 */

public class BaseMvpActivity<P extends Presenter<V>,V extends BaseView> extends BaseActivity implements BaseView, LoaderManager.LoaderCallbacks<P> {
   public P presenter;
    private final int BASE_LODER_ID = 1000;//loader的id值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       getSupportLoaderManager().initLoader(BASE_LODER_ID,null,this);
        LogManager.i("-----BaseMvpActivity-------");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogManager.i("-----onStart-------");
        presenter.attachView((V)this);

    }


    @Override
    public void onError(String msg) {
        showToast(msg);

    }


    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        LogManager.i("-----onCreateLoader-------");
        return null;
    }

    @Override
    public void onLoadFinished(Loader<P> loader, P data) {
        LogManager.i("-----onLoadFinished-------");
        presenter = data;
    }


    @Override
    public void onLoaderReset(Loader loader) {
        LogManager.i("-----onLoaderReset-------");
        presenter = null;
    }
}
