package com.example.mainapp.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import com.example.mainapp.R;
import com.example.mainapp.data.DataSource;

public class Arena extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        Intent i = new Intent(Arena.this, CharacterPage.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arena);
        SharedPreferences pref = DataSource.getInstance(this);
        SharedPreferences.Editor editor = pref.edit();
        Button nextBattle;
        nextBattle = (Button) findViewById(R.id.nextbattlebutton);
        nextBattle.setOnClickListener(view -> {
            if (pref.getBoolean("punchskill", false) && pref.getBoolean("healskill", false) && pref.getBoolean("pushskill", false) && pref.getBoolean("kickskill", false)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Arena.this);
                builder.setTitle("Choose an enemy to fight");
                Intent i = new Intent(Arena.this, BattleScreen.class);
                String[] enemies = {"Gym Rat", "Personal Trainer", "Bodybuilder", "Cancel"};
                builder.setItems(enemies, (dialog, which) -> {
                    switch (which) {
                        case 0:

                            editor.putInt("enemyhp", 350);
                            editor.putInt("enemydamage", 20);
                            editor.putInt("enemyprotection", 10);
                            editor.putString("enemy", "Gym Rat");
                            editor.commit();
                            startActivity(i);

                            break;

                        case 1:

                            editor.putInt("enemyhp", 400);
                            editor.putInt("enemydamage", 22);
                            editor.putInt("enemyprotection", 12);
                            editor.putString("enemy", "Personal Trainer");
                            editor.commit();
                            startActivity(i);


                            break;
                        case 2:

                            editor.putInt("enemyhp", 500);
                            editor.putInt("enemydamage", 30);
                            editor.putInt("enemyprotection", 30);
                            editor.putString("enemy", "Bodybuilder");
                            editor.commit();
                            startActivity(i);
                            break;
                        case 3:
                            break;


                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();


            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(Arena.this);
                builder.setMessage("You have to learn all the skills first!")
                        .setCancelable(false)
                        .setPositiveButton("OK", (dialog, id) -> {
                            Intent i = new Intent(Arena.this, Training.class);
                            startActivity(i);
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }

        });
        Button arenaBack;
        arenaBack = (Button) findViewById(R.id.arenabackbutton);
        arenaBack.setOnClickListener(view -> {


            Intent i = new Intent(Arena.this, CharacterPage.class);
            startActivity(i);


        });
    }
}