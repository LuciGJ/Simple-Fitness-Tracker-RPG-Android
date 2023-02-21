package com.example.mainapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.mainapp.R;
import com.example.mainapp.data.DataSource;

public class ProfileDisplay extends AppCompatActivity {

    public void onBackPressed() {
        Intent i = new Intent(ProfileDisplay.this, NavigationActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_display);

        SharedPreferences pref = DataSource.getInstance(this);
        SharedPreferences.Editor editor = pref.edit();
        String name = pref.getString("name", "notfound");
        String gender = pref.getString("gender", "notfound");
        int age2 = pref.getInt("age", 0);
        int height2 = pref.getInt("height", 0);
        int weight2 = pref.getInt("weight", 0);
        int activity2 = pref.getInt("level", 0);
        String age = String.valueOf(age2);
        String height = String.valueOf(height2);
        String weight = String.valueOf(weight2);
        String activity = String.valueOf(activity2);
        TextView editAge = (TextView) findViewById(R.id.displayage);
        TextView editWeight = (TextView) findViewById(R.id.displayweight);
        TextView editheight = (TextView) findViewById(R.id.displayheight);
        TextView editName = (TextView) findViewById(R.id.displayname);
        TextView editGender = (TextView) findViewById(R.id.displaygender);
        TextView editActivity = (TextView) findViewById(R.id.displayactivity);
        editName.setText("Name: " + name);
        editWeight.setText("Weight: " + weight + " kg");
        editheight.setText("Height: " + height + " cm");
        editGender.setText("Gender: " + gender);
        editAge.setText("Age: " + age + " years");
        editActivity.setText("Activity Level: " + activity);
        Button editprofile;
        editprofile = (Button) findViewById(R.id.editprofilebutton);
        editprofile.setOnClickListener(view -> {


            Intent i = new Intent(ProfileDisplay.this, Profile.class);
            startActivity(i);


        });
    }
}