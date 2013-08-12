package endtoendtest;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 8/9/13
 * Time: 10:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class Controller
{
    boolean flag = true;
    int numCellChecked = 0;
    MainWindow mainWindow;
    private Cell[][] cells;

    public Controller()
    {
        try
        {
            mainWindow = new MainWindow(this);
            mainWindow.setVisible(true);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void doStartGame()
    {
        mainWindow.getLbStatus().setText("START");
        doBuildBoard();
    }

    public void doEndGame()
    {
        mainWindow.getLbStatus().setText("END");
    }

    public void doBuildBoard()
    {
        cells = mainWindow.getCells();
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                cells[i][j] = new Cell(this);
                cells[i][j].setName("btnCell" + i + "_" + j);
                System.out.println(cells[i][j].getName());
                mainWindow.getPanelBoard().add(cells[i][j]);
            }
        }
    }


    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }

    public int getNumCellChecked()
    {
        return numCellChecked;
    }

    public void setNumCellChecked(int numCellChecked)
    {
        this.numCellChecked = numCellChecked;
    }

    public void showMessage(String message)
    {
        mainWindow.getLbStatus().setText(message);
    }
}
