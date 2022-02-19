/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import clientHandler.ClientHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import Actions.AppControl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
/**
 *
 * @author Nada
 */
public class InvitationController implements Initializable{
    @FXML
    private Label invitationLbl;
    @FXML
    private Button acceptBtn;
    @FXML
    private Button rejectBtn;
    @FXML
    private AnchorPane waitingSubscene;
    @FXML
    private Label waitingLbl;
    @FXML
    private Button startGameBtn;
    
    @FXML
    private void acceptBtnHandler(ActionEvent event){
        ClientHandler.invitationResponse("true");
        ClientHandler.getPlayer().setInvited(true);
        waitingSubscene.setVisible(true);
        try {
            ClientHandler.getPlayer().updateStatus("ingame");
            AppControl.moveTo("MultiplePlayer");
        } catch (IOException ex) {
            Logger.getLogger(InvitationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void startGameBtnHandler(ActionEvent event){
        try {
            AppControl.moveTo("MultiplePlayer");
        } catch (IOException ex) {
            Logger.getLogger(InvitationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void rejectBtnHandler(ActionEvent event){
        ClientHandler.invitationResponse("false");
        try {
            AppControl.moveTo("HomePage");
        } catch (IOException ex) {
            Logger.getLogger(InvitationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public Label getInvitationLabel(){
        return this.invitationLbl;
    }
    
    public Label getWaitingLbl(){
        return this.waitingLbl;
    }
    
    public Button getStartBtn(){
        return this.startGameBtn;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ClientHandler.setInvitationCtrl(this);
        waitingSubscene.setVisible(false);
        startGameBtn.setDisable(true);
    } 

}
