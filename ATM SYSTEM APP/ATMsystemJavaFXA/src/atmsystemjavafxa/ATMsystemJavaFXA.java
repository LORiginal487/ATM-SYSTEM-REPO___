/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package atmsystemjavafxa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Application.launch;
import utilities.ConstantVariables;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(ConstantVariables.FXML_SI));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}