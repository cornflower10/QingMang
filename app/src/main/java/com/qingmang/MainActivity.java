package com.qingmang;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.qingmang.home.FindFragment;
import com.qingmang.home.HomeFragment;
import com.qingmang.home.MyFragment;
import com.qingmang.uilibrary.BottomBar;
import com.qingmang.uilibrary.BottomBarTab;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.qingmang.R.id.fl_container;

public class MainActivity extends AppCompatActivity {

    @BindView(fl_container)
    FrameLayout flContainer;
    @BindView(R.id.bottomBar)
    BottomBar mBottomBar;
    private List<Fragment> mFragments = new ArrayList<Fragment>();
    private HomeFragment homeFragment;
    private MyFragment myFragment;
    private FindFragment findFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment(savedInstanceState);
        initView();
    }


    private void initView() {
        mBottomBar = (BottomBar) findViewById(R.id.bottomBar);

        mBottomBar.addItem(new BottomBarTab(this, R.mipmap.index))
                .addItem(new BottomBarTab(this, R.mipmap.find))
                .addItem(new BottomBarTab(this, R.mipmap.my));

        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments.get(position));
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
                final Fragment currentFragment = mFragments.get(position);
//                int count = currentFragment.getChildFragmentManager().getBackStackEntryCount();
//
//                // 如果不在该类别Fragment的主页,则回到主页;
//                if (count > 1) {
//                    if (currentFragment instanceof ZhihuFirstFragment) {
//                        currentFragment.popToChild(FirstHomeFragment.class, false);
//                    } else if (currentFragment instanceof ZhihuSecondFragment) {
//                        currentFragment.popToChild(ViewPagerFragment.class, false);
//                    } else if (currentFragment instanceof ZhihuThirdFragment) {
//                        currentFragment.popToChild(ShopFragment.class, false);
//                    } else if (currentFragment instanceof ZhihuFourthFragment) {
//                        currentFragment.popToChild(MeFragment.class, false);
//                    }
//                    return;
//                }


                // 这里推荐使用EventBus来实现 -> 解耦
//                if (count == 1) {
//                    // 在FirstPagerFragment中接收, 因为是嵌套的孙子Fragment 所以用EventBus比较方便
//                    // 主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
//                    EventBus.getDefault().post(new TabSelectedEvent(position));
//                }
            }
        });
        mBottomBar.setCurrentItem(0);
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        android.app.FragmentManager manager = getFragmentManager();
        if (homeFragment.isAdded()) {
            manager.putFragment(outState, "homeFragment", homeFragment);
        }
        if (myFragment.isAdded()) {
            manager.putFragment(outState, "myFragment", myFragment);
        }
        if (findFragment.isAdded()) {
            manager.putFragment(outState, "findFragment", findFragment);
        }

    }

    /**
     * 初始化fragment的记忆状态
     *
     * @param savedInstanceState
     */
    private void initFragment(Bundle savedInstanceState) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (savedInstanceState != null) {

            homeFragment = (HomeFragment) getFragmentManager().getFragment(savedInstanceState, "homeFragment");
            myFragment = (MyFragment) getFragmentManager().getFragment(savedInstanceState, "myFragment");
            findFragment = (FindFragment) getFragmentManager().getFragment(savedInstanceState, "findFragment");

        } else {
            homeFragment = HomeFragment.newInstance();
            myFragment = MyFragment.newInstance();
            findFragment = FindFragment.newInstance();
        }
        mFragments.add(homeFragment);
        mFragments.add(myFragment);
        mFragments.add(findFragment);
        transaction.add(R.id.fl_container,homeFragment);
        transaction.add(R.id.fl_container,myFragment);
        transaction.add(R.id.fl_container,findFragment);
        transaction.hide(myFragment);
        transaction.hide(findFragment);
        transaction.commit();
    }
    public void showHideFragment(Fragment fragment){
       FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        for (Fragment f:mFragments) {
            if(fragment.equals(f)){
                fragmentTransaction.show(fragment);
            }else
                fragmentTransaction.hide(f);

        }
        fragmentTransaction.commit();
    }
}
