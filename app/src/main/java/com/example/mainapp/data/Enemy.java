package com.example.mainapp.data;

import android.content.Context;
import android.content.SharedPreferences;

public class Enemy {
    private int enemyhp;
    private int enemydamage;
    private int enemyprotection;
    private String name;
    private static final Enemy enemy = new Enemy();

    private Enemy() {
    }

    public static Enemy getEnemy(Context context) {
        enemy.updateEnemy(context);
        return enemy;

    }

    private void updateEnemy(Context context) {
        SharedPreferences pref = DataSource.getInstance(context);
        enemyhp = pref.getInt("enemyhp", 0);
        name = pref.getString("enemy", null);
        enemydamage = pref.getInt("enemydamage", 0);
        enemyprotection = pref.getInt("enemyprotection", 0);
    }

    public int getEnemyhp() {
        return enemyhp;
    }


    public int getEnemydamage() {
        return enemydamage;
    }


    public int getEnemyprotection() {
        return enemyprotection;
    }

    public String getName() {
        return name;
    }
}
