package database;

import java.sql.*;

public class DatabaseConnection {

    public static void main(String args[]) throws SQLException {
        try {


            String query = " insert into user_regis values(1218,'koba','kistapista@toco.co',33453234,'7756@rer')";
            String update = "UPDATE user_regis SET user_email = 'kaka@mika,com' WHERE user_name='sontana';";
            String delete = "DELETE from user_regis WHERE user_id=1218;";
           // Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://@localhost:3306/sadata", "root", "admin");
            Statement stmt = connection.createStatement();
             stmt.execute(query);
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
