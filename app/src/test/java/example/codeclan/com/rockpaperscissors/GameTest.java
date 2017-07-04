package example.codeclan.com.rockpaperscissors;
import org.junit.Before;
import org.junit.Test;
import example.codeclan.com.rockpaperscissors.behaviours.Move;
import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 04/07/2017.
 */

public class GameTest {

    private Player player;
    private Computer computer;
    private Game game;

    @Before
    public void setUp() throws Exception {
        player = new Player();
        computer = new Computer();
        game = new Game();
    }

    @Test
    public void testPlayerWin() throws Exception {
        player.setMove(Move.ROCK);
        computer.setMove(Move.SCISSORS);
        assertEquals(1, game.compareMoves(player.getMove(), computer.getMove()));
    }

    @Test
    public void testPlayerWinString() throws Exception {
        player.setMove(Move.ROCK);
        computer.setMove(Move.SCISSORS);
        assertEquals("Player Wins!", game.displayWinner(game.compareMoves(player.getMove(), computer.getMove())));
    }
}
