package com.example.administrator.notificationdemo;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener{
    NotificationManager manager;//通知控制类
    int notification_id;
    private Button bt1;
    private Button bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1= (Button) findViewById(R.id.button1);
        bt2= (Button) findViewById(R.id.button2);
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        bt1.setOnClickListener((View.OnClickListener) this);
        bt2.setOnClickListener((View.OnClickListener) this);


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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.button1:
                sendNotification();
                break;
            case  R.id.button2:
                manager.cancel(notification_id);
                break;
        }
    }

    //构造Notification并发送到通知栏
    private void sendNotification(){
        Intent intent = new Intent(this,MainActivity.class);
        Intent[] ainten={intent};
        PendingIntent pintent = PendingIntent.getActivities(this,0,ainten,0);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker("hello");//
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle("通知栏通知标题");
        builder.setContentText("我来Notification");
        builder.setContentIntent(pintent);//
        builder.setDefaults(Notification.DEFAULT_SOUND);
        builder.setDefaults(Notification.DEFAULT_VIBRATE);
        builder.setDefaults(Notification.DEFAULT_LIGHTS);

        Notification notification = builder.build();//4.1及以上
        manager.notify(notification_id,notification);
    }
}
