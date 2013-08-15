package com.qsoft.kata5.persistence.dao;

import com.qsoft.kata5.persistence.entity.TicTacToeMatch;

import java.util.List;

/**
 * User: tienhd
 * Date: 8/14/13
 * Time: 3:01 PM
 */
public interface IHistoryDAO
{
    public TicTacToeMatch create(TicTacToeMatch match);

    public void findById(Long id);

    public List<TicTacToeMatch> getAll();
}
