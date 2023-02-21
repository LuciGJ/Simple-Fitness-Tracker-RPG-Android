package com.example.mainapp.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.mainapp.R;
import com.example.mainapp.data.DataSource;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class WorkoutPrint extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        Intent i = new Intent(WorkoutPrint.this, NavigationActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_print);
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        SharedPreferences pref = DataSource.getInstance(this);
        SharedPreferences.Editor editor = pref.edit();
        ImageButton tosettings;
        tosettings = (ImageButton) findViewById(R.id.workouttosettings);
        tosettings.setOnClickListener(view -> {


            Intent i = new Intent(WorkoutPrint.this, WorkoutSettings.class);
            startActivity(i);


        });
        ImageButton workoutexp;
        workoutexp = (ImageButton) findViewById(R.id.workoutplandonebutton);
        workoutexp.setOnClickListener(view -> {
            if (!pref.getBoolean("charcreated", false)) {
                AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                alertDialog.setTitle("Error");
                alertDialog.setMessage("You have to create a character first.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        (dialog, which) -> dialog.dismiss());
                alertDialog.show();
            } else {
                if (dayOfWeek == Calendar.MONDAY) {
                    if (!pref.getBoolean("workoutday1", false)) {
                        AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("You don't have any plan for today.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                (dialog, which) -> dialog.dismiss());
                        alertDialog.show();
                    } else {
                        if (pref.getBoolean("workoutfinished1", false)) {
                            AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                            alertDialog.setTitle("Error");
                            alertDialog.setMessage("You already finished your plan for today.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    (dialog, which) -> dialog.dismiss());
                            alertDialog.show();
                        } else {
                            int experience = pref.getInt("experience", 0);
                            int neededexperience = pref.getInt("neededexperience", 0);
                            experience = experience + 100;
                            editor.putBoolean("workoutfinished1", true);
                            editor.commit();
                            if (neededexperience - experience <= 0) {
                                AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                                alertDialog.setTitle("Level up");
                                alertDialog.setMessage("Congratulations! You have achieved a new level!");
                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                        (dialog, which) -> dialog.dismiss());
                                alertDialog.show();
                                int level = pref.getInt("charlevel", 0);
                                level = level + 1;
                                editor.putInt("charlevel", level);
                                editor.putInt("neededexperience", neededexperience + 100);
                                editor.putInt("experience", Math.abs(neededexperience - experience));
                            } else {
                                editor.putInt("experience", experience);
                            }
                            editor.commit();
                        }
                    }
                }
                if (dayOfWeek == Calendar.TUESDAY) {
                    if (!pref.getBoolean("workoutday2", false)) {
                        AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("You don't have any plan for today.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                (dialog, which) -> dialog.dismiss());
                        alertDialog.show();
                    } else {
                        if (pref.getBoolean("workoutfinished2", false)) {
                            AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                            alertDialog.setTitle("Error");
                            alertDialog.setMessage("You already finished your plan for today.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    (dialog, which) -> dialog.dismiss());
                            alertDialog.show();
                        } else {
                            int experience = pref.getInt("experience", 0);
                            int neededexperience = pref.getInt("neededexperience", 0);
                            experience = experience + 100;
                            editor.putBoolean("workoutfinished2", true);
                            editor.commit();
                            if (neededexperience - experience <= 0) {
                                AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                                alertDialog.setTitle("Level up");
                                alertDialog.setMessage("Congratulations! You have achieved a new level!");
                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                        (dialog, which) -> dialog.dismiss());
                                alertDialog.show();
                                int level = pref.getInt("charlevel", 0);
                                level = level + 1;
                                editor.putInt("charlevel", level);
                                editor.putInt("neededexperience", neededexperience + 100);
                                editor.putInt("experience", Math.abs(neededexperience - experience));
                            } else {
                                editor.putInt("experience", experience);
                            }
                            editor.commit();
                        }
                    }
                }
                if (dayOfWeek == Calendar.WEDNESDAY) {
                    if (!pref.getBoolean("workoutday3", false)) {
                        AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("You don't have any plan for today.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                (dialog, which) -> dialog.dismiss());
                        alertDialog.show();
                    } else {
                        if (pref.getBoolean("workoutfinished3", false)) {
                            AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                            alertDialog.setTitle("Error");
                            alertDialog.setMessage("You already finished your plan for today.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    (dialog, which) -> dialog.dismiss());
                            alertDialog.show();
                        } else {
                            int experience = pref.getInt("experience", 0);
                            int neededexperience = pref.getInt("neededexperience", 0);
                            experience = experience + 100;
                            editor.putBoolean("workoutfinished3", true);
                            editor.commit();
                            if (neededexperience - experience <= 0) {
                                AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                                alertDialog.setTitle("Level up");
                                alertDialog.setMessage("Congratulations! You have achieved a new level!");
                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                        (dialog, which) -> dialog.dismiss());
                                alertDialog.show();
                                int level = pref.getInt("charlevel", 0);
                                level = level + 1;
                                editor.putInt("charlevel", level);
                                editor.putInt("neededexperience", neededexperience + 100);
                                editor.putInt("experience", Math.abs(neededexperience - experience));
                            } else {
                                editor.putInt("experience", experience);
                            }
                            editor.commit();
                        }
                    }
                }

                if (dayOfWeek == Calendar.THURSDAY) {
                    if (!pref.getBoolean("workoutday4", false)) {
                        AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("You don't have any plan for today.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                (dialog, which) -> dialog.dismiss());
                        alertDialog.show();
                    } else {
                        if (pref.getBoolean("workoutfinished4", false)) {
                            AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                            alertDialog.setTitle("Error");
                            alertDialog.setMessage("You already finished your plan for today.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    (dialog, which) -> dialog.dismiss());
                            alertDialog.show();
                        } else {
                            int experience = pref.getInt("experience", 0);
                            int neededexperience = pref.getInt("neededexperience", 0);
                            experience = experience + 100;
                            editor.putBoolean("workoutfinished4", true);
                            editor.commit();
                            if (neededexperience - experience <= 0) {
                                AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                                alertDialog.setTitle("Level up");
                                alertDialog.setMessage("Congratulations! You have achieved a new level!");
                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                        (dialog, which) -> dialog.dismiss());
                                alertDialog.show();
                                int level = pref.getInt("charlevel", 0);
                                level = level + 1;
                                editor.putInt("charlevel", level);
                                editor.putInt("neededexperience", neededexperience + 100);
                                editor.putInt("experience", Math.abs(neededexperience - experience));
                            } else {
                                editor.putInt("experience", experience);
                            }
                            editor.commit();
                        }
                    }
                }
                if (dayOfWeek == Calendar.FRIDAY) {
                    if (!pref.getBoolean("workoutday5", false)) {
                        AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("You don't have any plan for today.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                (dialog, which) -> dialog.dismiss());
                        alertDialog.show();
                    } else {
                        if (pref.getBoolean("workoutfinished5", false)) {
                            AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                            alertDialog.setTitle("Error");
                            alertDialog.setMessage("You already finished your plan for today.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    (dialog, which) -> dialog.dismiss());
                            alertDialog.show();
                        } else {
                            int experience = pref.getInt("experience", 0);
                            int neededexperience = pref.getInt("neededexperience", 0);
                            experience = experience + 100;
                            editor.putBoolean("workoutfinished5", true);
                            editor.commit();
                            if (neededexperience - experience <= 0) {
                                AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                                alertDialog.setTitle("Level up");
                                alertDialog.setMessage("Congratulations! You have achieved a new level!");
                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                        (dialog, which) -> dialog.dismiss());
                                alertDialog.show();
                                int level = pref.getInt("charlevel", 0);
                                level = level + 1;
                                editor.putInt("charlevel", level);
                                editor.putInt("neededexperience", neededexperience + 100);
                                editor.putInt("experience", Math.abs(neededexperience - experience));
                            } else {
                                editor.putInt("experience", experience);
                            }
                            editor.commit();
                        }
                    }
                }
                if (dayOfWeek == Calendar.SATURDAY) {
                    if (!pref.getBoolean("workoutday6", false)) {
                        AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("You don't have any plan for today.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                (dialog, which) -> dialog.dismiss());
                        alertDialog.show();
                    } else {
                        if (pref.getBoolean("workoutfinished6", false)) {
                            AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                            alertDialog.setTitle("Error");
                            alertDialog.setMessage("You already finished your plan for today.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    (dialog, which) -> dialog.dismiss());
                            alertDialog.show();
                        } else {
                            int experience = pref.getInt("experience", 0);
                            int neededexperience = pref.getInt("neededexperience", 0);
                            experience = experience + 100;
                            editor.putBoolean("workoutfinished6", true);
                            editor.commit();
                            if (neededexperience - experience <= 0) {
                                AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                                alertDialog.setTitle("Level up");
                                alertDialog.setMessage("Congratulations! You have achieved a new level!");
                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                        (dialog, which) -> dialog.dismiss());
                                alertDialog.show();
                                int level = pref.getInt("charlevel", 0);
                                level = level + 1;
                                editor.putInt("charlevel", level);
                                editor.putInt("neededexperience", neededexperience + 100);
                                editor.putInt("experience", Math.abs(neededexperience - experience));
                            } else {
                                editor.putInt("experience", experience);
                            }
                            editor.commit();
                        }
                    }
                }
                if (dayOfWeek == Calendar.SUNDAY) {
                    if (!pref.getBoolean("workoutday7", false)) {
                        AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("You don't have any plan for today.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                (dialog, which) -> dialog.dismiss());
                        alertDialog.show();
                    } else {
                        if (pref.getBoolean("workoutfinished7", false)) {
                            AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                            alertDialog.setTitle("Error");
                            alertDialog.setMessage("You already finished your plan for today.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    (dialog, which) -> dialog.dismiss());
                            alertDialog.show();
                        } else {
                            int experience = pref.getInt("experience", 0);
                            int neededexperience = pref.getInt("neededexperience", 0);
                            experience = experience + 100;
                            editor.putBoolean("workoutfinished7", true);
                            editor.commit();
                            if (neededexperience - experience <= 0) {
                                AlertDialog alertDialog = new AlertDialog.Builder(WorkoutPrint.this).create();
                                alertDialog.setTitle("Level up");
                                alertDialog.setMessage("Congratulations! You have achieved a new level!");
                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                        (dialog, which) -> dialog.dismiss());
                                alertDialog.show();
                                int level = pref.getInt("charlevel", 0);
                                level = level + 1;
                                editor.putInt("charlevel", level);
                                editor.putInt("neededexperience", neededexperience + 100);
                                editor.putInt("experience", Math.abs(neededexperience - experience));
                            } else {
                                editor.putInt("experience", experience);
                            }
                            editor.commit();
                        }
                    }
                }
            }
        });
        if (dayOfWeek == Calendar.MONDAY) {

            ListView listView = (ListView) findViewById(R.id.workoutlist);
            Gson gson = new Gson();
            String json = pref.getString("workout1", "empty");


            if (!json.equals("empty")) {
                String[] string = gson.fromJson(json, String[].class);
                List<String> sample = Arrays.asList(string);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                listView.setAdapter(adapter);
            } else {
                List<String> sample2 = new ArrayList<>();
                ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                sample2.add("Enjoy your rest day!");
                listView.setAdapter(adapter2);

            }
        }
        if (dayOfWeek == Calendar.TUESDAY) {


            ListView listView = (ListView) findViewById(R.id.workoutlist);
            Gson gson = new Gson();
            String json = pref.getString("workout2", "empty");


            if (!json.equals("empty")) {
                String[] string = gson.fromJson(json, String[].class);
                List<String> sample = Arrays.asList(string);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                listView.setAdapter(adapter);
            } else {
                List<String> sample2 = new ArrayList<>();
                ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                sample2.add("Enjoy your rest day!");
                listView.setAdapter(adapter2);

            }
        }
        if (dayOfWeek == Calendar.WEDNESDAY) {

            ListView listView = (ListView) findViewById(R.id.workoutlist);
            Gson gson = new Gson();
            String json = pref.getString("workout3", "empty");


            if (!json.equals("empty")) {
                String[] string = gson.fromJson(json, String[].class);
                List<String> sample = Arrays.asList(string);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                listView.setAdapter(adapter);
            } else {
                List<String> sample2 = new ArrayList<>();
                ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                sample2.add("Enjoy your rest day!");
                listView.setAdapter(adapter2);

            }
        }
        if (dayOfWeek == Calendar.THURSDAY) {

            ListView listView = (ListView) findViewById(R.id.workoutlist);
            Gson gson = new Gson();
            String json = pref.getString("workout4", "empty");


            if (!json.equals("empty")) {
                String[] string = gson.fromJson(json, String[].class);
                List<String> sample = Arrays.asList(string);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                listView.setAdapter(adapter);
            } else {
                List<String> sample2 = new ArrayList<>();
                ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                sample2.add("Enjoy your rest day!");
                listView.setAdapter(adapter2);

            }
        }
        if (dayOfWeek == Calendar.FRIDAY) {

            ListView listView = (ListView) findViewById(R.id.workoutlist);
            Gson gson = new Gson();
            String json = pref.getString("workout5", "empty");


            if (!json.equals("empty")) {
                String[] string = gson.fromJson(json, String[].class);
                List<String> sample = Arrays.asList(string);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                listView.setAdapter(adapter);
            } else {
                List<String> sample2 = new ArrayList<>();
                ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                sample2.add("Enjoy your rest day!");
                listView.setAdapter(adapter2);

            }
        }
        if (dayOfWeek == Calendar.SATURDAY) {

            ListView listView = (ListView) findViewById(R.id.workoutlist);
            Gson gson = new Gson();
            String json = pref.getString("workout6", "empty");


            if (!json.equals("empty")) {
                String[] string = gson.fromJson(json, String[].class);
                List<String> sample = Arrays.asList(string);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                listView.setAdapter(adapter);
            } else {
                List<String> sample2 = new ArrayList<>();
                ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                sample2.add("Enjoy your rest day!");
                listView.setAdapter(adapter2);

            }
        }
        if (dayOfWeek == Calendar.SUNDAY) {

            ListView listView = (ListView) findViewById(R.id.workoutlist);
            Gson gson = new Gson();
            String json = pref.getString("workout7", "empty");


            if (!json.equals("empty")) {
                String[] string = gson.fromJson(json, String[].class);
                List<String> sample = Arrays.asList(string);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                listView.setAdapter(adapter);
            } else {
                List<String> sample2 = new ArrayList<>();
                ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                sample2.add("Enjoy your rest day!");
                listView.setAdapter(adapter2);

            }

        }
    }
}
