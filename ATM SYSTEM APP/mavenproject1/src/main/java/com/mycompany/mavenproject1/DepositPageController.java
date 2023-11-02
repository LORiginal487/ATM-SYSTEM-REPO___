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

public class DepositPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label amntDis1;

    @FXML
    private Button backBtn;

    @FXML
    private ImageView backPic;

    @FXML
    private AnchorPane depositFrame1;

    @FXML
    private AnchorPane depositFrame2;

    @FXML
    private AnchorPane depositFrame3;

    @FXML
    private Label errorMssgDis;

    @FXML
    private Label headingText;

    @FXML
    private TextField inAmount;

    @FXML
    private Button noSlip;

    @FXML
    private Button signInBck, depositDoneBtn, signInBck11;

    @FXML
    private Label userAccNumDis, userAccNumDis1, slip;

    @FXML
    private Button yesSlip;
    
    DatabaseHandler databaseHandler;

    @FXML
    void initialize() {
        databaseHandler = new DatabaseHandler();
        asserts();
    }
    private void whileOnFrame1(){
        userAccNumDis.setText(databaseHandler.getAccntNumDb());
        amntDis1.setText(databaseHandler.getAvailAmntDb().toString());
        depositDoneBtn.setOnAction((event) -> {
            if(validateAmount()){
                databaseHandler.depositIntDb(Double.parseDouble(inAmount.getText()));
                depositFrame1.setVisible(false);
                depositFrame2.setVisible(true);
            }
        });
    }
    private void whileOnFrame2(){
        noSlip.setOnAction((event) -> {
            
        });
    }
    private void whileOnFrame3(){
        slip.setText("DEPOSIT RECEIPT\n"
                + "\n ACCOUNT HOLDER"
                + "\n ______________"
                + "\n FULL NAMES:"
                + "\n --------"
                + "\n ACCOUNT NUMBER:"
                + "\n --------"
                + "\n AMOUNT DEPOSITED:"
                + "\n --------"
                + "\n AVAILABE AMOUNT:"
                + "\n --------"
                + "\n ______________"
                + "\n THANK YOU");
    }
    private void OnButtonPress(Button button, String fxmlPage){
        
    }
    private boolean validateAmount(){
        boolean checker = true;
        if(inAmount.getText().isEmpty()){
            checker=false;
                errorMssgDis.setText("Enter Amount");
        }
        for(int i=0; i < inAmount.getText().length(); i++){
            char ch = inAmount.getText().charAt(i);
            if(Character.isLetter(ch) && ch != '.'){
                checker=false;
                errorMssgDis.setText("InValid Amount");
            }
            
        }
        return checker;
            
    }
    

    void asserts() {
        assert amntDis1 != null : "fx:id=\"amntDis1\" was not injected: check your FXML file 'DepositPage.fxml'.";
        assert backBtn != null : "fx:id=\"backBtn\" was not injected: check your FXML file 'DepositPage.fxml'.";
        assert backPic != null : "fx:id=\"backPic\" was not injected: check your FXML file 'DepositPage.fxml'.";
        assert depositFrame1 != null : "fx:id=\"depositFrame1\" was not injected: check your FXML file 'DepositPage.fxml'.";
        assert depositFrame2 != null : "fx:id=\"depositFrame2\" was not injected: check your FXML file 'DepositPage.fxml'.";
        assert depositFrame3 != null : "fx:id=\"depositFrame21\" was not injected: check your FXML file 'DepositPage.fxml'.";
        assert errorMssgDis != null : "fx:id=\"errorMssgDis\" was not injected: check your FXML file 'DepositPage.fxml'.";
        assert headingText != null : "fx:id=\"headingText\" was not injected: check your FXML file 'DepositPage.fxml'.";
        assert inAmount != null : "fx:id=\"inAmount\" was not injected: check your FXML file 'DepositPage.fxml'.";
        assert noSlip != null : "fx:id=\"noSlip\" was not injected: check your FXML file 'DepositPage.fxml'.";
        assert signInBck != null : "fx:id=\"signInBck\" was not injected: check your FXML file 'DepositPage.fxml'.";
        assert depositDoneBtn != null : "fx:id=\"signInBck1\" was not injected: check your FXML file 'DepositPage.fxml'.";
        assert signInBck11 != null : "fx:id=\"signInBck11\" was not injected: check your FXML file 'DepositPage.fxml'.";
        assert userAccNumDis != null : "fx:id=\"userAccNumDis\" was not injected: check your FXML file 'DepositPage.fxml'.";
        assert userAccNumDis1 != null : "fx:id=\"userAccNumDis1\" was not injected: check your FXML file 'DepositPage.fxml'.";
        assert slip != null : "fx:id=\"userAccNumDis11\" was not injected: check your FXML file 'DepositPage.fxml'.";
        assert yesSlip != null : "fx:id=\"yesSlip\" was not injected: check your FXML file 'DepositPage.fxml'.";

    }

}
