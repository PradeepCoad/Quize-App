package com.example.quize4you;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RightResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_result);

        Intent finalIntent = getIntent();
        int score = finalIntent.getIntExtra("score",-1);
        TextView Score = findViewById(R.id.score);

        Score.setText(String.valueOf(score));
    }
}