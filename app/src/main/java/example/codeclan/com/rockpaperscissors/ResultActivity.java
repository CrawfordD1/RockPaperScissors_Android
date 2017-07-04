package example.codeclan.com.rockpaperscissors;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    TextView playerView;
    TextView computerView;
    TextView winnerView;
    TextView playerTrack;
    Computer computer;
    Game game;
    ScoreTracker tracker1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        playerView = (TextView) findViewById(R.id.player_View);
        computerView = (TextView) findViewById(R.id.computer_View);
        winnerView = (TextView) findViewById(R.id.winner_View);
        playerTrack = (TextView) findViewById(R.id.player_Track);

        computer = new Computer();
        tracker1 = new ScoreTracker(this);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String playerMove = extras.getString("move");

        game = new Game(playerMove, computer.getMoveString(), tracker1);
        playerView.setText("You played: " + playerMove);
        computerView.setText("Computer played: " + computer.getMoveString());
        String result = game.getWinner();
        tracker1.setwinner(result);
        winnerView.setText(result);
        playerTrack.setText("Player Wins:" + tracker1.getPlayerScore() + " | Computer Wins:" + tracker1.getComputerScore() + " | Draws:" + tracker1.getDrawScore());
    }

    public void onPAClicked(View button) {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

    public void onResetClicked(View button){
        tracker1.resetTracker();
        playerTrack.setText("Player Wins:" + tracker1.getPlayerScore() + " | Computer Wins:" + tracker1.getComputerScore() + " | Draws:" + tracker1.getDrawScore());
    }










}
