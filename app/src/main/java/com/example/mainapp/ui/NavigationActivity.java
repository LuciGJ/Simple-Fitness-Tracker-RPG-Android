package com.example.mainapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.mainapp.R;
import com.example.mainapp.data.DataSource;

import java.util.Calendar;

public class NavigationActivity extends AppCompatActivity {
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(NavigationActivity.this, NavigationActivity.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        SharedPreferences pref = DataSource.getInstance(this);
        if (dayOfWeek == Calendar.MONDAY) {
            if(pref.getBoolean("workoutday1",false)) {
                if (!pref.getBoolean("workoutfinished1", false)) {
                    Toast.makeText(NavigationActivity.this, "You have a workout scheduled for today!",
                            Toast.LENGTH_LONG).show();
                }
            }
        }
        if (dayOfWeek == Calendar.TUESDAY) {
            if(pref.getBoolean("workoutday2",false)) {
                if (pref.getBoolean("workoutfinished2", false)) {

                        Toast.makeText(NavigationActivity.this, "You have a workout scheduled for today!",
                                Toast.LENGTH_LONG).show();
                    }
            }
        }
        if (dayOfWeek == Calendar.WEDNESDAY) {
            if(pref.getBoolean("workoutday3",false)) {
                if (pref.getBoolean("workoutfinished3", false)) {
                        Toast.makeText(NavigationActivity.this, "You have a workout scheduled for today!",
                                Toast.LENGTH_LONG).show();
                    }
            }
        }
        if (dayOfWeek == Calendar.THURSDAY) {
            if(pref.getBoolean("workoutday4",false)) {
                if (pref.getBoolean("workoutfinished4", false)) {

                    Toast.makeText(NavigationActivity.this, "You have a workout scheduled for today!",
                            Toast.LENGTH_LONG).show();
                }
            }
        }
        if (dayOfWeek == Calendar.FRIDAY) {
            if(pref.getBoolean("workoutday5",false)) {
                if (pref.getBoolean("workoutfinished5", false)) {

                    Toast.makeText(NavigationActivity.this, "You have a workout scheduled for today!",
                            Toast.LENGTH_LONG).show();
                }
            }
        }
        if (dayOfWeek == Calendar.SATURDAY) {
            if(pref.getBoolean("workoutday6",false)) {
                if (pref.getBoolean("workoutfinished6", false)) {

                    Toast.makeText(NavigationActivity.this, "You have a workout scheduled for today!",
                            Toast.LENGTH_LONG).show();
                }
            }
        }
        if (dayOfWeek == Calendar.SUNDAY) {
            if(pref.getBoolean("workoutday7",false)) {
                if (pref.getBoolean("workoutfinished7", false)) {

                    Toast.makeText(NavigationActivity.this, "You have a workout scheduled for today!",
                            Toast.LENGTH_LONG).show();
                }
            }
        }
        Button toprofile;
        toprofile = (Button) findViewById(R.id.toprofile);

        toprofile.setOnClickListener(view -> {


            Intent i = new Intent(NavigationActivity.this, ProfileDisplay.class);
            startActivity(i);


        });
        Button tostats;
        tostats = (Button) findViewById(R.id.tostats);

        tostats.setOnClickListener(view -> {


            Intent i = new Intent(NavigationActivity.this, WeightActivity.class);
            startActivity(i);


        });
        Button tocharacter;
        tocharacter = (Button) findViewById(R.id.tocharacter);

        tocharacter.setOnClickListener(view -> {


            Intent i = new Intent(NavigationActivity.this, CharacterCreation.class);
            startActivity(i);


        });
        Button todiet;
        todiet = (Button) findViewById(R.id.tofood);

        todiet.setOnClickListener(view -> {


            Intent i = new Intent(NavigationActivity.this, FoodPrint.class);
            startActivity(i);


        });
        Button toworkout;
        toworkout = (Button) findViewById(R.id.toworkout);

        toworkout.setOnClickListener(view -> {


            Intent i = new Intent(NavigationActivity.this, WorkoutPrint.class);
            startActivity(i);


        });
    }
}