/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import actions.AppControl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author ahmed
 */
public class HomePageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private void newBtnClicked(ActionEvent event) throws IOException {
        AppControl.moveTo("Dashboard");
    }

    @FXML
    private void loadBtnClicked(ActionEvent event) throws IOException {
//        AppControl.moveTo("Dashboard");
    }

    @FXML
    private void exitBtnClicked(ActionEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

