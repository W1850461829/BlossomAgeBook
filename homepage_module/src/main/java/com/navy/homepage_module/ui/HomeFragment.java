package com.navy.homepage_module.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.navy.commonlibrary.baseadapter.FmPagerAdapter;
import com.navy.commonlibrary.mvp.base.BaseFragment;
import com.navy.commonlibrary.mvp.base.BasePresenter;
import com.navy.commonlibrary.mvp.base.BaseView;
import com.navy.commonlibrary.router.RouterConstants;
import com.navy.commonlibrary.utils.TabFragmentIndex;
import com.navy.homepage_module.R;
import com.navy.homepage_module.R2;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/2/5.
 */

@Route(path = RouterConstants.HOME_MODULE_FRAGMENT)
public class HomeFragment extends BaseFragment {

    protected OnOpenDrawerLayoutListener onOpenDrawerLayoutListener;
    private List<Fragment> fragments;
    private String[] tabs = new String[]{"知乎日报", "热点新闻", "微信精选"};
    @BindView(R2.id.toolbar)
    Toolbar toolbar;

    @BindView(R2.id.tl_tabs)
    TabLayout tlTabs;

    @BindView(R2.id.vp_fragment)
    ViewPager vpFragment;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnOpenDrawerLayoutListener) {
            onOpenDrawerLayoutListener = (OnOpenDrawerLayoutListener) context;
        }
        fragments = new ArrayList<>();
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
        vpFragment.setOffscreenPageLimit(tabs.length);
        for (int i = 0; i < tabs.length; i++) {
            tlTabs.addTab(tlTabs.newTab().setText(tabs[i]));
            switch (i) {
                case TabFragmentIndex.TAB_ZHIHU_INDEX:
                    fragments.add(ZhihuFragment.newInstance());
                    break;
                case TabFragmentIndex.TAB_REDIAN_INDEX:
                    fragments.add(RedianFragment.newInstance());
                    break;
                case TabFragmentIndex.TAB_WEIXIN_INDEX:
                    fragments.add(WeixinFragment.newInstance());
                    break;
                default:
                    fragments.add(ZhihuFragment.newInstance());
                    break;
            }
        }
        vpFragment.setAdapter(new FmPagerAdapter(fragments, getActivity().getSupportFragmentManager()));
        vpFragment.setCurrentItem(TabFragmentIndex.TAB_ZHIHU_INDEX);//要设置到viewpager.setAdapter后才起作用
        tlTabs.setupWithViewPager(vpFragment);
        tlTabs.setVerticalScrollbarPosition(TabFragmentIndex.TAB_ZHIHU_INDEX);
        //tlTabs.setupWithViewPager方法内部会remove所有的tabs，这里重新设置一遍tabs的text，否则tabs的text不显示
        for (int i = 0; i < tabs.length; i++) {
            tlTabs.getTabAt(i).setText(tabs[i]);
        }
    }


    /**
     * fragment打开DrawerLayout监听
     */
    public interface OnOpenDrawerLayoutListener {

        void onOpen();
    }
}
