/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import Actions.AppControl;
import clientHandler.ClientHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;


/**
 *
 * @author ahmed
 */
public class DashboardController implements Initializable {
    @FXML
    private  ListView <String>  playerList;
    @FXML
    private ListView <String> scoreList;
    @FXML
    private ListView <String>  statusList;
    

    // #============================================================================#
    // # handel Actions #
    // #============================================================================#

    @FXML
    private void singleClicked(ActionEvent event) throws IOException {
        AppControl.moveTo("SinglePlayer");
    }

    @FXML
    private void multiClicked(ActionEvent event) throws IOException {
        AppControl.moveTo("MultiplePlayer");
    }

    @FXML
    private void logOutClicked(ActionEvent event) throws IOException {
        AppControl.moveTo("HomePage");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ClientHandler.setDashboardCtrl(this);
        updateTable(ClientHandler.getNameList(),ClientHandler.getScoreList(),ClientHandler.getStatusList());
    }
     public void updateTable(ObservableList<String> nameList , ObservableList<String> score , ObservableList<String> status){
        playerList.setItems(nameList);
        scoreList.setItems(score);
        statusList.setItems(status);
    }

}

