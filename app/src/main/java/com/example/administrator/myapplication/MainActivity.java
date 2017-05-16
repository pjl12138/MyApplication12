package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.myapplication.resultservice.MyResultService;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startService(View view){
        Intent intent=new Intent(this, MyResultService.class);
        intent.putExtra("myRskey","resultservice");
        intent.putExtra("myReceiver",receiver);
        startService(intent);
    }
    private ResultReceiver receiver = new ResultReceiver(new Handler())
    {
        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);
            if(resultCode==0x120&&resultData!=null){
                Toast.makeText(MainActivity.this,resultData.getString("myKey","获取消息失败！"), Toast.LENGTH_SHORT).show();
            }
        }
    };
}
