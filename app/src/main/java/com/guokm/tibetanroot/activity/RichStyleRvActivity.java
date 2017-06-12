package com.guokm.tibetanroot.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.guokm.tibetanroot.R;
import com.guokm.tibetanroot.adapter.DemoAdapter;
import com.guokm.tibetanroot.domain.DataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 使用rv优雅的编写多种item的列表
 * Created by Administrator on 2017/6/11.
 */

public class RichStyleRvActivity extends BaseActivity {
    @BindView(R.id.rv_iv)
    RecyclerView rvIv;
    private DemoAdapter demoAdapter;
    int[] colors = {Color.BLUE, Color.GRAY, Color.GREEN};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rich);
        ButterKnife.bind(this);

        rvIv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        demoAdapter = new DemoAdapter(this);
        rvIv.setAdapter(demoAdapter);
        initData();//填充数据

    }

    private void initData() {
        List<DataModel> list=new ArrayList<DataModel>();
        for (int i = 0; i <= 40; i++) {
            int type = (int) (Math.random() * 3) + 1;
            DataModel dataModel = new DataModel();
            dataModel.setType(type);//设置item类型，模拟不同item
            dataModel.setAvatarColor(colors[type-1]);
            dataModel.setName("name"+i);
            dataModel.setContent("文本"+i);
            dataModel.setContentColor(colors[(type+1)%3]);
            list.add(dataModel);
        }
        demoAdapter.addData(list);
        demoAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
    }
}
