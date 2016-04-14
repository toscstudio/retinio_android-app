package com.retinio.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.retinio.MainActivity;
import com.retinio.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Color systemBars
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        SharedPreferences settings = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        if(settings.getBoolean("Logged_in", false)) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        Button fbLoginButton = (Button) findViewById(R.id.login_with_fb);
        Button gplusLoginButton = (Button) findViewById(R.id.login_with_gplus);

        if (gplusLoginButton != null) {
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
        }

        if (fbLoginButton != null) {
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
    }


    private boolean loginWithGplus() {
        return true;
    }

    private boolean loginWithFB() {
        return true;
    }
}
