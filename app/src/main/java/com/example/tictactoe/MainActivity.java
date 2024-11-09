package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button game;
    Button exit;
    Button score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = findViewById(R.id.start);
        game.setOnClickListener(this);
        exit = findViewById(R.id.exit);
        exit.setOnClickListener(end);
        score = findViewById(R.id.score);
        score.setOnClickListener(highScores);
    }

    public void onClick(View v)
    {
        Intent i = new Intent(MainActivity.this, game_screen.class);
        finish();
        startActivity(i);
    }

    public void onClick2(View v)
    {
        Intent i = new Intent(MainActivity.this, game_screen.class);
        finish();
        startActivity(i);
    }

    private View.OnClickListener end = new View.OnClickListener() {

        public void onClick(View v) {
            System.exit(0);


        }
    };

    private View.OnClickListener highScores = new View.OnClickListener() {

        public void onClick(View v) {

            Intent i = new Intent(MainActivity.this, high_score.class);
            finish();
            startActivity(i);
        }
    };
}