/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import database.DatabaseHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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

public class CheckBalancePageController {

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
    private Label errorMssgDis;

    @FXML
    private Label headingText;

    @FXML
    private Button signInBck;

    @FXML
    private Label userAccNumDis;
        DatabaseHandler databaseHandler;

    @FXML
    void initialize() {

        databaseHandler = new DatabaseHandler();
        displayDetails();
        asserts();

    }
    private void displayDetails() {
        amntDis1.setText("R "+databaseHandler.getAvailAmntDb().toString());
        userAccNumDis.setText(databaseHandler.getAccntNumDb());
    }

    private void asserts() {
        assert amntDis1 != null : "fx:id=\"amntDis1\" was not injected: check your FXML file 'CheckBalancePage.fxml'.";
        assert backBtn != null : "fx:id=\"backBtn\" was not injected: check your FXML file 'CheckBalancePage.fxml'.";
        assert backPic != null : "fx:id=\"backPic\" was not injected: check your FXML file 'CheckBalancePage.fxml'.";
        assert depositFrame1 != null : "fx:id=\"depositFrame1\" was not injected: check your FXML file 'CheckBalancePage.fxml'.";
        assert errorMssgDis != null : "fx:id=\"errorMssgDis\" was not injected: check your FXML file 'CheckBalancePage.fxml'.";
        assert headingText != null : "fx:id=\"headingText\" was not injected: check your FXML file 'CheckBalancePage.fxml'.";
        assert signInBck != null : "fx:id=\"signInBck\" was not injected: check your FXML file 'CheckBalancePage.fxml'.";
        assert userAccNumDis != null : "fx:id=\"userAccNumDis\" was not injected: check your FXML file 'CheckBalancePage.fxml'.";
    }

    private void OnButtonPress() {
        backBtn.setOnAction((event) -> {
            PageLoaderShow(backBtn, ConstantVariables.FXML_H);
        });
        signInBck.setOnAction((event) -> {
            PageLoaderShow(backBtn, ConstantVariables.FXML_SI);
        });
    }

    public void PageLoaderShow(Button button, String fxmlName) {
        button.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlName));
        try {
            loader.load();
        } catch (IOException ex) {
            System.out.println("cant open\n" + ex);
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    

}
