/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package atmsystemjavafxa;

import database.DatabaseHandler;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import utilities.*;

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
    private Label fingerText, fingerWhenStarted, sign_Up, pinText, errorTag;

    @FXML
    private Pane imageFinger;

    @FXML
    private TextField inAccountNumber;
    @FXML
    private TextField inPinH;

    DatabaseHandler dbH;
    String nummmm;

    @FXML
    void initialize() {
        
        dbH = new DatabaseHandler();
        asserts();
        onButtonPress();
    }

    void asserts() {
        assert errorTag != null : "fx:id=\"ERROR\" was not injected: check your FXML file 'signIn.fxml'.";
        assert inPinH != null : "fx:id=\"inPinH\" was not injected: check your FXML file 'signIn.fxml'.";

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
        assert inPinH != null : "fx:id=\"inPin\" was not injected: check your FXML file 'signIn.fxml'.";
        assert fingerText != null : "fx:id=\"fingerText\" was not injected: check your FXML file 'signIn.fxml'.";

    }

    private void onButtonPress() {//when you press a button
        sign_In_Btn.setOnAction((event) -> {//@sign in button
            ConstantVariables.SU_ACCNUM = inAccountNumber.getText();
            frame1.setVisible(false);

            frame2.setVisible(true);
        });
        sign_Up.setOnMouseClicked((event) -> {
            //@sign UP
            PageLoaderShow(sign_In_Btn, ConstantVariables.FXML_SU);
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
             nummmm = inPinH.getText();
            int INPIN = Integer.parseInt(nummmm);
            try {
                String validation = dbH.validateSignIn(ConstantVariables.SU_ACCNUM, INPIN, pinText);

                if ("valid".equals(validation)) {
                    PageLoaderShow(sign_In_Btn, ConstantVariables.FXML_H);

                } else if ("xEmail".equals(validation)) {
                    PageLoaderShow(sign_In_Btn, ConstantVariables.FXML_SI);

                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        inPinH.setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Enter")) {
                // User pressed Enter, process the entered PIN
                nummmm = inPinH.getText();
                
            }
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

    /*
    
     */
}
