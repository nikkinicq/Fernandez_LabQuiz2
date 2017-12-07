package com.fernandez.fernandez_labquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUser, etPassword;
    Button btnRm, btnLogin;
    SharedPreferences preferences;
    private SharedPreferences.Editor loginPrefsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = (EditText) findViewById(R.id.et_user);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnRm = (Button) findViewById(R.id.btn_rm);
        btnLogin = (Button) findViewById(R.id.btn_login);
        preferences = getPreferences(Context.MODE_PRIVATE);
    }

    public void callRememberMe (View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", etUser.getText().toString());
        editor.putString("password", etPassword.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
    }

    public void callLogin (View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
