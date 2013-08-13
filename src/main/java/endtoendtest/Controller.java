package endtoendtest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 8/9/13
 * Time: 10:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class Controller implements ActionListener
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
                mainWindow.getPanelBoard().add(cells[i][j]);
            }
        }
    }

    public void showMessage(String message)
    {
        mainWindow.getLbStatus().setText(message);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Cell cell = (Cell) e.getSource();
        if (flag == true)
        {
            cell.setText("X");
            flag = false;
        }
        else
        {
            cell.setText("O");
            flag = true;
        }
        numCellChecked++;
        cell.setEnabled(false);
        mainWindow.getLbStatus().setText("Symbol  " + cell.getText() + "  checked!");
        String winner = LogicGame.getWinner(cells);
        if (winner != null && !winner.isEmpty())
        {
            mainWindow.getLbStatus().setText(winner + " Win!");
        }
        if (numCellChecked == 9)
        {
            showMessage("GAME FINISH!");
        }
    }
}
