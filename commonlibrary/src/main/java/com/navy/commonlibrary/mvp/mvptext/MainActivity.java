package com.navy.commonlibrary.mvp.mvptext;

import android.os.Bundle;
import android.view.View;

import com.navy.commonlibrary.R;
import com.navy.commonlibrary.mvp.LoginPresenter;
import com.navy.commonlibrary.mvp.LoginView;
import com.navy.commonlibrary.mvp.base.BaseActivity;
import com.navy.commonlibrary.mvp.http.ResponseBean;


public class MainActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

    }

    @Override
    protected void initUi() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentLayout() {
        return 0;
    }

    public void clickLogin(View view) {

        if (getPresenter() != null) {
            getPresenter().login(   "dream", "123456");
        }

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
    public void loginResult(ResponseBean responseBean) {


    }
}
