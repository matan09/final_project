package FinalProject;

import javax.swing.*;
import java.awt.*;

public class VocationListGui extends JFrame {
    private JPanel mainPanel;
    private JLabel titleText;
    private JList wishList;
    private JLabel instructionTxt;
    private JTextField vocationPlaceTxtFiled;
    private JButton addButton;
    private JList visitedList;
    private JLabel imagefield;
    private JPanel Jpanel1;

    //create a JList models for both JLists to add and read data
    private DefaultListModel<String> wishListModel = new DefaultListModel<>();
    private DefaultListModel<String> visitedListModel =  new DefaultListModel<>();




public VocationListGui() {
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(500, 500));
        //getRootPane().setDefaultButton(addButton);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //mainPanel.setBackground(Color.magenta);
        titleText.setBackground(Color.magenta);

        validate();
}






}
