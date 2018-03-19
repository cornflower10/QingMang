package com.qingmang.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by xiejingbao on 2018/1/9.
 */

public class BaseMvpPresenter<V extends BaseView> implements Presenter<V> {
    private V v;

    protected CompositeDisposable mCompositeDisposable;
//    public Context context;
//    public BaseMvpPresenter(Context context){
//        this.context = context;
//    }

    protected void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    protected void addSubscribe(Disposable subscription) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }

//    protected <U> void addRxBusSubscribe(Class<U> eventType, Consumer<U> act) {
//        if (mCompositeDisposable == null) {
//            mCompositeDisposable = new CompositeDisposable();
//        }
//        mCompositeDisposable.add(RxBus.getDefault().toDefaultFlowable(eventType, act));
//    }

    @Override
    public void attachView(V mvpView) {
        this.v = mvpView;

    }

    @Override
    public void detachView() {
        unSubscribe();
        v = null;

    }

    /**
     * 判断 view是否为空
     * @return
     */
    public  boolean isAttachView(){
        return v != null;
    }
    /**
     * 返回目标view
     * @return
     */
    public  V getMvpView(){
        return v;
    }
    /**
     * 检查view和presenter是否连接
     */
    public void checkViewAttach(){
        if(! isAttachView()){
            throw  new MvpViewNotAttachedException();
        }
    }
    /**
     * 自定义异常
     */
    public static   class  MvpViewNotAttachedException extends RuntimeException{
        public  MvpViewNotAttachedException(){
            super("请求数据前请先调用 attachView(MvpView) 方法与View建立连接");
        }
    }

    public void onError(String msg,String code){
        v.onError(msg);
//        onNotLogin(code);
    }

//    public void onNotLogin(String code){
//        Utils.noLoginJump((Activity) context,code);
//    }

    public void onError(){
        v.onError("请求失败，请检查您的网络！");
    }
}
