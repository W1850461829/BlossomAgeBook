package com.navy.commonlibrary.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.navy.commonlibrary.R;
import com.navy.commonlibrary.mvp.base.BaseFragment;
import com.navy.commonlibrary.mvp.http.ResponseBean;


/**
 * Created by Administrator on 2017/11/30.
 */

public class MainFragment extends BaseFragment<LoginView, LoginPresenter> implements LoginView {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getPresenter() != null) {
                    getPresenter().login("dream", "123456");

                }
            }
        });
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public LoginView createView() {
        return this;
    }

    @Override
    public int getContentLayout() {
        return R.layout.main_fragment_layout;
    }

    @Override
    protected void initTop() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void loginResult(ResponseBean responseBean) {

    }

}
