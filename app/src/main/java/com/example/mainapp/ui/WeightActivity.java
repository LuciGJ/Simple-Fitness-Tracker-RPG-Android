package com.example.mainapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.mainapp.R;
import com.example.mainapp.data.DataSource;

public class WeightActivity extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        Intent i = new Intent(WeightActivity.this, NavigationActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        TextView BMI = (TextView) findViewById(R.id.textView4);
        TextView BodyFat = (TextView) findViewById(R.id.textView14);
        TextView calories = (TextView) findViewById(R.id.textView15);
        TextView BMICateg = (TextView) findViewById(R.id.textView16);
        TextView BodyFatCateg = (TextView) findViewById(R.id.textView17);
        SharedPreferences pref = DataSource.getInstance(this);
        SharedPreferences.Editor editor = pref.edit();
        int height = pref.getInt("height", 0);
        int weight = pref.getInt("weight", 0);
        float height2 = (float) height / 100;
        height2 = height2 * height2;
        float BMI2 = (float) weight / height2;
        String BMIset = String.format("%.2f", BMI2);
        BMI.setText("BMI: " + BMIset);
        if (BMI2 < 18.5)
            BMICateg.setText("Underweight");
        else if (BMI2 >= 18.5 && BMI2 <= 24.9)
            BMICateg.setText("Normal weight");
        else if (BMI2 >= 25 && BMI2 <= 29.9)
            BMICateg.setText("Overweight");
        else if (BMI2 >= 30 && BMI2 <= 34.9)
            BMICateg.setText("Obesity Class 1");
        else if (BMI2 >= 35 && BMI2 <= 39.9)
            BMICateg.setText("Obesity Class 2");
        else if (BMI2 > 40)
            BMICateg.setText("Extreme Obesity Class 3");
        double bodyfatpercentage;
        int age = pref.getInt("age", 0);
        String gender = pref.getString("gender", "none");
        if (gender.equals("M"))
            bodyfatpercentage = 1.39 * BMI2 + 0.16 * age - 10.34 - 9;
        else
            bodyfatpercentage = 1.39 * BMI2 + 0.16 * age - 9;
        String bodyfatpercentageset = String.format("%.2f", bodyfatpercentage);
        BodyFat.setText(" Bodyfat %: " + bodyfatpercentageset + "%");
        if (gender.equals("F")) {
            if (bodyfatpercentage >= 10 && bodyfatpercentage < 14)
                BodyFatCateg.setText("Essential Fat");
            else if (bodyfatpercentage >= 14 && bodyfatpercentage < 21)
                BodyFatCateg.setText("Athletes");
            else if (bodyfatpercentage >= 21 && bodyfatpercentage < 25)
                BodyFatCateg.setText("Fitness");
            else if (bodyfatpercentage >= 25 && bodyfatpercentage < 32)
                BodyFatCateg.setText("Average");
            else if (bodyfatpercentage > 32)
                BodyFatCateg.setText("Obese");
        } else if (gender.equals("M")) {
            if (bodyfatpercentage >= 2 && bodyfatpercentage < 6)
                BodyFatCateg.setText("Essential Fat");
            else if (bodyfatpercentage >= 6 && bodyfatpercentage < 14)
                BodyFatCateg.setText("Athletes");
            else if (bodyfatpercentage >= 14 && bodyfatpercentage < 18)
                BodyFatCateg.setText("Fitness");
            else if (bodyfatpercentage >= 18 && bodyfatpercentage < 25)
                BodyFatCateg.setText("Average");
            else if (bodyfatpercentage > 25)
                BodyFatCateg.setText("Obese");
        }

        double helper = weight * (1 - (bodyfatpercentage / 100));
        double caloriesneeded = 370 + (21.6 * helper);


        int activitylevel = pref.getInt("level", 0);
        if (activitylevel == 0)
            caloriesneeded = caloriesneeded + 300;
        else if (activitylevel == 2)
            caloriesneeded = caloriesneeded + 600;
        else if (activitylevel == 3)
            caloriesneeded = caloriesneeded + 800;
        else if (activitylevel == 4)
            caloriesneeded = caloriesneeded + 900;
        else if (activitylevel == 5)
            caloriesneeded = caloriesneeded + 1100;
        else if (activitylevel == 6)
            caloriesneeded = caloriesneeded + 1400;
        String setcalories = String.format("%.2f", caloriesneeded);
        editor.putString("caloriesneeded", setcalories);
        calories.setText("Daily calories needed: " + setcalories + "kcal");
        Button tomuscle;
        tomuscle = (Button) findViewById(R.id.tomuscle);
        tomuscle.setOnClickListener(view -> {


            Intent i = new Intent(WeightActivity.this, SetMuscleStats.class);
            startActivity(i);


        });
    }
}