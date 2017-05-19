package com.guokm.tibetanroot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guokm.tibetanroot.R;

public class ModifyNickActivity extends BaseActivity {

    private RelativeLayout titleLayout;
    private Button back_button;
    private TextView title_text;
    private Button search_button;
    private TextView nickname;
    private EditText nickname_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifynickname);
        initView();
    }

    private void initView() {
        titleLayout = (RelativeLayout) findViewById(R.id.title);
        back_button = (Button) titleLayout.findViewById(R.id.back_button);
        title_text = (TextView) titleLayout.findViewById(R.id.title_text);
        search_button = (Button) titleLayout.findViewById(R.id.search_button);
        nickname_et = (EditText) findViewById(R.id.nickname_et);
        nickname_et.setText(getIntent().getStringExtra("nickname"));
        title_text.setText("更改名字");
        back_button.setVisibility(View.VISIBLE);
        search_button.setVisibility(View.VISIBLE);
        back_button.setOnClickListener(ModifyNickActivity.this);
        nickname_et.setOnClickListener(ModifyNickActivity.this);
        search_button.setOnClickListener(ModifyNickActivity.this);

        Intent i=getIntent();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_button:
                finish();
                break;
            case R.id.search_button:
                //执行保存（网络请求），网络返回修改成功返回200，关闭finish此活动，且将该名称回传给个人信息页面，可以put，也可以result
                Intent intent=new Intent();
                intent.putExtra("nickname",nickname_et.getText().toString());
                Log.e(TAG,nickname_et.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
                break;
        }
    }
}
