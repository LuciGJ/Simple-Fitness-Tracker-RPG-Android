package com.example.mainapp.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mainapp.R;
import com.example.mainapp.utility.Utilities;
import com.example.mainapp.data.Enemy;
import com.example.mainapp.data.User;

import java.util.ArrayList;

public class BattleScreen extends AppCompatActivity {
    private TextView userHP;
    private TextView enemyHP;
    private TextView energy;
    private int currenthp;
    private int enemycurrenthp;
    final ArrayList<String> log = new ArrayList<>();
    ArrayAdapter<String> adapter;


    @Override
    public void onBackPressed() {
        Intent i = new Intent(BattleScreen.this, Arena.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_screen);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        User user = User.getUser(this);
        Enemy enemy = Enemy.getEnemy(this);
        energy = (TextView) findViewById(R.id.userenergy);
        TextView username = (TextView) findViewById(R.id.battlename);
        userHP = (TextView) findViewById(R.id.userhp);
        TextView enemyname = (TextView) findViewById(R.id.battlenemy);
        enemyHP = (TextView) findViewById(R.id.enemyhp);
        ListView battlelog = findViewById(R.id.battlelog);
        adapter = new ArrayAdapter<>(BattleScreen.this,
                android.R.layout.simple_list_item_1,
                log);
        battlelog.setAdapter(adapter);
        username.setText(user.getUsername());
        currenthp = user.getHp();
        energy.setText("Energy: " + user.getUserenergy() + "/10");
        userHP.setText(currenthp + "/" + user.getHp());
        enemyname.setText(pref.getString("enemy", null));
        enemycurrenthp = enemy.getEnemyhp();
        enemyHP.setText(enemycurrenthp + "/" + enemy.getEnemyhp());
        Button attackbutton;
        attackbutton = (Button) findViewById(R.id.attackbutton);
        attackbutton.setOnClickListener(view -> {
            int userattack = Utilities.getRandomNumber(user.getDamage() - 15, user.getDamage() + 15);
            enemycurrenthp = enemycurrenthp - userattack + enemy.getEnemyprotection();
            adapter.add(user.getUsername() + " has attacked " + enemy.getName() + " for " + (userattack - enemy.getEnemyprotection()) + " damage.");
            enemyHP.setText(enemycurrenthp + "/" + enemy.getEnemyhp());
            int enemyattack = Utilities.getRandomNumber(enemy.getEnemydamage() - 15, enemy.getEnemydamage() + 15);
            currenthp = currenthp - enemyattack + user.getProtection();
            adapter.add(enemy.getName() + " has attacked " + user.getUsername() + " for " + (enemyattack - user.getProtection()) + " damage.");
            userHP.setText(currenthp + "/" + user.getHp());
            if (currenthp <= 0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(BattleScreen.this);
                builder.setMessage("You have lost the battle!")
                        .setCancelable(false)
                        .setPositiveButton("OK", (dialog, id) -> {
                            Intent i = new Intent(BattleScreen.this, Arena.class);
                            startActivity(i);
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
            if (enemycurrenthp <= 0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(BattleScreen.this);
                builder.setMessage("You have won the battle!")
                        .setCancelable(false)
                        .setPositiveButton("OK", (dialog, id) -> {
                            editor.putInt("gold", pref.getInt("gold", 0) + 500);
                            editor.putBoolean("finishquest1", true);
                            editor.commit();
                            Intent i = new Intent(BattleScreen.this, Arena.class);
                            startActivity(i);
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        Button runbutton;
        runbutton = (Button) findViewById(R.id.runbutton);
        runbutton.setOnClickListener(view -> new AlertDialog.Builder(BattleScreen.this)
                .setTitle("Run")
                .setMessage("Are you sure you want to run?")


                .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                    Intent i = new Intent(BattleScreen.this, Arena.class);
                    startActivity(i);
                })

                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show());
        Button blockbutton;
        blockbutton = (Button) findViewById(R.id.blockbutton);
        blockbutton.setOnClickListener(view -> adapter.add(user.getUsername() + " has blocked the attack."));
        Button useitem = (Button) findViewById(R.id.itemsbutton);
        useitem.setOnClickListener(view -> {


                    AlertDialog.Builder builder = new AlertDialog.Builder(BattleScreen.this);
                    builder.setTitle("What would you like to do?");
                    String energydrinks = "Energy Drinks- " + user.getEnergydrink();
                    String proteinshakes = "Protein Shakes- " + user.getProtein();
                    String[] items = {energydrinks, proteinshakes, "Cancel"};
                    builder.setItems(items, (dialog, which) -> {
                        switch (which) {
                            case 0: {
                                if (user.getEnergydrink() > 0) {
                                    user.setEnergydrink(user.getEnergydrink() - 1);
                                    if (user.getUserenergy() + 5 <= 10) {
                                        user.setUserenergy(user.getUserenergy() + 5);
                                    } else {
                                        user.setUserenergy(10);
                                    }
                                    int enemyattack = Utilities.getRandomNumber(enemy.getEnemydamage() - 15, enemy.getEnemydamage() + 15);
                                    currenthp = currenthp - enemyattack + user.getProtection();
                                    adapter.add(enemy.getName() + " has attacked " + user.getUsername() + " for " + (enemyattack - user.getProtection()) + " damage.");
                                    userHP.setText(currenthp + "/" + user.getHp());
                                    energy.setText("Energy: " + user.getUserenergy() + "/10");
                                    editor.putInt("energydrinks", user.getEnergydrink());
                                    editor.commit();
                                    adapter.add(user.getUsername() + " has used an energy drink.");
                                    if (currenthp <= 0) {
                                        AlertDialog.Builder builder12 = new AlertDialog.Builder(BattleScreen.this);
                                        builder12.setMessage("You have lost the battle!")
                                                .setCancelable(false)
                                                .setPositiveButton("OK", (dialog1, id) -> {
                                                    Intent i = new Intent(BattleScreen.this, Arena.class);
                                                    startActivity(i);
                                                });
                                        AlertDialog alert = builder12.create();
                                        alert.show();
                                    }
                                }
                                break;
                            }

                            case 1: {
                                if (user.getProtein() > 0) {
                                    user.setProtein(user.getProtein() - 1);
                                    if (currenthp + 20 <= user.getHp()) {
                                        currenthp = currenthp + 20;
                                    } else {
                                        currenthp = user.getHp();
                                    }
                                    int enemyattack = Utilities.getRandomNumber(enemy.getEnemydamage() - 15, enemy.getEnemydamage() + 15);
                                    currenthp = currenthp - enemyattack + user.getProtection();
                                    adapter.add(enemy.getName() + " has attacked " + user.getUsername() + " for " + (enemyattack - user.getProtection()) + " damage.");
                                    userHP.setText(currenthp + "/" + user.getHp());
                                    editor.putInt("proteinshake", user.getProtein());
                                    editor.commit();
                                    adapter.add(user.getUsername() + " has used a protein shake.");
                                    if (currenthp <= 0) {
                                        AlertDialog.Builder builder12 = new AlertDialog.Builder(BattleScreen.this);
                                        builder12.setMessage("You have lost the battle!")
                                                .setCancelable(false)
                                                .setPositiveButton("OK", (dialog12, id) -> {
                                                    Intent i = new Intent(BattleScreen.this, Arena.class);
                                                    startActivity(i);
                                                });
                                        AlertDialog alert = builder12.create();
                                        alert.show();
                                    }
                                }
                                break;
                            }
                            case 2: {
                                break;
                            }


                        }
                    });


                    AlertDialog dialog = builder.create();
                    dialog.show();
                }


        );
        Button useskill = (Button) findViewById(R.id.skillsbutton);
        useskill.setOnClickListener(view -> {


                    AlertDialog.Builder builder = new AlertDialog.Builder(BattleScreen.this);
                    builder.setTitle("What would you like to do?");
                    String[] items = {"Kick- 5 energy", "Punch- 3 energy", "Heal- 10 energy", "Push- 7 energy", "Cancel"};
                    builder.setItems(items, (dialog, which) -> {
                        switch (which) {
                            case 0: {
                                if (user.getUserenergy() - 5 >= 0) {
                                    user.setUserenergy(user.getUserenergy() - 5);
                                    int kickdamage = pref.getInt("kicklevel", 0) * 5 + 50;
                                    int userattack = Utilities.getRandomNumber(kickdamage - 15, kickdamage + 15);
                                    enemycurrenthp = enemycurrenthp - userattack + enemy.getEnemyprotection();
                                    adapter.add(user.getUsername() + " has kicked " + enemy.getName() + " for " + (userattack - enemy.getEnemyprotection()) + " damage.");
                                    enemyHP.setText(enemycurrenthp + "/" + enemy.getEnemyhp());
                                    int enemyattack = Utilities.getRandomNumber(enemy.getEnemydamage() - 15, enemy.getEnemydamage() + 15);
                                    currenthp = currenthp - enemyattack + user.getProtection();
                                    adapter.add(enemy.getName() + " has attacked " + user.getUsername() + " for " + (enemyattack - user.getProtection()) + " damage.");
                                    userHP.setText(currenthp + "/" + user.getHp());
                                    energy.setText("Energy: " + user.getUserenergy() + "/10");

                                    if (currenthp <= 0) {
                                        AlertDialog.Builder builder1 = new AlertDialog.Builder(BattleScreen.this);
                                        builder1.setMessage("You have lost the battle!")
                                                .setCancelable(false)
                                                .setPositiveButton("OK", (dialog13, id) -> {
                                                    Intent i = new Intent(BattleScreen.this, Arena.class);
                                                    startActivity(i);
                                                });
                                        AlertDialog alert = builder1.create();
                                        alert.show();
                                    }
                                    if (enemycurrenthp <= 0) {
                                        AlertDialog.Builder builder1 = new AlertDialog.Builder(BattleScreen.this);
                                        builder1.setMessage("You have won the battle!")
                                                .setCancelable(false)
                                                .setPositiveButton("OK", (dialog14, id) -> {
                                                    editor.putInt("gold", pref.getInt("gold", 0) + 500);
                                                    editor.putBoolean("finishquest1", true);
                                                    editor.commit();
                                                    Intent i = new Intent(BattleScreen.this, Arena.class);
                                                    startActivity(i);
                                                });
                                        AlertDialog alert = builder1.create();
                                        alert.show();
                                    }
                                }
                                break;
                            }

                            case 1: {
                                if (user.getUserenergy() - 3 >= 0) {
                                    user.setUserenergy(user.getUserenergy() - 3);
                                    int punchdamage = pref.getInt("punchlevel", 0) * 5 + 35;
                                    int userattack = Utilities.getRandomNumber(punchdamage - 15, punchdamage + 15);
                                    enemycurrenthp = enemycurrenthp - userattack + enemy.getEnemyprotection();
                                    adapter.add(user.getUsername() + " has punched " + enemy.getName() + " for " + (userattack - enemy.getEnemyprotection()) + " damage.");
                                    enemyHP.setText(enemycurrenthp + "/" + enemy.getEnemyhp());
                                    int enemyattack = Utilities.getRandomNumber(enemy.getEnemydamage() - 15, enemy.getEnemydamage() + 15);
                                    currenthp = currenthp - enemyattack + user.getProtection();
                                    adapter.add(enemy.getName() + " has attacked " + user.getUsername() + " for " + (enemyattack - user.getProtection()) + " damage.");
                                    userHP.setText(currenthp + "/" + user.getHp());
                                    energy.setText("Energy: " + user.getUserenergy() + "/10");

                                    if (currenthp <= 0) {
                                        AlertDialog.Builder builder1 = new AlertDialog.Builder(BattleScreen.this);
                                        builder1.setMessage("You have lost the battle!")
                                                .setCancelable(false)
                                                .setPositiveButton("OK", (dialog15, id) -> {
                                                    Intent i = new Intent(BattleScreen.this, Arena.class);
                                                    startActivity(i);
                                                });
                                        AlertDialog alert = builder1.create();
                                        alert.show();
                                    }
                                    if (enemycurrenthp <= 0) {
                                        AlertDialog.Builder builder1 = new AlertDialog.Builder(BattleScreen.this);
                                        builder1.setMessage("You have won the battle!")
                                                .setCancelable(false)
                                                .setPositiveButton("OK", (dialog16, id) -> {
                                                    editor.putInt("gold", pref.getInt("gold", 0) + 500);
                                                    editor.putBoolean("finishquest1", true);
                                                    editor.commit();
                                                    Intent i = new Intent(BattleScreen.this, Arena.class);
                                                    startActivity(i);
                                                });
                                        AlertDialog alert = builder1.create();
                                        alert.show();
                                    }
                                }
                                break;
                            }
                            case 2: {
                                if (user.getUserenergy() - 10 >= 0) {
                                    user.setUserenergy(user.getUserenergy() - 10);
                                    int heal = pref.getInt("heallevel", 0) * 5 + 100;

                                    adapter.add(user.getUsername() + " has healed for " + heal + " HP");
                                    if (currenthp + heal <= user.getHp()) {
                                        currenthp = currenthp + heal;
                                    } else {
                                        currenthp = user.getHp();
                                    }
                                    int enemyattack = Utilities.getRandomNumber(enemy.getEnemydamage() - 15, enemy.getEnemydamage() + 15);
                                    currenthp = currenthp - enemyattack + user.getProtection();
                                    adapter.add(enemy.getName() + " has attacked " + user.getUsername() + " for " + (enemyattack - user.getProtection()) + " damage.");
                                    userHP.setText(currenthp + "/" + user.getHp());
                                    energy.setText("Energy: " + user.getUserenergy() + "/10");

                                    if (currenthp <= 0) {
                                        AlertDialog.Builder builder1 = new AlertDialog.Builder(BattleScreen.this);
                                        builder1.setMessage("You have lost the battle!")
                                                .setCancelable(false)
                                                .setPositiveButton("OK", (dialog17, id) -> {
                                                    Intent i = new Intent(BattleScreen.this, Arena.class);
                                                    startActivity(i);
                                                });
                                        AlertDialog alert = builder1.create();
                                        alert.show();
                                    }
                                    if (enemycurrenthp <= 0) {
                                        AlertDialog.Builder builder1 = new AlertDialog.Builder(BattleScreen.this);
                                        builder1.setMessage("You have won the battle!")
                                                .setCancelable(false)
                                                .setPositiveButton("OK", (dialog18, id) -> {
                                                    editor.putInt("gold", pref.getInt("gold", 0) + 500);
                                                    editor.putBoolean("finishquest1", true);
                                                    editor.commit();
                                                    Intent i = new Intent(BattleScreen.this, Arena.class);
                                                    startActivity(i);
                                                });
                                        AlertDialog alert = builder1.create();
                                        alert.show();
                                    }
                                }
                                break;
                            }
                            case 3: {
                                if (user.getUserenergy() - 7 >= 0) {
                                    user.setUserenergy(user.getUserenergy() - 7);
                                    int pushdamage = pref.getInt("pushlevel", 0) * 5 + 200;
                                    int userattack = Utilities.getRandomNumber(pushdamage - 15, pushdamage + 15);
                                    enemycurrenthp = enemycurrenthp - userattack + enemy.getEnemyprotection();
                                    adapter.add(user.getUsername() + " has pushed " + enemy.getName() + " for " + (userattack - enemy.getEnemyprotection()) + " damage.");
                                    enemyHP.setText(enemycurrenthp + "/" + enemy.getEnemyhp());
                                    int enemyattack = Utilities.getRandomNumber(enemy.getEnemydamage() - 15, enemy.getEnemydamage() + 15);
                                    currenthp = currenthp - enemyattack + user.getProtection();
                                    adapter.add(enemy.getName() + " has attacked " + user.getUsername() + " for " + (enemyattack - user.getProtection()) + " damage.");
                                    userHP.setText(currenthp + "/" + user.getHp());
                                    energy.setText("Energy: " + user.getUserenergy() + "/10");

                                    if (currenthp <= 0) {
                                        AlertDialog.Builder builder1 = new AlertDialog.Builder(BattleScreen.this);
                                        builder1.setMessage("You have lost the battle!")
                                                .setCancelable(false)
                                                .setPositiveButton("OK", (dialog19, id) -> {
                                                    Intent i = new Intent(BattleScreen.this, Arena.class);
                                                    startActivity(i);
                                                });
                                        AlertDialog alert = builder1.create();
                                        alert.show();
                                    }
                                    if (enemycurrenthp <= 0) {
                                        AlertDialog.Builder builder1 = new AlertDialog.Builder(BattleScreen.this);
                                        builder1.setMessage("You have won the battle!")
                                                .setCancelable(false)
                                                .setPositiveButton("OK", (dialog110, id) -> {
                                                    editor.putInt("gold", pref.getInt("gold", 0) + 500);
                                                    editor.putBoolean("finishquest1", true);
                                                    editor.commit();
                                                    Intent i = new Intent(BattleScreen.this, Arena.class);
                                                    startActivity(i);
                                                });
                                        AlertDialog alert = builder1.create();
                                        alert.show();
                                    }
                                }
                                break;
                            }
                            case 4: {
                                break;
                            }


                        }
                    });


                    AlertDialog dialog = builder.create();
                    dialog.show();
                }


        );


    }
}