package com.example.mainapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mainapp.R;
import com.example.mainapp.data.DataSource;
import com.example.mainapp.utility.Helper;

public class Welcome extends AppCompatActivity {

        Button mButton;
        EditText mEdit;
        TextView mText;
        String s;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_welcome);
            mButton = (Button) findViewById(R.id.button);
            SharedPreferences pref = DataSource.getInstance(this);
            SharedPreferences.Editor editor = pref.edit();
            if(pref.getBoolean("account", false))
            {
                Intent i = new Intent(Welcome.this, NavigationActivity.class);
                startActivity(i);
            }
            mButton.setOnClickListener((View.OnClickListener) view -> {
                mEdit = (EditText) findViewById(R.id.editName);
                mText = (TextView) findViewById(R.id.textView);
                s = mEdit.getText().toString();


                if (mEdit.getText().toString().length() == 0)
                    mEdit.setError("Name is required!");
                else if (!Helper.isStringOnlyAlphabet(s))
                    mEdit.setError("You can only use letters!!");
                else {
                    editor.putString("name", s);
                    editor.commit();
                    Intent i = new Intent(Welcome.this, WelcomeNext.class);
                    startActivity(i);
                }


            });
        }
    }
