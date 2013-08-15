package com.qsoft.kata5.ui.controller;

/**
 * User: BinkaA
 * Date: 8/15/13
 * Time: 11:07 AM
 */
public enum TictactoeStatus
{
    START("START"),
    END("END"),
    GAME_FINISH("GAME FINISH!"),
    SAVED("SAVED"),
    OCHECKED("Symbol O Checked"),
    XCHECKED("Symbol X Checked");

    String status;
    private TictactoeStatus(String status)
    {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
