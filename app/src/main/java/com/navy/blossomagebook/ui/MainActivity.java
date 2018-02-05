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
import com.navy.homepage_module.ui.HomeFragment;
import com.navy.personage_module.ui.PersonageFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainResultView, MainPresenter>
        implements NavigationView.OnNavigationItemSelectedListener, MainResultView {

    private FragmentManager fragmentManager;
    private HomeFragment homeFragment;
    private BookFragment bookFragment;
    private PersonageFragment personageFragment;
    @BindView(R.id.fl_container)
    FrameLayout frameLayout;
    private BottomNavigationView bottomNavigationView;
    /*  @BindView(R.id.bviv_bar)
    BottomNavigationView bottomNavigationView;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fragmentManager = getSupportFragmentManager();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bviv_bar);
        setListener();
    }

    private void setListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_item_home:
                        showFragment(1);
                        break;
                    case R.id.menu_item_book:
                        showFragment(2);
                        break;
                    case R.id.menu_item_personal:
                        showFragment(3);
                        break;

                }
                return true;
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);/*想要显示一个fragment,先隐藏所有fragment，防止重叠*/
        switch (index) {
            case 3:
                if (personageFragment != null)
                    fragmentTransaction.show(personageFragment);
                else {
                    personageFragment = new PersonageFragment();
                    fragmentTransaction.add(R.id.fl_container, personageFragment);
                }
                break;
            case 2:
                /*如果fragment1已经存在则将其显示出来*/
                if (bookFragment != null)
                    fragmentTransaction.show(bookFragment);
                /*否则是第一次切换则添加fragment1，注意添加后是会显示出来的，replace方法也是先remove后add*/
                else {
                    bookFragment = new BookFragment();
                    fragmentTransaction.add(R.id.fl_container, bookFragment);
                }
                break;
            case 1:
                if (homeFragment != null)
                    fragmentTransaction.show(homeFragment);
                else {
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.fl_container, homeFragment);
                }
                break;

        }
        fragmentTransaction.commitAllowingStateLoss();
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
}
