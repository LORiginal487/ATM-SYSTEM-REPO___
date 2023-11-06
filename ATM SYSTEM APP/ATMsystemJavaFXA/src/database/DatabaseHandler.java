/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;
import utilities.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Logger;
import javafx.scene.control.Label;

/**
 *
 * @author User
 */
public class DatabaseHandler extends ConstantsDB {

    Connection dbCon;
    PreparedStatement statement;

    public DatabaseHandler() {
    }

    public Connection getDbCon() throws ClassNotFoundException, SQLException {
        String urlDb = "jdbc:mysql://" + DB_Host + ":" + DB_Port + "/" + DB_Name;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbCon = DriverManager.getConnection(urlDb, DB_User, DB_Password);

        System.out.println("conneted");
        return dbCon;

    }

    //Inserting data into the database
    public void signUpDBsaver(String name, String surname, String dob, String email, String phone, int pin, String accnum, Double balance) throws SQLException, ClassNotFoundException {
        String insertQuery = "INSERT INTO " + DB_TB_Name + "(" + TB_C_Name + ", " + TB_C_Surname
                + ", " + TB_C_DOB + ", " + TB_C_Email + ", " + TB_C_Phone + ", " + TB_C_Pin + ", " + TB_C_Accnum + ", " + TB_C_Balance + ")"
                + "VALUES(?,?,?,?,?,?,?,?)";
        //String insertQuery = "INSERT INTO `atm_schema`.`atm_users` (`id`, `name`, `surname`, `dob`, `email`, `phone`, `pin`, `account_num`, `balance`) VALUES ('23456', 'lkk', 'yui', '02/03/2005', 'lkjhgjk@gmail.com', '01789654231', '12345', '01010101', '500246.35')";

        statement = (PreparedStatement) getDbCon().prepareStatement(insertQuery);

        statement.setString(1, name);
        statement.setString(2, surname);
        statement.setString(3, dob);
        statement.setString(4, email);
        statement.setString(5, phone);
        statement.setInt(6, pin);
        statement.setString(7, accnum);
        statement.setDouble(8, balance);
        statement.executeUpdate();
    }

    public String validateSignIn(String accNUM, int pin, Label error) throws ClassNotFoundException, SQLException {
        String Query = "SELECT " + TB_C_Pin + " FROM " + DB_TB_Name + " WHERE " + TB_C_Accnum + " = " + accNUM;

        statement = (PreparedStatement) getDbCon().prepareStatement(Query);
        ResultSet rs = statement.executeQuery(Query);
        if (rs.next() != false) {
            int result = rs.getInt(TB_C_Pin);
            if (pin == result) {
                ConstantVariables.SU_ACCNUM = accNUM;
                setUserDetails();
                return "valid";

            } else {
                error.setText("INVALID pin");
                return "xPin";
            }
        } else {
            error.setText("INVALID email");
            return "xEmail";
        }

    }

    public void getUserDetails(Double ammountIn) {//method for adding deposited amount into available amount

    }

    public void depositIntDb(Double ammountIn) throws ClassNotFoundException, SQLException {//method for adding deposited amount into available amount
        Double userbalance = ConstantVariables.SU_BALANCE + ammountIn;
        updateBalance(ConstantVariables.SU_ACCNUM, ammountIn);
    }

    public Double getAvailAmntDb(String accnum) throws ClassNotFoundException {//method for getting available amount
        String Query = "SELECT " +TB_C_Balance+ " FROM " + DB_TB_Name + " WHERE " + TB_C_Accnum + " = ?";
        try (PreparedStatement preparedStatement = getDbCon().prepareStatement(Query)) {
            preparedStatement.setString(1, accnum); // Set the parameter for the WHERE clause
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    if(accnum.equals(ConstantVariables.SU_ACCNUM)){
                    ConstantVariables.SU_BALANCE =rs.getDouble(TB_C_Balance);
                    }
                    return rs.getDouble(TB_C_Balance);
                } else {
                    // Handle the case where no matching record was found
                    return 0.0;
                }
            }
        } catch (SQLException e) {
            // Handle any database-related exceptions here
            return 0.0;
        }
        
    }

    public String getAccntNumDb() {//method for getting account number
        return "";
    }

    public String getUserNameDb() {//method for getting user name
        return "";
    }

    public void withdrawFromDb(Double ammountIn) throws ClassNotFoundException, SQLException {//method for subtracting withdrawn amount from available amount
        Double userbalance = ConstantVariables.SU_BALANCE - ammountIn;
        updateBalance(ConstantVariables.SU_ACCNUM, ammountIn);
    }

    public boolean look4accnInDb(String accntIn) {//method for subtracting withdrawn amount from available amount
        return true;
    }

    public void transferDb(Double ammountIn, String accntIn) throws ClassNotFoundException, SQLException {//method for getting user name
        Double reNbalance = getAvailAmntDb(accntIn) + ammountIn;
        Double userbalance = ConstantVariables.SU_BALANCE - ammountIn;
        updateBalance(accntIn, reNbalance);
        updateBalance(ConstantVariables.SU_ACCNUM, userbalance);
    }

    public void changeNameDb(String name) {//method for getting user name

    }

    public void changeSurnameDb(String Surname) {//method for getting user name

    }

    public void changeEmailDb(String Email) {//method for getting user name

    }

    public void changePhoneDb(String Phone) {//method for getting user name

    }

    public void setUserDetails() throws ClassNotFoundException, SQLException {
        String Query = "SELECT " + TB_C_Name + ", " + TB_C_Surname + ", " + TB_C_Email + ", " + TB_C_Phone + ", " + TB_C_Balance
                + " FROM " + DB_TB_Name + " WHERE " + TB_C_Accnum + " = ?";
        try (PreparedStatement preparedStatement = getDbCon().prepareStatement(Query)) {
            preparedStatement.setString(1, ConstantVariables.SU_ACCNUM); // Set the parameter for the WHERE clause
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    ConstantVariables.SU_NAME = rs.getString(TB_C_Name);
                    ConstantVariables.SU_SURNAME = rs.getString(TB_C_Surname);
                    ConstantVariables.SU_EMAIL = rs.getString(TB_C_Email);
                    ConstantVariables.SU_PHONE = rs.getString(TB_C_Phone);
                    ConstantVariables.SU_BALANCE = rs.getDouble(TB_C_Balance);
                } else {
                    // Handle the case where no matching record was found
                }
            }
        } catch (SQLException e) {
            // Handle any database-related exceptions here
        }
    }
    public void updateBalance(String accnt, Double aMNT) throws ClassNotFoundException, SQLException {
                String Query = "UPDATE " +DB_TB_Name+ " SET "+  TB_C_Balance +" = ? WHERE " + TB_C_Accnum + " = ?";
                statement = (PreparedStatement) getDbCon().prepareStatement(Query);
                statement.setDouble(1, aMNT);
                statement.setString(2, accnt);
    }

}
