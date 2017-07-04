package example.codeclan.com.rockpaperscissors;
import java.util.Random;
import example.codeclan.com.rockpaperscissors.behaviours.Move;

/**
 * Created by user on 04/07/2017.
 */

public class Computer {


    private Move move;

    public Computer(){
        setMoveRandom();
    }

    public void setMoveRandom(){
        Move[] moves = Move.values();
        Random random = new Random();
        int index = random.nextInt(moves.length);
        setMove(moves[index]);
    }

    public void setMove(Move move){
        this.move = move;
    }


    public Move getMove(){
        return this.move;
    }

    public String getMoveString(){
        return this.move.getType();
    }

}
