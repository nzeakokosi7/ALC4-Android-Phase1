package com.varscon.alc4_android_challenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mProfileBtn, mWebViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProfileBtn = findViewById(R.id.visit_profile_btn);
        mWebViewBtn = findViewById(R.id.visit_alc_btn);

        setOnclickListeners();
    }

    private void setOnclickListeners() {
        mProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });

        mWebViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WebViewActivity.class));
            }
        });
    }
}
