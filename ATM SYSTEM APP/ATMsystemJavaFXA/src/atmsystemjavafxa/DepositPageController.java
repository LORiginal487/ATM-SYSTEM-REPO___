/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package atmsystemjavafxa;

import database.DatabaseHandler;
import java.io.IOException;
import utilities.ConstantVariables;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import utilities.ConstatnMethods;

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
    Double inAmnt;

    DatabaseHandler databaseHandler;
    //ConstatnMethods constatnMethods;

    @FXML
    void initialize() throws ClassNotFoundException {
        //constatnMethods = new ConstatnMethods();
        databaseHandler = new DatabaseHandler();
        whileOnFrame1();
        whileOnFrame2();
        whileOnFrame3();
        OnButtonPress();
        asserts();
    }

    private void whileOnFrame1() throws ClassNotFoundException {
        userAccNumDis.setText(ConstantVariables.SU_ACCNUM);
        amntDis1.setText("R " + databaseHandler.getAvailAmntDb(ConstantVariables.SU_ACCNUM).toString());
        depositDoneBtn.setOnAction((event) -> {
            if (validateAmount()) {
                
                try {
                    databaseHandler.depositIntDb(inAmnt);
                    depositFrame1.setVisible(false);
                    depositFrame2.setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DepositPageController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(DepositPageController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    private void whileOnFrame2() {
        noSlip.setOnAction((event) -> {
            PageLoaderShow(backBtn, ConstantVariables.FXML_H);
        });
        yesSlip.setOnAction((event) -> {
            depositFrame2.setVisible(false);
            depositFrame3.setVisible(true);
        });
    }

    private void whileOnFrame3() throws ClassNotFoundException {
        slip.setText("DEPOSIT RECEIPT\n"
                + "\n ACCOUNT HOLDER"
                + "\n ______________"
                + "\n FULL NAMES:"
                + "\n -" + ConstantVariables.SU_NAME+" "+ ConstantVariables.SU_SURNAME
                + "\n ACCOUNT NUMBER:"
                + "\n -" + ConstantVariables.SU_ACCNUM
                + "\n AMOUNT DEPOSITED:"
                + "\n -R " + inAmnt
                + "\n AVAILABE AMOUNT:"
                + "\n -R " + databaseHandler.getAvailAmntDb(ConstantVariables.SU_ACCNUM)
                + "\n ______________"
                + "\n THANK YOU");
        signInBck11.setOnAction((event) -> {
            PageLoaderShow(backBtn, ConstantVariables.FXML_H);
        });
    }

    private void OnButtonPress() {
        backBtn.setOnAction((event) -> {
            PageLoaderShow(backBtn, ConstantVariables.FXML_H);
        });
        signInBck.setOnAction((event) -> {
            PageLoaderShow(backBtn, ConstantVariables.FXML_SI);
        });
    }

    private boolean validateAmount() {
        boolean checker = true;
        if (inAmount.getText().isEmpty()) {
            checker = false;
            errorMssgDis.setText("Enter Amount");
            errorMssgDis.setTextFill(Paint.valueOf("#FF0000"));
        }else{
            inAmnt = Double.valueOf(inAmount.getText());
        }
        for (int i = 0; i < inAmount.getText().length(); i++) {
            char ch = inAmount.getText().charAt(i);
            if (Character.isLetter(ch) && ch != '.') {
                checker = false;
                errorMssgDis.setText("InValid Amount");
                errorMssgDis.setTextFill(Paint.valueOf("#FF0000"));
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
