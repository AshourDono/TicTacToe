/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

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

/**
 *
 * @author ahmed
 */
public class MultipleController implements Initializable {
    @FXML
    private  TableColumn  playerList;
    @FXML
    private TableColumn scoreList;
    @FXML
    private TableColumn statusList;
    @FXML
    private Label waitingLbl;
    @FXML
    private Button okBtn;
    @FXML
    private AnchorPane waitingSubscene;
    boolean finish;
   @Override
        public void initialize(URL url, ResourceBundle rb) {

    } 
    public void updateTable(ObservableList<String> nameList , ObservableList<String> scoreList , ObservableList<String> statusList){
//        playerList.setItems(nameList);
//        scoreList.setItems(scoreList);
//        statusList.setItems(statusList);
    }
     public Label getWaitingLbl(){
        
        return this.waitingLbl;
    }
     public Button getOkBtn(){
        
        return this.okBtn;
    }
     public AnchorPane getWaitingSubscene(){
        
        return this.waitingSubscene;
    }
//    public AnchorPane getSavingSubscene(){
//        
//        return this.savingSubscene;
//    }
//     public Label getSavingLbl(){
//        
//        return this.savingLbl;
//    }
//       public Button getHomtBtn(){
//        
//        return this.homeBtn;
//    }
//    public void secondPlayerMove(){
//        if(!finish){
//            
//            //get cell move of the second player
//            GameHandler.BtnPosition resultCell = GameHandler.getMoveOfNextPlayer();
//            
//            if(resultCell.row == 0){
//                
//                switch (resultCell.col) {
//                    case 0:
//                        btn1.setText(String.valueOf(player2Value));
//                        game.setCell1(player2Value);
//                        player2Handle();
//                        checkWinOrDraw();
//                        break;
//                        
//                    case 1:
//                        btn2.setText(String.valueOf(player2Value));
//                        game.setCell2(player2Value);
//                        player2Handle();
//                        checkWinOrDraw();
//                        break;
//                        
//                    case 2:
//                        btn3.setText(String.valueOf(player2Value));
//                        game.setCell3(player2Value);
//                        player2Handle();
//                        checkWinOrDraw();
//                        break;
//                        
//                    default:
//                        break;
//                }
//            }
//            else if(resultCell.row == 1){
//                switch (resultCell.col) {
//                    case 0:
//                        cell4.setText(String.valueOf(player2Value));
//                        game.setCell4(player2Value);
//                        player2Handle();
//                        checkWinOrDraw();
//                        break;
//                    case 1:
//                        cell5.setText(String.valueOf(player2Value));
//                        game.setCell5(player2Value);
//                        player2Handle();
//                        checkWinOrDraw();
//                        break;
//                    case 2:
//                        cell6.setText(String.valueOf(player2Value));
//                        game.setCell6(player2Value);
//                        player2Handle();
//                        checkWinOrDraw();
//                        break;
//                    default:
//                        break;
//                }
//            }
//            else if(resultCell.row == 2){
//                switch (resultCell.col) {
//                    case 0:
//                        cell7.setText(String.valueOf(player2Value));
//                        game.setCell7(player2Value);
//                        player2Handle();
//                        checkWinOrDraw();
//                        break;
//                    case 1:
//                        cell8.setText(String.valueOf(player2Value));
//                        game.setCell8(player2Value);
//                        player2Handle();
//                        checkWinOrDraw();
//                        break;
//                    case 2:
//                        cell9.setText(String.valueOf(player2Value));
//                        game.setCell9(player2Value);
//                        player2Handle();
//                        checkWinOrDraw();
//                        break;
//                    default:
//                        break;
//                }
//            }
//        }
//    }
    
}
