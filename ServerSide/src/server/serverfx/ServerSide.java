/*
    This is the main GUI application class for the server.
 */

package server.serverfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed Mamdouh Abdel-Wahab
 */
public class ServerSide extends Application {
     
    public static FXMLDocumentController rootOrigin;
    public static final int refreshRate = 3 ;
    public static boolean DBStatusFlag = false ;
      @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
