package com.qsoft.kata5.service.impl;

import com.qsoft.kata5.persistence.dao.IHistoryDAO;
import com.qsoft.kata5.persistence.entity.TicTacToeMatch;
import com.qsoft.kata5.service.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: tienhd
 * Date: 8/14/13
 * Time: 3:27 PM
 */
@Component
public class HistoryService implements IHistoryService
{
    @Autowired
    IHistoryDAO historyDAO;

    @Override
    public void create(TicTacToeMatch match)
    {
        historyDAO.create(match);
    }

    @Override
    public void findById(Long id)
    {
        historyDAO.findById(id);
    }

    @Override
    public List<TicTacToeMatch> getAll()
    {
        return historyDAO.getAll();
    }
}
