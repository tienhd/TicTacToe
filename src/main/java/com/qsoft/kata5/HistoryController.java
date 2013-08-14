package com.qsoft.kata5;

import com.qsoft.kata5.persistence.entity.TicTacToeMatch;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * User: tienhd
 * Date: 8/14/13
 * Time: 9:06 AM
 */
public class HistoryController
{
    List<TicTacToeMatch> ticTacToeMatchList = new ArrayList<TicTacToeMatch>();
    HistoryWindow historyWindow;

    public HistoryController()
    {

        try
        {
            historyWindow = new HistoryWindow(this);
            createTable();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public TicTacToeMatch[][] parseTableData()
    {
        if (ticTacToeMatchList != null)
        {

        }
        return null;
    }

    public void createTable()
    {
        String[] columnsName = {"Id", "Time", "Start player", "Winner", "Steps"};
        DefaultTableModel tableModel = new DefaultTableModel(null, columnsName);
        historyWindow.getTbHistory().setModel(tableModel);
    }
}
