package com.navy.commonlibrary.mvp;


import com.navy.commonlibrary.mvp.base.BasePresenter;
import com.navy.commonlibrary.mvp.base.LoginMode;
import com.navy.commonlibrary.mvp.http.ResponseBean;

/**
 * Created by Administrator on 2017/11/30.
 */

public class LoginPresenter extends BasePresenter<LoginView> {
    private LoginMode loginMode;


    public LoginPresenter() {
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
