package com.qsoft.kata5.ui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.qsoft.kata5.ui.controller.HistoryController;
import com.qsoft.kata5.ui.controller.MainController;
import com.qsoft.kata5.ui.controller.TictactoeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 8/8/13
 * Time: 6:01 PM
 * To change this template use File | Settings | File Templates.
 */
@org.springframework.stereotype.Component()
@Scope(value = "prototype")
public class MainWindow extends JFrame
{
    public static final String MAIN_WINDOW_NAME = "Tic Tac Toe Main";
    public static final String MAIN_WINDOW_START_BUTTON = "btnStartGame";
    public static final String MAIN_WINDOW_STATUS_LABEL = "lbStatus";
    public static final String MAIN_WINDOW_END_BUTTON = "btnEndGame";
    public static final String MAIN_SYMBOL_X = "symbolX";
    public static final String MAIN_SYMBOL_O = "symbolO";
    public static final String MAIN_WINDOW_SHOW_HISTORY_BUTTON = "btnShowHistory";

    private JButton btnEndGame;
    private JButton btnStartGame;
    private JLabel lbStatus;
    private JPanel panel1;
    private JPanel panelBoard;
    private JRadioButton xRadioButton;
    private JRadioButton oRadioButton;
    private JButton showHistoryButton;

    @Autowired
    private MainController mainController;

    @Autowired
    private HistoryController historyController;

    private Cell[][] cells = new Cell[3][3];

    public MainWindow()
    {
        super(MAIN_WINDOW_NAME);
//        this.mainController = mainController;
//        this.historyController = historyController;
        $$$setupUI$$$();
        setTitle(MAIN_WINDOW_NAME);
        setName(MAIN_WINDOW_NAME);
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        //setVisible(true);
        lbStatus.setFont(new Font("", Font.BOLD, 30));
        btnStartGame.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (refreshPanelBoard())
                    mainController.doStartGame();
            }
        });
        btnEndGame.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mainController.doEndGame();
            }
        });

        xRadioButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mainController.setStartSymbol("X");
            }
        });
        oRadioButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mainController.setStartSymbol("O");
            }
        });
        showHistoryButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                historyController.showHistoryFrame();
            }
        });
    }

    private boolean refreshPanelBoard()
    {
        if (mainController.getActiveStatus() == TictactoeStatus.START){
            return false;
        }
        panelBoard.removeAll();
        return true;
    }

    public JLabel getLbStatus()
    {
        return lbStatus;
    }

    public JPanel getPanelBoard()
    {
        return panelBoard;
    }

    public Cell[][] getCells()
    {
        return cells;
    }

    private void createUIComponents()
    {
        panelBoard = new JPanel(new GridLayout(3, 3));
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        createUIComponents();
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout(0, 0));
        panel1.add(panel2, BorderLayout.EAST);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(6, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel2.add(panel3, BorderLayout.CENTER);
        btnEndGame = new JButton();
        btnEndGame.setName("btnEndGame");
        btnEndGame.setText("End");
        panel3.add(btnEndGame, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(66, 21), null, 0, false));
        btnStartGame = new JButton();
        btnStartGame.setName("btnStartGame");
        btnStartGame.setText("Start");
        panel3.add(btnStartGame, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(66, 25), null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new FormLayout("fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:d:grow,left:4dlu:noGrow,fill:max(d;4px):noGrow", "center:max(d;4px):noGrow,top:4dlu:noGrow,center:236px:grow,top:4dlu:noGrow,center:d:grow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow"));
        panel3.add(panel4, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Start Symbol");
        CellConstraints cc = new CellConstraints();
        panel4.add(label1, cc.xy(3, 5, CellConstraints.CENTER, CellConstraints.DEFAULT));
        xRadioButton = new JRadioButton();
        xRadioButton.setName("symbolX");
        xRadioButton.setSelected(true);
        xRadioButton.setText("X");
        panel4.add(xRadioButton, cc.xy(3, 7, CellConstraints.CENTER, CellConstraints.DEFAULT));
        oRadioButton = new JRadioButton();
        oRadioButton.setName("symbolO");
        oRadioButton.setText("O");
        panel4.add(oRadioButton, cc.xy(3, 9, CellConstraints.CENTER, CellConstraints.DEFAULT));
        final Spacer spacer1 = new Spacer();
        panel4.add(spacer1, cc.xy(3, 3, CellConstraints.DEFAULT, CellConstraints.FILL));
        final Spacer spacer2 = new Spacer();
        panel3.add(spacer2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        showHistoryButton = new JButton();
        showHistoryButton.setName("btnShowHistory");
        showHistoryButton.setText("Show History");
        panel3.add(showHistoryButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panel1.add(panelBoard, BorderLayout.CENTER);
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new BorderLayout(0, 0));
        panel1.add(panel5, BorderLayout.NORTH);
        lbStatus = new JLabel();
        lbStatus.setName("lbStatus");
        lbStatus.setText("");
        panel5.add(lbStatus, BorderLayout.CENTER);
        ButtonGroup buttonGroup;
        buttonGroup = new ButtonGroup();
        buttonGroup.add(xRadioButton);
        buttonGroup.add(oRadioButton);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return panel1;
    }
}
