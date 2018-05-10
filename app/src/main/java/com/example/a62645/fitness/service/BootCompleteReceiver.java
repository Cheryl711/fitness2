package com.example.a62645.fitness.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 开机完成广播
 * Created by lenovo on 2017/1/5.
 */

public class BootCompleteReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent){
        Intent i=new Intent(context, com.step.pedometer.mystep.service.StepService.class);
        context.startService(i);
    }
}
