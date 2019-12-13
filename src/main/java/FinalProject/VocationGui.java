package FinalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VocationGui extends JFrame {
    private JPanel mainPanel;
    private JLabel titleText;
    private JList<Place> wishList;
    private JLabel instructionTxt;
    private JTextField vocationPlaceTxtFiled;
    private JButton addButton;
    private JLabel imagefield;
    private JPanel Jpanel1;
    private JTextField reasonTextField;
    private JButton DeleteButton;

    //create a JList models for both JLists to add and read data
    private DefaultListModel<Place> placeInfoListModel;



VocationDB database;

public VocationGui(VocationDB database) {
        this.database = database;
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(500, 500));
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // associate modelList to jList
        placeInfoListModel = new DefaultListModel<>();
        wishList.setModel(placeInfoListModel);
        // set font style
        //titleText.setBackground(Color.magenta);

        addActionListeners();


}


public void addActionListeners(){
    addButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = vocationPlaceTxtFiled.getText();
            String reason = reasonTextField.getText();
            // validate user input
            if(name.isEmpty() || reason.isEmpty()){
                errormsg("enter a name and reason");
            }

            Place pl = new Place(name, reason);
           placeInfoListModel.addElement(pl);

           // delete button listener
     DeleteButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             Place place = wishList.getSelectedValue();
             placeInfoListModel.removeElement(place);

         }
     });



        }
    });
}

public void updatewishList(List<Place> place){
    placeInfoListModel.clear();
    if(place != null){
        for(Place pl : place){
            placeInfoListModel.addElement(pl);

        }
    }
}


private void errormsg(String msg){
    JOptionPane.showMessageDialog(VocationGui.this, msg, "ERROR", JOptionPane.ERROR_MESSAGE );
}






}
