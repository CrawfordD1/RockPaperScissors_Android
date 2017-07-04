package example.codeclan.com.rockpaperscissors;
import example.codeclan.com.rockpaperscissors.behaviours.Move;

/**
 * Created by user on 04/07/2017.
 */

public class Player {

    private Move move;

    public void setMove(Move move){
        this.move = move;
    }

    public Move getMove(){
        return this.move;
    }
}
