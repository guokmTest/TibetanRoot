package com.guokm.tibetanroot.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.guokm.tibetanroot.R;
import com.guokm.tibetanroot.TestJsonData;
import com.guokm.tibetanroot.activity.MessageActivity;
import com.guokm.tibetanroot.adapter.MessageItemAdapter;
import com.guokm.tibetanroot.adapter.SubjectItemAdapter;
import com.guokm.tibetanroot.domain.MessageItem;
import com.guokm.tibetanroot.domain.Subject;
import com.orhanobut.logger.Logger;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/5/18.
 */

public class SubjectFragment extends BaseFragment {
    @BindView(R.id.subject_lv)
    ListView subjectLv;
    Unbinder unbinder;
    @BindView(R.id.message_list_view_frame)
    PtrClassicFrameLayout messageListViewFrame;
    private List<Subject> itemList = new ArrayList<Subject>();
    //    int page=0;
    Handler handler = new Handler();

    public static SubjectFragment newInstance(String param1) {
        SubjectFragment fragment = new SubjectFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public SubjectFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subject, container, false);
        Bundle bundle = getArguments();
        String agrs1 = bundle.getString("agrs1");
/*        TextView tv = (TextView)view.findViewById(R.id.tv);
        tv.setText(agrs1);*/
        unbinder = ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//initView(view);
    }



    private void initView(View view) {

        final SubjectItemAdapter adapter = new SubjectItemAdapter(getActivity(), itemList);
        subjectLv.setAdapter(adapter);
        messageListViewFrame = (PtrClassicFrameLayout) view.findViewById(R.id.message_list_view_frame);
        messageListViewFrame.setAutoLoadMoreEnable(false);
        messageListViewFrame.postDelayed(new Runnable() {//自动刷新
            @Override
            public void run() {
                if (unbinder == null) {
                    return;
                }
                messageListViewFrame.autoRefresh(true);
            }
        }, 150);
        messageListViewFrame.setPtrHandler(new PtrDefaultHandler() {
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
//                            page = 0;
                        itemList.clear();
//                            getData(page);
                        getData();
                        adapter.notifyDataSetChanged();
                        if (unbinder == null) {
                            //防止注入解绑后找不到控件
                            return;
                        }
                        messageListViewFrame.refreshComplete();
//                            page++;
                        if (!messageListViewFrame.isLoadMoreEnable()) {
                            messageListViewFrame.setLoadMoreEnable(true);
                        }
                    }
                }, 1500);
            }
        });
        messageListViewFrame.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                //该方法请求第二/三/四。。。   的数据，来展示下一页。----后台分页数据加载
                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        getData();
//                            getData(page);
//                        itemList.add(new String("  ListView item  - add " + page));
                        adapter.notifyDataSetChanged();
                        if (unbinder == null) {
                            return;
                        }
                        messageListViewFrame.loadMoreComplete(true);
//                            Toast.makeText(getActivity(), "第"+page+"页加载完毕", Toast.LENGTH_SHORT)
//                                    .show();
//                            if (page == 1) {
                        //set load more disable
                        messageListViewFrame.setLoadMoreEnable(false);
                        Toast.makeText(getActivity(), "已经全部加载完毕", Toast.LENGTH_SHORT)
                                .show();
//                            }
//                            page++;


                    }
                }, 1000);
            }
        });
    }


    /**
     * 造假数据
     */
//    public void getData(int page){
    public void getData() {
//        String responseText = response.body().string();
        String responseText = TestJsonData.testJson;
        Gson gson = new Gson();
        List<Subject> list = gson.fromJson(responseText, new TypeToken<List<Subject>>() {
        }.getType());
        Logger.i("" + list.size());
        itemList.addAll(list);
//
//
//        for (int i=1;i<21;i++){
//            itemList.add(new MessageItem("这是标题"+i,"2017-08-22"+"第"+(page)));
//        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        unbinder = null;
    }

    @OnItemClick(R.id.subject_lv)
    public void onViewClicked() {
    }
}
