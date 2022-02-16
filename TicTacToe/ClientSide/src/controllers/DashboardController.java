/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import actions.AppControl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author ahmed
 */
public class DashboardController implements Initializable {

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

}

