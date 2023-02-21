package com.example.mainapp.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;

import android.text.InputType;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import android.widget.TextView;


import com.example.mainapp.R;
import com.example.mainapp.data.DataSource;
import com.example.mainapp.utility.Helper;

import java.util.Arrays;
import java.util.List;

public class Profile extends AppCompatActivity {
    private String name;
    private String age;
    private String gender;
    private String height;
    private String weight;
    private String activity;
    private int age2;
    private int weight2;
    private int height2;
    private final String regex = "[0-9]+";

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Profile.this, ProfileDisplay.class);
        startActivity(i);
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPreferences pref = DataSource.getInstance(this);
        SharedPreferences.Editor editor = pref.edit();
        name = pref.getString("name", "notfound");
        gender = pref.getString("gender", "notfound");
        age2 = pref.getInt("age", 0);
        height2 = pref.getInt("height", 0);
        weight2 = pref.getInt("weight", 0);
        int activity2 = pref.getInt("level", 0);
        age = String.valueOf(age2);
        height = String.valueOf(height2);
        weight = String.valueOf(weight2);
        activity = String.valueOf(activity2);
        TextView editAge = (TextView) findViewById(R.id.textage);
        TextView editWeight = (TextView) findViewById(R.id.textweight);
        TextView editheight = (TextView) findViewById(R.id.textheight);
        TextView editName = (TextView) findViewById(R.id.textname);
        TextView editGender = (TextView) findViewById(R.id.textgender);
        TextView editActivity = (TextView) findViewById(R.id.textactivity);
        editName.setText("Name: " + name);
        editWeight.setText("Weight: " + weight + " kg");
        editheight.setText("Height: " + height + " cm");
        editGender.setText("Gender: " + gender);
        editAge.setText("Age: " + age + " years");
        editActivity.setText("Activity Level: " + activity);


        ImageButton namebutton = (ImageButton) findViewById(R.id.editnamebutton);
        namebutton.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
            builder.setTitle("Enter new name:");


            final EditText input = new EditText(Profile.this);

            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);


            builder.setPositiveButton("OK", (dialog, which) -> {
                name = input.getText().toString();
                if (name.length() == 0) {
                    Intent i = new Intent(Profile.this, Profile.class);
                    startActivity(i);
                } else if (!Helper.isStringOnlyAlphabet(name)) {
                    Intent i = new Intent(Profile.this, Profile.class);
                    startActivity(i);
                } else {
                    editor.putString("name", name);
                    editor.commit();
                    Intent i = new Intent(Profile.this, Profile.class);
                    startActivity(i);
                }

            });
            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

            builder.show();

        });
        ImageButton ageeditbutton = (ImageButton) findViewById(R.id.editagebutton);
        ageeditbutton.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
            builder.setTitle("Enter new age:");


            final EditText input = new EditText(Profile.this);

            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);


            builder.setPositiveButton("OK", (dialog, which) -> {
                String inputage = input.getText().toString();
                age = inputage;
                age2 = Integer.parseInt(inputage);
                if (age.length() == 0) {
                    Intent i = new Intent(Profile.this, Profile.class);
                    startActivity(i);
                } else if (!age.matches(regex)) {
                    Intent i = new Intent(Profile.this, Profile.class);
                    startActivity(i);
                } else {
                    editor.putInt("age", age2);
                    editor.commit();
                    Intent i = new Intent(Profile.this, Profile.class);
                    startActivity(i);
                }

            });
            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

            builder.show();

        });
        ImageButton heighteditbutton = (ImageButton) findViewById(R.id.editheightbutton);
        heighteditbutton.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
            builder.setTitle("Enter new height:");


            final EditText input = new EditText(Profile.this);

            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);


            builder.setPositiveButton("OK", (dialog, which) -> {
                String inputheight = input.getText().toString();
                height = inputheight;
                height2 = Integer.parseInt(inputheight);
                if (age.length() == 0) {
                    Intent i = new Intent(Profile.this, Profile.class);
                    startActivity(i);
                } else if (!age.matches(regex)) {
                    Intent i = new Intent(Profile.this, Profile.class);
                    startActivity(i);
                } else {
                    editor.putInt("height", height2);
                    editor.commit();
                    Intent i = new Intent(Profile.this, Profile.class);
                    startActivity(i);
                }

            });
            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

            builder.show();

        });
        ImageButton weighteditbutton = (ImageButton) findViewById(R.id.editweightbutton);
        weighteditbutton.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
            builder.setTitle("Enter new weight:");


            final EditText input = new EditText(Profile.this);

            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);


            builder.setPositiveButton("OK", (dialog, which) -> {
                String inputweight = input.getText().toString();
                weight = inputweight;
                weight2 = Integer.parseInt(inputweight);
                if (age.length() == 0) {
                    Intent i = new Intent(Profile.this, Profile.class);
                    startActivity(i);
                } else if (!age.matches(regex)) {
                    Intent i = new Intent(Profile.this, Profile.class);
                    startActivity(i);
                } else {
                    editor.putInt("weight", weight2);
                    editor.commit();
                    Intent i = new Intent(Profile.this, Profile.class);
                    startActivity(i);
                }

            });
            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

            builder.show();

        });
        ImageButton genderbutton = (ImageButton) findViewById(R.id.editgenderbutton);
        genderbutton.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
            builder.setTitle("Enter new name:");


            final EditText input = new EditText(Profile.this);

            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);


            builder.setPositiveButton("OK", (dialog, which) -> {
                String genderinput = input.getText().toString();
                gender = genderinput;
                List valid = Arrays.asList("M", "F");
                if (gender.length() == 0) {
                    Intent i = new Intent(Profile.this, Profile.class);
                    startActivity(i);
                } else if (!valid.contains(gender)) {
                    Intent i = new Intent(Profile.this, Profile.class);
                    startActivity(i);
                } else {
                    editor.putString("gender", genderinput);
                    editor.commit();
                    Intent i = new Intent(Profile.this, Profile.class);
                    startActivity(i);
                }

            });
            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

            builder.show();

        });
        ImageButton activitybutton = (ImageButton) findViewById(R.id.activityeditbutton);
        activitybutton.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
            builder.setTitle("Enter new weight:");


            final EditText input = new EditText(Profile.this);

            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);


            builder.setPositiveButton("OK", (dialog, which) -> {
                String inputactivity = input.getText().toString();
                activity = inputactivity;
                int activity21 = Integer.parseInt(inputactivity);
                if (activity.length() == 0) {
                    Intent i = new Intent(Profile.this, Profile.class);
                    startActivity(i);
                } else if (activity21 < 0 || activity21 > 6) {
                    Intent i = new Intent(Profile.this, Profile.class);
                    startActivity(i);
                } else {
                    editor.putInt("level", activity21);
                    editor.commit();
                    Intent i = new Intent(Profile.this, Profile.class);
                    startActivity(i);
                }

            });
            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

            builder.show();

        });
        Button donebutton;
        donebutton = (Button) findViewById(R.id.profileeditdone);
        donebutton.setOnClickListener(view -> {


            Intent i = new Intent(Profile.this, ProfileDisplay.class);
            startActivity(i);


        });
    }


}