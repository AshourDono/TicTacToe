/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import clientHandler.ClientHandler;
import Actions.AppControl;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.JSONObject;

/**
 *
 * @author user
 */
public class App extends Application {
       
    boolean connected = false;
    Thread readerThread;
    Parent root;
    
    @Override
    public void init()
    {
        connected = ClientHandler.connectToServer();
    }
//        private static Parent loadFXML(String fxml) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(AppControl.class.getResource("/fxml/" + fxml + ".fxml"));
//        return fxmlLoader.load();
//    }
    @Override
    public void start(Stage stage) throws Exception {
        if (connected){

            root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            
            readerThread = new Thread(new ClientHandler.recieveRespone());
            readerThread.start();
        }
        else{

            root = FXMLLoader.load(getClass().getResource("ConnProblem.fxml"));
        }

        Scene scene = new Scene(root);
        ClientHandler.setWindow(stage);
        stage.resizableProperty().setValue(false);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void stop(){
        
        if(connected){
            JSONObject msg = new JSONObject();
            if(ClientHandler.getCurrentScene().equals("Multigame")){
                msg.put("type","gameQuit");
                msg.put("errorMsg", "clientDropped");
                ClientHandler.sendRequest(msg);
            }
            msg = new JSONObject();
            msg.put("type","signout");
            ClientHandler.sendRequest(msg);
            
            ClientHandler.closeCon();
            readerThread.stop();
        }
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
