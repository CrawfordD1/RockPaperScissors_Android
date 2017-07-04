package example.codeclan.com.rockpaperscissors;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by user on 04/07/2017.
 */

public class ScoreTracker {

    int playerScore;
    int computerScore;
    int drawScore;
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public static final String DEFAULT = "0";

    public ScoreTracker(Context context){
        this.playerScore = 0;
        this.computerScore = 0;
        this.drawScore = 0;
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences("trackerData", Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }

    public void setwinner(String result){
        if(result.equals("Player Wins!")){
            playerWin();
        }
        if(result.equals("Computer Wins!")){
            computerWin();
        }
        if(result.equals("It's a Draw!")){
            setDraw();
        }
    }

    public void resetTracker(){
        editor.putString("player", Integer.toString(0));
        editor.putString("computer", Integer.toString(0));
        editor.putString("draw", Integer.toString(0));
        editor.commit();
    }

    public String getPlayerScore() {
        return sharedPreferences.getString("player", DEFAULT);
    }

    public String getComputerScore() {
        return sharedPreferences.getString("computer", DEFAULT);
    }

    public String getDrawScore() {
        return sharedPreferences.getString("draw", DEFAULT);
    }

    public void playerWin() {
        String number = sharedPreferences.getString("player", DEFAULT);
        int result = Integer.parseInt(number) + 1;
        editor.putString("player", Integer.toString(result));
        editor.commit();
    }

    public void computerWin() {
        String number = sharedPreferences.getString("computer", DEFAULT);
        int result = Integer.parseInt(number) + 1;
        editor.putString("computer", Integer.toString(result));
        editor.commit();
    }

    public void setDraw() {
        String number = sharedPreferences.getString("draw", DEFAULT);
        int result = Integer.parseInt(number) + 1;
        editor.putString("draw", Integer.toString(result));
        editor.commit();
    }
}
