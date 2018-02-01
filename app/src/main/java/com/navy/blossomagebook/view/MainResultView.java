package com.navy.blossomagebook.view;

import com.navy.commonlibrary.mvp.base.BaseView;
import com.navy.commonlibrary.mvp.http.ResponseBean;

/**
 * Created by Administrator on 2018/2/1.
 */

public interface MainResultView extends BaseView {
    void loginResult(ResponseBean responseBean);
}
