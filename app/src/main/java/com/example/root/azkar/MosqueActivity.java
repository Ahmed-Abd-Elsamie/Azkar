package com.example.root.azkar;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.example.root.azkar.notification.IServices;
import com.example.root.azkar.notification.NewMessageNotification;
import com.example.root.azkar.notification.NotificationReciver;
import com.example.root.azkar.prayer_settings.TimeClockActivity;

import java.util.Calendar;

public class MosqueActivity extends AppCompatActivity {



    private Button btnsearch;
    private Button btnAzanState;
    //private Switch AzanSwitch;
    private Button btnAzanType;
    private SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mosque);
        sharedPreferences = getApplicationContext().getSharedPreferences("azan_state" , MODE_PRIVATE);

        btnsearch = (Button) findViewById(R.id.btnSearch);
        btnAzanType = (Button) findViewById(R.id.btnAzan);
        btnAzanState = (Button) findViewById(R.id.azan_state);

        //AzanSwitch = (Switch) findViewById(R.id.turn_azan);


        // switch button state
        checkState();


        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

      /* AzanSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (retriveData().equals("on")){
                    stopService(new Intent(MosqueActivity.this , IServices.class));
                    AzanSwitch.setText("تشغيل الاذان");
                    saveData("off");
                }else {
                    startService(new Intent(MosqueActivity.this , IServices.class));
                    AzanSwitch.setText("ايقاف الاذان");
                    saveData("on");

                }


            }
        });

        */

        btnAzanState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AzanDialogState();
            }
        });

        btnAzanType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Show select azan type Dialog
                AzanDialog();

            }
        });


    }

    private void checkState() {

        if (retriveData().equals("on")){
            btnAzanState.setText("حاله الاذان  : " + "مفعل");

        }else {
            btnAzanState.setText("حاله الاذان  : " + "ايقاف");

        }
    }

    private void AzanDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MosqueActivity.this);
        builder.setTitle("اختر الصوت");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MosqueActivity.this , android.R.layout.select_dialog_singlechoice);
        arrayAdapter.add("أذآن مصر");
        arrayAdapter.add("أذآن الحرم المكي");
        arrayAdapter.add("أذآن الحرم المدني");
        arrayAdapter.add("أذآن باكستان");


        builder.setNegativeButton("الغاء", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();
            }
        });

        builder.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                btnAzanType.setText(arrayAdapter.getItem(i).toString());

            }
        });

        builder.show();

    }

    private void saveData(String state){

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("azan_state" , state);
        editor.apply();

    }

    private String retriveData(){

        return sharedPreferences.getString("azan_state" , null);
    }


    private void AzanDialogState() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MosqueActivity.this);
        builder.setTitle("تشغيل / ايقاف");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MosqueActivity.this , android.R.layout.simple_expandable_list_item_1);
        arrayAdapter.add("مفعل");
        arrayAdapter.add("ايقاف");



        builder.setNegativeButton("الغاء", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();
            }
        });

        builder.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                btnAzanState.setText("حاله الاذان  : " + arrayAdapter.getItem(i).toString());
                if (i == 0){
                    saveData("on");
                    startService(new Intent(MosqueActivity.this , IServices.class));
                    Toast.makeText(MosqueActivity.this, "تم تشغيل الاذان", Toast.LENGTH_SHORT).show();

                }else if (i == 1){
                    saveData("off");
                    stopService(new Intent(MosqueActivity.this , IServices.class));
                    Toast.makeText(MosqueActivity.this, "تم ايقاف الاذان", Toast.LENGTH_SHORT).show();

                }
            }
        });

        builder.show();

    }


}
