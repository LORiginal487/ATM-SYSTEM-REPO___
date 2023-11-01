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
    PreparedStatement statement;
    

    public Connection getDbCon() throws ClassNotFoundException, SQLException {
        String conString = "jdbc:mysql://" +DB_Host+ ":" +DB_Port+ "/" +DB_Name;

        Class.forName("com.mysql.jdbc.Driver");

        dbCon = DriverManager.getConnection(conString, DB_User, DB_Password);

        return dbCon;
    }
    //Inserting data into the database
    public void signUpDBsaver(String id,String name, String surname,String dob, String email, String phone, int pin, String accnum, Double balance) throws SQLException, ClassNotFoundException {
        String insertQuery = "INSERT INTO "+DB_TB_Name+"("+TB_C_id+", "+TB_C_Name+", "+TB_C_Surname+
                ", "+TB_C_DOB+", "+TB_C_Email+", "+TB_C_Phone+", "+TB_C_Pin+", "+TB_C_Accnum+", "+TB_C_Balance+")" +
                "VALUES(?,?,?,?,?,?,?,?,?)";

        statement = (PreparedStatement) getDbCon().prepareStatement(insertQuery);

        statement.setString(1, id);
        statement.setString(2, name);
        statement.setString(3, surname);
        statement.setString(4, dob);
        statement.setString(5, email);
        statement.setString(6, phone);
        statement.setInt(7, pin);
        statement.setString(8, accnum);
        statement.setDouble(9, balance);
        statement.executeUpdate();
    }
    
}
