package FinalProject;

import java.sql.Date;

import static input.InputUtils.*;

public class dbManager {
    //initiate an object
    VocationDB database;

    public static void main(String[] args) {
        dbManager dbmanager = new dbManager();
        dbmanager.start();

    }
    public void start(){
        database = new VocationDB();
        addProduct();
    }



    protected void addProduct() {
        do {
            String name = stringInput("Enter the name of the place");
            String reason = stringInput("Why do you want to visit " + name + "?");
            // create a new Place object with the given placeName and reason
            Place plc = new Place(name, reason);
            // add the new Place object,
            database.addNewPlace(plc);
        } while (yesNoInput("More places to add to your wish list?"));
    }
}
