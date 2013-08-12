package endtoendtest;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 8/9/13
 * Time: 9:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class Cell extends JButton
{
    private Controller controller;

    public Cell(Controller controller)
    {
        super();
        this.controller = controller;
        this.setFont(new Font("", Font.BOLD, 30));
        addActionListener(controller);
    }
}
