package com.example.mainapp.data;

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    private int hp;
    private int damage;
    private int protection;
    private int userenergy = 10;
    private int protein;
    private int energydrink;
    private String username;
    private int strengthint;
    private int agilityint;
    private int enduranceint;
    private int level;

    private static final User user = new User();

    private User() {
    }

    public static User getUser(Context context) {
        user.updateUser(context);
        return user;
    }

    private void updateUser(Context context) {
        SharedPreferences pref = DataSource.getInstance(context);
        protein = pref.getInt("proteinshake", 0);
        energydrink = pref.getInt("energydrinks", 0);
        username = pref.getString("username", null);
        hp = pref.getInt("HP", 0);
        damage = pref.getInt("currentdamage", 0) + pref.getInt("power", 0);
        protection = pref.getInt("currentprotection", 0);
        strengthint=pref.getInt("strength",0);
        agilityint=pref.getInt("agility",0);
        enduranceint=pref.getInt("endurance",0);
        level=pref.getInt("charlevel",0);

    }

    public int getHp() {
        return hp;
    }

    public int getDamage() {
        return damage;
    }

    public int getProtection() {
        return protection;
    }

    public int getUserenergy() {
        return userenergy;
    }

    public int getProtein() {
        return protein;
    }

    public int getEnergydrink() {
        return energydrink;
    }

    public String getUsername() {
        return username;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public void setUserenergy(int userenergy) {
        this.userenergy = userenergy;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public void setEnergydrink(int energydrink) {
        this.energydrink = energydrink;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStrengthint() {
        return strengthint;
    }

    public void setStrengthint(int strengthint) {
        this.strengthint = strengthint;
    }

    public int getAgilityint() {
        return agilityint;
    }

    public void setAgilityint(int agilityint) {
        this.agilityint = agilityint;
    }

    public int getEnduranceint() {
        return enduranceint;
    }

    public void setEnduranceint(int enduranceint) {
        this.enduranceint = enduranceint;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
