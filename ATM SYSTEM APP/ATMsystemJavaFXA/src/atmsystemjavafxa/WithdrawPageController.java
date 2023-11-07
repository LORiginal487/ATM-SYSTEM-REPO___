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

public class WithdrawPageController {

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
    private AnchorPane depositFrame1, depositFrame2, depositFrame3;

    @FXML
    private Label errorMssgDis, headingText;

    @FXML
    private TextField inAmount;

    @FXML
    private Button menu, noSlip, signInBck;

    @FXML
    private Label slip, userAccNumDis, userAccNumDis1, userAccNumDis11;

    @FXML
    private Button wDoneBtn;

    @FXML
    private Button yesSlip;
    DatabaseHandler databaseHandler;
    Double inAmnt;

    @FXML
    void initialize() throws ClassNotFoundException {
        databaseHandler = new DatabaseHandler();
        whileOnFrame1();

        OnButtonPress();
        asserts();
    }

    private void whileOnFrame1() throws ClassNotFoundException {
        userAccNumDis.setText(ConstantVariables.SU_ACCNUM);
        amntDis1.setText("R " + databaseHandler.getAvailAmntDb(ConstantVariables.SU_ACCNUM));
        wDoneBtn.setOnAction((event) -> {
            if (validateAmount()) {
                try {
                    ConstantVariables.W_amount_In = Double.valueOf(inAmount.getText());
                    if (ConstantVariables.W_amount_In > databaseHandler.getAvailAmntDb(ConstantVariables.SU_ACCNUM)) {
                        try {
                            databaseHandler.withdrawFromDb(ConstantVariables.W_amount_In);
                            depositFrame1.setVisible(false);
                            depositFrame2.setVisible(true);
                            whileOnFrame2();

                        } catch (ClassNotFoundException | SQLException ex) {
                            Logger.getLogger(WithdrawPageController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        errorMssgDis.setText("Insufficient amount, You broke!");
                        errorMssgDis.setTextFill(Paint.valueOf("#FF0000"));
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(WithdrawPageController.class.getName()).log(Level.SEVERE, null, ex);
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
            try {
                whileOnFrame3();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(WithdrawPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private void whileOnFrame3() throws ClassNotFoundException {
        slip.setText("WITHDRAWAL RECEIPT\n"
                + "\n ACCOUNT HOLDER"
                + "\n ______________"
                + "\n FULL NAMES:"
                + "\n -" + ConstantVariables.SU_NAME + " " + ConstantVariables.SU_SURNAME
                + "\n ACCOUNT NUMBER:"
                + "\n -" + ConstantVariables.SU_ACCNUM
                + "\n AMOUNT WITHDRAWN:"
                + "\n -R " + ConstantVariables.W_amount_In
                + "\n AVAILABE AMOUNT:"
                + "\n -R " + databaseHandler.getAvailAmntDb(ConstantVariables.SU_ACCNUM)
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

    private boolean validateAmount() {
        boolean checker = true;
        if (inAmount.getText().isEmpty()) {
            checker = false;
            errorMssgDis.setText("Enter Amount");
            errorMssgDis.setTextFill(Paint.valueOf("#FF0000"));
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
        assert amntDis1 != null : "fx:id=\"amntDis1\" was not injected: check your FXML file 'WithdrawPage.fxml'.";
        assert backBtn != null : "fx:id=\"backBtn\" was not injected: check your FXML file 'WithdrawPage.fxml'.";
        assert backPic != null : "fx:id=\"backPic\" was not injected: check your FXML file 'WithdrawPage.fxml'.";
        assert depositFrame1 != null : "fx:id=\"depositFrame1\" was not injected: check your FXML file 'WithdrawPage.fxml'.";
        assert depositFrame2 != null : "fx:id=\"depositFrame2\" was not injected: check your FXML file 'WithdrawPage.fxml'.";
        assert depositFrame3 != null : "fx:id=\"depositFrame3\" was not injected: check your FXML file 'WithdrawPage.fxml'.";
        assert errorMssgDis != null : "fx:id=\"errorMssgDis\" was not injected: check your FXML file 'WithdrawPage.fxml'.";
        assert headingText != null : "fx:id=\"headingText\" was not injected: check your FXML file 'WithdrawPage.fxml'.";
        assert inAmount != null : "fx:id=\"inAmount\" was not injected: check your FXML file 'WithdrawPage.fxml'.";
        assert menu != null : "fx:id=\"menu\" was not injected: check your FXML file 'WithdrawPage.fxml'.";
        assert noSlip != null : "fx:id=\"noSlip\" was not injected: check your FXML file 'WithdrawPage.fxml'.";
        assert signInBck != null : "fx:id=\"signInBck\" was not injected: check your FXML file 'WithdrawPage.fxml'.";
        assert slip != null : "fx:id=\"slip\" was not injected: check your FXML file 'WithdrawPage.fxml'.";
        assert userAccNumDis != null : "fx:id=\"userAccNumDis\" was not injected: check your FXML file 'WithdrawPage.fxml'.";
        assert userAccNumDis1 != null : "fx:id=\"userAccNumDis1\" was not injected: check your FXML file 'WithdrawPage.fxml'.";
        assert userAccNumDis11 != null : "fx:id=\"userAccNumDis11\" was not injected: check your FXML file 'WithdrawPage.fxml'.";
        assert wDoneBtn != null : "fx:id=\"wDoneBtn\" was not injected: check your FXML file 'WithdrawPage.fxml'.";
        assert yesSlip != null : "fx:id=\"yesSlip\" was not injected: check your FXML file 'WithdrawPage.fxml'.";

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
