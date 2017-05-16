package com.example.administrator.myapplication.resultservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

/**
 * Created by Administrator on 2017/5/16.
 */

public class MyResultService extends IntentService {

    public MyResultService(){
        super("resultservice");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(intent!=null){
               String value=intent.getStringExtra("myRskey");
            ResultReceiver receiver=(ResultReceiver)intent.getExtras().get("myReceiver");
            System.out.println("#"+value);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Bundle bundle=new Bundle();
            bundle.putString("myKey","这是Service返回的信息");
            receiver.send(0x120,bundle);
        }

    }
}
