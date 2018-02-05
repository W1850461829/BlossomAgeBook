package com.navy.blossomagebook.presenter;

import com.navy.blossomagebook.view.MainResultView;
import com.navy.commonlibrary.mvp.LoginView;
import com.navy.commonlibrary.mvp.base.BasePresenter;
import com.navy.commonlibrary.mvp.base.LoginMode;
import com.navy.commonlibrary.mvp.http.ResponseBean;

/**
 * Created by Administrator on 2018/2/1.
 */

public class MainPresenter extends BasePresenter<MainResultView> {
    private LoginMode loginMode;


    public MainPresenter() {
        loginMode = new LoginMode();
    }

    public void login(String name, String password) {
        if (getView() != null) {
            loginMode.login(name, password, new LoginView() {
                @Override
                public void loginResult(ResponseBean responseBean) {
                    if (getView() != null) {
                        getView().loginResult(responseBean);
                    }
                }

            });

        }

    }

}
