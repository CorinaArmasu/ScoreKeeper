package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.android.scorekeeper.R;

public class MainActivity extends AppCompatActivity {


    static final String STATE_SCOREPLAYERA = "scorePlayerA";
    static final String STATE_SCOREPLAYERB = "scorePlayerB";
    /**
     * Tracks the score for Player A
     */

    int scorePlayerA = 0;
    /**
     * Tracks the score for Player B
     */
    int scorePlayerB = 0;
    TextView scorePlayerAView;
    TextView scorePlayerBView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scorePlayerAView = findViewById(R.id.player_a_score);
        scorePlayerBView = findViewById(R.id.player_b_score);

    }

    /**
     * @param savedInstanceState save the curent score state.
     */


    @Override

    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(STATE_SCOREPLAYERA, scorePlayerA);
        savedInstanceState.putInt(STATE_SCOREPLAYERB, scorePlayerB);

        /**
         * superclass call to save the view hierarchy state
         */
        super.onSaveInstanceState(savedInstanceState);

    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {

        /**
         * superclass call to restore the view hierarchy state
         */
        super.onRestoreInstanceState(savedInstanceState);

        /**
         * restore saved instance state
         */

        scorePlayerA = savedInstanceState.getInt(STATE_SCOREPLAYERA);
        scorePlayerB = savedInstanceState.getInt(STATE_SCOREPLAYERB);
        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);


    }

    /**
     * Increase the Player A score by 10 points.
     */
    public void addTenForPlayerA(View v) {
        scorePlayerA += 10;
        displayForPlayerA(scorePlayerA);
    }

    /**
     * Increase the Player A score by 20 points.
     */
    public void addTwentyForPlayerA(View v) {
        scorePlayerA += 20;
        displayForPlayerA(scorePlayerA);
    }

    /**
     * Increase the Player B score by 10 points.
     */
    public void addTenForPlayerB(View v) {
        scorePlayerB += 10;
        displayForPlayerB(scorePlayerB);
    }

    /**
     * Increase the Player B score by 20 points.
     */

    public void addTwentyForPlayerB(View v) {
        scorePlayerB += 20;
        displayForPlayerB(scorePlayerB);
    }

    /**
     * * Resets the score for both players back to 0.
     */
    public void resetScore(View v) {
        scorePlayerA = 0;
        scorePlayerB = 0;
        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);

    }

    /**
     * Displays the given score for Player A.
     */
    public void displayForPlayerA(int score) {
        scorePlayerAView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Player B.
     */
    public void displayForPlayerB(int score) {
        scorePlayerBView.setText(String.valueOf(score));
    }

}
