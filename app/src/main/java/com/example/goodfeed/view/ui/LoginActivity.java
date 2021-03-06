package com.example.goodfeed.view.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.goodfeed.GloabalData;
import com.example.goodfeed.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LoginActivity extends AppCompatActivity {
    EditText useriD;
    FloatingActionButton showFeedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        setListeners();
    }

    private void init() {
        useriD = findViewById(R.id.userId);
        showFeedButton = findViewById(R.id.showFeedButton);
    }

    @Override
    protected void onResume() {
        super.onResume();
        useriD.setVisibility(View.VISIBLE);
    }

    private void setListeners() {
        showFeedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (useriD != null && !useriD.getText().toString().isEmpty()) {
                    GloabalData.USER_ID = useriD.getText().toString();
                    startActivity(new Intent(LoginActivity.this, PostsActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, "Enter user name first!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
