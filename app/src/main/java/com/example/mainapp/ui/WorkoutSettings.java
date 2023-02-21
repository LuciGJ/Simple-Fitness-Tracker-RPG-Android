package com.example.mainapp.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mainapp.R;
import com.example.mainapp.data.DataSource;

public class WorkoutSettings extends AppCompatActivity {
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(WorkoutSettings.this, WorkoutPrint.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_settings);
        Button mondayworkoutbutton=(Button) findViewById(R.id.mondayworkout);
        Intent intent1 = new Intent(WorkoutSettings.this, WorkoutCreate.class);
        Intent intent2 = new Intent(WorkoutSettings.this, CardioMaker.class);
        SharedPreferences pref = DataSource.getInstance(this);
        SharedPreferences.Editor editor = pref.edit();
        ImageButton day1delete=(ImageButton) findViewById(R.id.deletew1);
        day1delete.setOnClickListener(view -> {

            AlertDialog alertDialog = new AlertDialog.Builder(WorkoutSettings.this).create();
            alertDialog.setTitle("Remove plan");
            alertDialog.setMessage("You have removed the plan for monday.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    (dialog, which) -> dialog.dismiss());
            alertDialog.show();
            editor.putString("workout1","empty");
                editor.putBoolean("workoutday1",false);
                editor.commit();


        }


        );
        ImageButton day2delete=(ImageButton) findViewById(R.id.deletew2);
        day2delete.setOnClickListener(view -> {

            AlertDialog alertDialog = new AlertDialog.Builder(WorkoutSettings.this).create();
            alertDialog.setTitle("Remove plan");
            alertDialog.setMessage("You have removed the plan for tuesday.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    (dialog, which) -> dialog.dismiss());
            alertDialog.show();
            editor.putString("workout2","empty");
            editor.putBoolean("workoutday2",false);
            editor.commit();


        }


        );
        ImageButton day3delete=(ImageButton) findViewById(R.id.deletew3);
        day3delete.setOnClickListener(view -> {

            AlertDialog alertDialog = new AlertDialog.Builder(WorkoutSettings.this).create();
            alertDialog.setTitle("Remove plan");
            alertDialog.setMessage("You have removed the plan for wednesday.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    (dialog, which) -> dialog.dismiss());
            alertDialog.show();
            editor.putBoolean("workoutday3",false);
            editor.putString("workout3","empty");
            editor.commit();


        }


        );
        ImageButton day4delete=(ImageButton) findViewById(R.id.deletew4);
        day4delete.setOnClickListener(view -> {

            AlertDialog alertDialog = new AlertDialog.Builder(WorkoutSettings.this).create();
            alertDialog.setTitle("Remove plan");
            alertDialog.setMessage("You have removed the plan for thursday.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    (dialog, which) -> dialog.dismiss());
            alertDialog.show();
            editor.putBoolean("workoutday4",false);
            editor.putString("workout4","empty");
            editor.commit();


        }


        );
        ImageButton day5delete=(ImageButton) findViewById(R.id.deletew5);
        day5delete.setOnClickListener(view -> {
            AlertDialog alertDialog = new AlertDialog.Builder(WorkoutSettings.this).create();
            alertDialog.setTitle("Remove plan");
            alertDialog.setMessage("You have removed the plan for friday.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    (dialog, which) -> dialog.dismiss());
            alertDialog.show();
            editor.putBoolean("workoutday5",false);
            editor.putString("workout5","empty");
            editor.commit();


        }


        );
        ImageButton day6delete=(ImageButton) findViewById(R.id.deletew6);
        day6delete.setOnClickListener(view -> {

            AlertDialog alertDialog = new AlertDialog.Builder(WorkoutSettings.this).create();
            alertDialog.setTitle("Remove plan");
            alertDialog.setMessage("You have removed the plan for saturday.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    (dialog, which) -> dialog.dismiss());
            alertDialog.show();
            editor.putBoolean("workoutday6",false);
            editor.putString("workout6","empty");
            editor.commit();


        }


        );
        ImageButton day7delete=(ImageButton) findViewById(R.id.deletew7);
        day7delete.setOnClickListener(view -> {

            AlertDialog alertDialog = new AlertDialog.Builder(WorkoutSettings.this).create();
            alertDialog.setTitle("Remove plan");
            alertDialog.setMessage("You have removed the plan for sunday.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    (dialog, which) -> dialog.dismiss());
            alertDialog.show();
            editor.putBoolean("workoutday7",false);
            editor.putString("workout7","empty");
            editor.commit();


        }


        );
        mondayworkoutbutton.setOnClickListener(view -> {
            SharedPreferences pref17 = DataSource.getInstance(WorkoutSettings.this);
            SharedPreferences.Editor editor17 = pref17.edit();
            editor17.putInt("workday",1);
            editor17.commit();
            AlertDialog.Builder builder = new AlertDialog.Builder(WorkoutSettings.this);
            builder.setTitle("Choose workout type");

            // add a list
            String[] workouts = {"Strength/Endurance","Cardio","Cancel"};
            builder.setItems(workouts, (dialog, which) -> {
                switch (which) {
                    case 0:

                        startActivity(intent1);
                        break;

                    case 1:


                        startActivity(intent2);
                        break;
                    case 2:
                        break;


                }
            });

            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }


        );
        Button tuesdayworkbutton=(Button) findViewById(R.id.tuesdayworkout);
        tuesdayworkbutton.setOnClickListener(view -> {
            SharedPreferences pref16 = DataSource.getInstance(WorkoutSettings.this);
            SharedPreferences.Editor editor16 = pref16.edit();
            editor16.putInt("workday",2);
            editor16.commit();
            AlertDialog.Builder builder2 = new AlertDialog.Builder(WorkoutSettings.this);
            builder2.setTitle("Choose workout type");

            // add a list
            String[] workouts = {"Strength/Endurance","Cardio","Cancel"};
            builder2.setItems(workouts, (dialog, which) -> {
                switch (which) {
                    case 0: {

                        startActivity(intent1);
                        break;
                    }

                    case 1: {

                        startActivity(intent2);
                        break;
                    }
                    case 2: {
                        break;
                    }


                }
            });

            // create and show the alert dialog
            AlertDialog dialog2 = builder2.create();
            dialog2.show();
        }


        );
        Button wednesdayworkbutton=(Button) findViewById(R.id.wednesdayworkout);
        wednesdayworkbutton.setOnClickListener(view -> {
            SharedPreferences pref15 = DataSource.getInstance(WorkoutSettings.this);
            SharedPreferences.Editor editor15 = pref15.edit();
            editor15.putInt("workday",3);
            editor15.commit();
            AlertDialog.Builder builder = new AlertDialog.Builder(WorkoutSettings.this);
            builder.setTitle("Choose workout type");

            // add a list
            String[] workouts = {"Strength/Endurance","Cardio","Cancel"};
            builder.setItems(workouts, (dialog, which) -> {
                switch (which) {
                    case 0: {

                        startActivity(intent1);
                        break;
                    }

                    case 1: {

                        startActivity(intent2);
                        break;
                    }
                    case 2: {
                        break;
                    }


                }
            });

            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }


        );
        Button thursdayworkbutton=(Button) findViewById(R.id.thursdayworkout);
        thursdayworkbutton.setOnClickListener(view -> {
            SharedPreferences pref14 = DataSource.getInstance(WorkoutSettings.this);
            SharedPreferences.Editor editor14 = pref14.edit();
            editor14.putInt("workday",4);
            editor14.commit();
            AlertDialog.Builder builder = new AlertDialog.Builder(WorkoutSettings.this);
            builder.setTitle("Choose workout type");

            // add a list
            String[] workouts = {"Strength/Endurance","Cardio","Cancel"};
            builder.setItems(workouts, (dialog, which) -> {
                switch (which) {
                    case 0: {

                        startActivity(intent1);
                        break;
                    }

                    case 1: {

                        startActivity(intent2);
                        break;
                    }
                    case 2: {
                        break;

                    }


                }
            });

            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }


        );
        Button fridayworkbutton=(Button) findViewById(R.id.fridayworkout);
        fridayworkbutton.setOnClickListener(view -> {
            SharedPreferences pref13 = DataSource.getInstance(WorkoutSettings.this);
            SharedPreferences.Editor editor13 = pref13.edit();
            editor13.putInt("workday",5);
            editor13.commit();
            AlertDialog.Builder builder = new AlertDialog.Builder(WorkoutSettings.this);
            builder.setTitle("Choose workout type");

            // add a list
            String[] workouts = {"Strength/Endurance","Cardio","Cancel"};
            builder.setItems(workouts, (dialog, which) -> {
                switch (which) {
                    case 0: {

                        startActivity(intent1);
                        break;
                    }

                    case 1: {
                        Intent intent8 = new Intent(WorkoutSettings.this, CardioMaker.class);
                        startActivity(intent2);
                        break;
                    }
                    case 2: {
                        break;

                    }


                }
            });

            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }


        );
        Button toexercises;
        toexercises = (Button) findViewById(R.id.tomyexercises);
        toexercises.setOnClickListener(view -> {


            Intent i = new Intent(WorkoutSettings.this, Exercises.class);
            startActivity(i);


        });
        Button saturdayworkbutton=(Button) findViewById(R.id.saturdayworkout);
        saturdayworkbutton.setOnClickListener(view -> {
            SharedPreferences pref12 = DataSource.getInstance(WorkoutSettings.this);
            SharedPreferences.Editor editor12 = pref12.edit();
            editor12.putInt("workday",6);
            editor12.commit();
            AlertDialog.Builder builder = new AlertDialog.Builder(WorkoutSettings.this);
            builder.setTitle("Choose workout type");

            // add a list
            String[] workouts = {"Strength/Endurance","Cardio","Cancel"};
            builder.setItems(workouts, (dialog, which) -> {
                switch (which) {
                    case 0: {

                        startActivity(intent1);
                        break;
                    }

                    case 1: {

                        startActivity(intent2);
                        break;
                    }
                    case 2: {
                        break;

                    }


                }
            });

            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }


        );
        Button sundayworkbutton=(Button) findViewById(R.id.sundayworkout);
        sundayworkbutton.setOnClickListener(view -> {
            SharedPreferences pref1 = DataSource.getInstance(WorkoutSettings.this);
            SharedPreferences.Editor editor1 = pref1.edit();
            editor1.putInt("workday",7);
            editor1.commit();
            AlertDialog.Builder builder = new AlertDialog.Builder(WorkoutSettings.this);
            builder.setTitle("Choose workout type");

            // add a list
            String[] workouts = {"Strength/Endurance","Cardio","Cancel"};
            builder.setItems(workouts, (dialog, which) -> {
                switch (which) {
                    case 0: {

                        startActivity(intent1);
                        break;
                    }

                    case 1: {

                        startActivity(intent2);
                        break;
                    }
                    case 2: {
                        break;

                    }


                }
            });

            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }


        );
        Button donebutton=(Button) findViewById(R.id.workoutdonebutton);
        donebutton.setOnClickListener(view -> {

            Intent i = new Intent(WorkoutSettings.this, WorkoutPrint.class);
            startActivity(i);
        }


        );
    }
}