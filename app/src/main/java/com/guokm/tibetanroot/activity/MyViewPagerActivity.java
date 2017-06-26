package com.guokm.tibetanroot.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guokm.tibetanroot.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyViewPagerActivity extends AppCompatActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    private View view1, view2, view3;
    private List<View> viewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_pager);
        ButterKnife.bind(this);
        initview();
    }

    private void initview() {
        LayoutInflater inflater = getLayoutInflater();
        view1 = inflater.inflate(R.layout.vp1, null);
        view2 = inflater.inflate(R.layout.vp2, null);
        view3 = inflater.inflate(R.layout.vp3, null);

        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        PagerAdapter pagerAdapter = new PagerAdapter() {//此处严重注意，不可以将pagerAdpter作为匿名内部类写，会出现多个parent，导致错误，而删除parent会导致页面空白

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return viewList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                container.addView(viewList.get(position));

                return viewList.get(position);
            }
        };

        vp.setAdapter(pagerAdapter);
    }
}
