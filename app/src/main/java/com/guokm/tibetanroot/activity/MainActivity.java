package com.guokm.tibetanroot.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.guokm.tibetanroot.R;
import com.guokm.tibetanroot.fragment.MineFragment;
import com.guokm.tibetanroot.fragment.PublishFragment;
import com.guokm.tibetanroot.fragment.SubjectFragment;

public class MainActivity extends BaseActivity {

    private BottomNavigationBar bottomNavigationBar;
    int lastSelectedPosition = 0;
    private String TAG = MainActivity.class.getSimpleName();
    private SubjectFragment mSubjectFragment;
    private MineFragment mMineFragment;
    private PublishFragment mPublishFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 背景图和通知栏融合
         */
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_main);
        setDefaultFragment();
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "话题"))
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "发表"))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "我"))
                .setFirstSelectedPosition(lastSelectedPosition )
                .initialise();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {
//                Log.d(TAG, "onTabSelected() called with: " + "position = [" + position + "]");
                FragmentManager fm = MainActivity.this.getFragmentManager();
                //开启事务
                FragmentTransaction transaction = fm.beginTransaction();
                switch (position) {
                    case 0:
                        if (mSubjectFragment == null) {
                            mSubjectFragment = SubjectFragment.newInstance("话题");//传内容给fragment
                        }
                        transaction.replace(R.id.tb, mSubjectFragment);
                        break;
                    case 2:
                        if (mMineFragment == null) {
                            mMineFragment = MineFragment.newInstance("我");
                        }
                        transaction.replace(R.id.tb, mMineFragment);
                        break;
                    case 1:
                        if (mPublishFragment == null) {
                            mPublishFragment = PublishFragment.newInstance("发表");
                        }
                        transaction.replace(R.id.tb, mPublishFragment);
                        break;
                    default:
                        break;
                }
                // 事务提交
                transaction.commit();
            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });

    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mSubjectFragment = SubjectFragment.newInstance("话题");
        transaction.replace(R.id.tb, mSubjectFragment);
        transaction.commit();
    }
}
