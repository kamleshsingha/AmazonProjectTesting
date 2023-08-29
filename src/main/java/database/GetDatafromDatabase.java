package database;

import java.sql.*;

public class GetDatafromDatabase {
    public static void main(String args[]) throws SQLException {
        try {



            Connection connection = DriverManager.getConnection("jdbc:mysql://@localhost:3306/sadata", "root", "admin");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * from user_regis where user_name='koba';");

            while(resultSet.next())
            {
                System.out.println(resultSet.getInt(1)+"  "+resultSet.getString(2)+"  "+resultSet.getString(3)+"  "+resultSet.getInt(4)+"  "+resultSet.getString(5));
            }
            connection.close();
            System.out.println("Value inserted successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}



