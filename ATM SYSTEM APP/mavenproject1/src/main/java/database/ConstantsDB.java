/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;

/**
 *
 * @author User
 */
public class ConstantsDB {
    public final String DB_Host = "127.0.0.1";
    public final String DB_Port = "3306";
    public final String DB_Name = "ATM_users";
    public final String DB_User = "rootUser3306";
    public final String DB_Password = "UserATM3306";
    
}

/*
import java.sql.*;

public class DBHandler extends Config{
    Connection dbCon;
    private Connection con;
    PreparedStatement statement;
    private int userId;

    public Connection getDbCon() throws ClassNotFoundException, SQLException {
        String conString = "jdbc:mysql://" +dbHost+ ":" +dbPort+ "/" +dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbCon = DriverManager.getConnection(conString, dbUser, dbPass);

        return dbCon;
    }

    //Inserting data into the database
    public void writeToDB(String names, String user, String number, String mail, String pass) throws SQLException, ClassNotFoundException {
        String insertQuery = "INSERT INTO users(fullName, userName, phoneNumber, email, password)" +
                "VALUES(?,?,?,?,?)";

        statement = (PreparedStatement) getDbCon().prepareStatement(insertQuery);

        statement.setString(1, names);
        statement.setString(2, user);
        statement.setString(3, number);
        statement.setString(4, mail);
        statement.setString(5, pass);
        statement.executeUpdate();
    }

    public Boolean validUser(String username, String password)
    {
        String readSql = "SELECT * FROM users WHERE userName=\"" +username+ "\" AND password=\"" +password+ "\"";
        int count = 0;

        try
        {
            statement = getDbCon().prepareStatement(readSql);

            ResultSet set = statement.executeQuery();

            while (set.next())
            {
                count++;
                setUser(set.getInt("idUsers"));
            }

            if (count == 1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }

    }
*/