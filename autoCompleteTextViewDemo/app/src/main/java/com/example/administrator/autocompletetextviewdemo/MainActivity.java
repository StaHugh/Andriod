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

        //��һ����ʼ���ؼ�
        acTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        //�ڶ�������Ҫ����������������������
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,res);
        //3.��ʼ������Դ
        //4.��adapter �� acTextview ��
        acTextView.setAdapter(adapter);


        //��Ҫ���÷ָ���
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
