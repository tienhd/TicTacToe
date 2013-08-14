package com.qsoft.kata5.persistence.entity;

import javax.persistence.*;

/**
 * User: tienhd
 * Date: 8/14/13
 * Time: 10:49 AM
 */

@Entity
@Table(name = "history")
@SequenceGenerator(name = "tictactoe_seq", sequenceName = "tictactoe_seq", initialValue = 1, allocationSize = 1)
public class TicTacToeMatch
{
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tictactoe_seq")
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "first_player")
    private String firstPlayer;

    @Column(name = "winner")
    private String winner;

    @Column(name = "time_stamp")
    private String timeStamp;

    @Column(name = "steps")
    private String steps;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFirstPlayer()
    {
        return firstPlayer;
    }

    public void setFirstPlayer(String firstPlayer)
    {
        this.firstPlayer = firstPlayer;
    }

    public String getWinner()
    {
        return winner;
    }

    public void setWinner(String winner)
    {
        this.winner = winner;
    }

    public String getTimeStamp()
    {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp)
    {
        this.timeStamp = timeStamp;
    }

    public String getSteps()
    {
        return steps;
    }

    public void setSteps(String steps)
    {
        this.steps = steps;
    }
}
