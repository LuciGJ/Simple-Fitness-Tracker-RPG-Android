package com.example.mainapp.ui;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mainapp.R;
import com.example.mainapp.data.DataSource;

public class MuscleStats extends AppCompatActivity {
    private int rightbiceps;
    private int leftbiceps;
    private int rightforearm;
    private int leftforearm;
    private int chest;
    private int shoulders;
    private int neck;
    private int rightthigh;
    private int leftthigh;
    private int rightcalf;
    private int leftcalf;
    private int waist;
    private int hips;
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(MuscleStats.this, NavigationActivity.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_stats);
        SharedPreferences pref = DataSource.getInstance(this);
        SharedPreferences.Editor editor = pref.edit();
         rightbiceps=pref.getInt("rightbiceps",0);
         leftbiceps=pref.getInt("leftbiceps",0);
        rightforearm=pref.getInt("rightforearm",0);
         leftforearm=pref.getInt("leftforearm",0);
        chest=pref.getInt("chest",0);
        shoulders=pref.getInt("shoulders",0);
        neck=pref.getInt("neck",0);
        rightthigh=pref.getInt("rightthigh",0);
        leftthigh=pref.getInt("leftthigh",0);
        rightcalf=pref.getInt("rightcalf",0);
        leftcalf=pref.getInt("leftcalf",0);
        waist=pref.getInt("waist",0);
         hips=pref.getInt("hips",0);
        TextView rightbicepsdisplay = (TextView) findViewById(R.id.rightbiceps);
        rightbicepsdisplay.setText("Right Biceps: "+ rightbiceps);
        TextView leftbicepsdisplay = (TextView) findViewById(R.id.leftbiceps);
        leftbicepsdisplay.setText("Left Biceps: "+ leftbiceps);
        TextView rightforearmdisplay = (TextView) findViewById(R.id.rightforearm);
        rightforearmdisplay.setText("Right Forearm: "+ rightforearm);
        TextView leftforearmdisplay = (TextView) findViewById(R.id.leftforearm);
        leftforearmdisplay.setText("Left Forearm: "+ leftforearm);
        TextView chestdisplay = (TextView) findViewById(R.id.chest);
        chestdisplay.setText("Chest: "+ chest);
        TextView shouldersdisplay = (TextView) findViewById(R.id.shoulders);
        shouldersdisplay.setText("Shoulders: "+ shoulders);
        TextView neckdisplay = (TextView) findViewById(R.id.neck);
        neckdisplay.setText("Neck: "+ neck);
        TextView rightthighdisplay = (TextView) findViewById(R.id.rightthigh);
        rightthighdisplay.setText("Right Thigh: "+ rightthigh);
        TextView leftthighdisplay = (TextView) findViewById(R.id.leftthigh);
        leftthighdisplay.setText("Left Thigh: "+ leftthigh);
        TextView rightcalfdisplay = (TextView) findViewById(R.id.rightcalf);
        rightcalfdisplay.setText("Right Calf: "+ rightcalf);
        TextView leftcalfdisplay = (TextView) findViewById(R.id.leftcalf);
        leftcalfdisplay.setText("Left Calf: "+ leftcalf);
        TextView waistdisplay = (TextView) findViewById(R.id.waist);
        waistdisplay.setText("Waist: "+ waist);
        TextView hipsdisplay = (TextView) findViewById(R.id.hips);
        hipsdisplay.setText("Hips: "+ hips);
        ImageButton rightbicepsup;
        rightbicepsup = (ImageButton) findViewById(R.id.rightbicepsup);

        rightbicepsup.setOnClickListener(view -> {

            rightbiceps=rightbiceps+1;
            editor.putInt("rightbiceps",rightbiceps);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton rightbicepsdown;
        rightbicepsdown = (ImageButton) findViewById(R.id.rightbicepsdown);

        rightbicepsdown.setOnClickListener(view -> {

            rightbiceps=rightbiceps-1;
            editor.putInt("rightbiceps",rightbiceps);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton leftbicepsdown;
        leftbicepsdown = (ImageButton) findViewById(R.id.leftbicepsdown);

        leftbicepsdown.setOnClickListener(view -> {

            leftbiceps=leftbiceps-1;
            editor.putInt("leftbiceps",leftbiceps);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton leftbicepsup;
        leftbicepsup = (ImageButton) findViewById(R.id.leftbicepsup);

        leftbicepsup.setOnClickListener(view -> {

            leftbiceps=leftbiceps+1;
            editor.putInt("leftbiceps",leftbiceps);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton rightforearmup;
        rightforearmup = (ImageButton) findViewById(R.id.rightforearmup);

        rightforearmup.setOnClickListener(view -> {

            rightforearm=rightforearm+1;
            editor.putInt("rightforearm",rightforearm);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton rightforearmdown;
        rightforearmdown = (ImageButton) findViewById(R.id.rightforearmdown);

        rightforearmdown.setOnClickListener(view -> {

            rightforearm=rightforearm-1;
            editor.putInt("rightforearm",rightforearm);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton leftforearmup;
        leftforearmup = (ImageButton) findViewById(R.id.leftforearmup);

        leftforearmup.setOnClickListener(view -> {

            leftforearm=leftforearm+1;
            editor.putInt("leftforearm",leftforearm);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton leftforearmdown;
        leftforearmdown = (ImageButton) findViewById(R.id.leftforearmdown);

        leftforearmdown.setOnClickListener(view -> {

            leftforearm=leftforearm-1;
            editor.putInt("leftforearm",leftforearm);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton chestdown;
        chestdown = (ImageButton) findViewById(R.id.chestdown);

        chestdown.setOnClickListener(view -> {

            chest=chest-1;
            editor.putInt("chest",chest);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton chestup;
        chestup = (ImageButton) findViewById(R.id.chestup);

        chestup.setOnClickListener(view -> {

            chest=chest+1;
            editor.putInt("chest",chest);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton rightcalfdown;
        rightcalfdown = (ImageButton) findViewById(R.id.rightcalfdown);

        rightcalfdown.setOnClickListener(view -> {

            rightcalf=rightcalf-1;
            editor.putInt("rightcalf",rightcalf);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton rightcalfup;
        rightcalfup = (ImageButton) findViewById(R.id.rightcalfup);

        rightcalfup.setOnClickListener(view -> {

            rightcalf=rightcalf+1;
            editor.putInt("rightcalf",rightcalf);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton leftcalfdown;
        leftcalfdown = (ImageButton) findViewById(R.id.leftcalfdown);

        leftcalfdown.setOnClickListener(view -> {

            leftcalf=leftcalf-1;
            editor.putInt("leftcalf",leftcalf);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton leftcalfup;
        leftcalfup = (ImageButton) findViewById(R.id.leftcalfup);

        leftcalfup.setOnClickListener(view -> {

            leftcalf=leftcalf+1;
            editor.putInt("leftcalf",leftcalf);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton neckdown;
        neckdown = (ImageButton) findViewById(R.id.neckdown);

        neckdown.setOnClickListener(view -> {

            neck=neck-1;
            editor.putInt("neck",neck);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton neckup;
        neckup = (ImageButton) findViewById(R.id.neckup);

        neckup.setOnClickListener(view -> {

            neck=neck+1;
            editor.putInt("neck",neck);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton waistdown;
        waistdown = (ImageButton) findViewById(R.id.waistdown2);

        waistdown.setOnClickListener(view -> {

            waist=waist-1;
            editor.putInt("waist",waist);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton waistup;
        waistup = (ImageButton) findViewById(R.id.waistup2);

        waistup.setOnClickListener(view -> {

            waist=waist+1;
            editor.putInt("waist",waist);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton hipsdown;
        hipsdown = (ImageButton) findViewById(R.id.hipsdown);

        hipsdown.setOnClickListener(view -> {

            hips=hips-1;
            editor.putInt("hips",hips);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton hipsup;
        hipsup = (ImageButton) findViewById(R.id.hipsup);

        hipsup.setOnClickListener(view -> {

            hips=hips+1;
            editor.putInt("hips",hips);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton rightthighdown;
        rightthighdown = (ImageButton) findViewById(R.id.rightthighdown);

        rightthighdown.setOnClickListener(view -> {

            rightthigh=rightthigh-1;
            editor.putInt("rightthigh",rightthigh);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton rightthighup;
        rightthighup = (ImageButton) findViewById(R.id.rightthighup);

        rightthighup.setOnClickListener(view -> {

            rightthigh=rightthigh+1;
            editor.putInt("rightthigh",rightthigh);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton leftthighdown;
        leftthighdown = (ImageButton) findViewById(R.id.leftthighdown);

        leftthighdown.setOnClickListener(view -> {

            leftthigh=leftthigh-1;
            editor.putInt("leftthigh",leftthigh);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton leftthighup;
        leftthighup = (ImageButton) findViewById(R.id.leftthighup);

        leftthighup.setOnClickListener(view -> {

            leftthigh=leftthigh+1;
            editor.putInt("leftthigh",leftthigh);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton shouldersdown;
        shouldersdown = (ImageButton) findViewById(R.id.shouldersdown);

        shouldersdown.setOnClickListener(view -> {

            shoulders=shoulders-1;
            editor.putInt("shoulders",shoulders);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        ImageButton shouldersup;
        shouldersup = (ImageButton) findViewById(R.id.shouldersup7);

        shouldersup.setOnClickListener(view -> {

            shoulders=shoulders+1;
            editor.putInt("shoulders",shoulders);
            editor.commit();
            Intent i = new Intent(MuscleStats.this, MuscleStats.class);
            startActivity(i);


        });
        Button toweight;
        toweight = (Button) findViewById(R.id.toweight);

        toweight.setOnClickListener(view -> {


            Intent i = new Intent(MuscleStats.this, WeightActivity.class);
            startActivity(i);


        });
    }
}