package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDateTime;

public class result_screen extends AppCompatActivity implements View.OnClickListener {

    Button exit;
    TextView result;
    TextView player;
    TextView turn;
    Button save;
    Button play;
    EditText name;

    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_screen);
        exit = findViewById(R.id.exit2);
        exit.setOnClickListener(end);

        result = findViewById(R.id.result);
        player = findViewById(R.id.textViewPlayer);
        turn = findViewById(R.id.result_score);
        save = findViewById(R.id.save);
        save.setOnClickListener(saveScore);
        play = findViewById(R.id.again);
        play.setOnClickListener(this);

        Intent in = getIntent();
        Bundle b = in.getExtras();
        int winner = 0;
        int score = 0;

        if (b != null) {
            winner = (int) b.get("winner");
            score = (int) b.get("score");
        }

        if (winner == 1) {
            result.setText("You win!");
            turn.setText(Integer.toString(score - 1));
        } else if (winner == 2) {
            result.setText("You lose");
            turn.setText(Integer.toString(score - 1));
        } else if (winner == 3) {
            result.setText("Tied!");
            turn.setText(Integer.toString(score - 1));
        }


    }

    protected void onStart() {
        //start off choosing a player at random and set textViewPlayer to that selection
        super.onStart();
        //end();
    }

    public void onClick(View v) {
        //play again button
        Intent t = new Intent(result_screen.this, game_screen.class);
        finish();
        startActivity(t);

    }

    private View.OnClickListener end = new View.OnClickListener() {

        public void onClick(View v) {
            System.exit(0);


        }
    };

    private View.OnClickListener saveScore = new View.OnClickListener(){

        @SuppressLint("Range")
        public void onClick(View v) {
            int no = 0;
            name = findViewById(R.id.name);
            String x = name.getText().toString();
            String y = turn.getText().toString();
            LocalDateTime time = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                time = LocalDateTime.now();
            }

            SQLiteDatabase db = openOrCreateDatabase("Tic Tac Toe", MODE_PRIVATE, null);
           // db.execSQL("CREATE TABLE Highscores (name varchar2(20), moves int, date date_time)");
            //get text from text view and store it into a variable then use the variable to add an entry to the table
            db.execSQL("INSERT INTO Highscores (name, moves, date) VALUES (?, ?, ?)", new String[]{x, y, time.toString()});
            Cursor cr = db.rawQuery("SELECT name, moves, date FROM Highscores", null);
            if(cr.moveToFirst()){
                do{
                    Log.e("score", cr.getString(cr.getColumnIndex("name")) + "   " + y);
                //     no = yes.getInt(yes.getColumnIndex("id"));
                 //   turn.setText(toString().no);
                }while(cr.moveToNext());
                cr.close();
            }



          //  db.execSQL("INSERT INTO Highscores (name, moves) values (input, winner, time)");



        }
    };
}
