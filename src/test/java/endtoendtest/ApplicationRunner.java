package endtoendtest;

import com.qsoft.kata5.HistoryWindow;
import com.qsoft.kata5.MainApp;
import com.qsoft.kata5.MainWindow;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * User: tienhd
 * Date: 8/8/13
 * Time: 8:25 AM
 */
public class ApplicationRunner
{
    private TicTacToeDriver ticTacToeDriver;
    private HistoryTicTacToeDriver historyTicTacToeDriver;

    private void initTicTacToe()
    {
        MainApp.main();
        ticTacToeDriver = new TicTacToeDriver(3000);
        ticTacToeDriver.hasTitle(MainWindow.MAIN_WINDOW_NAME);
    }

    private void initHistoryTicTacToe()
    {
        historyTicTacToeDriver = new HistoryTicTacToeDriver(3000);
        historyTicTacToeDriver.hasTitle(HistoryWindow.HISTORY_WINDOW_NAME);
        historyTicTacToeDriver.hasColumnTitles();
    }

    public void startFrame()
    {
        initTicTacToe();
    }

    public void startGame()
    {
        ticTacToeDriver.startGame();
    }

    public void endGame()
    {
        ticTacToeDriver.endGame();
    }

    public void exitGame()
    {
        ticTacToeDriver.exitGame();
    }

    public void showsGameStatusStarted()
    {
        ticTacToeDriver.showStatus("START");
    }

    public void showsGameStatusEnded()
    {
        ticTacToeDriver.showStatus("END");
    }

    public void doTickCell(String coordinate)
    {
        ticTacToeDriver.doTickCell(coordinate);
    }

    public void showsCellChar(String coordinate, String status)
    {
        ticTacToeDriver.showsCellChar(coordinate, status);
    }

    public void checksStatusEqual(String text)
    {
        ticTacToeDriver.labelStatus().hasText(equalTo(text));
    }

    public void showsXWin()
    {
        ticTacToeDriver.labelStatus().hasText(equalTo("X Win!"));
    }

    public void chooseXSymbol()
    {
        ticTacToeDriver.chooseSymbol(MainWindow.MAIN_SYMBOL_X);
    }

    public void showsStartSymbolX()
    {
        ticTacToeDriver.labelStatus().hasText(equalTo("Start symbol X"));
    }

    public void chooseOSymbol()
    {
        ticTacToeDriver.chooseSymbol(MainWindow.MAIN_SYMBOL_O);
    }

    public void showsStartSymbolO()
    {
        ticTacToeDriver.labelStatus().hasText(equalTo("Start symbol O"));
    }

    public void doShowHistory()
    {
        ticTacToeDriver.doShowHistory();
    }

    public void showsHistoryFrame()
    {
        initHistoryTicTacToe();
    }

    public void pause()
    {
        ticTacToeDriver.pauseOnScreen();
        historyTicTacToeDriver.pauseOnScreen();
    }

//    public void showsHistoryData()
//    {
//        initHistoryTicTacToe();
//        historyTicTacToeDriver.showsHistoryData();
//    }

    public void showsTableHasLastMatch(String firstPlayer, String winner, String steps)
    {
        initHistoryTicTacToe();
        historyTicTacToeDriver.showsHistoryData(firstPlayer, winner, steps);
    }
}
