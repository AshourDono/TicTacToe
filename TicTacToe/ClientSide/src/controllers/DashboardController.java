 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import actions.AppControl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;


/**
 *
 * @author ahmed
 */
public class DashboardController implements Initializable {
    @FXML
    private  TableColumn  playerList;
    @FXML
    private TableColumn scoreList;
    @FXML
    private TableColumn statusList;
    

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

    }
     public void updateTable(ObservableList<String> nameList , ObservableList<String> scoreList , ObservableList<String> statusList){
//        playerList.setItems(nameList);
//        scoreList.setItems(scoreList);
//        statusList.setItems(statusList);
    }

}

