package com.androiddev.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6},};
    Boolean gameActive = true;
    int activePlayer = 0;

    public void dropIn(View view) {
//        if (temp==10){
//            Intent intent = new Intent(MainActivity.this,MainActivity.class);
//            startActivity(intent);
//        }
        ImageView imageView = (ImageView) view;
        int tappedItem = Integer.parseInt(imageView.getTag().toString());
        if (gameState[tappedItem] == 2 && gameActive) {
            gameState[tappedItem] = activePlayer;
            if (activePlayer == 0) {
                imageView.setImageResource(R.drawable.red);
                imageView.animate().alpha(1).setDuration(1000);

                activePlayer = 1;
            } else if (activePlayer == 1) {
                imageView.setImageResource(R.drawable.yellow);
                imageView.animate().alpha(1).setDuration(1000);
                activePlayer = 0;
            }
        }

        CheckEngine();
//        Log.i("MyTag", Arrays.toString(gameState));


    }

    private void CheckEngine() {
        for (int[] winningPosition : winningPositions) {
            if (gameState[winningPosition[0]] == gameState[winningPosition[1]]
                    && gameState[winningPosition[1]] == gameState[winningPosition[2]]
                    && gameState[winningPosition[0]] != 2) {
                Toast.makeText(MainActivity.this, "Someone won", Toast.LENGTH_SHORT).show();
                gameActive = false;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}