package com.example.administrator.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/1/18.
 */
public class FAcitivity extends Activity {
    private Button  btn1;
    private Button  btn2;
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facitivity);

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        txt = (TextView) findViewById(R.id.textView);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //�����Ķ���
                //Ŀ���ļ�
                Intent intent = new Intent(FAcitivity.this,SActivity.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FAcitivity.this,SActivity.class);
                //�����Ķ���
                //����ı�־
                startActivityForResult(intent,1);
            }
        });
    }
    //ͨ��startActivityForResult��ת�����ܷ������ݵķ���
    //requestCode :�Ǹ���ת�ı�־
    //resultCode ���ڶ���ҳ�淵�صı�־
    //data:�ڶ���ҳ��ش�������
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2){
            String content = data.getStringExtra("data");
            txt.setText("�ж���");
        }
    }
}
