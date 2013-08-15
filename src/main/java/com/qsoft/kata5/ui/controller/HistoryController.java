package com.qsoft.kata5.ui.controller;

import com.qsoft.kata5.persistence.entity.TicTacToeMatch;
import com.qsoft.kata5.service.IHistoryService;
import com.qsoft.kata5.ui.HistoryWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * User: tienhd
 * Date: 8/14/13
 * Time: 9:06 AM
 */
@Component("historyController")
public class HistoryController
{
    private List<TicTacToeMatch> ticTacToeMatchList = new ArrayList<TicTacToeMatch>();

    @Autowired
    private HistoryWindow historyWindow;

    @Autowired
    public IHistoryService historyService;

    public HistoryController()
    {
    }

    public void showHistoryFrame()
    {
        historyWindow.setVisible(true);
        createTable();
    }

    public void insertDataToTable(DefaultTableModel tableModel)
    {
        ticTacToeMatchList = historyService.getAll();

        if (ticTacToeMatchList != null)
        {
            for (TicTacToeMatch ticTacToeMatch : ticTacToeMatchList)
            {
                tableModel.addRow(ticTacToeMatch.toArrayObject());
            }
        }
    }

    public void createTable()
    {
        String[] columnsName = {"Id", "Time", "Start player", "Winner", "Steps"};
        DefaultTableModel tableModel = new DefaultTableModel(null, columnsName);
        insertDataToTable(tableModel);
        historyWindow.getTbHistory().setModel(tableModel);
    }

    public Long saveLog(TicTacToeMatch ticTacToeMatch)
    {
        historyService.create(ticTacToeMatch);
        return ticTacToeMatch.getId();
    }
}
