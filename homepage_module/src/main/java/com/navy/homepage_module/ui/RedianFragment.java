package com.navy.homepage_module.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.navy.commonlibrary.mvp.base.BasePresenter;
import com.navy.commonlibrary.mvp.base.BaseView;
import com.navy.commonlibrary.mvp.base.LazyloadFragment;
import com.navy.homepage_module.R;
import com.navy.homepage_module.R2;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/2/7.
 */

public class RedianFragment extends LazyloadFragment {
    @BindView(R2.id.text)
    TextView textView;

    public static RedianFragment newInstance() {
        Bundle args = new Bundle();
        RedianFragment fragment = new RedianFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void lazyLoad() {
        textView.setText("改变");
    }

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
        return R.layout.home_redian_fragment_layout;
    }
}
