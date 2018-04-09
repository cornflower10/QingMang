package com.qingmang.utils.rx;

import com.qingmang.base.BaseView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by xiejingbao on 2018/4/3.
 */

public class CommonSubscriber<T> implements Observer<T> {
    private BaseView mView;
    private String mErrorMsg;
    private boolean isShowErrorState = true;

    public CommonSubscriber(BaseView view){
        this.mView = view;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {
//        if (mView == null) {
//            return;
//        }
//        if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
//            mView.showErrorMsg(mErrorMsg);
//        } else if (e instanceof ApiException) {
//            mView.showErrorMsg(e.toString());
//        } else if (e instanceof HttpException) {
//            mView.showErrorMsg("数据加载失败");
//        } else {
//            mView.showErrorMsg("未知错误");
//        }
//        if (isShowErrorState) {
//            mView.stateError();
//        }
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
////        mView.stateLoading();
//    }

    @Override
    public void onComplete() {
//        mView.stateMain();
    }
}
