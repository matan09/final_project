package FinalProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static input.InputUtils.*;

public class VocationList {

public static void main(String[] args) {

     List<Place> wishList = new ArrayList<>();
    String wishListFile = "wishlist.txt";
    //creat Storage object
    Storage storage = new Storage();

do {
String name = stringInput("Enter the name of the place");
String reason = stringInput("Why do you want to visit " + name + "?");

// use to newPlace method to
// create a new Place object with the given placeName and reason
// The Place object's constructor should calculate the date created and store that.
Place plc = newPlace(name, reason);
// add the new Place object, returned by newPlace, to the wishList
wishList.add(plc);
} while (yesNoInput("More places to add to your wish list?"));

// Call the displayPlacesInNameOrder method to print
//  a list of the places, sorted by name
displayPlacesInNameOrder(wishList);

boolean want_to_delete = yesNoInput("do you want delete a place?");
if(want_to_delete){
    placeToDelete(wishList);
    displayPlacesInNameOrder(wishList);
}
//write all of the data about all of the places to a file
storage.writeListToFile(wishList, wishListFile);

}


public static Place newPlace(String placeName, String reason) {
    // create a new Place object with the given placeName and reason
    Place new_place = new Place(placeName, reason);


return new_place;  //
}

public static void displayPlacesInNameOrder(List<Place> places) {
        //  Sort the List of Place objects, places should be sorted in name order.
        //  Print each place, one per line
        Collections.sort(places);
        for (int i = 0; i <places.size(); i++){
            System.out.println(places.get(i));
}
}

public  static void placeToDelete(List<Place> places){

        String placeName = stringInput("Enter the name of the place you want to delete");
        //Collections.sort(places);
        for(int i = 0; i<places.size(); i++){
            if(places.get(i).getName().equalsIgnoreCase(placeName)){
                places.remove(i);
                System.out.println(placeName +" successfully deleted");
            }
        }
    }

}
