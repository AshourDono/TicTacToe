/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import actions.AppControl;
import clientHandler.Player;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author ahmed
 */
public class SignUpController implements Initializable {

@FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label warningLabel;

    Player player;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player = new Player();
//        ClientHandler.setLoginCtrl(this); 
    }

//#============================================================================#
//#                                handel Actions                              #
//#============================================================================#
    @FXML
    private void backClicked(ActionEvent event) throws IOException {
        AppControl.moveTo("Login");
    }

    @FXML
    private void registerClicked(ActionEvent event) throws IOException {
        String user = username.getText();
        String pass = password.getText();

        boolean checkUname = player.checkUsername(user);
        boolean checkPass = player.checkPassword(pass);

        if (!checkUname) {
            warningLabel.setText("Invalid username format");
        } else if (!checkPass) {
            warningLabel.setText("Invalid password format, should be between 6 and 20 characters");
        } else {
            warningLabel.setText("");

            player.setUsername(user);

            AppControl.moveTo("Welcome");
        }
    }
  @FXML
    private void poupUpClicked(ActionEvent event) throws IOException {
        AppControl.createPopup("TestCustomPopups","popup");
    }

}

