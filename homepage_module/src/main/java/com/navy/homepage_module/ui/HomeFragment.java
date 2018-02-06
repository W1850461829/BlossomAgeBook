package com.navy.homepage_module.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.navy.commonlibrary.mvp.base.BaseFragment;
import com.navy.commonlibrary.mvp.base.BasePresenter;
import com.navy.commonlibrary.mvp.base.BaseView;
import com.navy.commonlibrary.router.RouterConstants;
import com.navy.homepage_module.R;
import com.navy.homepage_module.R2;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/2/5.
 */

@Route(path = RouterConstants.HOME_MODULE_FRAGMENT)
public class HomeFragment extends BaseFragment {

    protected OnOpenDrawerLayoutListener onOpenDrawerLayoutListener;

    @BindView(R2.id.toolbar)
    Toolbar toolbar;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnOpenDrawerLayoutListener) {
            onOpenDrawerLayoutListener = (OnOpenDrawerLayoutListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onOpenDrawerLayoutListener = null;
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
        return R.layout.home_fragment_main;
    }

    @Override
    protected void initTop() {
        toolbar.setTitle("首页");
        toolbar.setNavigationIcon(R.mipmap.home_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onOpenDrawerLayoutListener != null) {
                    onOpenDrawerLayoutListener.onOpen();
                }
            }
        });
    }

    @Override
    protected void initData() {

    }

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * fragment打开DrawerLayout监听
     */
    public interface OnOpenDrawerLayoutListener {

        void onOpen();
    }
}
