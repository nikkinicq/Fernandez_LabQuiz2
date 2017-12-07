package com.fernandez.fernandez_labquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUser, etPassword;
    Button btnRm, btnLogin;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = (EditText) findViewById(R.id.et_user);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnRm = (Button) findViewById(R.id.btn_rm);
        btnLogin = (Button) findViewById(R.id.btn_login);
        preferences = getPreferences(Context.MODE_PRIVATE);

        etUser.setOnKeyListener(new EditText.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String user = preferences.getString("username","");
                String pass = preferences.getString("password","");

                String sUsername = etUser.getText().toString();

                if(!user.isEmpty()) {
                    if (sUsername.equals(user)) {
                        etPassword.setText(pass);
                        etPassword.setBackgroundColor(Color.TRANSPARENT);
                    }
                    else if (!(sUsername.equals(user))){
                        etPassword.setText("");
                        etPassword.setBackgroundColor(Color.TRANSPARENT);
                    }
                }

                return false;
            }
        });

        etPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    String user = preferences.getString("username","");
                    String pass = preferences.getString("password","");

                    String sUsername = etUser.getText().toString();

                    if(!user.isEmpty()) {
                        if (sUsername.equals(user)) {
                            etPassword.setText(pass);
                            etPassword.setBackgroundColor(Color.YELLOW);
                        }
                        else if (!(sUsername.equals(user))){
                            etPassword.setText("");
                            etPassword.setBackgroundColor(Color.TRANSPARENT);
                        }
                    }

                }
            }
        });
    }

    public void callRememberMe (View view){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", etUser.getText().toString());
        editor.putString("password", etPassword.getText().toString());
        editor.commit();
        Toast.makeText(this, "Preference Saved!", Toast.LENGTH_SHORT).show();

    }

    public void callLogin (View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }


}
