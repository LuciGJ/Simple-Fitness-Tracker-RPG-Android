package com.example.mainapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.mainapp.R;
import com.example.mainapp.data.DataSource;

public class SetMuscleStatsNext extends AppCompatActivity {
    private final String regex = "[0-9]+";
    private EditText edithips;
    private EditText editneck;
    private EditText editshoulders;
    private EditText editrightthigh;
    private EditText editleftthigh;
    private EditText editwaist;

    private boolean checkstats = true;

    @Override
    public void onBackPressed() {
        Intent i = new Intent(SetMuscleStatsNext.this, SetMuscleStats.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_muscle_stats_next);
        SharedPreferences pref = DataSource.getInstance(this);
        SharedPreferences.Editor editor = pref.edit();

        Button finishbutton = findViewById(R.id.finishbutton2);
        finishbutton.setOnClickListener(view -> {
            edithips = (EditText) findViewById(R.id.edithips);
            editshoulders = (EditText) findViewById(R.id.editshoulders);
            editrightthigh = (EditText) findViewById(R.id.editrightthigh);
            editleftthigh = (EditText) findViewById(R.id.editleftthigh);
            editwaist = (EditText) findViewById(R.id.editwaist);
            editneck = (EditText) findViewById(R.id.editneck);
            String hips = edithips.getText().toString();
            String neck = editneck.getText().toString();
            String shoulders = editshoulders.getText().toString();
            String rightthigh = editrightthigh.getText().toString();
            String leftthigh = editleftthigh.getText().toString();
            String waist = editwaist.getText().toString();
            if (hips.length() == 0) {
                edithips.setError("Size required!");
                checkstats = false;
            } else if (!hips.matches(regex)) {
                edithips.setError("Size must be a number!");
                checkstats = false;
            }
            if (neck.length() == 0) {
                editneck.setError("Size required!");
                checkstats = false;
            } else if (!neck.matches(regex)) {
                editneck.setError("Size must be a number!");
                checkstats = false;
            }
            if (shoulders.length() == 0) {
                editshoulders.setError("Size required!");
                checkstats = false;
            } else if (!shoulders.matches(regex)) {
                editshoulders.setError("Size must be a number!");
                checkstats = false;
            }
            if (rightthigh.length() == 0) {
                editrightthigh.setError("Size required!");
                checkstats = false;
            } else if (!rightthigh.matches(regex)) {
                editrightthigh.setError("Size must be a number!");
                checkstats = false;
            }
            if (leftthigh.length() == 0) {
                editleftthigh.setError("Size required!");
                checkstats = false;
            } else if (!leftthigh.matches(regex)) {
                editleftthigh.setError("Size must be a number!");
                checkstats = false;
            }
            if (waist.length() == 0) {
                editwaist.setError("Size required!");
                checkstats = false;
            } else if (!waist.matches(regex)) {
                editwaist.setError("Size must be a number!");
                checkstats = false;
            }
            if (checkstats) {

                int hipsint = Integer.parseInt(hips);
                int neckint = Integer.parseInt(neck);
                int rightthighint = Integer.parseInt(rightthigh);
                int leftthighint = Integer.parseInt(leftthigh);
                int waistint = Integer.parseInt(waist);
                int shouldersint = Integer.parseInt(shoulders);
                editor.putInt("waist", waistint);
                editor.putInt("shoulders", shouldersint);
                editor.putInt("hips", hipsint);
                editor.putInt("neck", neckint);
                editor.putInt("rightthigh", rightthighint);
                editor.putInt("leftthigh", leftthighint);
                editor.putBoolean("statsset", true);
                editor.commit();
                Intent i = new Intent(SetMuscleStatsNext.this, MuscleStats.class);
                startActivity(i);
            }


        });

    }
}