/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import Actions.AppControl;
import clientHandler.Player;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import clientHandler.ClientHandler;
import javafx.scene.input.MouseEvent;
import org.json.simple.JSONObject;

/**
 *
 * @author ahmed
 */
public class LoginController implements Initializable {

//#============================================================================#
//#                                handel Actions                              #
//#============================================================================#
    @FXML
    private Button loginBtn;

    @FXML
    private Button signupBtn;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label warningLabel;

    Player player;

  
    public Label getWarning()
    {
        return warningLabel;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player = new Player();
       // ClientHandler.setLoginCtrl(this);
    }

    @FXML
    private void signupButtonClicked(ActionEvent event) throws IOException {
        AppControl.moveTo("SignUp");

        
    }

    @FXML
    private void loginButtonClicked(MouseEvent event) throws IOException  {
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
            ClientHandler.setPlayer(player);
            //Generate a new login request to the server.
            JSONObject loginReq = new JSONObject();
            loginReq.put("type", "signin");
            loginReq.put("username", user);
            loginReq.put("password", pass);
            ClientHandler.sendRequest(loginReq);
           
        }

    }

}