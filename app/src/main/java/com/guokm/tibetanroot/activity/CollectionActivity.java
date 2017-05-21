package com.guokm.tibetanroot.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.guokm.tibetanroot.R;
import com.guokm.tibetanroot.adapter.TopicsItemAdapter;
import com.guokm.tibetanroot.domain.Collection;
import com.guokm.tibetanroot.domain.Topic;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class CollectionActivity extends BaseActivity {


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
    @BindView(R.id.message_lv)
    ListView messageLv;
    private List<Collection> itemList= new ArrayList<Collection>();
    private PtrClassicFrameLayout ptrFrame_message;
    /*    private RelativeLayout titleLayout;
    private Button back_button;
    private TextView title_text;
    private Button search_button;*/
    int page=0;
    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        initView();
       ;
    }



    private void initView() {
//        getData(page);
/*        titleLayout = (RelativeLayout) findViewById(R.id.title);
        back_button = (Button) titleLayout.findViewById(R.id.back_button);
        title_text = (TextView) titleLayout.findViewById(R.id.title_text);
        search_button = (Button) titleLayout.findViewById(R.id.search_button);*/
        title_text.setText("我的收藏");
        back_button.setVisibility(View.VISIBLE);
        search_button.setVisibility(View.GONE);
        final TopicsItemAdapter adapter=new TopicsItemAdapter(this,itemList);
        messageLv.setAdapter(adapter);
        ptrFrame_message = (PtrClassicFrameLayout) findViewById(R.id.message_list_view_frame);
        ptrFrame_message.setAutoLoadMoreEnable(true);//自动下载下一页，不用点击"记载下一页的条目"
        ptrFrame_message.postDelayed(new Runnable() {//自动刷新
            @Override
            public void run() {
                ptrFrame_message.autoRefresh(true);
            }
        }, 150);
        ptrFrame_message.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                //该方法中访问请求第一次数据的接口返回的数据（可能是第一页数据）
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page = 0;
                        itemList.clear();
                        getData(page);
                        adapter.notifyDataSetChanged();
                        ptrFrame_message.refreshComplete();
                        page++;
                        if (!ptrFrame_message.isLoadMoreEnable()) {
                            ptrFrame_message.setLoadMoreEnable(true);
                        }
                    }
                }, 1500);
            }
        });
        ptrFrame_message.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                //该方法请求第二/三/四。。。   的数据，来展示下一页。----后台分页数据加载
                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        getData(page);
//                        itemList.add(new String("  ListView item  - add " + page));
                        adapter.notifyDataSetChanged();
                        ptrFrame_message.loadMoreComplete(true);
                        Toast.makeText(CollectionActivity.this, "第"+page+"页加载完毕", Toast.LENGTH_SHORT)
                                .show();
                        if (page == 1) {
                            //当为第五页时，停止加载更多
                            //set load more disable
                            ptrFrame_message.setLoadMoreEnable(false);
                            Toast.makeText(CollectionActivity.this, "已经全部加载完毕", Toast.LENGTH_SHORT)
                                    .show();
                        }
                        page++;


                    }
                }, 1000);
            }
        });
    }
    @OnItemClick(R.id.message_lv)
    void OnItemClick(AdapterView<?> adapterView, View view, int position, long l){
        //listview item的点击事件
//        Intent intent=new Intent(TopicActivity.this,MessageDetailActivity.class);
//        Bundle bundle=new Bundle();
//        bundle.putString("title",itemList.get(position).getTitle());
//        intent.putExtras(bundle);
//        startActivity(intent);
//        Toast.makeText(MessageActivity.this,itemList.get(position).toString(),Toast.LENGTH_SHORT).show();


    }

    @OnClick(R.id.back_button)
    void onClickaa(View view)  {
        //返回键点击事件
        this.finish();
    }

    /**
     * 造假数据
     */
    public void getData(int page){

        for (int i=1;i<21;i++){
            itemList.add(new Collection("郭大大","我是"+i+"只徐达灰会挥发"+page,"imageurl"));
        }
    }
}
