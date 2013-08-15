package com.qsoft.kata5.ui.controller;

import com.qsoft.kata5.persistence.entity.TicTacToeMatch;
import com.qsoft.kata5.ui.Cell;
import com.qsoft.kata5.ui.LogicGame;
import com.qsoft.kata5.ui.MainWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 * User: thinhdd
 * Date: 8/9/13
 * Time: 10:36 AM
 */
@Component("mainController")
public class MainController implements ActionListener
{
    public final boolean X_PLAYER = true;
    public final boolean O_PLAYER = false;
    boolean isFirstPlayer = true;
    int numCellChecked = 0;

    Calendar timeSystem;
    private TictactoeStatus activeStatus;

    public String steps = "";
    public String logFirstPlayer = "X";
    public String logWinner = "-";
    public Long lastMatchId = 0L;

    @Autowired
    private HistoryController historyController;

    @Autowired
    private MainWindow mainWindow;
    private Cell[][] cells;

    public MainController()
    {
    }

    public void showMainFrame()
    {
        mainWindow.setVisible(true);
    }

    public void doStartGame()
    {
        activeStatus = TictactoeStatus.START;
        mainWindow.getLbStatus().setText(activeStatus.getStatus());
        doBuildBoard();
    }

    public void doEndGame()
    {
        activeStatus = TictactoeStatus.END;
        mainWindow.getLbStatus().setText(activeStatus.getStatus());
        //saveMatchLogToDB();
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
        steps += cell.getName().substring(7, cell.getName().length()) + ",";
        System.out.println(steps);
        if (isFirstPlayer == X_PLAYER)
        {
            cell.setText("X");
            isFirstPlayer = false;
            activeStatus = TictactoeStatus.XCHECKED;
        }
        else
        {
            cell.setText("O");
            isFirstPlayer = true;
            activeStatus = TictactoeStatus.OCHECKED;
        }
        numCellChecked++;
        cell.setEnabled(false);
        mainWindow.getLbStatus().setText(activeStatus.getStatus());
        String winner = LogicGame.getWinner(cells);
        if (winner != null && !winner.isEmpty())
        {
            mainWindow.getLbStatus().setText(winner + " Win!");
            disableUncheckedCells();
            logWinner = winner;
            saveMatchLogToDB();
        }
        if (numCellChecked == 9)
        {
            activeStatus = TictactoeStatus.GAME_FINISH;
            showMessage(activeStatus.getStatus());
            saveMatchLogToDB();
        }
    }

    private void disableUncheckedCells()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (!cells[i][j].isSelected())
                    cells[i][j].setEnabled(false);
            }
        }
    }

    public void setStartSymbol(String symbol)
    {
        mainWindow.getLbStatus().setText("Start symbol " + symbol);
        if (symbol.equals("O"))
        {
            isFirstPlayer = false;
        }
        logFirstPlayer = symbol;
        System.out.println(symbol);
    }

    public String getSteps()
    {
        return steps;
    }

    public Long getLastMatchId()
    {
        return lastMatchId;
    }

    public void setTimeSystem(Calendar calendar)
    {
        this.timeSystem = calendar;
    }

    public Long saveMatchLogToDB()
    {
        TicTacToeMatch ticTacToeMatch = new TicTacToeMatch(timeSystem.getTimeInMillis(), logFirstPlayer, logWinner, steps);
        return historyController.saveLog(ticTacToeMatch);
    }

    public Cell[][] getCells()
    {
        return cells;
    }

    public TictactoeStatus getActiveStatus()
    {
        return activeStatus;
    }
}
