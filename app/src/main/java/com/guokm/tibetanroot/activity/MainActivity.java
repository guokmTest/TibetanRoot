package com.guokm.tibetanroot.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.guokm.tibetanroot.ActivityCollector;
import com.guokm.tibetanroot.R;
import com.guokm.tibetanroot.fragment.MineFragment;
import com.guokm.tibetanroot.fragment.PublishFragment;
import com.guokm.tibetanroot.fragment.SubjectFragment;
import com.guokm.tibetanroot.util.T;

public class MainActivity extends BaseActivity {

    private BottomNavigationBar bottomNavigationBar;
    int lastSelectedPosition = 0;
    private String TAG = MainActivity.class.getSimpleName();
    private SubjectFragment mSubjectFragment;
    private MineFragment mMineFragment;
    private PublishFragment mPublishFragment;
    private Button search_button;
    private Button back_button;
    private TextView title_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout titleLayout = (RelativeLayout) this.findViewById(R.id.title);
        back_button = (Button) titleLayout.findViewById(R.id.back_button);
        search_button = (Button) titleLayout.findViewById(R.id.search_button);
        title_text = (TextView) titleLayout.findViewById(R.id.title_text);

        setDefaultFragment();
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "话题"))
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "发表"))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "我"))
                .setFirstSelectedPosition(lastSelectedPosition)
                .initialise();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
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
                        title_text.setText("藏根");
                        transaction.replace(R.id.tb, mSubjectFragment);
                        break;
                    case 2:
                        if (mMineFragment == null) {
                            mMineFragment = MineFragment.newInstance("我");
                        }
                        title_text.setText("藏根");
                        transaction.replace(R.id.tb, mMineFragment);
                        break;
                    case 1:
                        if (mPublishFragment == null) {
                            mPublishFragment = PublishFragment.newInstance("发表");
                        }
                        title_text.setText("发表话题规则");
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
        if (mSubjectFragment == null) {

            mSubjectFragment = SubjectFragment.newInstance("话题");
        }
        transaction.replace(R.id.tb, mSubjectFragment);
        transaction.commit();
    }

    // 退出时间
    private long currentBackPressedTime = 0;
    // 退出间隔
    private static final int BACK_PRESSED_INTERVAL = 2000;

    //在activity中重写onBackPressed方法
    @Override
    public void onBackPressed() {
        // 判断时间间隔
        if (System.currentTimeMillis() - currentBackPressedTime > BACK_PRESSED_INTERVAL) {
            currentBackPressedTime = System.currentTimeMillis();
            T.s("再按一次返回键退出程序");
        } else {
            // 退出
            ActivityCollector.finishAll();
        }
    }
}
