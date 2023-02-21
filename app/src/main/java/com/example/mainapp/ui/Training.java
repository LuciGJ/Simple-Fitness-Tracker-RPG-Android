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

public class Training extends AppCompatActivity {
    TextView pushups;
    TextView situps;
    TextView pullups;
    TextView squats;

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Training.this, SkillsPage.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        SharedPreferences pref = DataSource.getInstance(this);
        SharedPreferences.Editor editor = pref.edit();
        pushups = (TextView) findViewById(R.id.pushups);
        pullups = (TextView) findViewById(R.id.pullups);
        situps = (TextView) findViewById(R.id.situps);
        squats = (TextView) findViewById(R.id.squats);
        if (pref.getInt("pushlevel", 0) == 0)
            pushups.setText("Do 10xpushups in a row");
        else if (pref.getInt("pushlevel", 0) == 1)
            pushups.setText("Do 20xpushups in a row");
        else if (pref.getInt("pushlevel", 0) == 2)
            pushups.setText("Do 30xpushups in a row");
        else if (pref.getInt("pushlevel", 0) == 3)
            pushups.setText("Do 40xpushups in a row");
        else if (pref.getInt("pushlevel", 0) == 4)
            pushups.setText("Do 50xpushups in a row");
        else pushups.setText("Congratulations! You have finished the challenge!");
        if (pref.getInt("kicklevel", 0) == 0)
            squats.setText("Do 20xsquats in a row");
        else if (pref.getInt("kicklevel", 0) == 1)
            squats.setText("Do 40xsquats in a row");
        else if (pref.getInt("kicklevel", 0) == 2)
            squats.setText("Do 60xsquats in a row");
        else if (pref.getInt("kicklevel", 0) == 3)
            squats.setText("Do 80xsquats in a row");
        else if (pref.getInt("kicklevel", 0) == 4)
            squats.setText("Do 1000xsquats in a row");
        else squats.setText("Congratulations! You have finished the challenge!");
        if (pref.getInt("punchlevel", 0) == 0)
            pullups.setText("Do 5xpullups in a row");
        else if (pref.getInt("punchlevel", 0) == 1)
            pullups.setText("Do 10xpullups in a row");
        else if (pref.getInt("punchlevel", 0) == 2)
            pullups.setText("Do 20xpullups in a row");
        else if (pref.getInt("punchlevel", 0) == 3)
            pullups.setText("Do 25xpullups in a row");
        else if (pref.getInt("punchlevel", 0) == 4)
            pullups.setText("Do 30xpullups in a row");
        else pullups.setText("Congratulations! You have finished the  challenge!");
        if (pref.getInt("heallevel", 0) == 0)
            situps.setText("Do 20xsitups in a row");
        else if (pref.getInt("heallevel", 0) == 1)
            situps.setText("Do 40xsitups in a row");
        else if (pref.getInt("heallevel", 0) == 2)
            situps.setText("Do 60xsitups in a row");
        else if (pref.getInt("heallevel", 0) == 3)
            situps.setText("Do 80xsitups in a row");
        else if (pref.getInt("heallevel", 0) == 4)
            situps.setText("Do 100xsitups in a row");
        else situps.setText("Congratulations! You have finished the challenge!");
        Button backtraining;
        backtraining = (Button) findViewById(R.id.trainingbackbutton);
        backtraining.setOnClickListener(view -> {


            Intent i = new Intent(Training.this, SkillsPage.class);
            startActivity(i);


        });
        ImageButton pushbutton;
        pushbutton = (ImageButton) findViewById(R.id.pushupsbutton);
        pushbutton.setOnClickListener(view -> {
            editor.putBoolean("pushskill", true);
            int level = pref.getInt("pushlevel", 0) + 1;
            if (level <= 5)
                editor.putInt("pushlevel", level);
            editor.commit();
            Intent i = new Intent(Training.this, Training.class);
            startActivity(i);


        });

        ImageButton pullbutton;
        pullbutton = (ImageButton) findViewById(R.id.pullupsbutton);
        pullbutton.setOnClickListener(view -> {
            editor.putBoolean("punchskill", true);
            int level = pref.getInt("punchlevel", 0) + 1;
            if (level <= 5)
                editor.putInt("punchlevel", level);
            editor.commit();
            Intent i = new Intent(Training.this, Training.class);
            startActivity(i);


        });

        ImageButton squatbutton;
        squatbutton = (ImageButton) findViewById(R.id.squatsbutton);
        squatbutton.setOnClickListener(view -> {
            editor.putBoolean("kickskill", true);
            int level = pref.getInt("kicklevel", 0) + 1;
            if (level <= 5)
                editor.putInt("kicklevel", level);
            editor.commit();
            Intent i = new Intent(Training.this, Training.class);
            startActivity(i);


        });

        ImageButton sitbutton;
        sitbutton = (ImageButton) findViewById(R.id.situpsbutton);
        sitbutton.setOnClickListener(view -> {
            editor.putBoolean("healskill", true);
            int level = pref.getInt("heallevel", 0) + 1;
            if (level <= 5)
                editor.putInt("heallevel", level);
            editor.commit();
            Intent i = new Intent(Training.this, Training.class);
            startActivity(i);


        });

    }
}