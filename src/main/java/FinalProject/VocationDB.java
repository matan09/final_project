package FinalProject;

import java.sql.*;

public class VocationDB {
    static String db_url = "jdbc:sqlite:Holidays.db";

    VocationDB(){
        try(Connection connection  = DriverManager.getConnection(db_url);
            Statement statement = connection.createStatement()){

            statement.execute("CREATE TABLE IF NOT EXISTS placeInfo ( name text unique, reason text, datecreated TIMESTAMP )");

        }catch (SQLException sqle){
            System.err.println("error creating  DB table because " + sqle);
        }
    }


    public boolean addNewPlace(Place place){
        try (Connection connection = DriverManager.getConnection(db_url);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO placeInfo values(?, ?, ?)")){

            preparedStatement.setString(1, place.getName());
            preparedStatement.setString(2, place.getReason());
            preparedStatement.setDate(3, (Date) place.getCreated());
            preparedStatement.executeUpdate();
        }catch (SQLException SQL){

        }
        return true;
    }


}
