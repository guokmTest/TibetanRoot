package com.guokm.tibetanroot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guokm.tibetanroot.R;

public class PersonInfoActivity extends BaseActivity {


    private RelativeLayout titleLayout;
    private Button back_button;
    private TextView title_text;
    private Button search_button;
    private TextView nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        initView();
    }

    private void initView() {
        titleLayout = (RelativeLayout) findViewById(R.id.title);
        back_button = (Button) titleLayout.findViewById(R.id.back_button);
        title_text = (TextView) titleLayout.findViewById(R.id.title_text);
        search_button = (Button) titleLayout.findViewById(R.id.search_button);
        nickname = (TextView) findViewById(R.id.nickname);
        title_text.setText("个人信息");
        nickname.setText("杨秃驴");
        back_button.setVisibility(View.VISIBLE);
        search_button.setVisibility(View.GONE);
        back_button.setOnClickListener(this);
        nickname.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_button:
                finish();
                break;
            case R.id.nickname:
                Intent i = new Intent(this, ModifyNickActivity.class);
                i.putExtra("nickname", nickname.getText());
                startActivityForResult(i, 1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String s=data.getStringExtra("nickname").toString();
                    Log.e(TAG,s);
                    nickname.setText(data.getStringExtra("nickname"));
                }
                break;
        }
    }
}
