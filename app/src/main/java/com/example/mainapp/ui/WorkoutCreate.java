package com.example.mainapp.ui;

import androidx.appcompat.app.AlertDialog;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.mainapp.R;
import com.example.mainapp.data.DataSource;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkoutCreate extends ListActivity {
    private String[] string = null;
    private String breaktake = "";
    private String m_Text = "";
    private String reps = "";
    private String myexercises;
    private final ArrayList<String> listItems = new ArrayList<>();
    private List<String> exercises = new ArrayList<>();
    private final String regex = "[0-9]+";


    private ArrayAdapter<String> adapter;

    @Override
    public void onBackPressed() {
        Intent i = new Intent(WorkoutCreate.this, WorkoutSettings.class);
        startActivity(i);
    }


    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        SharedPreferences pref = DataSource.getInstance(this);
        myexercises = pref.getString("myexercises", "empty");
        if (!myexercises.equals("empty")) {
            Gson gson = new Gson();
            string = gson.fromJson(myexercises, String[].class);
            exercises = new ArrayList<>(Arrays.asList(string));
        }
        setContentView(R.layout.activity_workout_create);
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        setListAdapter(adapter);
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        setListAdapter(adapter);
        Button cancelbutton = (Button) findViewById(R.id.workoutcancelbutton);
        cancelbutton.setOnClickListener(view -> {
            Intent i = new Intent(WorkoutCreate.this, WorkoutSettings.class);
            startActivity(i);
        }


        );
        FloatingActionButton finishbutton = (FloatingActionButton) findViewById(R.id.workoutcreatedone);
        finishbutton.setOnClickListener(view -> {
            SharedPreferences pref1 = DataSource.getInstance(WorkoutCreate.this);
            SharedPreferences.Editor editor = pref1.edit();
            int day = pref1.getInt("workday", 0);


            if (day == 1) {
                Gson gson = new Gson();
                String set = gson.toJson(listItems);
                editor.putString("workout1", set);
                editor.commit();
                if (!set.isEmpty()) {
                    editor.putBoolean("workoutday1", true);
                } else {
                    editor.putBoolean("workoutday1", false);
                }
                editor.commit();
                Intent i = new Intent(WorkoutCreate.this, WorkoutSettings.class);
                startActivity(i);
            }
            if (day == 2) {

                Gson gson = new Gson();
                String set = gson.toJson(listItems);
                editor.putString("workout2", set);
                editor.commit();
                if (!set.isEmpty()) {
                    editor.putBoolean("workoutday2", true);
                } else {
                    editor.putBoolean("workoutday2", false);
                }
                editor.commit();
                Intent i = new Intent(WorkoutCreate.this, WorkoutSettings.class);
                startActivity(i);
            }
            if (day == 3) {
                Gson gson = new Gson();
                String set = gson.toJson(listItems);
                editor.putString("workout3", set);
                editor.commit();
                if (!set.isEmpty()) {
                    editor.putBoolean("workoutday3", true);
                } else {
                    editor.putBoolean("workoutday3", false);
                }
                editor.commit();
                Intent i = new Intent(WorkoutCreate.this, WorkoutSettings.class);
                startActivity(i);
            }
            if (day == 4) {
                Gson gson = new Gson();
                String set = gson.toJson(listItems);
                editor.putString("workout4", set);
                editor.commit();
                if (!set.isEmpty()) {
                    editor.putBoolean("workoutday4", true);
                } else {
                    editor.putBoolean("workoutday4", false);
                }
                editor.commit();
                Intent i = new Intent(WorkoutCreate.this, WorkoutSettings.class);
                startActivity(i);
            }
            if (day == 5) {
                Gson gson = new Gson();
                String set = gson.toJson(listItems);
                editor.putString("workout5", set);
                editor.commit();
                if (!set.isEmpty()) {
                    editor.putBoolean("workoutday5", true);
                } else {
                    editor.putBoolean("workoutday5", false);
                }
                editor.commit();
                Intent i = new Intent(WorkoutCreate.this, WorkoutSettings.class);
                startActivity(i);
            }
            if (day == 6) {
                Gson gson = new Gson();
                String set = gson.toJson(listItems);
                editor.putString("workout6", set);
                editor.commit();
                if (!set.isEmpty()) {
                    editor.putBoolean("workoutday6", true);
                } else {
                    editor.putBoolean("workoutday6", false);
                }
                editor.commit();
                Intent i = new Intent(WorkoutCreate.this, WorkoutSettings.class);
                startActivity(i);
            }
            if (day == 7) {
                Gson gson = new Gson();
                String set = gson.toJson(listItems);
                editor.putString("workout7", set);
                editor.commit();
                if (!set.isEmpty()) {
                    editor.putBoolean("workoutday7", true);
                } else {
                    editor.putBoolean("workoutday7", false);
                }
                editor.commit();
                Intent i = new Intent(WorkoutCreate.this, WorkoutSettings.class);
                startActivity(i);
            }


        }


        );
        Button addbreakbutton = (Button) findViewById(R.id.addbreakbutton);
        addbreakbutton.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(WorkoutCreate.this);
            builder.setTitle("Enter break time:");


            final EditText input = new EditText(WorkoutCreate.this);

            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);


            builder.setPositiveButton("OK", (dialog, which) -> {
                breaktake = input.getText().toString();
                if (breaktake.length() != 0 && breaktake.matches(regex)) {
                    adapter.add("Break " + breaktake + " s");
                }

            });
            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

            builder.show();

        });


    }

    public void addItems(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exercise");


        //         final EditText input = new EditText(this);
        final EditText input2 = new EditText(this);
        final AutoCompleteTextView input = new AutoCompleteTextView(WorkoutCreate.this);
        if (string != null) {
            ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,
                    android.R.layout.simple_dropdown_item_1line, string);
            input.setAdapter(adapter2);
        }

        input.setInputType(InputType.TYPE_CLASS_TEXT);

        input.setHint("Exercise");
        input2.setHint("Reps");
        LinearLayout lay = new LinearLayout(this);
        lay.setOrientation(LinearLayout.VERTICAL);
        lay.addView(input);
        lay.addView(input2);
        builder.setView(lay);


        builder.setPositiveButton("OK", (dialog, which) -> {
            m_Text = input.getText().toString();
            reps = input2.getText().toString();
            if (m_Text.length() != 0 && reps.length() != 0 && reps.matches(regex)) {
                if (!exercises.contains(m_Text)) {
                    SharedPreferences pref = DataSource.getInstance(WorkoutCreate.this);
                    SharedPreferences.Editor editor = pref.edit();
                    exercises.add(m_Text);
                    Gson gson = new Gson();
                    myexercises = gson.toJson(exercises);
                    editor.putString("myexercises", myexercises);
                    editor.commit();
                    String ex = pref.getString("myexercises", "empty");
                    string = gson.fromJson(ex, String[].class);
                    exercises = new ArrayList<String>(Arrays.asList(string));
                }
                adapter.add(m_Text + " x " + reps);
            }

        });
        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        builder.show();
    }
}
