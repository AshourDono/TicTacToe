/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import clientHandler.ClientHandler;
import static clientHandler.ClientHandler.changeScene;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.json.simple.JSONObject;

/**
 *
 * @author nermin
 */
public class LoadGameController implements Initializable  {
     @FXML
    private ListView<String> playerList;
    @FXML
    private ListView<String> statusList;
    @FXML
    private ListView<String> scoreList;
     @FXML
    private Label userName;
    @FXML
    private Label userScore;
     @FXML
    private ComboBox<String> gamesComboBox; 
    @FXML
    private Label waitingLbl;
    @FXML
    private Button okBtn;
    @FXML
    private AnchorPane waitingSubscene;
    boolean finish;
    @FXML
    private Button inviteBtn;
    @FXML
    private Button backBtn;
    @FXML
    private ImageView loadingImage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ClientHandler.setLoadgameCtrl(this);
        waitingSubscene.setVisible(false);
        okBtn.setDisable(true);
        updateTable(ClientHandler.getNameList(),ClientHandler.getScoreList(),ClientHandler.getStatusList());
        userName.setText(ClientHandler.getPlayer().getUsername());
        userScore.setText(String.valueOf(ClientHandler.getPlayer().getScore())+" points");
    }    

    @FXML
    private void backHandler(ActionEvent event) {
        
             changeScene("Dashboard");
        
    }
    
    public void updateTable(ObservableList<String> name , ObservableList<String> score , ObservableList<String> status){
        playerList.setItems(name);
        statusList.setItems(status);
        scoreList.setItems(score);
    }
    
    public void updateScore(String newScore){
        userScore.setText(newScore);
    }
    
    public void displayGames(ObservableList<String> games){
        gamesComboBox.setItems(games);
    }
    public Label getwaitingLbl(){
        return  waitingLbl;
    }
    @FXML
    private void invitePlayerHandler(ActionEvent event) {
        JSONObject chosenGame;
        if(gamesComboBox.getValue()!=null && !gamesComboBox.getValue().equals("")){
            int gameIndex=Integer.parseInt(gamesComboBox.getValue().split("\\.")[0])-1;
            chosenGame=(JSONObject)ClientHandler.getGames().get(gameIndex);
            Long gameID = (Long)chosenGame.get("gameId");
            ClientHandler.loadGameRequest(chosenGame.get("player").toString(),gameID);
            waitingSubscene.setVisible(true);
        }
    }
    
    public void requestRejectionHandler(){
       getwaitingLbl().setText("Opponent rejected your request.");
        loadingImage.setVisible(false);
        okBtn.setDisable(false);
    }

    @FXML
    private void proceedHandler(ActionEvent event) {
        waitingSubscene.setVisible(false);
        okBtn.setDisable(true);
        getwaitingLbl().setText("Please wait for opponent response.");
        loadingImage.setVisible(true);
       
    }
  
}

