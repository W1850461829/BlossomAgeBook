package com.navy.books_module.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.navy.books_module.R;
import com.navy.commonlibrary.mvp.base.BaseFragment;
import com.navy.commonlibrary.mvp.base.BasePresenter;
import com.navy.commonlibrary.mvp.base.BaseView;
import com.navy.commonlibrary.router.RouterConstants;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/2/5.
 */
@Route(path = RouterConstants.BOOK_MODULE_FRAGMENT)
public class BookFragment extends BaseFragment {


    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public BaseView createView() {
        return null;
    }

    @Override
    public int getContentLayout() {
        return R.layout.book_fragment_main;
    }

    @Override
    protected void initTop() {

    }

    @Override
    protected void initData() {

    }
}

