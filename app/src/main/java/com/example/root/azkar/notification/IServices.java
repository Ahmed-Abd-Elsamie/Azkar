package com.example.root.azkar.notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.Calendar;

public class IServices extends Service {

    MediaPlayer mediaPlayer;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        FajrAlarm();
        DhuhrAlarm();
        AsrAlarm();
        MaghribAlarm();
        IshaAlarm();

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        mediaPlayer.stop();
    }




    private void FajrAlarm(){


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY , 4);
        calendar.set(Calendar.MINUTE , 3);
        calendar.set(Calendar.SECOND , 0);

        Intent intent = new Intent(getApplicationContext() , FajrReciver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext() , 100 , intent , PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP , calendar.getTimeInMillis() , AlarmManager.INTERVAL_DAY , pendingIntent);



    }



    private void ShoroqAlarm(){


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY , 6);
        calendar.set(Calendar.MINUTE , 27);
        calendar.set(Calendar.SECOND , 0);

        Intent intent = new Intent(getApplicationContext() , NotificationReciver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext() , 100 , intent , PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP , calendar.getTimeInMillis() , AlarmManager.INTERVAL_DAY , pendingIntent);



    }



    private void DhuhrAlarm(){


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY , 11);
        calendar.set(Calendar.MINUTE , 56);
        calendar.set(Calendar.SECOND , 0);

        Intent intent = new Intent(getApplicationContext() , DauhurReciver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext() , 101 , intent , PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP , calendar.getTimeInMillis() , AlarmManager.INTERVAL_DAY , pendingIntent);



    }


    private void AsrAlarm(){


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY , 15);
        calendar.set(Calendar.MINUTE , 30);
        calendar.set(Calendar.SECOND , 0);

        Intent intent = new Intent(getApplicationContext() , AsrReciver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext() , 102 , intent , PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP , calendar.getTimeInMillis() , AlarmManager.INTERVAL_DAY , pendingIntent);



    }


    private void MaghribAlarm(){


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY , 18);
        calendar.set(Calendar.MINUTE , 19);
        calendar.set(Calendar.SECOND , 0);

        Intent intent = new Intent(getApplicationContext() , MaghribReciver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext() , 103 , intent , PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP , calendar.getTimeInMillis() , AlarmManager.INTERVAL_DAY , pendingIntent);



    }



    private void IshaAlarm(){


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY , 19);
        calendar.set(Calendar.MINUTE , 39);
        calendar.set(Calendar.SECOND , 0);


        Intent intent = new Intent(getApplicationContext() , IshaReciver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext() , 104 , intent , PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP , calendar.getTimeInMillis() , AlarmManager.INTERVAL_DAY , pendingIntent);


    }

}

