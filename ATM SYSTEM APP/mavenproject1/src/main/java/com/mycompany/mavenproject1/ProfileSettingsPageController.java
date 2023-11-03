/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import database.DatabaseHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import utilities.ConstantVariables;

public class ProfileSettingsPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label TOP_TEXT2;

    @FXML
    private Label TOP_TEXT21;

    @FXML
    private Label TOP_TEXT211;

    @FXML
    private Label TOP_TEXT2111;

    @FXML
    private Button backBtn;

    @FXML
    private ImageView backPic;

    @FXML
    private Button cANCELbtn1;

    @FXML
    private AnchorPane depositFrame1;

    @FXML
    private Label emailDis;

    @FXML
    private Label errorMssgDis;

    @FXML
    private Label headingText;

    @FXML
    private TextField inEMAIL;

    @FXML
    private TextField inNAME;

    @FXML
    private TextField inPHONE;

    @FXML
    private TextField inSURNAME;

    @FXML
    private Label nameDis;

    @FXML
    private Label phoneDis;

    @FXML
    private Button signInBck;

    @FXML
    private Label surnameDis;

    @FXML
    private Button tDoneBtn;

    @FXML
    private Label userAccNumDis;
    DatabaseHandler databaseH;

    @FXML
    void initialize() {
        databaseH = new DatabaseHandler();
        asserts();
        disPlayAndClick();
        tDoneBtn.setOnAction((event) -> {
            onDoneClick();
        });
        
        cANCELbtn1.setOnAction((event) -> {
            onCancelClick();
        });
    }
    private void asserts(){
        assert TOP_TEXT2 != null : "fx:id=\"TOP_TEXT2\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";
        assert TOP_TEXT21 != null : "fx:id=\"TOP_TEXT21\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";
        assert TOP_TEXT211 != null : "fx:id=\"TOP_TEXT211\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";
        assert TOP_TEXT2111 != null : "fx:id=\"TOP_TEXT2111\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";
        assert backBtn != null : "fx:id=\"backBtn\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";
        assert backPic != null : "fx:id=\"backPic\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";
        assert cANCELbtn1 != null : "fx:id=\"cANCELbtn1\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";
        assert depositFrame1 != null : "fx:id=\"depositFrame1\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";
        assert emailDis != null : "fx:id=\"emailDis\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";
        assert errorMssgDis != null : "fx:id=\"errorMssgDis\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";
        assert headingText != null : "fx:id=\"headingText\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";
        assert inEMAIL != null : "fx:id=\"inEMAIL\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";
        assert inNAME != null : "fx:id=\"inNAME\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";
        assert inPHONE != null : "fx:id=\"inPHONE\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";
        assert inSURNAME != null : "fx:id=\"inSURNAME\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";
        assert nameDis != null : "fx:id=\"nameDis\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";
        assert phoneDis != null : "fx:id=\"phoneDis\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";
        assert signInBck != null : "fx:id=\"signInBck\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";
        assert surnameDis != null : "fx:id=\"surnameDis\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";
        assert tDoneBtn != null : "fx:id=\"tDoneBtn\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";
        assert userAccNumDis != null : "fx:id=\"userAccNumDis\" was not injected: check your FXML file 'ProfileSettingsPage.fxml'.";

    }
    private void disPlayAndClick(){
        nameDis.setText(ConstantVariables.SU_NAME);
        onEditClick(nameDis, inNAME);
        surnameDis.setText(ConstantVariables.SU_SURNAME);
        onEditClick(surnameDis, inEMAIL);
        emailDis.setText(ConstantVariables.SU_EMAIL);
        onEditClick(emailDis, inSURNAME);
        phoneDis.setText(ConstantVariables.SU_PHONE);
        onEditClick(phoneDis, inPHONE);
        
    }
    private void onEditClick(Label text, TextField editorV){
        text.setOnMouseClicked((event) -> {
            editorV.setVisible(true);
        });
    }
    private void onDoneClick(){
       String watcher1 = "";
        if(inNAME.isVisible()&& !inNAME.getText().isEmpty()){
            databaseH.changeNameDb(inNAME.getText());
            watcher1 = watcher1+"Name";
            errorMssgDis.setText(watcher1 + " changed");
        }
        if(inEMAIL.isVisible()&& !inEMAIL.getText().isEmpty()){
            databaseH.changeSurnameDb(inEMAIL.getText());
            watcher1 = watcher1+"Email";
            errorMssgDis.setText(watcher1 + " changed");
        }
        if(inSURNAME.isVisible()&& !inSURNAME.getText().isEmpty()){
            databaseH.changeEmailDb(inSURNAME.getText());
            watcher1 = watcher1+"SURNAME";
            errorMssgDis.setText(watcher1 + " changed");
        }
        if(inPHONE.isVisible()&& !inPHONE.getText().isEmpty()){
            databaseH.changePhoneDb(inPHONE.getText());
            watcher1 = watcher1+"PHONE";
            errorMssgDis.setText(watcher1 + " changed");
        }
    }
     private void onCancelClick(){
         
         if(inNAME.isVisible()){
             inNAME.setVisible(true);
        }
        if(inEMAIL.isVisible()){
            inEMAIL.setVisible(true);
        }
        if(inSURNAME.isVisible()){
            inSURNAME.setVisible(true);
        }
        if(inPHONE.isVisible()){
            inPHONE.setVisible(true);
        }
     }

}

