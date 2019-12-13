package FinalProject;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class VocationDB {
    // store database url
    static String db_url = "jdbc:sqlite:Holidays.db";
    static final String name_column = "name";
    static final String reason_column = "reason";

    // create constaant variables to use when handling duplicate entry
    static final String noDupicate = "noDuplicate";
    static final String duplicate = "duplicate entry";
    // error code 19 = contraint voilation
    static final int sqlite_primary_key_error_code = 19;

    VocationDB(){
        try(Connection connection  = DriverManager.getConnection(db_url);
            Statement statement = connection.createStatement()){

            statement.execute("CREATE TABLE IF NOT EXISTS placeInfo ( name text PRIMARY KEY, reason text )");

        }catch (SQLException sqle){
            throw new RuntimeException();
        }
    }


    public   String addNewPlace(Place place) {
        try (Connection connection = DriverManager.getConnection(db_url);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO placeInfo values(?, ?)")) {

            preparedStatement.setString(1, place.getName());
            preparedStatement.setString(2, place.getReason());
            //preparedStatement.setDate(3, (Date) place.getCreated());
            preparedStatement.executeUpdate();

            return noDupicate;

        } catch (SQLException sqle) {
            if(sqle.getErrorCode() == sqlite_primary_key_error_code){
                return duplicate;
            }else{
                throw new RuntimeException();
            }
        }
    }

    public List<Place> retrievePlaceInfo(){
        List<Place> pl = new ArrayList<>();//store the date in List
        try(Connection connection = DriverManager.getConnection(db_url);
            Statement statement = connection.createStatement()){
            // fetch all products from placeInfo table
            ResultSet placeResults = statement.executeQuery("SELECT  * FROM placeInfo");

            while (placeResults.next()){

                String name = placeResults.getString(name_column);
                String reason = placeResults.getString(reason_column);
                Place place = new Place(name, reason);
                pl.add(place);
            }
            return pl;

        }catch (SQLException sqle){
            throw new RuntimeException(sqle);
        }

    }

    public void deleteplaceFromDB(Place place){
        try (Connection connection = DriverManager.getConnection(db_url);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM placeInfo WHERE name = ?")){

            preparedStatement.setString(1, place.getName());
            preparedStatement.executeUpdate();
        }catch (SQLException sqle){
           throw new RuntimeException(sqle);
        }
    }




}//C:\Users\abdala\finalProject\src\main\java\VocationGui
