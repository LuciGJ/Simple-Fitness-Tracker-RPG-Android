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

public class Shop extends AppCompatActivity {
    TextView goldshop;
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(Shop.this, CharacterPage.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        SharedPreferences pref = DataSource.getInstance(this);
        SharedPreferences.Editor editor = pref.edit();
        goldshop = (TextView) findViewById(R.id.shopgold);
        int gold=pref.getInt("gold",0);
        goldshop.setText("Gold: "+ gold);
        Button itemsbutton=(Button) findViewById(R.id.shopitems);
        itemsbutton.setOnClickListener(view -> {


            AlertDialog.Builder builder = new AlertDialog.Builder(Shop.this);
            builder.setTitle("What would you like to buy?");
            String[] items = {"Energy Drink 50g","Protein Shake 50g","Cancel"};
            builder.setItems(items, (dialog, which) -> {
                switch (which) {
                    case 0: {
                        if ((pref.getInt("gold", 0) - 50) >= 0) {
                            int newvalue = pref.getInt("gold", 0) - 50;
                            editor.putInt("gold", newvalue);
                            int energydrinks = pref.getInt("energydrinks", 0) + 1;
                            editor.putInt("energydrinks", energydrinks);
                            editor.commit();

                        }
                        Intent i = new Intent(Shop.this, Shop.class);

                        startActivity(i);
                        break;
                    }

                    case 1: {
                        if ((pref.getInt("gold", 0) - 50) >= 0) {
                            int newvalue = pref.getInt("gold", 0) - 50;
                            editor.putInt("gold", newvalue);
                            int proteinshake = pref.getInt("proteinshake", 0) + 1;
                            editor.putInt("proteinshake", proteinshake);
                            editor.commit();

                        }
                        Intent i = new Intent(Shop.this, Shop.class);
                        startActivity(i);
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
        Button armorbutton=(Button) findViewById(R.id.shoparmor);
        armorbutton.setOnClickListener(view -> {


            AlertDialog.Builder builder = new AlertDialog.Builder(Shop.this);
            builder.setTitle("What would you like to buy?");
            String[] items = {"Gym Suit 1500g","Tank Top 500g ","Cancel"};
            builder.setItems(items, (dialog, which) -> {
                switch (which) {
                    case 0: {
                        if ((pref.getInt("gold", 0) - 1500) >= 0) {
                            if (!pref.getBoolean("gymsuit", false)) {
                                int newvalue = pref.getInt("gold", 0) - 1500;
                                editor.putInt("gold", newvalue);
                                editor.putBoolean("gymsuit", true);
                                editor.putInt("gymsuitstats", 30);
                                editor.commit();
                            }

                        }
                        Intent i = new Intent(Shop.this, Shop.class);

                        startActivity(i);
                        break;
                    }

                    case 1: {
                        if ((pref.getInt("gold", 0) - 500) >= 0) {
                            int newvalue = pref.getInt("gold", 0) - 500;
                            editor.putInt("gold", newvalue);
                            editor.putBoolean("tanktop", true);
                            editor.putInt("tanktopstats", 10);
                            editor.commit();

                        }
                        Intent i = new Intent(Shop.this, Shop.class);
                        startActivity(i);
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
        Button weaponsbutton=(Button) findViewById(R.id.shopweapon);
        weaponsbutton.setOnClickListener(view -> {


            AlertDialog.Builder builder = new AlertDialog.Builder(Shop.this);
            builder.setTitle("What would you like to buy?");
            String[] items = {"Box Gloves 1500g","Wrist Wraps 500g ","Cancel"};
            builder.setItems(items, (dialog, which) -> {
                switch (which) {
                    case 0: {
                        if ((pref.getInt("gold", 0) - 1500) >= 0) {
                            if (!pref.getBoolean("boxinggloves", false)) {
                                int newvalue = pref.getInt("gold", 0) - 1500;
                                editor.putInt("gold", newvalue);
                                editor.putBoolean("boxinggloves", true);
                                editor.putInt("boxgloves", 30);
                                editor.commit();
                            }

                        }
                        Intent i = new Intent(Shop.this, Shop.class);

                        startActivity(i);
                        break;
                    }

                    case 1: {
                        if ((pref.getInt("gold", 0) - 500) >= 0) {
                            int newvalue = pref.getInt("gold", 0) - 500;
                            editor.putInt("gold", newvalue);
                            editor.putBoolean("wristwraps", true);
                            editor.putInt("wristwrapsdamage", 10);
                            editor.commit();

                        }
                        Intent i = new Intent(Shop.this, Shop.class);
                        startActivity(i);
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
        Button shopback;
        shopback = (Button) findViewById(R.id.shopback);
        shopback.setOnClickListener(view -> {


            Intent i = new Intent(Shop.this, CharacterPage.class);
            startActivity(i);


        });
    }
}