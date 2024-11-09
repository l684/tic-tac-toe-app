package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class high_score extends AppCompatActivity implements View.OnClickListener{

    Button play;
    Button exit;
    TextView highScores;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.high_score);

        play = findViewById(R.id.again2);
        play.setOnClickListener(this);
        exit = findViewById(R.id.exit3);
        exit.setOnClickListener(end);
        highScores = findViewById(R.id.scores);
    }

    @SuppressLint("Range")
    protected void onStart() {
        super.onStart();
        // Cursor cr = db.rawQuery ("SELECT name, moves, date FROM Highscores", null);

        SQLiteDatabase db = openOrCreateDatabase("Tic Tac Toe", MODE_PRIVATE, null);

        Cursor cr = db.rawQuery("SELECT name, moves, date FROM Highscores", null);
        if(cr.moveToFirst()){
            do{
                highScores.append(cr.getString(cr.getColumnIndex("name")) + '\n');
            }while(cr.moveToNext());
            cr.close();
        }
    }

    public void onClick(View v)
    {//play again
        Intent t = new Intent(high_score.this, game_screen.class);
        finish();
        startActivity(t);
    }

    private View.OnClickListener end = new View.OnClickListener() {

        public void onClick(View v) {
            System.exit(0);
        }
    };

  /*  public class DatabaseHelper extends SQLiteOpenHelper
    {

        public static final String DATABASE_NAME = "Highscores";

        public DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, 1);
        }                       // I don't even need this, do I? ...

        @Override
        public void onCreate(SQLiteDatabase db)
        {

            String sql = "CREATE TABLE IF NOT EXISTS Highscores (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name String, " +
                    "moves INTEGER );";
            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            //Not used
        }

        public boolean insertScore (String name, Integer moves) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", name);
            contentValues.put("turn", moves);
            return true;
        }
        public Cursor getData(int t) {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor res = db.rawQuery("SELECT * FROM Highscores WHERE _id = t", null);
            return res;
        }

} */



}
