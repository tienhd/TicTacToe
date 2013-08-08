package endtoendtest;

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
        Thread thread = new Thread("Test Tic Tac Toe Application")
        {
            @Override
            public void run()
            {
                MainApp.main();
            }
        };
        thread.setDaemon(true);
        thread.start();

        ticTacToeDriver = new TicTacToeDriver(3000);
        ticTacToeDriver.hasTitle(MainWindow.MAIN_WINDOW_NAME);
    }
}
