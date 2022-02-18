/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import actions.AppControl;
import clientHandler.ClientHandler;
import clientHandler.GameHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Stream;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author ahmed
 */
/**
 * FXML Controller class
 *
 *
 */
public class SinglePlayerController implements Initializable {

    @FXML
    private Button Btn1, Btn2, Btn3, Btn4, Btn5, Btn6, Btn7, Btn8, Btn9;
    @FXML
    private Label player1;
    @FXML
    private Label player2;
    @FXML
    private AnchorPane resultAnchor;
    @FXML
    private SubScene resultSubscene;
    @FXML
    private Label winnerLabel;

    GameHandler game;
    char value;
    boolean isPlay;
    ActionEvent event;
    boolean isFinish;

//#============================================================================#
//#                                handel Actions                              #
//#============================================================================#
    private void playerXHandle() {
        game.setNextMove(1);
        isPlay = false;
        value = 'O';
    }

    private void playerOHandle() {
        game.setNextMove(0);
        isPlay = true;
        value = 'X';
    }

    private void checkWinOrDraw() {
        int win = game.checkWin();
        if (win == 1) {
            isFinish = true;
            if (value == 'X') {
                winnerLabel.setText(player1.getText() + " won!");
                setSceneVisibility(true);
            } else {
                winnerLabel.setText(player2.getText() + " won!");
                setSceneVisibility(true);
            }

        } else if (win == 2) {
            isFinish = true;
            winnerLabel.setText("It's a draw!");
            setSceneVisibility(true);
        }
    }

    @FXML
    private void Btn1Handler(ActionEvent event) throws IOException {
        Btn1.setStyle("-fx-background-color:#081FA5; -fx-text-fill: white;");
        if (!isFinish && isPlay && Btn1.getText() == "") {
            Btn1.setText(String.valueOf(value));
            game.setBtn1(value);
            isPlay = false;      //to start play =>player x      
            checkWinOrDraw();
            playerXHandle();
            computerPlay();
        } else if (!isFinish && !isPlay) {
            Btn1.setText(String.valueOf(value));
            game.setBtn1(value);
            checkWinOrDraw();
            playerOHandle();
        }
    }

    @FXML
    private void Btn2Handler(ActionEvent event) throws IOException {
        Btn2.setStyle("-fx-background-color:#081FA5; -fx-text-fill: white;");
        if (!isFinish && isPlay && Btn2.getText() == "") {
            Btn2.setText(String.valueOf(value));
            game.setBtn2(value);
            checkWinOrDraw();
            playerXHandle();
            computerPlay();
        } else if (!isFinish && !isPlay) {
            Btn2.setText(String.valueOf(value));
            game.setBtn2(value);
            checkWinOrDraw();
            playerOHandle();
        }
    }

    @FXML
    private void Btn3Handler(ActionEvent event) throws IOException {
        Btn3.setStyle("-fx-background-color:#081FA5; -fx-text-fill: white;");
        if (!isFinish && isPlay && Btn3.getText() == "") {
            Btn3.setText(String.valueOf(value));
            game.setBtn3(value);
            checkWinOrDraw();
            playerXHandle();
            computerPlay();
        } else if (!isFinish && !isPlay) {
            Btn3.setText(String.valueOf(value));
            game.setBtn3(value);
            checkWinOrDraw();
            playerOHandle();
        }
    }

    @FXML
    private void Btn4Handler(ActionEvent event) throws IOException {
        Btn4.setStyle("-fx-background-color:#081FA5; -fx-text-fill: white;");
        if (!isFinish && isPlay && Btn4.getText() == "") {
            Btn4.setText(String.valueOf(value));
            game.setBtn4(value);
            checkWinOrDraw();
            playerXHandle();
            computerPlay();
        } else if (!isFinish && !isPlay) {
            Btn4.setText(String.valueOf(value));
            game.setBtn4(value);
            checkWinOrDraw();
            playerOHandle();
        }
    }

    @FXML
    private void Btn5Handler(ActionEvent event) throws IOException {
        Btn5.setStyle("-fx-background-color:#081FA5; -fx-text-fill: white;");
        if (!isFinish && isPlay && Btn5.getText() == "") {
            Btn5.setText(String.valueOf(value));
            game.setBtn5(value);
            checkWinOrDraw();
            playerXHandle();
            computerPlay();
        } else if (!isFinish && !isPlay) {
            Btn5.setText(String.valueOf(value));
            game.setBtn5(value);
            checkWinOrDraw();
            playerOHandle();
        }
    }

    @FXML
    private void Btn6Handler(ActionEvent event) throws IOException {
        Btn6.setStyle("-fx-background-color:#081FA5; -fx-text-fill: white;");
        if (!isFinish && isPlay && Btn6.getText() == "") {
            Btn6.setText(String.valueOf(value));
            game.setBtn6(value);
            checkWinOrDraw();
            playerXHandle();
            computerPlay();
        } else if (!isFinish && !isPlay) {
            Btn6.setText(String.valueOf(value));
            game.setBtn6(value);
            checkWinOrDraw();
            playerOHandle();

        }
    }

    @FXML
    private void Btn7Handler(ActionEvent event) throws IOException {
        Btn7.setStyle("-fx-background-color:#081FA5; -fx-text-fill: white;");
        if (!isFinish && isPlay && Btn7.getText() == "") {
            Btn7.setText(String.valueOf(value));
            game.setBtn7(value);
            checkWinOrDraw();
            playerXHandle();
            computerPlay();
        } else if (!isFinish && !isPlay) {
            Btn7.setText(String.valueOf(value));
            game.setBtn7(value);
            checkWinOrDraw();
            playerOHandle();

        }
    }

    @FXML
    private void Btn8Handler(ActionEvent event) throws IOException {
        Btn8.setStyle("-fx-background-color:#081FA5; -fx-text-fill: white;");
        if (!isFinish && isPlay && Btn8.getText() == "") {
            Btn8.setText(String.valueOf(value));
            game.setBtn8(value);
            checkWinOrDraw();
            playerXHandle();
            computerPlay();
        } else if (!isFinish && !isPlay) {
            Btn8.setText(String.valueOf(value));
            game.setBtn8(value);
            checkWinOrDraw();
            playerOHandle();
        }

    }

    @FXML
    private void Btn9Handler(ActionEvent event) throws IOException {
        Btn9.setStyle("-fx-background-color:#081FA5; -fx-text-fill: white;");
        if (!isFinish && isPlay && Btn9.getText() == "") {
            Btn9.setText(String.valueOf(value));
            game.setBtn9(value);
            checkWinOrDraw();
            playerXHandle();
            computerPlay();
        } else if (!isFinish && !isPlay) {
            Btn9.setText(String.valueOf(value));
            game.setBtn9(value);
            checkWinOrDraw();
            playerOHandle();

        }
    }

    @FXML
    private void computerPlay() throws IOException {
        if (!isFinish) {
            GameHandler.BtnPosition resultBtn = null;
            resultBtn = game.getRandomBtn();


            if (resultBtn.row == 0) {
                switch (resultBtn.col) {
                    case 0:
                        Btn1Handler(event);
                        break;
                    case 1:
                        Btn2Handler(event);
                        break;
                    case 2:
                        Btn3Handler(event);
                        break;
                    default:
                        break;
                }
            } else if (resultBtn.row == 1) {
                switch (resultBtn.col) {
                    case 0:
                        Btn4Handler(event);
                        break;
                    case 1:
                        Btn5Handler(event);
                        break;
                    case 2:
                        Btn6Handler(event);
                        break;
                    default:
                        break;
                }
            } else if (resultBtn.row == 2) {
                switch (resultBtn.col) {
                    case 0:
                        Btn7Handler(event);
                        break;
                    case 1:
                        Btn8Handler(event);
                        break;
                    case 2:
                        Btn9Handler(event);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void setSceneVisibility(Boolean visible) {
        if (visible) {
            resultAnchor.setVisible(true);
        } else {
            resultAnchor.setVisible(false);
        }
    }

    @FXML
    private void retryBtnHandler(ActionEvent event) throws IOException {
        game.clearBoard();
        game.setNextMove(0);
        game.setMovesCount(0);

        value = 'X';
        isPlay = true;
        isFinish = false;
        clearBtns();
        setSceneVisibility(false);
        Stream.of(Btn1, Btn2, Btn3, Btn4, Btn5, Btn6, Btn7, Btn8, Btn9).forEach(button -> {
            button.setStyle("-fx-background-color: #01054c;");
        });
    }

    @FXML
    private void exitBtnHandler(ActionEvent event) throws IOException {
        Platform.exit();
    }

    @FXML
    private void backBtnHandler(ActionEvent event) throws IOException {
        setSceneVisibility(false);
        AppControl.moveTo("Dashboard");
    }

    @FXML
    private void quitBtnHandler(ActionEvent event) throws IOException {
        AppControl.moveTo("Dashboard");
    }

    @FXML
    private void exitClicked(ActionEvent event) throws IOException {
        AppControl.moveTo("Dashboard");
    }

    @FXML
    private void saveBtnHandler(ActionEvent event) throws IOException {

    }

    @FXML
    private void clearBtns() {
        Stream.of(Btn1, Btn2, Btn3, Btn4, Btn5, Btn6, Btn7, Btn8, Btn9).forEach(button -> {
            button.setText ("");
        });
    }
    
    @Override
        public void initialize(URL url, ResourceBundle rb) {
        setSceneVisibility(false);
        player1.setText(ClientHandler.getPlayer().getUsername());
        player2.setText("Computer");
        
//        mode = Game.getMode(); //should get mode from the previous scene
        game = new GameHandler();
        game.setNextMove(0);
        value = 'X';
        isPlay = true;
        isFinish = false;
    }    
}

