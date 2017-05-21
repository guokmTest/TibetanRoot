package com.guokm.tibetanroot.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guokm.tibetanroot.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageDetailActivity extends BaseActivity {


    @BindView(R.id.back_button)
    Button back_button;
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.freshtime_tv)
    TextView freshtimeTv;
    @BindView(R.id.search_button)
    Button search_button;
    @BindView(R.id.title)
    RelativeLayout titleLayout;
    @BindView(R.id.title_big)
    TextView titleBig;
    @BindView(R.id.text_source)
    TextView textSource;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.other_info)
    TextView otherInfo;
    @BindView(R.id.title_middle)
    TextView titleMiddle;
    @BindView(R.id.title_small)
    TextView titleSmall;
    @BindView(R.id.body_tv)
    TextView bodyTv;

    /*    private RelativeLayout titleLayout;
    private Button back_button;
    private TextView title_text;
    private Button search_button;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);
        ButterKnife.bind(this);
        initView();
    }


    private void initView() {
//        getData(page);
/*        titleLayout = (RelativeLayout) findViewById(R.id.title);
        back_button = (Button) titleLayout.findViewById(R.id.back_button);
        title_text = (TextView) titleLayout.findViewById(R.id.title_text);
        search_button = (Button) titleLayout.findViewById(R.id.search_button);*/
        title_text.setText("消息详情");
        back_button.setVisibility(View.VISIBLE);
        search_button.setVisibility(View.GONE);
        titleBig.setText(getIntent().getExtras().getString("title"));

    }

    @OnClick(R.id.back_button)
    void onClickaa(View view) {
        //返回键点击事件
        this.finish();
    }


}
