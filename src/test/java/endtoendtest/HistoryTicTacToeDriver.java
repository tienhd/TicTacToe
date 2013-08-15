package endtoendtest;

import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.driver.JTableDriver;
import com.objogate.wl.swing.driver.JTableHeaderDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;
import com.qsoft.kata5.ui.HistoryWindow;

import javax.swing.table.JTableHeader;

import static com.objogate.wl.swing.matcher.IterableComponentsMatcher.matching;
import static com.objogate.wl.swing.matcher.JLabelTextMatcher.withLabelText;

/**
 * User: tienhd
 * Date: 8/14/13
 * Time: 9:00 AM
 */
public class HistoryTicTacToeDriver extends JFrameDriver
{
    public HistoryTicTacToeDriver(int timeoutMillis)
    {
        super(new GesturePerformer(),
                JFrameDriver.topLevelFrame(
                        named(HistoryWindow.HISTORY_WINDOW_NAME),
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

    public void showsHistoryData(Long id, Long timeStamp, String firstPlayer, String winner, String steps)
    {
        //assertion
        JTableDriver tableDriver = new JTableDriver(this);
        tableDriver.hasRow(matching(withLabelText(id.toString()), withLabelText(timeStamp.toString()), withLabelText(firstPlayer), withLabelText(winner), withLabelText(steps)));
    }

    public void hasColumnTitles()
    {
        JTableHeaderDriver headers = new JTableHeaderDriver(this,
                JTableHeader.class);
        headers.hasHeaders(
                matching(withLabelText("Id"), withLabelText("Time"),
                        withLabelText("Start player"), withLabelText("Winner"), withLabelText("Steps")));
    }

    public void exitGame()
    {
        this.dispose();
    }
}
