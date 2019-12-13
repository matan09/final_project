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


// initialize object
    Main main;


public VocationGui(Main main) {
    this.main = main;

        setContentPane(mainPanel);
        setPreferredSize(new Dimension(500, 500));
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // add image icon to deleteBtton
        DeleteButton.setIcon(new ImageIcon("C:\\Users\\abdala\\Desktop\\d.png"));
        // associate modelList to jList
        placeInfoListModel = new DefaultListModel<>();
        wishList.setModel(placeInfoListModel);

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
                return;
            }

            Place pl = new Place(name, reason);
            String outcome = main.addPlace(pl);

            if(outcome.equals(VocationDB.noDupicate)){
                List<Place> alldata = main.getPlaceData();
                updatewishList(alldata);
            }

        }
    });

    DeleteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Place placeinfo = wishList.getSelectedValue();
            if(placeinfo == null){
                errormsg("select a place to delete");
            }else{
                main.deleteplace(placeinfo);
                List<Place> placedata = main.getPlaceData();
                updatewishList(placedata);
            }

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
