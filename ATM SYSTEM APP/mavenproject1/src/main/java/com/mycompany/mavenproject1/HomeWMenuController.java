/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utilities.ConstantVariables;

public class HomeWMenuController {
    
    @FXML
    private ResourceBundle resources;
    
    @FXML
    private URL location;
    Image  image2, image3, image4, image5, image6;
    @FXML
    private ImageView cbImg, dImg, wImg, tImg, psImg;

    
    @FXML
    private Label TOP_TEXT, TOP_TEXT1, TOP_TEXT2, TOP_TEXT21, TOP_TEXT211, TOP_TEXT2111, TOP_TEXT21111, accntnumDis;
    
    @FXML
    private AnchorPane chckBalanceBar, depositBar;
    
    @FXML
    private Label emailDis;
    
    @FXML
    private AnchorPane formContainer;
    
    @FXML
    private Label headingText, nameDis, nameDis1, nameDis11, nameDis12, nameDis13, phoneDis;
    
    @FXML
    private Button profileSettingsBtn, signInBck;
    
    @FXML
    private Label surnameDis;
    
    @FXML
    private AnchorPane transactBar, withdrawBar;
    
    @FXML
    void initialize() {
        asserts();
        displayDetails();
        onButtonPress();
    }

    void asserts() {
        assert TOP_TEXT != null : "fx:id=\"TOP_TEXT\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert TOP_TEXT1 != null : "fx:id=\"TOP_TEXT1\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert TOP_TEXT2 != null : "fx:id=\"TOP_TEXT2\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert TOP_TEXT21 != null : "fx:id=\"TOP_TEXT21\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert TOP_TEXT211 != null : "fx:id=\"TOP_TEXT211\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert TOP_TEXT2111 != null : "fx:id=\"TOP_TEXT2111\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert TOP_TEXT21111 != null : "fx:id=\"TOP_TEXT21111\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert accntnumDis != null : "fx:id=\"accntnumDis\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert chckBalanceBar != null : "fx:id=\"chckBalanceBar\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert depositBar != null : "fx:id=\"depositBar\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert emailDis != null : "fx:id=\"emailDis\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert formContainer != null : "fx:id=\"formContainer\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert headingText != null : "fx:id=\"headingText\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert nameDis != null : "fx:id=\"nameDis\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert nameDis1 != null : "fx:id=\"nameDis1\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert nameDis11 != null : "fx:id=\"nameDis11\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert nameDis12 != null : "fx:id=\"nameDis12\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert nameDis13 != null : "fx:id=\"nameDis13\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert phoneDis != null : "fx:id=\"phoneDis\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert profileSettingsBtn != null : "fx:id=\"profileSettingsBtn\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert signInBck != null : "fx:id=\"signInBck\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert surnameDis != null : "fx:id=\"surnameDis\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert transactBar != null : "fx:id=\"transactBar\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        assert withdrawBar != null : "fx:id=\"withdrawBar\" was not injected: check your FXML file 'HomeW-Menu.fxml'.";
        
    }

    private void onButtonPress() {//when you press a button
        signInBck.setOnAction((event) -> {
            signInBck.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("signIn.fxml"));
            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(HomeWMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        
    }

    private void displayDetails() {
        nameDis.setText(ConstantVariables.SU_NAME);
        surnameDis.setText(ConstantVariables.SU_SURNAME);
        emailDis.setText(ConstantVariables.SU_EMAIL);
        phoneDis.setText(ConstantVariables.SU_PHONE);
        accntnumDis.setText(ConstantVariables.SU_ACCNUM);
    }

    private void setImages() {
        
    }
}


