package com.qsoft.kata5.ui;

import com.qsoft.kata5.ui.controller.MainController;

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

    public Cell()
    {
    }

    public Cell(MainController mainController)
    {
        super();
        this.setFont(new Font("", Font.BOLD, 30));
        addActionListener(mainController);
    }
}
