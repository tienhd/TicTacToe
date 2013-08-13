package endtoendtest;

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
public class MainWindow extends JFrame
{
    public static final String MAIN_WINDOW_NAME = "Tic Tac Toe Main";
    public static final String MAIN_WINDOW_START_BUTTON = "btnStartGame";
    public static final String MAIN_WINDOW_STATUS_LABEL = "lbStatus";
    public static final String MAIN_WINDOW_END_BUTTON = "btnEndGame";

    private JButton btnEndGame;
    private JButton btnStartGame;
    private JLabel lbStatus;
    private JPanel panel1;
    private JPanel panelBoard;
    private Controller controller;
    private Cell[][] cells = new Cell[3][3];

    public MainWindow(final Controller controller)
    {
        super(MAIN_WINDOW_NAME);
        this.controller = controller;
        $$$setupUI$$$();
        setTitle(MAIN_WINDOW_NAME);
        setName(MAIN_WINDOW_NAME);
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
        lbStatus.setFont(new Font("", Font.BOLD, 30));
        btnStartGame.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                controller.doStartGame();
            }
        });
        btnEndGame.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                controller.doEndGame();
            }
        });

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
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel2.add(panel3, BorderLayout.CENTER);
        btnEndGame = new JButton();
        btnEndGame.setName("btnEndGame");
        btnEndGame.setText("End");
        panel3.add(btnEndGame, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(66, 21), null, 0, false));
        btnStartGame = new JButton();
        btnStartGame.setName("btnStartGame");
        btnStartGame.setText("Start");
        panel3.add(btnStartGame, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(66, 25), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel3.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        panel1.add(panelBoard, BorderLayout.CENTER);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new BorderLayout(0, 0));
        panel1.add(panel4, BorderLayout.NORTH);
        lbStatus = new JLabel();
        lbStatus.setName("lbStatus");
        panel4.add(lbStatus, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return panel1;
    }
}
