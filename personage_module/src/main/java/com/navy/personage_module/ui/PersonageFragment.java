package com.navy.personage_module.ui;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.navy.commonlibrary.mvp.base.BaseFragment;
import com.navy.commonlibrary.mvp.base.BasePresenter;
import com.navy.commonlibrary.mvp.base.BaseView;
import com.navy.commonlibrary.router.RouterConstants;
import com.navy.personage_module.R;

/**
 * Created by Administrator on 2018/2/5.
 */
@Route(path = RouterConstants.PERSONAGE_MODULE_FRAGMENT)
public class PersonageFragment extends BaseFragment {

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
        return R.layout.personage_fragment_main;
    }
}
