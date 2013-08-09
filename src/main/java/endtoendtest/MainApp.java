package endtoendtest;

/**
 * User: tienhd
 * Date: 8/8/13
 * Time: 8:28 AM
 */
public class MainApp
{
    private MainWindow ui;

    public MainApp()
    {
        startUserInterface();
    }

    private void startUserInterface()
    {
        try
        {
//            SwingUtilities.invokeAndWait(new Runnable()
//            {
//                public void run()
//                {
            ui = new MainWindow();
            ui.setVisible(true);
//                }
//            });
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main()
    {
        MainApp main = new MainApp();
    }
}
