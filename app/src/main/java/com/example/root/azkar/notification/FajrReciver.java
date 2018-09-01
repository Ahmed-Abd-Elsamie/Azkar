package com.example.root.azkar.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.root.azkar.MosqueActivity;

/**
 * Created by root on 01/09/18.
 */

public class FajrReciver  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent OpenIntent = new Intent(context , MosqueActivity.class);
        OpenIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        NewMessageNotification newMessageNotification = new NewMessageNotification();
        newMessageNotification.notify(context , "حان الآن موعد اذان الفجر" , 100 , "صلاه الفجر");

    }

}
