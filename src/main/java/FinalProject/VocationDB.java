package FinalProject;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class VocationDB {
    static String db_url = "jdbc:sqlite:Holidays.db";

    // create constaant variables to use when handling duplicate entry
//    static final String noDupicate = "noDuplicate";
//    static final String duplicate = "duplicate entry";
//    // error code 19 = contraint voilation
//    static final int sqlite_primary_key_error_code = 19;

    VocationDB(){
        try(Connection connection  = DriverManager.getConnection(db_url);
            Statement statement = connection.createStatement()){

            statement.execute("CREATE TABLE IF NOT EXISTS placeInfo ( name text unique, reason text )");

        }catch (SQLException sqle){
            System.err.println("error creating  DB table because " + sqle);
        }
    }


    public  void  addNewPlace(Place place){
        try (Connection connection = DriverManager.getConnection(db_url);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO placeInfo values(?, ?)")){

            preparedStatement.setString(1, place.getName());
            preparedStatement.setString(2, place.getReason());
            preparedStatement.setDate(3, (Date) place.getCreated());
            preparedStatement.executeUpdate();

        }catch (SQLException sqle){
            throw new RuntimeException(sqle);
        }
    }

    public List<Place> retrievePlaceInfo(){
        List<Place> pl = new LinkedList<>();//store the date in List
        try(Connection connection = DriverManager.getConnection(db_url);
            Statement statement = connection.createStatement()){
            // fetch all products from placeInfo table, sort by product name.
            ResultSet placeResults = statement.executeQuery("SELECT  * FROM placeInfo");

            while (placeResults.next()){

                String name = placeResults.getString("name");
                String reason = placeResults.getString("reason");
                Place place = new Place(name, reason);
                pl.add(place);
            }
            return pl;

        }catch (SQLException sqle){
            throw new RuntimeException(sqle);
        }

    }

    public void deleterecord(Place place){
        try (Connection connection = DriverManager.getConnection(db_url);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM placeInfo WHERE name = ?")){

            preparedStatement.setString(1, place.getName());
            preparedStatement.executeUpdate();
        }catch (SQLException sqle){
            System.err.println("Error deleting product because " + sqle);
        }
    }




}//C:\Users\abdala\finalProject\src\main\java\VocationGui
