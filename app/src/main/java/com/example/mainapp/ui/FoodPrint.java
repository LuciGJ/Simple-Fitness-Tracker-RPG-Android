package com.example.mainapp.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mainapp.R;
import com.example.mainapp.data.DataSource;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class FoodPrint extends AppCompatActivity {
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(FoodPrint.this, NavigationActivity.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_print);
        Calendar c = Calendar.getInstance();
        TextView caloriesdisplay = (TextView) findViewById(R.id.settotalcaloriesdisplay);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        SharedPreferences pref = DataSource.getInstance(this);
        SharedPreferences.Editor editor = pref.edit();
        int activeplan=pref.getInt("activeplan",1);
        ImageButton tosettings;
        tosettings = (ImageButton) findViewById(R.id.foodsettingsbutton);
        tosettings.setOnClickListener(view -> {

            Intent i = new Intent(FoodPrint.this, FoodSettings.class);
            startActivity(i);


        });
        FloatingActionButton foodexp;
        foodexp = (FloatingActionButton) findViewById(R.id.foodexp);
        foodexp.setOnClickListener(view -> {
            if (!pref.getBoolean("charcreated", false)) {
                AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
                alertDialog.setTitle("Error");
                alertDialog.setMessage("You have to create a character first.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        (dialog, which) -> dialog.dismiss());
                alertDialog.show();
            } else {
                if (dayOfWeek == Calendar.MONDAY) {
                    if (!pref.getBoolean("foodday1", false)) {
                        AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("You don't have any plan for today.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                (dialog, which) -> dialog.dismiss());
                        alertDialog.show();
                    } else {
                        if (pref.getBoolean("foodfinished1", false)) {
                            AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
                            alertDialog.setTitle("Error");
                            alertDialog.setMessage("You already finished your plan for today.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    (dialog, which) -> dialog.dismiss());
                            alertDialog.show();
                        } else {
                            int experience = pref.getInt("experience", 0);
                            int neededexperience = pref.getInt("neededexperience", 0);
                            experience = experience + 100;
                            editor.putBoolean("foodfinished1", true);
                            editor.commit();
                            if (neededexperience - experience <= 0) {
                                AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
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
                            }
                            else
                            {
                                editor.putInt("experience",experience);
                            }
                            editor.commit();
                        }
                    }
                }
                if (dayOfWeek == Calendar.TUESDAY) {
                    if (!pref.getBoolean("foodday2", false)) {
                        AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("You don't have any plan for today.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                (dialog, which) -> dialog.dismiss());
                        alertDialog.show();
                    } else {
                        if (pref.getBoolean("foodfinished2", false)) {
                            AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
                            alertDialog.setTitle("Error");
                            alertDialog.setMessage("You already finished your plan for today.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    (dialog, which) -> dialog.dismiss());
                            alertDialog.show();
                        } else {
                            int experience = pref.getInt("experience", 0);
                            int neededexperience = pref.getInt("neededexperience", 0);
                            experience = experience + 100;
                            editor.putBoolean("foodfinished2", true);
                            editor.commit();
                            if (neededexperience - experience <= 0) {
                                AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
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
                            }
                            else
                            {
                                editor.putInt("experience",experience);
                            }
                            editor.commit();
                        }
                    }
                }
                if (dayOfWeek == Calendar.WEDNESDAY) {
                    if (!pref.getBoolean("foodday3", false)) {
                        AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("You don't have any plan for today.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                (dialog, which) -> dialog.dismiss());
                        alertDialog.show();
                    } else {
                        if (pref.getBoolean("foodfinished3", false)) {
                            AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
                            alertDialog.setTitle("Error");
                            alertDialog.setMessage("You already finished your plan for today.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    (dialog, which) -> dialog.dismiss());
                            alertDialog.show();
                        } else {
                            int experience = pref.getInt("experience", 0);
                            int neededexperience = pref.getInt("neededexperience", 0);
                            experience = experience + 100;
                            editor.putBoolean("foodfinished3", true);
                            editor.commit();
                            if (neededexperience - experience <= 0) {
                                AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
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
                            }
                            else
                            {
                                editor.putInt("experience",experience);
                            }
                            editor.commit();
                        }
                    }
                }

                if (dayOfWeek == Calendar.THURSDAY) {
                    if (!pref.getBoolean("foodday4", false)) {
                        AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("You don't have any plan for today.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                (dialog, which) -> dialog.dismiss());
                        alertDialog.show();
                    } else {
                        if (pref.getBoolean("foodfinished4", false)) {
                            AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
                            alertDialog.setTitle("Error");
                            alertDialog.setMessage("You already finished your plan for today.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    (dialog, which) -> dialog.dismiss());
                            alertDialog.show();
                        } else {
                            int experience = pref.getInt("experience", 0);
                            int neededexperience = pref.getInt("neededexperience", 0);
                            experience = experience + 100;
                            editor.putBoolean("foodfinished4", true);
                            editor.commit();
                            if (neededexperience - experience <= 0) {
                                AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
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
                            }
                            else
                            {
                                editor.putInt("experience",experience);
                            }
                            editor.commit();
                        }
                    }
                }
                if (dayOfWeek == Calendar.FRIDAY) {
                    if (!pref.getBoolean("foodday5", false)) {
                        AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("You don't have any plan for today.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                (dialog, which) -> dialog.dismiss());
                        alertDialog.show();
                    } else {
                        if (pref.getBoolean("foodfinished5", false)) {
                            AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
                            alertDialog.setTitle("Error");
                            alertDialog.setMessage("You already finished your plan for today.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    (dialog, which) -> dialog.dismiss());
                            alertDialog.show();
                        } else {
                            int experience = pref.getInt("experience", 0);
                            int neededexperience = pref.getInt("neededexperience", 0);
                            experience = experience + 100;
                            editor.putBoolean("foodfinished5", true);
                            editor.commit();
                            if (neededexperience - experience <= 0) {
                                AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
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
                            }
                            else
                            {
                                editor.putInt("experience",experience);
                            }
                            editor.commit();
                        }
                    }
                }
                if (dayOfWeek == Calendar.SATURDAY) {
                    if (!pref.getBoolean("foodday6", false)) {
                        AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("You don't have any plan for today.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                (dialog, which) -> dialog.dismiss());
                        alertDialog.show();
                    } else {
                        if (pref.getBoolean("foodfinished6", false)) {
                            AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
                            alertDialog.setTitle("Error");
                            alertDialog.setMessage("You already finished your plan for today.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    (dialog, which) -> dialog.dismiss());
                            alertDialog.show();
                        } else {
                            int experience = pref.getInt("experience", 0);
                            int neededexperience = pref.getInt("neededexperience", 0);
                            experience = experience + 100;
                            editor.putBoolean("foodfinished6", true);
                            editor.commit();
                            if (neededexperience - experience <= 0) {
                                AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
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
                            }
                            else
                            {
                                editor.putInt("experience",experience);
                            }
                            editor.commit();
                        }
                    }
                }
                if (dayOfWeek == Calendar.SUNDAY) {
                    if (!pref.getBoolean("foodday7", false)) {
                        AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("You don't have any plan for today.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                (dialog, which) -> dialog.dismiss());
                        alertDialog.show();
                    } else {
                        if (pref.getBoolean("foodfinished7", false)) {
                            AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
                            alertDialog.setTitle("Error");
                            alertDialog.setMessage("You already finished your plan for today.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    (dialog, which) -> dialog.dismiss());
                            alertDialog.show();
                        } else {
                            int experience = pref.getInt("experience", 0);
                            int neededexperience = pref.getInt("neededexperience", 0);
                            experience = experience + 100;
                            editor.putBoolean("foodfinished7", true);
                            editor.commit();
                            if (neededexperience - experience <= 0) {
                                AlertDialog alertDialog = new AlertDialog.Builder(FoodPrint.this).create();
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
                            }
                            else
                            {
                                editor.putInt("experience",experience);
                            }
                            editor.commit();
                        }
                    }
                }
            }
        });
        if (activeplan==1) {
            if (dayOfWeek == Calendar.MONDAY) {
              
                editor.putBoolean("foodfinished2",false);
                editor.putBoolean("foodfinished3",false);
                editor.putBoolean("foodfinished4",false);
                editor.putBoolean("foodfinished5",false);
                editor.putBoolean("foodfinished6",false);
                editor.putBoolean("foodfinished7",false);
                editor.commit();

                String calorie= pref.getString("calories1","0");
                caloriesdisplay.setText("Total Calories:"+calorie );
                ListView listView = (ListView) findViewById(R.id.listView);
                Gson gson=new Gson();
                String json=pref.getString("food1","empty");
                if (!json.equals("empty")){
                   String[] string=gson.fromJson(json,String[].class);

                    List<String> sample=Arrays.asList(string);
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                    listView.setAdapter(adapter);

                }
                else {
                    List<String> sample2 = new ArrayList<>();
                    ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                    sample2.add("You haven't added anything yet.");
                    listView.setAdapter(adapter2);

                }
            }
            if (dayOfWeek == Calendar.TUESDAY) {
                editor.putBoolean("foodfinished1",false);
                editor.putBoolean("foodfinished3",false);
                editor.putBoolean("foodfinished4",false);
                editor.putBoolean("foodfinished5",false);
                editor.putBoolean("foodfinished6",false);
                editor.putBoolean("foodfinished7",false);
                editor.commit();

                String calorie= pref.getString("calories2","0");
                caloriesdisplay.setText("Total Calories:"+calorie );
                    ListView listView = (ListView) findViewById(R.id.listView);
                    Gson gson=new Gson();
                    String json=pref.getString("food2","empty");
                    if (!json.equals("empty")){
                        String[] string=gson.fromJson(json,String[].class);
                        List<String> sample=Arrays.asList(string);
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                        listView.setAdapter(adapter);
                    }
                    else {
                        List<String> sample2 = new ArrayList<>();
                        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                        sample2.add("You haven't added anything yet.");
                        listView.setAdapter(adapter2);

                    }
            }
            if (dayOfWeek == Calendar.WEDNESDAY) {

                editor.putBoolean("foodfinished1",false);
                editor.putBoolean("foodfinished2",false);
                editor.putBoolean("foodfinished4",false);
                editor.putBoolean("foodfinished5",false);
                editor.putBoolean("foodfinished6",false);
                editor.putBoolean("foodfinished7",false);
                editor.commit();

                String calorie= pref.getString("calories3","0");
                caloriesdisplay.setText("Total Calories:"+calorie );
                    ListView listView = (ListView) findViewById(R.id.listView);
                    Gson gson=new Gson();
                    String json=pref.getString("food3","empty");
                    if (!json.equals("empty")){
                        String[] string=gson.fromJson(json,String[].class);
                        List<String> sample=Arrays.asList(string);
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                        listView.setAdapter(adapter);


                    }
                    else {
                        List<String> sample2 = new ArrayList<>();
                        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                        sample2.add("You haven't added anything yet.");
                        listView.setAdapter(adapter2);

                    }
            }
            if (dayOfWeek == Calendar.THURSDAY) {

                editor.putBoolean("foodfinished1",false);
                editor.putBoolean("foodfinished2",false);
                editor.putBoolean("foodfinished3",false);
                editor.putBoolean("foodfinished5",false);
                editor.putBoolean("foodfinished6",false);
                editor.putBoolean("foodfinished7",false);
                editor.commit();

                String calorie= pref.getString("calories4","0");
                caloriesdisplay.setText("Total Calories:"+calorie );
                    ListView listView = (ListView) findViewById(R.id.listView);
                    Gson gson=new Gson();
                    String json=pref.getString("food4","empty");
                    if (!json.equals("empty")){
                        String[] string=gson.fromJson(json,String[].class);
                        List<String> sample=Arrays.asList(string);
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                        listView.setAdapter(adapter);
                    }
                    else {
                        List<String> sample2 = new ArrayList<>();
                        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                        sample2.add("You haven't added anything yet.");
                        listView.setAdapter(adapter2);

                    }
            }
            if (dayOfWeek == Calendar.FRIDAY) {
                editor.putBoolean("foodfinished1",false);
                editor.putBoolean("foodfinished2",false);
                editor.putBoolean("foodfinished3",false);
                editor.putBoolean("foodfinished4",false);
                editor.putBoolean("foodfinished6",false);
                editor.putBoolean("foodfinished7",false);
                editor.commit();


                String calorie= pref.getString("calories5","0");
                caloriesdisplay.setText("Total Calories:"+calorie );
                    ListView listView = (ListView) findViewById(R.id.listView);
                    Gson gson=new Gson();
                    String json=pref.getString("food5","empty");
                    if (!json.equals("empty")){
                        String[] string=gson.fromJson(json,String[].class);
                        List<String> sample=Arrays.asList(string);
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                        listView.setAdapter(adapter);
                    }
                    else {
                        List<String> sample2 = new ArrayList<>();
                        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                        sample2.add("You haven't added anything yet.");
                        listView.setAdapter(adapter2);

                    }
            }
            if (dayOfWeek == Calendar.SATURDAY) {

                editor.putBoolean("foodfinished1",false);
                editor.putBoolean("foodfinished2",false);
                editor.putBoolean("foodfinished3",false);
                editor.putBoolean("foodfinished4",false);
                editor.putBoolean("foodfinished5",false);
                editor.putBoolean("foodfinished7",false);
                editor.commit();

                String calorie= pref.getString("calories6","0");
                caloriesdisplay.setText("Total Calories:"+calorie );
                    ListView listView = (ListView) findViewById(R.id.listView);
                    Gson gson=new Gson();
                    String json=pref.getString("food6","empty");
                    if (!json.equals("empty")){
                        String[] string=gson.fromJson(json,String[].class);
                        List<String> sample=Arrays.asList(string);
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                        listView.setAdapter(adapter);
                    }
                    else {
                        List<String> sample2 = new ArrayList<>();
                        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                        sample2.add("You haven't added anything yet.");
                        listView.setAdapter(adapter2);

                    }
            }
            if (dayOfWeek == Calendar.SUNDAY) {

                editor.putBoolean("foodfinished1",false);
                editor.putBoolean("foodfinished2",false);
                editor.putBoolean("foodfinished3",false);
                editor.putBoolean("foodfinished4",false);
                editor.putBoolean("foodfinished5",false);
                editor.putBoolean("foodfinished6",false);
                editor.commit();

                String calorie= pref.getString("calories7","0");
                caloriesdisplay.setText("Total Calories:"+calorie );
                    ListView listView = (ListView) findViewById(R.id.listView);
                    Gson gson=new Gson();
                    String json=pref.getString("food7","empty");
                    if (!json.equals("empty")){
                        String[] string=gson.fromJson(json,String[].class);
                        List<String> sample=Arrays.asList(string);
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                        listView.setAdapter(adapter);
                    }
                    else {
                        List<String> sample2 = new ArrayList<>();
                        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                        sample2.add("You haven't added anything yet.");
                        listView.setAdapter(adapter2);

                    }
            }
        }
        if (activeplan==2)
        {
            if (dayOfWeek == Calendar.MONDAY) {
                editor.putBoolean("foodfinished2",false);
                editor.putBoolean("foodfinished3",false);
                editor.putBoolean("foodfinished4",false);
                editor.putBoolean("foodfinished5",false);
                editor.putBoolean("foodfinished6",false);
                editor.putBoolean("foodfinished7",false);
                editor.commit();

                String calorie= pref.getString("calories8","0");
                caloriesdisplay.setText("Total Calories:"+calorie );
                ListView listView = (ListView) findViewById(R.id.listView);
                Gson gson=new Gson();
                String json=pref.getString("food8","empty");
                if (!json.equals("empty")){
                    String[] string=gson.fromJson(json,String[].class);
                    List<String> sample=Arrays.asList(string);
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                    listView.setAdapter(adapter);
                }
                else {
                    List<String> sample2 = new ArrayList<>();
                    ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                    sample2.add("You haven't added anything yet.");
                    listView.setAdapter(adapter2);

                }
            }
            if (dayOfWeek == Calendar.TUESDAY) {
                editor.putBoolean("foodfinished1",false);
                editor.putBoolean("foodfinished3",false);
                editor.putBoolean("foodfinished4",false);
                editor.putBoolean("foodfinished5",false);
                editor.putBoolean("foodfinished6",false);
                editor.putBoolean("foodfinished7",false);
                editor.commit();

                String calorie= pref.getString("calories9","0");
                caloriesdisplay.setText("Total Calories:"+calorie );
                ListView listView = (ListView) findViewById(R.id.listView);
                Gson gson=new Gson();
                String json=pref.getString("food9","empty");
                if (!json.equals("empty")){
                    String[] string=gson.fromJson(json,String[].class);
                    List<String> sample=Arrays.asList(string);
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                    listView.setAdapter(adapter);
                }
                else {
                    List<String> sample2 = new ArrayList<>();
                    ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                    sample2.add("You haven't added anything yet.");
                    listView.setAdapter(adapter2);

                }
            }
            if (dayOfWeek == Calendar.WEDNESDAY) {
                editor.putBoolean("foodfinished1",false);
                editor.putBoolean("foodfinished2",false);
                editor.putBoolean("foodfinished4",false);
                editor.putBoolean("foodfinished5",false);
                editor.putBoolean("foodfinished6",false);
                editor.putBoolean("foodfinished7",false);
                editor.commit();

                String calorie= pref.getString("calories10","0");
                caloriesdisplay.setText("Total Calories:"+calorie );
                ListView listView = (ListView) findViewById(R.id.listView);
                Gson gson=new Gson();
                String json=pref.getString("food10","empty");
                if (!json.equals("empty")){
                    String[] string=gson.fromJson(json,String[].class);
                    List<String> sample=Arrays.asList(string);
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                    listView.setAdapter(adapter);
                }
                else {
                    List<String> sample2 = new ArrayList<>();
                    ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                    sample2.add("You haven't added anything yet.");
                    listView.setAdapter(adapter2);

                }
            }
            if (dayOfWeek == Calendar.THURSDAY) {
                editor.putBoolean("foodfinished1",false);
                editor.putBoolean("foodfinished2",false);
                editor.putBoolean("foodfinished3",false);
                editor.putBoolean("foodfinished5",false);
                editor.putBoolean("foodfinished6",false);
                editor.putBoolean("foodfinished7",false);
                editor.commit();

                String calorie= pref.getString("calories11","0");
                caloriesdisplay.setText("Total Calories:"+calorie );
                ListView listView = (ListView) findViewById(R.id.listView);
                Gson gson=new Gson();
                String json=pref.getString("food11","empty");
                if (!json.equals("empty")){
                    String[] string=gson.fromJson(json,String[].class);
                    List<String> sample=Arrays.asList(string);
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                    listView.setAdapter(adapter);
                }
                else {
                    List<String> sample2 = new ArrayList<>();
                    ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                    sample2.add("You haven't added anything yet.");
                    listView.setAdapter(adapter2);

                }
            }
            if (dayOfWeek == Calendar.FRIDAY) {
                editor.putBoolean("foodfinished1",false);
                editor.putBoolean("foodfinished2",false);
                editor.putBoolean("foodfinished3",false);
                editor.putBoolean("foodfinished4",false);
                editor.putBoolean("foodfinished6",false);
                editor.putBoolean("foodfinished7",false);
                editor.commit();

                String calorie= pref.getString("calories12","0");
                caloriesdisplay.setText("Total Calories:"+calorie );
                ListView listView = (ListView) findViewById(R.id.listView);
                Gson gson=new Gson();
                String json=pref.getString("food12","empty");
                if (!json.equals("empty")){
                    String[] string=gson.fromJson(json,String[].class);
                    List<String> sample=Arrays.asList(string);
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                    listView.setAdapter(adapter);
                }
                else {
                    List<String> sample2 = new ArrayList<>();
                    ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                    sample2.add("You haven't added anything yet.");
                    listView.setAdapter(adapter2);

                }
            }
            if (dayOfWeek == Calendar.SATURDAY) {
                editor.putBoolean("foodfinished1",false);
                editor.putBoolean("foodfinished2",false);
                editor.putBoolean("foodfinished3",false);
                editor.putBoolean("foodfinished4",false);
                editor.putBoolean("foodfinished5",false);
                editor.putBoolean("foodfinished7",false);
                editor.commit();

                String calorie= pref.getString("calories13","0");
                caloriesdisplay.setText("Total Calories:"+calorie );
                ListView listView = (ListView) findViewById(R.id.listView);
                Gson gson=new Gson();
                String json=pref.getString("food13","empty");
                if (!json.equals("empty")){
                    String[] string=gson.fromJson(json,String[].class);
                    List<String> sample=Arrays.asList(string);
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                    listView.setAdapter(adapter);
                }
                else {
                    List<String> sample2 = new ArrayList<>();
                    ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                    sample2.add("You haven't added anything yet.");
                    listView.setAdapter(adapter2);

                }
            }
            if (dayOfWeek == Calendar.SUNDAY) {
                editor.putBoolean("foodfinished1",false);
                editor.putBoolean("foodfinished2",false);
                editor.putBoolean("foodfinished3",false);
                editor.putBoolean("foodfinished4",false);
                editor.putBoolean("foodfinished5",false);
                editor.putBoolean("foodfinished6",false);
                editor.commit();

                String calorie= pref.getString("calories14","0");
                caloriesdisplay.setText("Total Calories:"+calorie );
                ListView listView = (ListView) findViewById(R.id.listView);
                Gson gson=new Gson();
                String json=pref.getString("food14","empty");
                if (!json.equals("empty")){
                    String[] string=gson.fromJson(json,String[].class);
                    List<String> sample=Arrays.asList(string);
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample);
                    listView.setAdapter(adapter);
                }
                else {
                    List<String> sample2 = new ArrayList<>();
                    ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sample2);
                    sample2.add("You haven't added anything yet.");
                    listView.setAdapter(adapter2);

                }
            }
        }
    }
}
