package com.example.administrator.autocompletetextviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;


public class MainActivity extends Activity {

    private AutoCompleteTextView acTextView;
    private  String[] res ={"beijing1","bejing2","beijing3","shanghai","wuhan"};

    private MultiAutoCompleteTextView macTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //第一步初始化控件
        acTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        //第二步：需要适配器，来适配输入内容
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,res);
        //3.初始化数据源
        //4.将adapter 与 acTextview 绑定
        acTextView.setAdapter(adapter);


        //需要设置分隔符
        macTextView = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
        macTextView.setAdapter(adapter);
        macTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
