/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;


import clientHandler.ClientHandler;
import static clientHandler.ClientHandler.changeScene;
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
import org.json.simple.JSONObject;

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
        ClientHandler.setSignUpCtrl(this); 
        player = new Player();
        
    }

//#============================================================================#
//#                                handel Actions                              #
//#============================================================================#
    @FXML
    private void backClicked(ActionEvent event) throws IOException {
        changeScene("Login");
    }
      public Label getWarning()
    {
        return warningLabel;
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
             ClientHandler.setPlayer(player);
            JSONObject signReq = new JSONObject();
            signReq.put("type", "signup");
            signReq.put("username", user);
            signReq.put("password", pass);
            ClientHandler.sendRequest(signReq);
            
        }
    }
//  @FXML
//    private void poupUpClicked(ActionEvent event) throws IOException {
//        AppControl.createPopup("TestCustomPopups","popup");
//    }

}

