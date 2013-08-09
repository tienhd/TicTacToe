package endtoendtest;

import org.junit.After;
import org.junit.Test;

/**
 * User: tienhd
 * Date: 8/8/13
 * Time: 8:23 AM
 */
public class EndToEndAcceptanceTest
{
    private final ApplicationRunner application = new ApplicationRunner();

    @After
    public void exitGameWhenTestDone()
    {
        application.exitGame();
    }

    @Test
    public void testStartGameThenEndGame()
    {
        application.startGame();
        application.showsGameStatusStarted();
        application.endGame();
        application.showsGameStatusEnded();
    }

    @Test
    public void testStartGameThenPlayAndEndGame()
    {
        application.startGame();
        application.doTickCell("2_2");
        application.showsCellChar("2_2", "X");
        application.doTickCell("1_1");
        application.showsCellChar("1_1", "O");
        application.endGame();
    }
}
