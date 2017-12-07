package com.fernandez.fernandez_labquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvUuuser;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvUuuser = findViewById(R.id.tv_uuuser);
        btnLogout = findViewById(R.id.btn_logout);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());;
        String user = preferences.getString("username","");
        String pwd = preferences.getString("password","");
        tvUuuser.setText(user);

    }

    public void callMainActivity (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
