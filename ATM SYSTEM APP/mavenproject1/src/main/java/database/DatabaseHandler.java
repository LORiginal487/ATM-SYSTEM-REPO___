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
public class DatabaseHandler extends ConstantsDB{
    Connection dbCon;
    private Connection con;
    PreparedStatement statement;
    private int userId;

    public Connection getDbCon() throws ClassNotFoundException, SQLException {
        String conString = "jdbc:mysql://" +DB_Host+ ":" +DB_Port+ "/" +DB_Name;

        Class.forName("com.mysql.jdbc.Driver");

        dbCon = DriverManager.getConnection(conString, DB_User, DB_Password);

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
    
}
