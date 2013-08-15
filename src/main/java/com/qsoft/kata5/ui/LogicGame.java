package com.qsoft.kata5.ui;

/**
 * User: BinkaA
 * Date: 8/13/13
 * Time: 9:07 AM
 */
public class LogicGame
{
    public static String getWinner(Cell[][] cells)
    {
        for (int i = 0; i < 3; i++)
        {
            if (cells[i][0].getText().equals(cells[i][1].getText()) &&
                    cells[i][0].getText().equals(cells[i][2].getText()))
            {
                return cells[i][0].getText();
            }
        }
        for (int j = 0; j < 3; j++)
        {
            if (cells[0][j].getText().equals(cells[1][j].getText()) &&
                    cells[0][j].getText().equals(cells[2][j].getText()))
            {
                return cells[0][j].getText();
            }
        }
        //
        if (cells[0][0].getText().equals(cells[1][1].getText()) &&
                cells[0][0].getText().equals(cells[2][2].getText()))
        {
            return cells[0][0].getText();
        }
        //
        if (cells[2][0].getText().equals(cells[1][1].getText()) &&
                cells[2][0].getText().equals(cells[0][2].getText()))
        {
            return cells[2][0].getText();
        }
        return null;
    }
}
