package endtoendtest;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * User: tienhd
 * Date: 8/8/13
 * Time: 8:25 AM
 */
public class ApplicationRunner
{
    private TicTacToeDriver ticTacToeDriver;

    public void startGame()
    {
        initTicTacToe();
        ticTacToeDriver.startGame();

    }

    public void showsGameStatusStarted()
    {
        ticTacToeDriver.showStatus("START");
    }

    public void endGame()
    {
        ticTacToeDriver.endGame();
    }

    public void showsGameStatusEnded()
    {
        ticTacToeDriver.showStatus("END");
    }

    private void initTicTacToe()
    {
        MainApp.main();
        ticTacToeDriver = new TicTacToeDriver(3000);
        ticTacToeDriver.hasTitle(MainWindow.MAIN_WINDOW_NAME);
    }

    public void doTickCell(String coordinate)
    {
        ticTacToeDriver.doTickCell(coordinate);

    }

    public void showsCellChar(String coordinate, String status)
    {
        ticTacToeDriver.showsCellChar(coordinate, status);
    }

    public void exitGame()
    {
        ticTacToeDriver.exitGame();
    }

    public void checksStatusEqual(String text)
    {
        ticTacToeDriver.labelStatus().hasText(equalTo(text));
    }
}
