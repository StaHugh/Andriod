package com.example.administrator.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/1/18.
 */
public class SActivity extends Activity {
    private  Button btn;
    private String content = "你好";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sactivity);
        //给第一个页面回传数据
        //回传给第一个页面的是Intent对象
        btn= (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("data",content);
                setResult(2,data);
                //结束当前页面
                finish();
            }
        });
    }
}
