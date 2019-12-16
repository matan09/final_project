package FinalProject;

import java.util.List;

public class Main {

    // initialize objects for gui and db files
    VocationDB database;
    VocationGui gui;

    public static void main(String[] args) {

        Main main = new Main();
        main.creation();

    }

    private void creation(){
        //create vocationDB object
        database = new VocationDB();
        // create list place object to store all the place object data from the data base
        List<Place> allPlaceInfo = database.retrievePlaceInfo();
        //create gui object
        gui = new VocationGui(this);
        // then add this data to the wishJlist
        gui.updatewishList(allPlaceInfo);


    }

     protected List<Place> getPlaceData(){
        return database.retrievePlaceInfo();
    }

    String addPlace(Place place){
        return  database.addNewPlace(place);
    }

    void deleteplace(Place place){
        database.deleteplaceFromDB(place);
    }
}