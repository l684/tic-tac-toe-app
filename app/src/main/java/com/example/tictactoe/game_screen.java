package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class game_screen extends AppCompatActivity implements View.OnClickListener{

    Button b2;
    Button exit;
    TextView V1;
    TextView V2;
    TextView V3;
    TextView V4;
    TextView V5;
    TextView V6;
    TextView V7;
    TextView V8;
    TextView V9;
    TextView symbol;
    TextView changePlayer;
    TextView turn;
    int j = 1; //turn counter
    int winner = 0;
    int f = 1; /* 0 means game is over 1 means game is still going. used at line 1145
     to stop flow of code and nextMove running regardless of player one winning. */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        b2 = findViewById(R.id.home);
        b2.setOnClickListener(this);
        exit = findViewById(R.id.end);
        exit.setOnClickListener(end);
        V1 = findViewById(R.id.textView1);
        V1.setOnClickListener(turnClick);
        V2 = findViewById(R.id.textView2);
        V2.setOnClickListener(turnClick);
        V3 = findViewById(R.id.textView3);
        V3.setOnClickListener(turnClick);
        V4 = findViewById(R.id.textView4);
        V4.setOnClickListener(turnClick);
        V5 = findViewById(R.id.textView5);
        V5.setOnClickListener(turnClick);
        V6 = findViewById(R.id.textView6);
        V6.setOnClickListener(turnClick);
        V7 = findViewById(R.id.textView7);
        V7.setOnClickListener(turnClick);
        V8 = findViewById(R.id.textView8);
        V8.setOnClickListener(turnClick);
        V9 = findViewById(R.id.textView9);
        V9.setOnClickListener(turnClick);

        symbol = findViewById(R.id.turnSymbol);

        changePlayer = findViewById(R.id.textViewPlayer);

        turn = findViewById(R.id.turnCount);




    }
    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
     protected void onStart() {
         //start off choosing a player at random and set textViewPlayer to that selection
         super.onStart();
         TextView symbol = findViewById(R.id.turnSymbol);
         TextView textViewPlayer = findViewById(R.id.textViewPlayer);

         int i = getRandomNumberUsingNextInt(1,3);

         if(i == 1)
         {
             textViewPlayer.setText("It's Player ones turn");
             symbol.setText("O");
         }
         if(i == 2)
         {
             textViewPlayer.setText("It's Player twos turn");
             symbol.setText("O");
         }
         nextMove();
     }

    public void onClick(View v)
    {
        Intent t = new Intent(game_screen.this, MainActivity.class);
        finish();
        startActivity(t);
    }

    private View.OnClickListener end = new View.OnClickListener() {

        public void onClick(View v) {
            System.exit(0);
        }
    };

    public void checkWin() {

        TextView[] textViewArray = new TextView[9];
        textViewArray[0] = V1;
        textViewArray[1] = V2;
        textViewArray[2] = V3;
        textViewArray[3] = V4;
        textViewArray[4] = V5;
        textViewArray[5] = V6;
        textViewArray[6] = V7;
        textViewArray[7] = V8;
        textViewArray[8] = V9;

        if (changePlayer.getText().toString() == "It's Player ones turn")
        {
            winner = 1;
        }
        else if (changePlayer.getText().toString() == "It's Player twos turn")
        {
            winner = 2;
        }

        /*array for a counter for each text view. A value of 1 means it contains a X.
        A value of 2 means it contains a O. */
        int[] counterArray = new int[9];

        for (int i = 0; i < 9 ; i++) {

            if(textViewArray[i].getText() == "X")
            {
                counterArray[i] = 1;
            }
            else if (textViewArray[i].getText() == "O")
            {
                counterArray[i] = 2;
            }
        }

        /* if statement for each row, column and diagonal and a
         nested if to check if all values are either X or O */
        if (counterArray[0] != 0 & counterArray[1] != 0 & counterArray[2] != 0)
        { //first row
            if (textViewArray[0].getText() == textViewArray[1].getText() &
                    textViewArray[0].getText() == textViewArray[2].getText())
            {
                //win or lose
                f = 0;
                Intent t = new Intent(game_screen.this, result_screen.class);
                t.putExtra("winner", winner);
                t.putExtra("score", j);
                kill_activity();
                startActivity(t);
            }
        }
        if (counterArray[3] != 0 & counterArray[4] != 0 & counterArray[5] != 0)
        { // second row
            if (textViewArray[3].getText() == textViewArray[4].getText() &
                    textViewArray[3].getText() == textViewArray[5].getText())
            {
                //win or lose
                f = 0;
                Intent t = new Intent(game_screen.this, result_screen.class);
                t.putExtra("winner", winner);
                t.putExtra("score", j);
                kill_activity();
                startActivity(t);
            }
        }
        if (counterArray[6] != 0 & counterArray[7] != 0 & counterArray[8] != 0)
        { // third row
            if (textViewArray[6].getText() == textViewArray[7].getText() &
                    textViewArray[6].getText() == textViewArray[8].getText())
            {
                //win or lose
                f = 0;
                Intent t = new Intent(game_screen.this, result_screen.class);
                t.putExtra("winner", winner);
                t.putExtra("score", j);
                kill_activity();
                startActivity(t);
            }
        }
        if (counterArray[0] != 0 & counterArray[4] != 0 & counterArray[8] != 0)
        { // diagonal
            if (textViewArray[0].getText() == textViewArray[4].getText() &
                    textViewArray[0].getText() == textViewArray[8].getText())
            {
                //win or lose
                f = 0;
                Intent t = new Intent(game_screen.this, result_screen.class);
                t.putExtra("winner", winner);
                t.putExtra("score", j);
                kill_activity();
                startActivity(t);
            }
        }
        if (counterArray[2] != 0 & counterArray[4] != 0 & counterArray[6] != 0)
        { // other diagonal
            if (textViewArray[2].getText() == textViewArray[4].getText() &
                    textViewArray[2].getText() == textViewArray[6].getText())
            {
                //win or lose
                f = 0;
                Intent t = new Intent(game_screen.this, result_screen.class);
                t.putExtra("winner", winner);
                t.putExtra("score", j);
                kill_activity();
                startActivity(t);
            }
        }
        if (counterArray[0] != 0 & counterArray[3] != 0 & counterArray[6] != 0)
        { // left column
            if (textViewArray[0].getText() == textViewArray[3].getText() &
                    textViewArray[0].getText() == textViewArray[6].getText())
            {
                //win or lose
                f = 0;
                Intent t = new Intent(game_screen.this, result_screen.class);
                t.putExtra("winner", winner);
                t.putExtra("score", j);
                kill_activity();
                startActivity(t);
            }
        }
        if (counterArray[1] != 0 & counterArray[4] != 0 & counterArray[7] != 0)
        { // middle column
            if (textViewArray[1].getText() == textViewArray[4].getText() &
                    textViewArray[1].getText() == textViewArray[7].getText())
            {
                //win or lose
                f = 0;
                Intent t = new Intent(game_screen.this, result_screen.class);
                t.putExtra("winner", winner);
                t.putExtra("score", j);
                kill_activity();
                startActivity(t);
            }
        }
        if (counterArray[2] != 0 & counterArray[5] != 0 & counterArray[8] != 0)
        { // right column
            if (textViewArray[2].getText() == textViewArray[5].getText() &
                    textViewArray[2].getText() == textViewArray[8].getText())
            {
                //win or lose
                f = 0;
                Intent t = new Intent(game_screen.this, result_screen.class);
                t.putExtra("winner", winner);
                t.putExtra("score", j);
                kill_activity();
                startActivity(t);
            }
        }
    }

    public void nextMove () {
        /*computer player move takes a certain move to stop
        the human winning or a random move from remaining empty spots */


        TextView[] textViewArray = new TextView[9];
        textViewArray[0] = V1;
        textViewArray[1] = V2;
        textViewArray[2] = V3;
        textViewArray[3] = V4;
        textViewArray[4] = V5;
        textViewArray[5] = V6;
        textViewArray[6] = V7;
        textViewArray[7] = V8;
        textViewArray[8] = V9;
        int firstRow = 0;
        int secondRow = 0;
        int thirdRow = 0;
        int leftColumn = 0;
        int middleColumn = 0;
        int rightColumn = 0;
        int leftDiagonal = 0;
        int rightDiagonal = 0;

        /*array for a counter for each text view. A value of 1 means it contains a X.
        A value of 2 means it contains a O. */
        int[] counterArray = new int[9];

        for (int i = 0; i < 9 ; i++) {

            if(textViewArray[i].getText() == "X")
            {
                counterArray[i] = 1;
                if (i == 0)
                {
                    firstRow += 2;
                    leftColumn += 10;
                    leftDiagonal += 16;
                }
                if (i == 1)
                {
                    firstRow += 2;
                    middleColumn +=12;
                }
                if (i == 2)
                {
                    firstRow += 2;
                    rightColumn +=14;
                    rightDiagonal += 18;
                }
                if (i == 3)
                {
                    secondRow += 5;
                    leftColumn += 10;
                }
                if (i == 4)
                {
                    secondRow += 5;
                    middleColumn +=12;
                    leftDiagonal += 16;
                    rightDiagonal += 18;
                }
                if (i == 5)
                {
                    secondRow += 5;
                    rightColumn +=14;
                }
                if (i == 6)
                {
                    thirdRow += 8;
                    leftColumn += 10;
                    rightDiagonal += 18;
                }
                if (i == 7)
                {
                    thirdRow += 8;
                    middleColumn +=12;
                }
                if (i == 8)
                {
                    thirdRow += 8;
                    rightColumn +=14;
                    leftDiagonal += 16;
                }
            }
            else if (textViewArray[i].getText() == "O")
            {
                counterArray[i] = 2;
                if (i == 0)
                {
                    firstRow += 3;
                    leftColumn += 11;
                    leftDiagonal += 17;
                }
                if (i == 1)
                {
                    firstRow += 3;
                    middleColumn += 13;
                }
                if (i == 2)
                {
                    firstRow += 3;
                    rightColumn += 15;
                    rightDiagonal += 19;
                }
                if (i == 3)
                {
                    secondRow += 7;
                    leftColumn += 11;
                }
                if (i == 4)
                {
                    secondRow += 7;
                    middleColumn += 13;
                    leftDiagonal += 17;
                    rightDiagonal += 19;
                }
                if (i == 5)
                {
                    secondRow += 7;
                    rightColumn += 19;
                }
                if (i == 6)
                {
                    thirdRow += 9;
                    leftColumn += 11;
                    rightDiagonal += 19;
                }
                if (i == 7)
                {
                    thirdRow += 9;
                    middleColumn += 13;
                }
                if (i == 8)
                {
                    thirdRow += 9;
                    rightColumn += 15;
                    leftDiagonal += 17;
                }
            }
        }
        if (firstRow == 4 & changePlayer.getText().toString() == "It's Player twos turn" &
                symbol.getText().toString() == "O")
        {
            if (V1.getText().toString().isEmpty())
            {
                V1.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V2.getText().toString().isEmpty())
            {
                V2.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V3.getText().toString().isEmpty())
            {
                V3.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
        }
        if (secondRow == 10 & changePlayer.getText().toString() == "It's Player twos turn" &
                symbol.getText().toString() == "O")
        {
            if (V4.getText().toString().isEmpty())
            {
                V4.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V5.getText().toString().isEmpty())
            {
                V5.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V6.getText().toString().isEmpty())
            {
                V6.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
        }
        if (thirdRow == 16 & changePlayer.getText().toString() == "It's Player twos turn" &
                symbol.getText().toString() == "O")
        {
            if (V7.getText().toString().isEmpty())
            {
                V7.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V8.getText().toString().isEmpty())
            {
                V8.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V9.getText().toString().isEmpty())
            {
                V9.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
        }
        if (leftColumn == 20 & changePlayer.getText().toString() == "It's Player twos turn" &
                symbol.getText().toString() == "O")
        {
            if (V1.getText().toString().isEmpty())
            {
                V1.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V4.getText().toString().isEmpty())
            {
                V4.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V7.getText().toString().isEmpty())
            {
                V7.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
        }
        if (middleColumn == 24 & changePlayer.getText().toString() == "It's Player twos turn" &
                symbol.getText().toString() == "O")
        {
            if (V2.getText().toString().isEmpty())
            {
                V2.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V5.getText().toString().isEmpty())
            {
                V5.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V8.getText().toString().isEmpty())
            {
                V8.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
        }
        if (rightColumn == 28 & changePlayer.getText().toString() == "It's Player twos turn" &
                symbol.getText().toString() == "O")
        {
            if (V3.getText().toString().isEmpty())
            {
                V3.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V6.getText().toString().isEmpty())
            {
                V6.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V9.getText().toString().isEmpty())
            {
                V9.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
        }
        if (leftDiagonal == 32 & changePlayer.getText().toString() == "It's Player twos turn" &
                symbol.getText().toString() == "O")
        {
            if (V1.getText().toString().isEmpty())
            {
                V1.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V5.getText().toString().isEmpty())
            {
                V5.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V9.getText().toString().isEmpty())
            {
                V9.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
        }
        if (rightDiagonal == 36 & changePlayer.getText().toString() == "It's Player twos turn" &
                symbol.getText().toString() == "O")
        {
            if (V3.getText().toString().isEmpty())
            {
                V3.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V5.getText().toString().isEmpty())
            {
                V5.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V7.getText().toString().isEmpty())
            {
                V7.setText("O");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
        }

        if (firstRow == 6 & changePlayer.getText().toString() == "It's Player twos turn" &
                symbol.getText().toString() == "X")
        {
            if (V1.getText().toString().isEmpty())
            {
                V1.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V2.getText().toString().isEmpty())
            {
                V2.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V3.getText().toString().isEmpty())
            {
                V3.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
        }
        if (secondRow == 14 & changePlayer.getText().toString() == "It's Player twos turn" &
                symbol.getText().toString() == "X")
        {
            if (V4.getText().toString().isEmpty())
            {
                V4.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V5.getText().toString().isEmpty())
            {
                V5.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V6.getText().toString().isEmpty())
            {
                V6.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
        }
        if (thirdRow == 18 & changePlayer.getText().toString() == "It's Player twos turn" &
                symbol.getText().toString() == "X")
        {
            if (V7.getText().toString().isEmpty())
            {
                V7.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V8.getText().toString().isEmpty())
            {
                V8.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V9.getText().toString().isEmpty())
            {
                V9.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
        }
        if (leftColumn == 22 & changePlayer.getText().toString() == "It's Player twos turn" &
                symbol.getText().toString() == "X")
        {
            if (V1.getText().toString().isEmpty())
            {
                V1.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V4.getText().toString().isEmpty())
            {
                V4.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V7.getText().toString().isEmpty())
            {
                V7.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
        }
        if (middleColumn == 26 & changePlayer.getText().toString() == "It's Player twos turn" &
                symbol.getText().toString() == "X")
        {
            if (V2.getText().toString().isEmpty())
            {
                V2.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V5.getText().toString().isEmpty())
            {
                V5.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V8.getText().toString().isEmpty())
            {
                V8.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
        }
        if (rightColumn == 30 & changePlayer.getText().toString() == "It's Player twos turn" &
                symbol.getText().toString() == "X")
        {
            if (V3.getText().toString().isEmpty())
            {
                V3.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V6.getText().toString().isEmpty())
            {
                V6.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V9.getText().toString().isEmpty())
            {
                V9.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
        }
        if (leftDiagonal == 34 & changePlayer.getText().toString() == "It's Player twos turn" &
                symbol.getText().toString() == "X")
        {
            if (V1.getText().toString().isEmpty())
            {
                V1.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V5.getText().toString().isEmpty())
            {
                V5.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V9.getText().toString().isEmpty())
            {
                V9.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
        }
        if (rightDiagonal == 38 & changePlayer.getText().toString() == "It's Player twos turn" &
                symbol.getText().toString() == "X")
        {
            if (V3.getText().toString().isEmpty())
            {
                V3.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V5.getText().toString().isEmpty())
            {
                V5.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
            else if (V7.getText().toString().isEmpty())
            {
                V7.setText("X");
                updateTurn();
                checkWin();
                changePlayer.setText("It's Player ones turn");
                changeTurnSymbol();
            }
        }

        //pick a random empty space
        if (changePlayer.getText().toString() == "It's Player twos turn")
        // switch case for the selected random empty box
        {
            ArrayList<TextView> emptyArray = new ArrayList<TextView>();
            Random r = new Random();
            for (int j = 0; j < textViewArray.length; j++) {

                if (textViewArray[j].getText().toString() == "") {

                    emptyArray.add(textViewArray[j]);

                }
            }
                    if (symbol.getText().toString() == "X")
                    {
                        int randomValue = 0;
                        try
                        {
                             randomValue = r.nextInt(emptyArray.size());
                        }
                        catch (Exception e)
                        {
                            winner = 3;
                            Intent t = new Intent(game_screen.this, result_screen.class);
                            kill_activity();
                            startActivity(t);
                        }

                        try
                        {
                            emptyArray.get(randomValue).setText("X");
                        }
                        catch (Exception e)
                        {
                            winner = 3;
                            Intent t = new Intent(game_screen.this, result_screen.class);
                            t.putExtra("winner", winner);
                            t.putExtra("score", j);
                            kill_activity();
                            startActivity(t);
                        }
                        updateTurn();
                        checkWin();
                        changePlayer.setText("It's Player ones turn");
                        changeTurnSymbol();
                    }

                    else if (symbol.getText().toString() == "O")
                    {
                        int randomValue = r.nextInt(emptyArray.size());
                        try
                        {
                            emptyArray.get(randomValue).setText("O");
                        }
                        catch (Exception e)
                        {
                            winner = 3;
                            Intent t = new Intent(game_screen.this, result_screen.class);
                            t.putExtra("winner", winner);
                            t.putExtra("score", j);
                            kill_activity();
                            startActivity(t);
                        }
                        updateTurn();
                        checkWin();
                        changePlayer.setText("It's Player ones turn");
                        changeTurnSymbol();
                    }
        }
    }

    public void changeTurnSymbol() {

        if (symbol.getText() == "O")
        {
            symbol.setText("X");
        }
        else if (symbol.getText() == "X")
        {
            symbol.setText("O");
        }
    }

    void kill_activity() {
        finish();
    }

    public void updateTurn () {

        j += 1;
        turn.setText("Turn " + String.valueOf(j));

        winner = 3;

        if (j >= 10)
        {
            Intent t = new Intent(game_screen.this, result_screen.class);
            t.putExtra("winner", winner);
            t.putExtra("score", j);
            kill_activity();
            startActivity(t);
        }

    }

    private View.OnClickListener turnClick = new View.OnClickListener() {
        //click event- put shape(letter) in text view, change player turn and update turn counter
        public void onClick(View v){

            String player = changePlayer.getText().toString();

            switch(v.getId()) {

                case R.id.textView1:
                    if (player == "It's Player ones turn" &  V1.getText().toString().isEmpty())
                    {
                        if (symbol.getText() == "O")
                        { //put 'shape'
                            V1.setText("O");
                            symbol.setText("X");
                        }
                        else
                        { //put 'shape'
                            V1.setText("X");
                            symbol.setText("O");
                        }
                        updateTurn();
                        checkWin();
                        changePlayer.setText("It's Player twos turn");
                    }
                    break;

                case R.id.textView2:
                    if (player == "It's Player ones turn" &  V2.getText().toString().isEmpty())
                    {
                        if (symbol.getText() == "O")
                        { //put 'shape'
                            V2.setText("O");
                            symbol.setText("X");
                        }
                        else
                        { //put 'shape'
                            V2.setText("X");
                            symbol.setText("O");
                        }
                        updateTurn();
                        checkWin();
                        changePlayer.setText("It's Player twos turn");
                    }
                    break;

                case R.id.textView3:
                    if (player == "It's Player ones turn" &  V3.getText().toString().isEmpty())
                    {
                        if (symbol.getText() == "O")
                        { //put 'shape'
                            V3.setText("O");
                            symbol.setText("X");
                        }
                        else
                        { //put 'shape'
                            V3.setText("X");
                            symbol.setText("O");
                        }
                        updateTurn();
                        checkWin();
                        changePlayer.setText("It's Player twos turn");
                    }
                    break;

                case R.id.textView4:
                    if (player == "It's Player ones turn" &  V4.getText().toString().isEmpty())
                    {
                        if (symbol.getText() == "O")
                        { //put 'shape'
                            V4.setText("O");
                            symbol.setText("X");
                        }
                        else
                        { //put 'shape'
                            V4.setText("X");
                            symbol.setText("O");
                        }
                        updateTurn();
                        checkWin();
                        changePlayer.setText("It's Player twos turn");
                    }

                    break;
                case R.id.textView5:
                    if (player == "It's Player ones turn" &  V5.getText().toString().isEmpty())
                    {
                        if (symbol.getText() == "O")
                        { //put 'shape'
                            V5.setText("O");
                            symbol.setText("X");
                        }
                        else
                        { //put 'shape'
                            V5.setText("X");
                            symbol.setText("O");
                        }
                        updateTurn();
                        checkWin();
                        changePlayer.setText("It's Player twos turn");
                    }

                    break;
                case R.id.textView6:
                    if (player == "It's Player ones turn" &  V6.getText().toString().isEmpty())
                    {
                        if (symbol.getText() == "O")
                        { //put 'shape'
                            V6.setText("O");
                            symbol.setText("X");
                        }
                        else
                        { //put 'shape'
                            V6.setText("X");
                            symbol.setText("O");
                        }
                        updateTurn();
                        checkWin();
                        changePlayer.setText("It's Player twos turn");
                    }

                    break;
                case R.id.textView7:
                    if (player == "It's Player ones turn" &  V7.getText().toString().isEmpty())
                    {
                        if (symbol.getText() == "O")
                        { //put 'shape'
                            V7.setText("O");
                            symbol.setText("X");
                        }
                        else
                        { //put 'shape'
                            V7.setText("X");
                            symbol.setText("O");
                        }
                        updateTurn();
                        checkWin();
                        changePlayer.setText("It's Player twos turn");
                    }

                    break;
                case R.id.textView8:
                    if (player == "It's Player ones turn" &  V8.getText().toString().isEmpty())
                    {
                        if (symbol.getText() == "O")
                        { //put 'shape'
                            V8.setText("O");
                            symbol.setText("X");
                        }
                        else
                        { //put 'shape'
                            V8.setText("X");
                            symbol.setText("O");
                        }
                        updateTurn();
                        checkWin();
                        changePlayer.setText("It's Player twos turn");
                    }

                    break;
                case R.id.textView9:
                    if (player == "It's Player ones turn" &  V9.getText().toString().isEmpty())
                    {
                        if (symbol.getText() == "O")
                        { //put 'shape'
                            V9.setText("O");
                            symbol.setText("X");
                        }
                        else
                        { //put 'shape'
                            V9.setText("X");
                            symbol.setText("O");
                        }
                        updateTurn();
                        checkWin();
                        changePlayer.setText("It's Player twos turn");
                    }
                    break;
            }
            if (f == 1)
            {
                nextMove();
            }

        }
    };


}
