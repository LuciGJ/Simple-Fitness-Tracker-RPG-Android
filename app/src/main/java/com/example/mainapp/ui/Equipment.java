package com.example.mainapp.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.mainapp.R;
import com.example.mainapp.data.DataSource;

public class Equipment extends AppCompatActivity {
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(Equipment.this, CharacterPage.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);
        SharedPreferences pref = DataSource.getInstance(this);
        SharedPreferences.Editor editor = pref.edit();
        TextView weapon = (TextView) findViewById(R.id.weaponcurrent);
        TextView armor = (TextView) findViewById(R.id.armorcurrent);
        TextView damage = (TextView) findViewById(R.id.weapondamage);
        TextView protection = (TextView) findViewById(R.id.armorprotection);
        weapon.setText("Weapon: "+pref.getString("weapon","Nothing"));
        armor.setText("Armor: "+pref.getString("armor","Nothing"));
       damage.setText("Weapon Damage: "+ pref.getInt("currentdamage", 0));
       protection.setText("Armor Protection: "+ pref.getInt("currentprotection", 0));
        Button backequipment;
        backequipment = (Button) findViewById(R.id.equipmentback);
        backequipment.setOnClickListener(view -> {


            Intent i = new Intent(Equipment.this, CharacterPage.class);
            startActivity(i);


        });
        Button weaponsbutton=(Button) findViewById(R.id.changeweapon);
        weaponsbutton.setOnClickListener(view -> {


            AlertDialog.Builder builder = new AlertDialog.Builder(Equipment.this);
            builder.setTitle("What would you like to equip?");
            String[] items = {"Box Gloves","Wrist Wraps ","Nothing"};
            builder.setItems(items, (dialog, which) -> {
                switch (which) {
                    case 0: {

                        if (pref.getBoolean("boxinggloves", false)) {
                            editor.putString("weapon", "Boxing Gloves");
                            editor.putInt("currentdamage", 30);
                            editor.commit();
                        }


                        Intent i = new Intent(Equipment.this, Equipment.class);

                        startActivity(i);
                        break;
                    }

                    case 1: {
                        if (pref.getBoolean("wristwraps", false)) {
                            editor.putString("weapon", "Wrist Wraps");
                            editor.putInt("currentdamage", 10);
                            editor.commit();
                        }
                        Intent i = new Intent(Equipment.this, Equipment.class);
                        startActivity(i);
                        break;
                    }
                    case 2: {
                        editor.putString("weapon", "Nothing");
                        editor.putInt("currentdamage", 0);
                        editor.commit();
                        Intent i = new Intent(Equipment.this, Equipment.class);

                        startActivity(i);
                    }


                }
            });


            AlertDialog dialog = builder.create();
            dialog.show();
        }


        );
        Button armorbutton=(Button) findViewById(R.id.changearmor);
        armorbutton.setOnClickListener(view -> {


            AlertDialog.Builder builder = new AlertDialog.Builder(Equipment.this);
            builder.setTitle("What would you like to equip?");
            String[] items = {"Gym Suit","Tank Top ","Nothing"};
            builder.setItems(items, (dialog, which) -> {
                switch (which) {
                    case 0: {

                        if (pref.getBoolean("gymsuit", false)) {
                            editor.putString("armor", "Gym Suit");
                            editor.putInt("currentprotection", 30);
                            editor.commit();
                        }


                        Intent i = new Intent(Equipment.this, Equipment.class);

                        startActivity(i);
                        break;
                    }

                    case 1: {
                        if (pref.getBoolean("tanktop", false)) {
                            editor.putString("armor", "Tank Top");
                            editor.putInt("currentprotection", 10);
                            editor.commit();
                        }
                        Intent i = new Intent(Equipment.this, Equipment.class);
                        startActivity(i);
                        break;
                    }
                    case 2: {
                        editor.putString("armor", "Nothing");
                        editor.putInt("currentprotection", 0);
                        editor.commit();
                        Intent i = new Intent(Equipment.this, Equipment.class);

                        startActivity(i);
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