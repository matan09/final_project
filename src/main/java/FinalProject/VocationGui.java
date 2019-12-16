package FinalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VocationGui extends JFrame {
    private JPanel mainPanel;
    private JLabel titleText;
    private JList<Place> wishList;
    private JTextField vocationPlaceTxtFiled;
    private JButton addButton;
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
            //validate JtextField using REGEx
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(name);
            Matcher mtch = pattern.matcher(reason);
            // check all occurance
            if (matcher.find() || mtch.find()){
                errormsg("Please use letter only");
                vocationPlaceTxtFiled.setText("");// clear name textfield
                reasonTextField.setText("");// clear reasont textfiled
                return;
            }

            if(name.isEmpty() || reason.isEmpty()){
                errormsg("enter a name and reason");
                return;
            }

            Place pl = new Place(name, reason);
            String outcome = main.addPlace(pl);

            if(outcome.equals(VocationDB.noDupicate)){
                List<Place> alldata = main.getPlaceData();
                updatewishList(alldata);
                // clear both JTextfields after each entry
                vocationPlaceTxtFiled.setText("");
                reasonTextField.setText("");

            }else{
                errormsg(name + " is already in the list");
                // clear both JTextFileds
                vocationPlaceTxtFiled.setText("");
                reasonTextField.setText("");

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
