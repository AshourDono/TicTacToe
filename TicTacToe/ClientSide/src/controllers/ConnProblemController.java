/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import clientHandler.ClientHandler;
import static clientHandler.ClientHandler.changeScene;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 *
 * @author ahmed
 */
public class ConnProblemController implements Initializable {

    /**
     * Initializes the controller class.
     * 
     */
    @FXML
    private Button tryagain;
    @FXML
    private void tryAgainBtnClicked(ActionEvent Event) {
    //ClientHandler area
    if(ClientHandler.connectToServer())
        {

            Thread readerThread = new Thread(new ClientHandler.recieveRespone());
            readerThread.start();
    
            changeScene("Login");
        
       
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

