/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;
import sun.rmi.runtime.Log;

/**
 *
 * @author User
 */
public class DatabaseHandler extends ConstantsDB{
    Connection dbCon;
    PreparedStatement statement;

    public DatabaseHandler() {
    }
    
    
    public Connection getDbCon() throws ClassNotFoundException, SQLException {
        String conString = "jdbc:mysql://" +DB_Host+ ":" +DB_Port+ "/" +DB_Name;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbCon = DriverManager.getConnection(urlDb, DB_User, DB_Password);
        
        return dbCon;
        
    }
    //Inserting data into the database
    public void signUpDBsaver(String id,String name, String surname,String dob, String email, String phone, int pin, String accnum, Double balance) throws SQLException, ClassNotFoundException {
        String insertQuery = "INSERT INTO "+DB_TB_Name+"("+TB_C_id+", "+TB_C_Name+", "+TB_C_Surname+
                ", "+TB_C_DOB+", "+TB_C_Email+", "+TB_C_Phone+", "+TB_C_Pin+", "+TB_C_Accnum+", "+TB_C_Balance+")" +
                "VALUES(?,?,?,?,?,?,?,?,?)";
        //String insertQuery = "INSERT INTO `atm_schema`.`atm_users` (`id`, `name`, `surname`, `dob`, `email`, `phone`, `pin`, `account_num`, `balance`) VALUES ('23456', 'lkk', 'yui', '02/03/2005', 'lkjhgjk@gmail.com', '01789654231', '12345', '01010101', '500246.35')";

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
    public void getUserDetails(Double ammountIn){//method for adding deposited amount into available amount
        
    }
    public void depositIntDb(Double ammountIn){//method for adding deposited amount into available amount
        
    }
    public Double getAvailAmntDb(){//method for getting available amount
        return 0.0;
    }
    public String getAccntNumDb(){//method for getting account number
        return "";
    }
    public String getUserNameDb(){//method for getting user name
        return "";
    }
    public void withdrawFromDb(Double ammountIn){//method for subtracting withdrawn amount from available amount
        
    }
    public boolean look4accnInDb(String accntIn){//method for subtracting withdrawn amount from available amount
        return true;
    }
    public void transferDb(Double ammountIn, String accntIn){//method for getting user name
        
    }
    public void changeNameDb(String name){//method for getting user name
        
    }
    public void changeSurnameDb(String Surname){//method for getting user name
        
    }
    public void changeEmailDb(String Email){//method for getting user name
        
    }
    public void changePhoneDb(String Phone){//method for getting user name
        
    }
    
}
