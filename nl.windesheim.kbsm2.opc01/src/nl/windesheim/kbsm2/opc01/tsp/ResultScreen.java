package nl.windesheim.kbsm2.opc01.tsp;

import javax.swing.*;
import java.awt.event.*;

public class ResultScreen extends JDialog {
    private JPanel contentPane;
    private JButton buttonExit;
    private JLabel nnTime;
    private JLabel bfTime;
    private JLabel gTime;
    private JLabel nnDistance;
    private JLabel bfDistance;
    private JLabel gDistance;
    private JButton buttonCancel;

    public ResultScreen() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonExit);

        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
// add your code here
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        ResultScreen dialog = new ResultScreen();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
