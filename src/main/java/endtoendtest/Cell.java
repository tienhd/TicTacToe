package endtoendtest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 8/9/13
 * Time: 9:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class Cell extends JButton implements ActionListener
{

    Controller controller = new Controller();

    public Cell(Controller controller)
    {
        super();
        this.controller = controller;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if (controller.isFlag() == true)
        {
            this.setText("X");
        }
        else
        {
            this.setText("O");
        }
        if (controller.isFlag() == true)
        {
            controller.setFlag(false);
        }
        else
        {
            controller.setFlag(true);
        }
    }
}
