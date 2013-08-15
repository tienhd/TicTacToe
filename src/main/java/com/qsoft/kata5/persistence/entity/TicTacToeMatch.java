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
    private Long timeStamp;

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

    public Long getTimeStamp()
    {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp)
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        TicTacToeMatch that = (TicTacToeMatch) o;

        if (firstPlayer != null ? !firstPlayer.equals(that.firstPlayer) : that.firstPlayer != null)
        {
            return false;
        }
        if (steps != null ? !steps.equals(that.steps) : that.steps != null)
        {
            return false;
        }
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null)
        {
            return false;
        }
        if (winner != null ? !winner.equals(that.winner) : that.winner != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = firstPlayer != null ? firstPlayer.hashCode() : 0;
        result = 31 * result + (winner != null ? winner.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        result = 31 * result + (steps != null ? steps.hashCode() : 0);
        return result;
    }

    //-------------------------


    public TicTacToeMatch()
    {
    }

    public TicTacToeMatch(Long timeStamp, String firstPlayer, String winner, String steps)
    {
        this.firstPlayer = firstPlayer;
        this.winner = winner;
        this.timeStamp = timeStamp;
        this.steps = steps;
    }

    public Object[] toArrayObject()
    {
        return new Object[]{this.id, this.timeStamp, this.firstPlayer, this.winner, this.steps};
    }
}
