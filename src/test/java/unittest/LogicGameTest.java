package unittest;

import com.qsoft.kata5.Cell;
import com.qsoft.kata5.LogicGame;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: BinkaA
 * Date: 8/13/13
 * Time: 9:23 AM
 */
public class LogicGameTest
{

    public Cell[][] initialBoard()
    {
        Cell[][] cells = new Cell[3][3];
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                cells[i][j] = new Cell();
            }
        }
        return cells;
    }

    @Test
    public void testGetWinnerAtHorizontal()
    {
        Cell[][] cells = initialBoard();
        cells[0][0].setText("X");
        cells[1][0].setText("O");
        cells[0][1].setText("X");
        cells[1][1].setText("O");
        cells[0][2].setText("X");
        assertEquals("X", LogicGame.getWinner(cells));
    }

    @Test
    public void testGetWinnerAtVertical()
    {
        Cell[][] cells = initialBoard();
        cells[0][0].setText("X");
        cells[2][2].setText("O");
        cells[1][0].setText("X");
        cells[1][1].setText("O");
        cells[2][0].setText("X");
        assertEquals("X", LogicGame.getWinner(cells));
    }

    @Test
    public void testGetWinnerAtDiagonal()
    {
        Cell[][] cells = initialBoard();
        cells[1][0].setText("X");
        cells[0][0].setText("O");
        cells[2][0].setText("X");
        cells[1][1].setText("O");
        cells[2][1].setText("X");
        cells[2][2].setText("O");
        assertEquals("O", LogicGame.getWinner(cells));
    }
}
