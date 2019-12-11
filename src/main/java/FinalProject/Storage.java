package FinalProject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * For saving and fetching lists of places from files
 */

public class Storage {

    public void writeListToFile(List<Place> places, String filename) {
        // TODO finish this method.  See Lab 10 Questions.md.
        //try_with_resource will automatically close the resource.
        //create a BufferedWrter which wraps the file
        try (BufferedWriter buf_writer = new BufferedWriter(new FileWriter(filename))) {
            //go through all the elements in the places lists
            for (int i = 0; i < places.size(); i++) {
                // write every element in to the file, on element per line
                buf_writer.write(places.get(i) + "\n");
            }

        } catch (IOException e) {

            e.printStackTrace();

        }
    }


    public List<String> readListFromFile (String filename){
        List<String> list_from_file = new ArrayList<>();// this list stores the content of the file
        //create a BuffeeredReader which wraps the file
        try(BufferedReader bReader = new BufferedReader(new FileReader(filename))){
            String lines_in_file = bReader.readLine();
            while (lines_in_file != null){
                list_from_file.add(lines_in_file);
                lines_in_file = bReader.readLine();
            }

        }catch (IOException e){
            return list_from_file;

        }

        // TODO complete this method. See Lab 10 Questions.md.

        return list_from_file;  // TODO replace with your own code.
    }
}
