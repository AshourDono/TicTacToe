/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;


import clientHandler.ClientHandler;
import static clientHandler.ClientHandler.changeScene;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import clientHandler.GameHandler;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;


/**
 *
 * @author ahmed
 */
public class InviteController implements Initializable {

    @FXML
    private ListView<String> playerList;
    @FXML
    private ListView<String> scoreList;
    @FXML
    private ListView<String> statusList;
    @FXML
    private Label waitingLbl;
    @FXML
    private Button okBtn;
    @FXML
    private AnchorPane waitingSubscene;
    boolean finish;
    @FXML
    private ComboBox <String> inviteBox;
    @FXML
    private Label userName;
    @FXML
    private Label userScore;

    private ObservableList<String> OnlinePlayers;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int index = 0;
        ClientHandler.setInviteCtrl(this);
        waitingSubscene.setVisible(false);
        okBtn.setDisable(true);
        inviteBox.setPromptText("Select a player");
        userName.setText(ClientHandler.getPlayer().getUsername());
        userScore.setText(String.valueOf(ClientHandler.getPlayer().getScore()) + " points");
        updateTable(ClientHandler.getNameList(), ClientHandler.getScoreList(), ClientHandler.getStatusList());
    }

    public Label getWaitingLbl() {

        return this.waitingLbl;
    }

    public Button getOkBtn() {

        return this.okBtn;
    }

    public AnchorPane getWaitingSubscene() {

        return this.waitingSubscene;
    }

    @FXML
    private void inviteHandler(ActionEvent event) {

        if (inviteBox.getValue() != null && !inviteBox.getValue().equals("")) {

            ClientHandler.invitePlayerRequest((String) inviteBox.getValue());
            waitingLbl.setText("Please wait for opponent response.");
            waitingSubscene.setVisible(true);
        }
    }

    @FXML
    private void okBtnHandler(ActionEvent event) {
        if (ClientHandler.getGameAccepted()) {
            
                changeScene("MultiplePlayer");
            
        } else {
            waitingSubscene.setVisible(false);
        }
    }

    @FXML
    private void backHandler(ActionEvent event) {
       
            changeScene("Dashboard");
       
    }

    public void updateTable(ObservableList<String> name, ObservableList<String> score, ObservableList<String> status) {
        int index = 0;
        playerList.setItems(name);
        statusList.setItems(status);
        scoreList.setItems(score);
        OnlinePlayers = FXCollections.observableArrayList();
        for (String player : name) {
            if ("online".equals(status.get(index)) && !player.equals(userName.getText())) {
                OnlinePlayers.add(player);
            }
            index++;
        }
        inviteBox.setItems(OnlinePlayers);
    }

    public void updateScore(String newScore) {
        userScore.setText(newScore);
    }

}
