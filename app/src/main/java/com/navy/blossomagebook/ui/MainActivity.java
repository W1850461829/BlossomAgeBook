package com.navy.blossomagebook.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.navy.blossomagebook.R;
import com.navy.blossomagebook.presenter.MainPresenter;
import com.navy.blossomagebook.view.MainResultView;
import com.navy.books_module.ui.BookFragment;
import com.navy.commonlibrary.mvp.base.BaseActivity;
import com.navy.commonlibrary.mvp.http.ResponseBean;
import com.navy.commonlibrary.router.RouterConstants;
import com.navy.commonlibrary.router.RouterUtils;
import com.navy.homepage_module.ui.HomeFragment;
import com.navy.personage_module.ui.PersonageFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainResultView, MainPresenter>
        implements NavigationView.OnNavigationItemSelectedListener, MainResultView, HomeFragment.OnOpenDrawerLayoutListener {
    private HomeFragment homeFragment;
    private BookFragment bookFragment;
    private PersonageFragment personageFragment;

    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_BOOK = 1;
    private static final int FRAGMENT_PERSONAGE = 2;

    @BindView(R.id.fl_container)
    FrameLayout frameLayout;
    @BindView(R.id.bviv_bar)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        showFragment(FRAGMENT_HOME);
        setListener();
    }

    private void setListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_item_home:
                        showFragment(FRAGMENT_HOME);
                        return true;
                    case R.id.menu_item_book:
                        showFragment(FRAGMENT_BOOK);
                        return true;
                    case R.id.menu_item_personal:
                        showFragment(FRAGMENT_PERSONAGE);
                        return true;

                }
                return false;
            }
        });
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public MainResultView createView() {
        return this;
    }


    @Override
    public void loginResult(ResponseBean responseBean) {

    }

    /**
     * 显示fragment
     */
    public void showFragment(int index) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);/*想要显示一个fragment,先隐藏所有fragment，防止重叠*/
        switch (index) {
            case FRAGMENT_HOME:
                if (homeFragment != null)
                    fragmentTransaction.show(homeFragment);
                else {
                    homeFragment = (HomeFragment) RouterUtils.navigation(RouterConstants.HOME_MODULE_FRAGMENT);
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.fl_container, homeFragment);
                }
                break;

            case FRAGMENT_BOOK:
                /*如果fragment1已经存在则将其显示出来*/
                if (bookFragment != null)
                    fragmentTransaction.show(bookFragment);
                /*否则是第一次切换则添加fragment1，注意添加后是会显示出来的，replace方法也是先remove后add*/
                else {
                    bookFragment = (BookFragment) RouterUtils.navigation(RouterConstants.BOOK_MODULE_FRAGMENT);
                    fragmentTransaction.add(R.id.fl_container, bookFragment);
                }
                break;
            case FRAGMENT_PERSONAGE:
                if (personageFragment != null)
                    fragmentTransaction.show(personageFragment);
                else {
                    personageFragment = (PersonageFragment) RouterUtils.navigation(RouterConstants.PERSONAGE_MODULE_FRAGMENT);
                    fragmentTransaction.add(R.id.fl_container, personageFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }

    /**
     * 隐藏fragment
     */
    private void hideFragment(FragmentTransaction ft) {
        if (homeFragment != null)
            ft.hide(homeFragment);
        if (bookFragment != null)
            ft.hide(bookFragment);
        if (personageFragment != null)
            ft.hide(personageFragment);
    }

    @Override
    public void onOpen() {
        if (!drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.openDrawer(GravityCompat.START);
        }
    }
}
