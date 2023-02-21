package com.example.mainapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.mainapp.R;
import com.example.mainapp.data.DataSource;

public class SkillsPage extends AppCompatActivity {
    TextView punchskill;
    TextView kickskill;
    TextView healskill;
    TextView pushskill;
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(SkillsPage.this, CharacterPage.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills_page);
        SharedPreferences pref = DataSource.getInstance(this);
        punchskill = (TextView) findViewById(R.id.punchskilltext);
        pushskill = (TextView) findViewById(R.id.pushskilltext);
        healskill = (TextView) findViewById(R.id.healskilltext);
        kickskill = (TextView) findViewById(R.id.kickskilltext);
        if (pref.getBoolean("punchskill",false))
            punchskill.setText("Punch Level "+ pref.getInt("punchlevel", 0));
        if (pref.getBoolean("kickskill",false))
            kickskill.setText("Kick Level "+ pref.getInt("kicklevel", 0));
        if (pref.getBoolean("pushskill",false))
            pushskill.setText("Push Level "+ pref.getInt("pushlevel", 0));
        if (pref.getBoolean("healskill",false))
            healskill.setText("Heal Level "+ pref.getInt("heallevel", 0));
        Button  skillchar;
        skillchar = (Button) findViewById(R.id.skillscharbutton);
        skillchar.setOnClickListener(view -> {


            Intent i = new Intent(SkillsPage.this, CharacterPage.class);
            startActivity(i);


        });

        Button totraining;
        totraining = (Button) findViewById(R.id.totraining);
        totraining.setOnClickListener(view -> {


            Intent i = new Intent(SkillsPage.this, Training.class);
            startActivity(i);


        });




    }
}