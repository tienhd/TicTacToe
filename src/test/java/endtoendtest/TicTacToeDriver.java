package endtoendtest;

import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.*;
import com.objogate.wl.swing.gesture.GesturePerformer;
import com.qsoft.kata5.ui.MainWindow;

import javax.swing.*;

import static org.hamcrest.Matchers.equalTo;

/**
 * User: tienhd
 * Date: 8/8/13
 * Time: 8:26 AM
 */
public class TicTacToeDriver extends JFrameDriver
{
    public TicTacToeDriver(int timeoutMillis)
    {
        super(new GesturePerformer(),
                JFrameDriver.topLevelFrame(
                        named(MainWindow.MAIN_WINDOW_NAME),
                        showingOnScreen()),
                new AWTEventQueueProber(timeoutMillis, 100));
    }

    public void pauseOnScreen()
    {
        Thread currentThread = Thread.currentThread();
        try
        {
            currentThread.sleep(750);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    // =============== DRIVER ===================================================================

    private JButtonDriver buttonStart()
    {
        return new JButtonDriver(this, JButton.class, named(MainWindow.MAIN_WINDOW_START_BUTTON));
    }

    private JButtonDriver buttonEnd()
    {
        return new JButtonDriver(this, JButton.class, named(MainWindow.MAIN_WINDOW_END_BUTTON));
    }

    public JLabelDriver labelStatus()
    {
        return new JLabelDriver(this, named(MainWindow.MAIN_WINDOW_STATUS_LABEL));
    }

    private JButtonDriver buttonCell(String coordinate)
    {
        return new JButtonDriver(this, JButton.class, named("btnCell" + coordinate));
    }

    public JOptionPaneDriver jOptionPaneFinishGame()
    {
        return new JOptionPaneDriver(this, JOptionPane.class);
    }

    public JButtonDriver buttonShowHistory()
    {
        return new JButtonDriver(this, JButton.class, named(MainWindow.MAIN_WINDOW_SHOW_HISTORY_BUTTON));
    }

    // ========================================================
    public void startGame()
    {
        buttonStart().click();
    }

    public void endGame()
    {
        buttonEnd().click();
    }

    public void exitGame()
    {
        this.dispose();
    }

    public void doTickCell(String coordinate)
    {
        buttonCell(coordinate).click();

    }

    //=============================================================
    public void showStatus(String status)
    {
        JLabelDriver lbStatusDriver = labelStatus();
        lbStatusDriver.hasText(equalTo(status));
    }

    public void showsCellChar(String coordinate, String status)
    {
        JButtonDriver jButtonDriver = buttonCell(coordinate);
        jButtonDriver.hasText(equalTo(status));
    }

    public void chooseSymbol(String symbol)
    {
        JRadioButtonDriver jRadioButtonDriver = new JRadioButtonDriver(this, JRadioButton.class, named(symbol));
        jRadioButtonDriver.click();
    }

    public void doShowHistory()
    {
        JButtonDriver jButtonDriver = buttonShowHistory();
        jButtonDriver.click();
    }

    public void showsDisableUncheckedCell(String coordinate)
    {
        JButtonDriver jButtonDriver = buttonCell(coordinate);
        jButtonDriver.isNotChecked();

    }
}
