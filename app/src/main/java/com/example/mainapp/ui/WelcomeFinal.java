package com.example.mainapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mainapp.R;
import com.example.mainapp.data.DataSource;

public class WelcomeFinal extends AppCompatActivity {
    String level;
    int level2;
    Button mButton;
    EditText editlevel;
    final String regex = "[0-9]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_final);
        SharedPreferences pref = DataSource.getInstance(this);
        SharedPreferences.Editor editor = pref.edit();
        mButton = (Button) findViewById(R.id.button3);
        mButton.setOnClickListener((View.OnClickListener) view -> {
            editlevel = (EditText) findViewById(R.id.level);

            level = editlevel.getText().toString();


            if (level.length() == 0)
                editlevel.setError("Level is required!");
            else if (!level.matches(regex))
                editlevel.setError("You can only use numbers!!");
            else {
                level2 = Integer.parseInt(level);
                if (level2 < 0 || level2 > 6)
                    editlevel.setError("Level must be between 1 and 6");
                else {
                    editor.putInt("level", level2);
                    editor.putBoolean("account", true);
                    editor.commit();
                    Intent i = new Intent(WelcomeFinal.this, NavigationActivity.class);
                    startActivity(i);
                }
            }


        });

    }
}