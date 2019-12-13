package FinalProject;

import java.util.List;

public class Main {
    public static String wishListFile = "wishlist.txt";
    public static String visitedFile = "visited.txt";

    static Storage storage = new Storage();

    public static void main(String[] args) {
        VocationDB db = new VocationDB();
        VocationGui gui = new VocationGui(db);



    }



}