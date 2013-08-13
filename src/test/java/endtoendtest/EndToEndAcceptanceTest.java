package endtoendtest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * User: tienhd
 * Date: 8/8/13
 * Time: 8:23 AM
 */
public class EndToEndAcceptanceTest
{
    private final ApplicationRunner application = new ApplicationRunner();

    @Before
    public void startFrameBeforeTest()
    {
        application.startFrame();
    }

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

    @Test
    public void testPlayUtilFullCellThenShowMessageFinishGame()
    {
        application.startGame();

        application.doTickCell("2_2");
        application.showsCellChar("2_2", "X");
        application.doTickCell("1_1");
        application.showsCellChar("1_1", "O");
        application.doTickCell("0_0");
        application.showsCellChar("0_0", "X");
        application.doTickCell("1_0");
        application.showsCellChar("1_0", "O");
        application.doTickCell("1_2");
        application.showsCellChar("1_2", "X");
        application.doTickCell("0_2");
        application.showsCellChar("0_2", "O");
        application.doTickCell("2_0");
        application.showsCellChar("2_0", "X");
        application.doTickCell("2_1");
        application.showsCellChar("2_1", "O");
        application.doTickCell("0_1");
        application.showsCellChar("0_1", "X");
        application.checksStatusEqual("GAME FINISH!");
    }

    @Test
    public void testPlayUtilXWinThenFinishGame()
    {
        application.startGame();
        application.doTickCell("0_0");
        application.showsCellChar("0_0", "X");
        application.doTickCell("1_0");
        application.showsCellChar("1_0", "O");
        application.doTickCell("0_1");
        application.showsCellChar("0_1", "X");
        application.doTickCell("1_1");
        application.showsCellChar("1_1", "O");
        application.doTickCell("0_2");
        application.showsCellChar("0_2", "X");
        application.showsXWin();
    }

    @Test
    public void testPlayUtilXWinAtDiagonalThenFinishGame()
    {
        application.startGame();
        application.doTickCell("0_0");
        application.showsCellChar("0_0", "X");
        application.doTickCell("1_0");
        application.showsCellChar("1_0", "O");
        application.doTickCell("1_1");
        application.showsCellChar("1_1", "X");
        application.doTickCell("2_1");
        application.showsCellChar("2_1", "O");
        application.doTickCell("2_2");
        application.showsCellChar("2_2", "X");
        application.showsXWin();
    }

    @Test
    public void testChooseSymbolXStartGameThenEndGame()
    {
        application.chooseXSymbol();
        application.showsStartSymbolX();
        application.startGame();
        application.endGame();
    }

    @Test
    public void testChooseSymbolOStartGameThenEndGame()
    {
        application.chooseOSymbol();
        application.showsStartSymbolO();
        application.startGame();
        application.endGame();
    }

    @Test
    public void testChooseSymbolOStartGameThenPlayAndEndgame()
    {
        application.chooseOSymbol();
        application.showsStartSymbolO();
        application.startGame();
        application.doTickCell("2_2");
        application.showsCellChar("2_2", "O");
        application.doTickCell("1_1");
        application.showsCellChar("1_1", "X");
        application.endGame();
    }
}
