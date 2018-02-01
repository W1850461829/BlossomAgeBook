package com.navy.commonlibrary.mvp;


import com.navy.commonlibrary.mvp.base.BaseView;
import com.navy.commonlibrary.mvp.http.ResponseBean;

/**
 * Created by Administrator on 2017/11/30.
 */

public interface LoginView extends BaseView {
    void loginResult(ResponseBean responseBean);
}
