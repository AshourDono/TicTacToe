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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.json.simple.JSONObject;

/**
 *
 * @author ahmed
 */
public class HomePageController implements Initializable {

    @FXML
    private Label userName;
    @FXML
    private Label userScore;
     @FXML
    private Button newbtn;
    @FXML
    private Button loadbtn;
    @FXML
    private Button exitbtn;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void newBtnClicked(ActionEvent event) throws IOException {
        changeScene("Dashboard");
    }

    @FXML
    private void loadBtnClicked(ActionEvent event) throws IOException {
        JSONObject getGamesRequest = new JSONObject();
        getGamesRequest.put("type", "getGames");
        ClientHandler.sendRequest(getGamesRequest);
        changeScene("LoadGame");
    }

    @FXML
    private void exitBtnClicked(ActionEvent event) {
        Platform.exit();
    }

    public void updateScore(String newScore) {
        userScore.setText(newScore);
    }

    private void updateHandler(ActionEvent event) {
        JSONObject updateReq = new JSONObject();
        updateReq.put("type", "updateList");
        ClientHandler.sendRequest(updateReq);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
           ClientHandler.setNewgameCtrl(this);
        userName.setText(ClientHandler.getPlayer().getUsername());
        userScore.setText(String.valueOf(ClientHandler.getPlayer().getScore()) + " points");
    }

}
