package com.example.mainapp.ui;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;

import com.example.mainapp.R;
import com.example.mainapp.data.DataSource;


public class SetMuscleStats extends AppCompatActivity {
    private EditText editrightbiceps;
    private EditText editleftbiceps;
    private EditText editrightforearm;
    private EditText editleftforearm;
    private EditText editchest;
    private EditText editrightcalf;
    private EditText editleftcalf;
    private boolean checkstats=true;
    private final String regex = "[0-9]+";

    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(SetMuscleStats.this, NavigationActivity.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();


        super.onCreate(savedInstanceState);
        SharedPreferences pref = DataSource.getInstance(this);
        SharedPreferences.Editor editor = pref.edit();
        if(pref.getBoolean("statsset",false))
        {
            Intent i = new Intent(SetMuscleStats.this, MuscleStats.class);
            startActivity(i);
        }



        setContentView(R.layout.activity_set_muscle_stats);
        Button finishbstatsbutton = findViewById(R.id.finishmuscle);
        finishbstatsbutton.setOnClickListener(view -> {
            editrightbiceps = (EditText) findViewById(R.id.editrightbiceps);
            editleftbiceps = (EditText) findViewById(R.id.editleftbiceps);
            editrightforearm = (EditText) findViewById(R.id.editrightforearm);
            editleftforearm = (EditText) findViewById(R.id.editleftforearm);
            editchest = (EditText) findViewById(R.id.editchest);
            editrightcalf = (EditText) findViewById(R.id.rightcalfedit);
            editleftcalf = (EditText) findViewById(R.id.leftcalfedit);

            String rightbiceps=editrightbiceps.getText().toString();
            String leftbiceps=editleftbiceps.getText().toString();
            String rightforearm=editrightforearm.getText().toString();
            String leftforearm=editleftforearm.getText().toString();
            String chest=editchest.getText().toString();

            String rightcalf=editrightcalf.getText().toString();
            String leftcalf=editleftcalf.getText().toString();

            if (rightbiceps.length() == 0) {
                editrightbiceps.setError("Size required!");
                checkstats = false;
            } else if (!rightbiceps.matches(regex)) {
                editrightbiceps.setError("Size must be a number!");
                checkstats = false;
            }
            if (leftbiceps.length() == 0) {
                editleftbiceps.setError("Size required!");
                checkstats = false;
            } else if (!leftbiceps.matches(regex)) {
                editleftbiceps.setError("Size must be a number!");
                checkstats = false;
            }
            if (rightforearm.length() == 0) {
                editrightforearm.setError("Size required!");
                checkstats = false;
            } else if (!rightforearm.matches(regex)) {
                editrightforearm.setError("Size must be a number!");
                checkstats = false;
            }
            if (leftforearm.length() == 0) {
                editleftforearm.setError("Size required!");
                checkstats = false;
            } else if (!leftforearm.matches(regex)) {
                editleftforearm.setError("Size must be a number!");
                checkstats = false;
            }
            if (chest.length() == 0) {
                editchest.setError("Size required!");
                checkstats = false;
            } else if (!chest.matches(regex)) {
                editchest.setError("Size must be a number!");
                checkstats = false;
            }

            if (rightcalf.length() == 0) {
                editrightcalf.setError("Size required!");
                checkstats = false;
            } else if (!rightcalf.matches(regex)) {
                editrightcalf.setError("Size must be a number!");
                checkstats = false;
            }
            if (leftcalf.length() == 0) {
                editleftcalf.setError("Size required!");
                checkstats = false;
            } else if (!leftcalf.matches(regex)) {
                editleftcalf.setError("Size must be a number!");
                checkstats = false;
            }

            if(checkstats) {


                int rightbicepsint = Integer.parseInt(rightbiceps);
                int leftbicepsint = Integer.parseInt(leftbiceps);
                int rightforearmint = Integer.parseInt(rightforearm);
                int leftforearmint = Integer.parseInt(leftforearm);
                int chestint = Integer.parseInt(chest);

                int rightcalfint = Integer.parseInt(rightcalf);
                int leftcalfint = Integer.parseInt(leftcalf);

                editor.putInt("rightbiceps",rightbicepsint);
                editor.putInt("leftbiceps",leftbicepsint);
                editor.putInt("rightforearm",rightforearmint);
                editor.putInt("leftforearm",leftforearmint);
                editor.putInt("chest",chestint);

                editor.putInt("rightcalf",rightcalfint);
                editor.putInt("leftcalf",leftcalfint);


                editor.commit();
                Intent i = new Intent(SetMuscleStats.this, SetMuscleStatsNext.class);
                startActivity(i);
            }
            else checkstats=true;




        });

    }
}