package com.retinio;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    private Button fbLoginButton;
    private Button gplusLoginButton;
    private SharedPreferences settings;

    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        settings = getSharedPreferences("Login", MODE_PRIVATE);
        editor = settings.edit();

        if(settings.getBoolean("Logged_in", false)) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        fbLoginButton = (Button) findViewById(R.id.login_with_fb);
        gplusLoginButton = (Button) findViewById(R.id.login_with_gplus);
        gplusLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loginWithGplus()) {
                    SharedPreferences settings = getSharedPreferences("Login", MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putBoolean("Logged_in", true);
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        fbLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loginWithFB()) {
                    SharedPreferences settings = getSharedPreferences("Login", MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putBoolean("Logged_in", true);
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }


    private boolean loginWithGplus() {
        return true;
    }

    private boolean loginWithFB() {
        return true;
    }
}
