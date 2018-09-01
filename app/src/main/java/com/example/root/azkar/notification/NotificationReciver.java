package com.example.root.azkar.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.example.root.azkar.MosqueActivity;
import com.example.root.azkar.R;

/**
 * Created by root on 23/08/18.
 */

public class NotificationReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent OpenIntent = new Intent(context , MosqueActivity.class);
        OpenIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context , 100 , OpenIntent , PendingIntent.FLAG_CANCEL_CURRENT);

        /*Notification.Builder builder = new Notification.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.mosque)
                .setContentTitle("لقد حان الآن موعد الصلاه")
                .setContentText("")
                .setSound(Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.azan))
                .setAutoCancel(false);



        notificationManager.notify(100 , builder.build());
        */

        NewMessageNotification newMessageNotification = new NewMessageNotification();

        newMessageNotification.notify(context , "حان الآن موعد اذان الفجر" , 100 , "صلاه الفجر");
        newMessageNotification.notify(context , "حان الآن موعد اذان الظهر" , 101 , "صلاه الظهر");
        newMessageNotification.notify(context , "حان الآن موعد اذان العصر" , 102 , "صلاه العصر");
        newMessageNotification.notify(context , "حان الآن موعد اذان المغرب" , 103 , "صلاه المغرب");
        newMessageNotification.notify(context , "حان الآن موعد اذان العشاء" , 104 , "صلاه العشاء");
        newMessageNotification.notify(context , "حان الآن موعد الشروق" , 105 , "صلاه الضحي");



    }


}
