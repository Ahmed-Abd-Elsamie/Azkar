package com.example.root.azkar;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.root.azkar.prayer_settings.TimeClockActivity;
import com.tomer.fadingtextview.FadingTextView;

public class MainActivity extends AppCompatActivity {



    private CardView sabahCard;
    private CardView masaCard;
    private CardView doaaCard;
    private CardView quranCard;
    private CardView tasbehCard;
    private CardView dailyCard;
    private FadingTextView ftv;
    private String [] txts = {"ازكار" , "المسلم" , "اليوميه"};
    private ImageButton btnMenu;
    private ImageButton btnMosque;
    private ImageButton btnCloc;
    private ImageButton btnSettings;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ftv = (FadingTextView) findViewById(R.id.fadingTextView);
        ftv.setTexts(txts);
        */





        new CountDownTimer(4000 , 1000){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {

                setContentView(R.layout.select_zekr);
                sabahCard = (CardView) findViewById(R.id.card_sabah);
                masaCard = (CardView) findViewById(R.id.card_masa);
                doaaCard = (CardView) findViewById(R.id.card_doaa);
                quranCard = (CardView) findViewById(R.id.card_quran);
                dailyCard = (CardView) findViewById(R.id.card_daily);
                tasbehCard = (CardView) findViewById(R.id.card_tasbeh);

                // Nav Bar Items

                btnMenu = (ImageButton) findViewById(R.id.btn_menu);
                btnMosque = (ImageButton) findViewById(R.id.btn_mosque);
                btnCloc = (ImageButton) findViewById(R.id.btn_clock);
                btnSettings = (ImageButton) findViewById(R.id.btn_settings);
                final Animation navbarAnim = AnimationUtils.loadAnimation(MainActivity.this , R.anim.fab_anim);
                //////////////////////////////////
                btnMenu.startAnimation(navbarAnim);
                btnMosque.startAnimation(navbarAnim);
                btnCloc.startAnimation(navbarAnim);
                btnSettings.startAnimation(navbarAnim);


                ////////////
                final Animation itemAnim = AnimationUtils.loadAnimation(MainActivity.this , R.anim.click_anim);


                btnMenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        btnMenu.startAnimation(itemAnim);
                        menuEvent();

                    }
                });


                btnMosque.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        btnMosque.startAnimation(itemAnim);
                        startActivity(new Intent(MainActivity.this , MosqueActivity.class));


                    }
                });


                btnCloc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        btnCloc.startAnimation(itemAnim);
                        startActivity(new Intent(MainActivity.this , TimeClockActivity.class));


                    }
                });


                btnSettings.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        btnSettings.startAnimation(itemAnim);
                        startActivity(new Intent(MainActivity.this , SettingsActivity.class));


                    }
                });




                Animation anim = AnimationUtils.loadAnimation(MainActivity.this , R.anim.fade_in);
                sabahCard.startAnimation(anim);
                masaCard.startAnimation(anim);
                doaaCard.startAnimation(anim);
                quranCard.startAnimation(anim);
                dailyCard.startAnimation(anim);
                tasbehCard.startAnimation(anim);


                sabahCard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        ZekrText.type = "sabah";
                        startActivity(new Intent(MainActivity.this , ZekrActivity.class));

                    }
                });

                masaCard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        ZekrText.type = "masa";
                        startActivity(new Intent(MainActivity.this , ZekrActivity.class));

                    }
                });

                doaaCard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        ZekrText.type = "doaa";
                        startActivity(new Intent(MainActivity.this , ZekrActivity.class));

                    }
                });

                quranCard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        ZekrText.type = "quran";
                        startActivity(new Intent(MainActivity.this , ZekrActivity.class));

                    }
                });

                dailyCard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        ZekrText.type = "daily";
                        startActivity(new Intent(MainActivity.this , ZekrActivity.class));

                    }
                });

                tasbehCard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        ZekrText.type = "tasbeh";
                        startActivity(new Intent(MainActivity.this , ZekrActivity.class));

                    }
                });

            }

        }.start();


    }

    private void menuEvent(){


        final Dialog dialog = new Dialog(this);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_layout , null);
        Button btnAbout = (Button)  view.findViewById(R.id.btn_about);
        Button btnSuggest = (Button) view.findViewById(R.id.btn_suggest);
        Button btnShare = (Button) view.findViewById(R.id.btn_share);
        Button btnFollow = (Button) view.findViewById(R.id.btn_follow);


        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dailogAbout = new Dialog(MainActivity.this);
                dailogAbout.setTitle("عن البرنامج \n  تم تطوير هذا البرنامج بواسطه احمد مصطفي \n  Email : ahmed.a199810@gmail.com");
                dailogAbout.show();

            }
        });

        btnSuggest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();

            }
        });

        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();

            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();

            }
        });

        dialog.setContentView(R.layout.dialog_layout);
        dialog.show();



    }
}