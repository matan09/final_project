package FinalProject;

import java.util.List;

public class Main {
    //this my original code
//    public static String wishListFile = "wishlist.txt";
//    public static String visitedFile = "visited.txt";
//    this is original code as well
    static Storage storage = new Storage();
    // initialize objects for gui and db files
    VocationDB database;
    VocationGui gui;

    public static void main(String[] args) {

        Main main = new Main();
        main.creation();

    }

    public static void quit(List<Place> wishList) {
        //this is my original code
//        storage.writeListToFile(wishList, wishListFile);


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

     List<Place> getPlaceData(){
        return database.retrievePlaceInfo();
    }

    String addPlace(Place place){
        return  database.addNewPlace(place);
    }
    void deleteplace(Place place){
        database.deleteplaceFromDB(place);
    }
}