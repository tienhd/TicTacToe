package endtoendtest;

import org.junit.Test;

/**
 * User: tienhd
 * Date: 8/8/13
 * Time: 8:23 AM
 */
public class EndToEndAcceptanceTest
{
    private final ApplicationRunner application = new ApplicationRunner();

    @Test
    public void testStartGameThenEndGame()
    {
        application.startGame();
        application.checkStartGameStatus();
        application.endGame();
        application.checkEndGameStatus();
    }
}
