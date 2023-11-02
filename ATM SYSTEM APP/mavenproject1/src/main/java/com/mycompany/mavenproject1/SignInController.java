package com.mycompany.mavenproject1;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utilities.ConstantVariables;
import utilities.ConstatnMethods;

public class SignInController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private AnchorPane frame1, frame2, fingerFrame, pinFrame;

    @FXML
    private Button fingerStartBtn, sign_In_Btn, submitbtn, usePinBtn;

    @FXML
    private Label fingerText, fingerWhenStarted, sign_Up, pinText;

    @FXML
    private Pane imageFinger;

    @FXML
    private TextField inAccountNumber, inPin;
    ConstatnMethods constatnMethods;

    @FXML
    void initialize() {
        constatnMethods = new ConstatnMethods();
        asserts();
        onButtonPress();
    }

    void asserts() {
        assert fingerStartBtn != null : "fx:id=\"fingerStartBtn\" was not injected: check your FXML file 'signIn.fxml'.";
        assert fingerText != null : "fx:id=\"fingerText\" was not injected: check your FXML file 'signIn.fxml'.";
        assert fingerWhenStarted != null : "fx:id=\"fingerWhenStarted\" was not injected: check your FXML file 'signIn.fxml'.";
        assert imageFinger != null : "fx:id=\"imageFinger\" was not injected: check your FXML file 'signIn.fxml'.";
        assert inAccountNumber != null : "fx:id=\"inAccountNumber\" was not injected: check your FXML file 'signIn.fxml'.";
        assert sign_In_Btn != null : "fx:id=\"sign_In_Btn\" was not injected: check your FXML file 'signIn.fxml'.";
        assert sign_Up != null : "fx:id=\"sign_Up\" was not injected: check your FXML file 'signIn.fxml'.";
        assert submitbtn != null : "fx:id=\"submitbtn\" was not injected: check your FXML file 'signIn.fxml'.";
        assert frame1 != null : "fx:id=\"frame1\" was not injected: check your FXML file 'signIn.fxml'.";
        assert frame2 != null : "fx:id=\"frame2\" was not injected: check your FXML file 'signIn.fxml'.";
        assert usePinBtn != null : "fx:id=\"usePinBtn\" was not injected: check your FXML file 'signIn.fxml'.";
        assert fingerFrame != null : "fx:id=\"fingerFrame\" was not injected: check your FXML file 'signIn.fxml'.";
        assert pinFrame != null : "fx:id=\"pinFrame\" was not injected: check your FXML file 'signIn.fxml'.";
        assert inPin != null : "fx:id=\"inPin\" was not injected: check your FXML file 'signIn.fxml'.";
        assert fingerText != null : "fx:id=\"fingerText\" was not injected: check your FXML file 'signIn.fxml'.";

    }

    private void onButtonPress() {//when you press a button
        sign_In_Btn.setOnAction((event) -> {//@sign in button
            frame1.setVisible(false);

            frame2.setVisible(true);
        });
        sign_Up.setOnMouseClicked((event) -> {//@sign UP
            constatnMethods.PageLoaderShow(sign_In_Btn,ConstantVariables.FXML_SU);
        });
        fingerStartBtn.setOnAction((event) -> {
            fingerStartBtn.setVisible(false);
            imageFinger.setVisible(true);
            fingerText.setVisible(true);

        });
        usePinBtn.setOnAction((event) -> {
            fingerFrame.setVisible(false);
            pinFrame.setVisible(true);
        });
        submitbtn.setOnAction((event) -> {
            if (checkPin()) {
                constatnMethods.PageLoaderShow(sign_In_Btn,ConstantVariables.FXML_H);
            } else {
                pinText.setText("Enter valid pin");
            }
        });

    }
    private Boolean checkPin(){
        return true;
    }
    /*
    
     */

}
