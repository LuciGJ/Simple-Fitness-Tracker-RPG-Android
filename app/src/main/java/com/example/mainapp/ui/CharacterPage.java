package com.example.mainapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.mainapp.R;
import com.example.mainapp.data.User;

public class CharacterPage extends AppCompatActivity {
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(CharacterPage.this, NavigationActivity.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_page);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("HP",pref.getInt("charlevel",0)*100);
        editor.commit();
        TextView usernameview;
        TextView classview;
        TextView leveldisplay;
        TextView strength;
        TextView agility;
        TextView endurance;
        TextView power;
        TextView experiencetext;
        User user = User.getUser(this);
        String strengthprint=String.valueOf(user.getStrengthint());
        String agilityprint=String.valueOf(user.getAgilityint());
        String enduranceprint=String.valueOf(user.getEnduranceint());
        Button toskills;
        toskills = (Button) findViewById(R.id.toskills);
        toskills.setOnClickListener(view -> {


            Intent i = new Intent(CharacterPage.this, SkillsPage.class);
            startActivity(i);


        });
        Button toinventory;
        toinventory = (Button) findViewById(R.id.toinventory);
        toinventory.setOnClickListener(view -> {


            Intent i = new Intent(CharacterPage.this, Inventory.class);
            startActivity(i);


        });
        Button toshop;
        toshop = (Button) findViewById(R.id.toshop);
        toshop.setOnClickListener(view -> {


            Intent i = new Intent(CharacterPage.this, Shop.class);
            startActivity(i);


        });
        Button toequipment;
        toequipment = (Button) findViewById(R.id.toequipment);
        toequipment.setOnClickListener(view -> {


            Intent i = new Intent(CharacterPage.this, Equipment.class);
            startActivity(i);


        });
        Button toarena;
        toarena = (Button) findViewById(R.id.toarena);
        toarena.setOnClickListener(view -> {


            Intent i = new Intent(CharacterPage.this, Arena.class);
            startActivity(i);


        });
        Button toquest;
        toquest = (Button) findViewById(R.id.toquests);
        toquest.setOnClickListener(view -> {


            Intent i = new Intent(CharacterPage.this, Quest.class);
            startActivity(i);


        });
        int powerint=user.getLevel()+user.getStrengthint()%10+user.getAgilityint()%10+user.getEnduranceint()%10;
        editor.putInt("power",powerint);
        editor.commit();
        String powerprint2=String.valueOf(powerint);
        String levelprint= String.valueOf(user.getLevel());
        String classdisplay=pref.getString("class",null);
        String usernamedisplay=pref.getString("username",null);
        usernameview = (TextView) findViewById(R.id.usernameshow);
        classview = (TextView) findViewById(R.id.classview);
        leveldisplay = (TextView) findViewById(R.id.levetshow);
        experiencetext = (TextView) findViewById(R.id.experiencetext);
        strength = (TextView) findViewById(R.id.strstat);
        agility = (TextView) findViewById(R.id.agistat);
        endurance = (TextView) findViewById(R.id.endstat);
        power = (TextView) findViewById(R.id.powerstat);
        leveldisplay.setText("Level: "+levelprint);
        strength.setText("Strength: "+strengthprint);
        agility.setText("Agility: "+agilityprint);
        endurance.setText("Endurance: "+enduranceprint);
        power.setText("Power: "+powerprint2);
        usernameview.setText("Username: "+usernamedisplay);
        classview.setText("Class: "+classdisplay);
        leveldisplay.setText("Level "+levelprint);
        experiencetext.setText("Experience: "+ pref.getInt("experience", 0) +" / "+ pref.getInt("neededexperience", 0));

    }
}