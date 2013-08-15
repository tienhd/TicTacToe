package com.qsoft.kata5.service;

import com.qsoft.kata5.persistence.entity.TicTacToeMatch;

import java.util.List;

/**
 * User: tienhd
 * Date: 8/14/13
 * Time: 3:26 PM
 */
public interface IHistoryService
{
    public void create(TicTacToeMatch match);

    public void findById(Long id);

    public List<TicTacToeMatch> getAll();
}
