/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actions;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AppControl {

    private static Stage window;
    private static Stage popUpWindow;

    public static void setWindow(Stage stage) {
        window = stage;
    }

    public static Stage getWindow() {
        return window;
    }

    public static void setPopUpWindow(Stage stage) {
        popUpWindow = stage;
    }

    public static Stage getPopUpWindow() {
        return popUpWindow;
    }
//#============================================================================#
//#                    handel move from page to another page                   #
//#============================================================================#

    public static void moveTo(String targetFXML) throws IOException {
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        Parent root = FXMLLoader.load(AppControl.class.getResource("/fxml/" + targetFXML + ".fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("../Styles/Styles.css");
        window.setScene(scene);
        window.setResizable(false);
//        window.setMaximized(true);
//        window.setFullScreen(true);
        window.show();
    }
//#============================================================================#
//#                       handel create popup window                           #
//#============================================================================#

    public static void createPopup(String targetFXML, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppControl.class.getResource("/customPopupsFXML/" + targetFXML + ".fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        popUpWindow = stage;
//        stage.setAlwaysOnTop(true);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
}
