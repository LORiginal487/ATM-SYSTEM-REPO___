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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SignUpController {

    @FXML
    private ChoiceBox<String> gendersCB, monthsCB;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane cointanerPin;

    @FXML
    private TextField dayIn,emailIn, emailInC,nameIn, phoneNoIn,phoneNoInC,snameIn,yearIn;

    @FXML
    private Button fingerStartBtn,signInBck,signUpbtn,submitbtn;

    @FXML
    private Label fingerText, fingerWhenStarted;

    @FXML
    private AnchorPane formContainer;

    @FXML
    private Pane imageFinger;


    @FXML
    void initialize() {
        asserts();
        choiceBoxes();
        onButtonPress();
    }

    void asserts() {
        assert cointanerPin != null : "fx:id=\"cointanerPin\" was not injected: check your FXML file 'signUp.fxml'.";
        assert dayIn != null : "fx:id=\"dayIn\" was not injected: check your FXML file 'signUp.fxml'.";
        assert emailIn != null : "fx:id=\"emailIn\" was not injected: check your FXML file 'signUp.fxml'.";
        assert emailInC != null : "fx:id=\"emailInC\" was not injected: check your FXML file 'signUp.fxml'.";
        assert fingerStartBtn != null : "fx:id=\"fingerStartBtn\" was not injected: check your FXML file 'signUp.fxml'.";
        assert fingerText != null : "fx:id=\"fingerText\" was not injected: check your FXML file 'signUp.fxml'.";
        assert fingerWhenStarted != null : "fx:id=\"fingerWhenStarted\" was not injected: check your FXML file 'signUp.fxml'.";
        assert formContainer != null : "fx:id=\"formContainer\" was not injected: check your FXML file 'signUp.fxml'.";
        assert gendersCB != null : "fx:id=\"gendersCB\" was not injected: check your FXML file 'signUp.fxml'.";
        assert imageFinger != null : "fx:id=\"imageFinger\" was not injected: check your FXML file 'signUp.fxml'.";
        assert monthsCB != null : "fx:id=\"monthsCB\" was not injected: check your FXML file 'signUp.fxml'.";
        assert nameIn != null : "fx:id=\"nameIn\" was not injected: check your FXML file 'signUp.fxml'.";
        assert phoneNoIn != null : "fx:id=\"phoneNoIn\" was not injected: check your FXML file 'signUp.fxml'.";
        assert phoneNoInC != null : "fx:id=\"phoneNoInC\" was not injected: check your FXML file 'signUp.fxml'.";
        assert signInBck != null : "fx:id=\"signInBck\" was not injected: check your FXML file 'signUp.fxml'.";
        assert signUpbtn != null : "fx:id=\"signInBck1\" was not injected: check your FXML file 'signUp.fxml'.";
        assert snameIn != null : "fx:id=\"snameIn\" was not injected: check your FXML file 'signUp.fxml'.";
        assert submitbtn != null : "fx:id=\"submitbtn\" was not injected: check your FXML file 'signUp.fxml'.";
        assert yearIn != null : "fx:id=\"yearIn\" was not injected: check your FXML file 'signUp.fxml'.";
    }

    void choiceBoxes() {//this is for allowing the user to choose from choices in a choice box
        String[] genderPrf = {"Mr.", "Miss.", "Mrs."};
        gendersCB.getItems().addAll(genderPrf);
        String[] months = {"January", "February", "March", "April", "May", "June", "July",
             "August", "September", "October", "November", "December"};
        monthsCB.getItems().addAll(months);

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
        signUpbtn.setOnAction((event) -> {
            if (validateInfo()) {
                signUpbtn.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("HomeW-Menu.fxml"));
                try {
                    loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(HomeWMenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } 
        });
    }

    private boolean validateInfo() {
        return true;
    }

}
/*



 */
