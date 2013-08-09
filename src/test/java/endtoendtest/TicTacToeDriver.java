package endtoendtest;

import com.objogate.wl.Prober;
import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.ComponentSelector;
import com.objogate.wl.swing.driver.JButtonDriver;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.driver.JLabelDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;

import javax.swing.*;

import static endtoendtest.MainWindow.MAIN_WINDOW_NAME;
import static org.hamcrest.Matchers.equalTo;

/**
 * User: tienhd
 * Date: 8/8/13
 * Time: 8:26 AM
 */
public class TicTacToeDriver extends JFrameDriver
{
    public TicTacToeDriver(GesturePerformer gesturePerformer, ComponentSelector<JFrame> componentSelector, Prober prober)
    {
        super(gesturePerformer, componentSelector, prober);
    }

    public TicTacToeDriver(int timeoutMillis)
    {
        super(new GesturePerformer(),
                JFrameDriver.topLevelFrame(
                        named(MainWindow.MAIN_WINDOW_NAME),
                        showingOnScreen()),
                new AWTEventQueueProber(timeoutMillis, 100));
    }

    @SuppressWarnings("unchecked")
    public TicTacToeDriver()
    {
        super(new GesturePerformer(), new AWTEventQueueProber(), named(MAIN_WINDOW_NAME), showingOnScreen());
    }

    public void startGame()
    {
        buttonStart().click();
    }

    private JButtonDriver buttonStart()
    {
        return new JButtonDriver(this, JButton.class, named(MainWindow.MAIN_WINDOW_START_BUTTON));
    }

    public void showStatus(String status)
    {
        JLabelDriver lbStatusDriver = labelStatus();
        lbStatusDriver.hasText(equalTo(status));
    }

    private JLabelDriver labelStatus()
    {
        return new JLabelDriver(this, named(MainWindow.MAIN_WINDOW_STATUS_LABEL));
    }

    public void endGame()
    {
        buttonEnd().click();
    }

    private JButtonDriver buttonEnd()
    {
        return new JButtonDriver(this, JButton.class, named(MainWindow.MAIN_WINDOW_END_BUTTON));
    }

    public void doTickCell(String coordinate)
    {
        buttonCell(coordinate).click();

    }

    private JButtonDriver buttonCell(String coordinate)
    {
        return new JButtonDriver(this, JButton.class, named("btnCell" + coordinate));
    }

    public void showsCellChar(String coordinate, String status)
    {
        JButtonDriver jButtonDriver = buttonCell(coordinate);
        jButtonDriver.hasText(equalTo(status));
    }

    public void exitGame()
    {
        this.dispose();
    }
}
