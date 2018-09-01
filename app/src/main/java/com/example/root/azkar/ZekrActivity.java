package com.example.root.azkar;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class ZekrActivity extends AppCompatActivity {

    private String [] zekr;
    private String [] proof;
    private String [] counter;


    private TextView txtTitle;
    private TextView txtZekr;
    private TextView txtProof;
    private LinearLayout cardViewZekr;
    private int index = 0;
    private Button btnCount;
    private ZekrText zekrText;
    private ScrollView scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zekr);

        // Assign Views

        txtTitle = (TextView) findViewById(R.id.zekr_type);
        txtZekr = (TextView) findViewById(R.id.txt_zekr);
        cardViewZekr = (LinearLayout) findViewById(R.id.cardZekr);
        btnCount = (Button) findViewById(R.id.btn_count);
        txtProof = (TextView) findViewById(R.id.txt_zekr_proof);
        scrollView = (ScrollView) findViewById(R.id.scrool);
        zekrText = new ZekrText();



        if (ZekrText.type.equals("sabah")){

            zekr = zekrText.getSabah();
            txtTitle.setText("ازكار الصباح");
            txtZekr.setText(zekr[0]);
            proof = zekrText.getProofs();
            txtProof.setText(proof[0]);
            counter = zekrText.getSabahCounter();
            btnCount.setText(counter[0]);


        }
       if (ZekrText.type.equals("masa")){

           zekr = zekrText.getMasa();
           txtTitle.setText("ازكار المساء");
           txtZekr.setText(zekr[0]);
           proof = zekrText.getProofsMasa();
           txtProof.setText(proof[0]);
           counter = zekrText.getMasaCounter();
           btnCount.setText(counter[0]);

        }
        if (ZekrText.type.equals("quran")){

            setContentView(R.layout.test);

        }
        if (ZekrText.type.equals("doaa")){

            setContentView(R.layout.test);


        }
        if (ZekrText.type.equals("daily")){

            setContentView(R.layout.test);


        }
        if (ZekrText.type.equals("tasbeh")){

            setContentView(R.layout.test);


        }





        cardViewZekr.setOnTouchListener(new OnSwipeTouchListener(ZekrActivity.this){


            @Override
            public void onSwipeLeft() {
                //Toast.makeText(ZekrActivity.this, "Left", Toast.LENGTH_SHORT).show();
                Animation hyperspaceJump = AnimationUtils.loadAnimation(ZekrActivity.this, R.anim.slide_in_right);
                txtZekr.startAnimation(hyperspaceJump);
                // change text

                ChangeTextRight();


            }

            @Override
            public void onSwipeRight() {
                //Toast.makeText(ZekrActivity.this, "Right", Toast.LENGTH_SHORT).show();
                Animation hyperspaceJump = AnimationUtils.loadAnimation(ZekrActivity.this, R.anim.slide_in_left);
                txtZekr.startAnimation(hyperspaceJump);
                // change text

                ChangeTextLeft();
            }

        });

        txtZekr.setOnTouchListener(new OnSwipeTouchListener(ZekrActivity.this){


            @Override
            public void onSwipeLeft() {
                //Toast.makeText(ZekrActivity.this, "Left", Toast.LENGTH_SHORT).show();
                Animation hyperspaceJump = AnimationUtils.loadAnimation(ZekrActivity.this, R.anim.slide_in_right);
                txtZekr.startAnimation(hyperspaceJump);
                // change text

                ChangeTextRight();


            }

            @Override
            public void onSwipeRight() {
                //Toast.makeText(ZekrActivity.this, "Right", Toast.LENGTH_SHORT).show();
                Animation hyperspaceJump = AnimationUtils.loadAnimation(ZekrActivity.this, R.anim.slide_in_left);
                txtZekr.startAnimation(hyperspaceJump);
                // change text

                ChangeTextLeft();
            }

        });

        txtProof.setOnTouchListener(new OnSwipeTouchListener(ZekrActivity.this){


            @Override
            public void onSwipeLeft() {
                //Toast.makeText(ZekrActivity.this, "Left", Toast.LENGTH_SHORT).show();
                Animation hyperspaceJump = AnimationUtils.loadAnimation(ZekrActivity.this, R.anim.slide_in_right);
                txtZekr.startAnimation(hyperspaceJump);
                // change text

                ChangeTextRight();


            }

            @Override
            public void onSwipeRight() {
                //Toast.makeText(ZekrActivity.this, "Right", Toast.LENGTH_SHORT).show();
                Animation hyperspaceJump = AnimationUtils.loadAnimation(ZekrActivity.this, R.anim.slide_in_left);
                txtZekr.startAnimation(hyperspaceJump);
                // change text

                ChangeTextLeft();
            }

        });

        scrollView.setOnTouchListener(new OnSwipeTouchListener(ZekrActivity.this){


            @Override
            public void onSwipeLeft() {
                //Toast.makeText(ZekrActivity.this, "Left", Toast.LENGTH_SHORT).show();
                Animation hyperspaceJump = AnimationUtils.loadAnimation(ZekrActivity.this, R.anim.slide_in_right);
                txtZekr.startAnimation(hyperspaceJump);
                // change text

                ChangeTextRight();


            }

            @Override
            public void onSwipeRight() {
                //Toast.makeText(ZekrActivity.this, "Right", Toast.LENGTH_SHORT).show();
                Animation hyperspaceJump = AnimationUtils.loadAnimation(ZekrActivity.this, R.anim.slide_in_left);
                txtZekr.startAnimation(hyperspaceJump);
                // change text

                ChangeTextLeft();
            }

        });


        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = 0;
                if (btnCount.getText().toString().equals("تم")){
                    btnCount.setEnabled(false);
                }else {
                    i = Integer.parseInt(btnCount.getText().toString());
                    btnCount.setEnabled(true);
                }

                if (i - 1 != 0){
                    if (!btnCount.getText().toString().equals("تم")) {
                        i--;
                        btnCount.setText(i + "");
                    }
                }else {
                    btnCount.setText("تم");
                    btnCount.setEnabled(false);
                    counter[index] = "تم";
                    zekrText.setSabahCounter(counter);
                }


            }
        });


    }

    private void ChangeTextLeft() {

        if (index == zekr.length - 1){

        }else {

            btnCount.setEnabled(true);
            index++;
            txtZekr.setText(zekr[index]);
            txtProof.setText(proof[index]);
            btnCount.setText(counter[index]);

        }


    }
    private void ChangeTextRight() {
        if (index == 0) {


        }else {

                btnCount.setEnabled(true);
                index--;
                txtZekr.setText(zekr[index]);
                txtProof.setText(proof[index]);
                btnCount.setText(counter[index]);

        }


    }

}
