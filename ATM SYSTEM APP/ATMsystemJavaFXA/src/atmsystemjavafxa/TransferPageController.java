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
import utilities.ConstantVariables;

public class TransferPageController {

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
    private TextField inACCNT;

    @FXML
    private TextField inAMNT;

    @FXML
    private Button menu;

    @FXML
    private Button noSlip;

    @FXML
    private Button signInBck;

    @FXML
    private Label slip;

    @FXML
    private Button tDoneBtn;

    @FXML
    private Label userAccNumDis;

    @FXML
    private Label userAccNumDis1;

    @FXML
    private Label userAccNumDis11;

    @FXML
    private Button yesSlip;
    DatabaseHandler databaseHandler;
    Double inAmnt;
    String accountReceiver;

    @FXML
    void initialize() throws ClassNotFoundException {
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
        tDoneBtn.setOnAction((event) -> {
            try {
                if (validateAmount()) {
                    accountReceiver = inACCNT.getText();
                    try {
                        databaseHandler.transferDb(inAmnt, accountReceiver);
                        depositFrame1.setVisible(false);
                        depositFrame2.setVisible(true);
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(TransferPageController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TransferPageController.class.getName()).log(Level.SEVERE, null, ex);
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
        slip.setText(slip.getText()+"\n"
                + "\n ACCOUNT HOLDER"
                + "\n ______________"
                + "\n FULL NAMES:"
                + "\n -" + ConstantVariables.SU_NAME+" "+ ConstantVariables.SU_SURNAME
                + "\n ACCOUNT NUMBER:"
                + "\n -" + ConstantVariables.SU_ACCNUM
                + "\n AMOUNT TRANSFERED:"
                + "\n -R " + inAmnt
                + "\n AVAILABE AMOUNT:"
                + "\n -R " + databaseHandler.getAvailAmntDb(ConstantVariables.SU_ACCNUM)
                + "\n TO ACCOUNT NUMBER:"
                + "\n -" + inACCNT
                + "\n ______________"
                + "\n THANK YOU");
        menu.setOnAction((event) -> {
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

    private boolean validateToAccountNum() {
        boolean checker = true;
        if (inACCNT.getText().isEmpty()) {
            checker = false;
            errorMssgDis.setText("Enter Account");
            errorMssgDis.setTextFill(Paint.valueOf("#FF0000"));
        }
        for (int i = 0; i < inACCNT.getText().length(); i++) {
            char ch = inACCNT.getText().charAt(i);
            if (Character.isLetter(ch) && ch != '.') {
                checker = false;
                errorMssgDis.setText("InValid Account");
                errorMssgDis.setTextFill(Paint.valueOf("#FF0000"));
            }

        }
        if (!databaseHandler.look4accnInDb(inACCNT.getText())) {
            checker = false;
            errorMssgDis.setText("InValid Account");
            errorMssgDis.setTextFill(Paint.valueOf("#FF0000"));
        }
        return checker;
    }

    private boolean validateAmount() throws ClassNotFoundException {

        if (validateToAccountNum()) {
            boolean checker = true;
            if (inAMNT.getText().isEmpty()) {
                checker = false;
                errorMssgDis.setText("Enter Amount");
                errorMssgDis.setTextFill(Paint.valueOf("#FF0000"));
            }
            for (int i = 0; i < inAMNT.getText().length(); i++) {
                char ch = inAMNT.getText().charAt(i);
                if (Character.isLetter(ch) && ch != '.') {
                    checker = false;
                    errorMssgDis.setText("InValid Amount");
                    errorMssgDis.setTextFill(Paint.valueOf("#FF0000"));
                }

            }
            inAmnt = Double.valueOf(inAMNT.getText());
            if (inAmnt > databaseHandler.getAvailAmntDb(ConstantVariables.SU_ACCNUM)) {
                checker = false;

                errorMssgDis.setText("Insufficient funds, You broke");
                errorMssgDis.setTextFill(Paint.valueOf("#FF0000"));
            }
            return checker;
        } else {
            return validateToAccountNum();
        }

    }

    void asserts() {
        assert amntDis1 != null : "fx:id=\"amntDis1\" was not injected: check your FXML file 'TransferPage.fxml'.";
        assert backBtn != null : "fx:id=\"backBtn\" was not injected: check your FXML file 'TransferPage.fxml'.";
        assert backPic != null : "fx:id=\"backPic\" was not injected: check your FXML file 'TransferPage.fxml'.";
        assert depositFrame1 != null : "fx:id=\"depositFrame1\" was not injected: check your FXML file 'TransferPage.fxml'.";
        assert depositFrame2 != null : "fx:id=\"depositFrame2\" was not injected: check your FXML file 'TransferPage.fxml'.";
        assert depositFrame3 != null : "fx:id=\"depositFrame3\" was not injected: check your FXML file 'TransferPage.fxml'.";
        assert errorMssgDis != null : "fx:id=\"errorMssgDis\" was not injected: check your FXML file 'TransferPage.fxml'.";
        assert headingText != null : "fx:id=\"headingText\" was not injected: check your FXML file 'TransferPage.fxml'.";
        assert inACCNT != null : "fx:id=\"inACCNT\" was not injected: check your FXML file 'TransferPage.fxml'.";
        assert inAMNT != null : "fx:id=\"inAMNT\" was not injected: check your FXML file 'TransferPage.fxml'.";
        assert menu != null : "fx:id=\"menu\" was not injected: check your FXML file 'TransferPage.fxml'.";
        assert noSlip != null : "fx:id=\"noSlip\" was not injected: check your FXML file 'TransferPage.fxml'.";
        assert signInBck != null : "fx:id=\"signInBck\" was not injected: check your FXML file 'TransferPage.fxml'.";
        assert slip != null : "fx:id=\"slip\" was not injected: check your FXML file 'TransferPage.fxml'.";
        assert tDoneBtn != null : "fx:id=\"tDoneBtn\" was not injected: check your FXML file 'TransferPage.fxml'.";
        assert userAccNumDis != null : "fx:id=\"userAccNumDis\" was not injected: check your FXML file 'TransferPage.fxml'.";
        assert userAccNumDis1 != null : "fx:id=\"userAccNumDis1\" was not injected: check your FXML file 'TransferPage.fxml'.";
        assert userAccNumDis11 != null : "fx:id=\"userAccNumDis11\" was not injected: check your FXML file 'TransferPage.fxml'.";
        assert yesSlip != null : "fx:id=\"yesSlip\" was not injected: check your FXML file 'TransferPage.fxml'.";

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
