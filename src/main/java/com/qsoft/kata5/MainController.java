package com.qsoft.kata5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: thinhdd
 * Date: 8/9/13
 * Time: 10:36 AM
 */
public class MainController implements ActionListener
{
    public final boolean X_PLAYER = true;
    public final boolean O_PLAYER = false;
    boolean isFirstPlayer = true;
    int numCellChecked = 0;
    MainWindow mainWindow;
    private Cell[][] cells;

    public MainController()
    {
        try
        {
            mainWindow = new MainWindow(this);
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
        if (isFirstPlayer == X_PLAYER)
        {
            cell.setText("X");
            isFirstPlayer = false;
        }
        else
        {
            cell.setText("O");
            isFirstPlayer = true;
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

    public void setStartSymbol(String symbol)
    {
        mainWindow.getLbStatus().setText("Start symbol " + symbol);
        if (symbol.equals("O"))
        {
            isFirstPlayer = false;
        }
        System.out.println(symbol);
    }
}
