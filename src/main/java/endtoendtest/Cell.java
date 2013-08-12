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
    private Controller controller;

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
            controller.setFlag(false);
        }
        else
        {
            this.setText("O");
            controller.setFlag(true);
        }
        controller.setNumCellChecked(controller.getNumCellChecked() + 1);

        if (controller.getNumCellChecked() == 9)
        {
            controller.showMessage("GAME FINISH!");
        }
    }
}
