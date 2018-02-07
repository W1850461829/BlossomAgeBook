package com.navy.commonlibrary.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/2/7.
 */

public abstract class LazyloadFragment<V extends BaseView, P extends BasePresenter<V>> extends Fragment {
    private V view;
    private P presenter;
    private Unbinder unbinder;
    private boolean isInitView = false;
    private boolean isVisible = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        isInitView = true;
        isCanLoadData();
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见，获取该标志记录下来
        if (isVisibleToUser) {
            isVisible = true;
            isCanLoadData();
        } else {
            isVisible = false;
        }
    }

    private void isCanLoadData() {
        //所以条件是view初始化完成并且对用户可见
        if (isInitView && isVisible) {
            lazyLoad();

            //防止重复加载数据
            isInitView = false;
            isVisible = false;
        }
    }

    /**
     * 让布局中的view与fragment中的变量建立起映射
     */
    protected abstract void init();

    /**
     * 加载要显示的数据
     */
    protected abstract void lazyLoad();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (presenter == null) {
            presenter = createPresenter();
        }
        if (view == null) {
            view = createView();
        }
        if (presenter != null && view != null) {
            presenter.attachView(view);
        }

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        if (presenter != null && view != null) {
            presenter.detachView();
        }
    }

    public P getPresenter() {
        return presenter;
    }

    public abstract P createPresenter();

    public abstract V createView();

    public abstract int getContentLayout();

}


