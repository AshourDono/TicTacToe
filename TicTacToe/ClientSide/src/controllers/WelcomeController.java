/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import clientHandler.ClientHandler;
import static clientHandler.ClientHandler.changeScene;
public class WelcomeController implements Initializable {

    /**
     * Initializes the controller class.
     */

        @FXML
        private ImageView WelcomeImg;
        @FXML
        private Label username;
        @FXML
        private Button startPlaying;

        // StartPlaying button handler switch the scene to StartPane
        @FXML
        private void startBtnClicked(ActionEvent event) throws IOException {
           changeScene("HomePage");
        }

        @Override
        public void initialize(URL url, ResourceBundle rb) {
        username.setText(ClientHandler.getPlayer().getUsername());
        }
    }


