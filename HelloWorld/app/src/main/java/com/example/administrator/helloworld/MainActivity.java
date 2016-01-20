package com.example.administrator.helloworld;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private ViewGroup viewGroup;
    private TextView  textView;
    private ImageView imageView,imageView2,imageView3;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewGroup = (ViewGroup)findViewById(R.id.view_group);
        textView = (TextView)findViewById(R.id.textView);
        textView.setText("Animation demo");

        imageView = (ImageView)findViewById(R.id.imageView);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        imageView3 = (ImageView)findViewById(R.id.imageView3);

        button = (Button)findViewById(R.id.button);
        button.setText("OK");
        button.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View V){
                toggle(textView,imageView,imageView2,imageView3);
            }
        }

        );

    }

    public static void toggle(View... views){
        for (View v : views){
            boolean isVisible = v.getVisibility() == View.VISIBLE;
            v.setVisibility(isVisible ? View.INVISIBLE : View.VISIBLE);
        }
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
