/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;


import clientHandler.ClientHandler;
import static clientHandler.ClientHandler.changeScene;
import clientHandler.GameHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.json.simple.JSONObject;

public class MultiplePlayerController implements Initializable {

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
    @FXML
    private AnchorPane waitingSubscene;
    @FXML
    private Button okBtn;
    @FXML
    private Button homeBtn;
    @FXML
    private AnchorPane savingSubscene;
    @FXML
    private Label waitingLbl;
    @FXML
    private Label savingLbl;
    GameHandler game;
    char value;
    boolean isPlay;
    ActionEvent event;
    boolean isFinish;
    char playerX;
    char playerO;
    boolean isDraw;

//#============================================================================#
//#                                handel Actions                              #
//#============================================================================#
    private void playerXHandle() {
        toggleNextMove();
        togglePlay();
    }

    private void playerOHandle() {
        toggleNextMove();
        togglePlay();
    }

    private void checkWinOrDraw() {

        int win = game.checkWin();

        if (win == 1) {
            isFinish = true;

            if (playerX == 'X') {

                if (player1.getText().equals(ClientHandler.getPlayer().getUsername())) {
                    try {
                        Thread.sleep(300);

                        ClientHandler.gameEndedRequest(player1.getText(), isDraw, "");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MultiplePlayerController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                winnerLabel.setText(player1.getText() + " won!");
                setSceneVisibility(true);

            } else {

                if (player2.getText().equals(ClientHandler.getPlayer().getUsername())) {
                    try {
                        Thread.sleep(300);

                        ClientHandler.gameEndedRequest(player2.getText(), isDraw, "");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MultiplePlayerController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                winnerLabel.setText(player2.getText() + " won!");
                setSceneVisibility(true);
            }

        } else if (win == 2) {

            if (playerX == 'X') {

                if (player1.getText().equals(ClientHandler.getPlayer().getUsername())) {
                    try {
                        isDraw = true;
                        Thread.sleep(300);
                        ClientHandler.gameEndedRequest(player1.getText(), isDraw, "");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MultiplePlayerController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            isFinish = true;

            winnerLabel.setText("It's a draw!");
            setSceneVisibility(true);

        }
    }

    @FXML
    private void Btn1Handler(ActionEvent event) {
        if (isPlay && ("".equals(Btn1.getText()) || " ".equals(Btn1.getText()))) {
            Btn1.setText(String.valueOf(playerX));
            game.setBtn1(playerX);
            ClientHandler.sendMoveRequest(0, 0);
            checkWinOrDraw();
            playerXHandle();
        }
    }

    @FXML
    private void Btn2Handler(ActionEvent event) {
        if (isPlay && ("".equals(Btn2.getText()) || " ".equals(Btn2.getText()))) {
            Btn2.setText(String.valueOf(playerX));
            game.setBtn2(playerX);
            ClientHandler.sendMoveRequest(0, 1);
            checkWinOrDraw();
            playerXHandle();
        }
    }

    @FXML
    private void Btn3Handler(ActionEvent event) {
        if (isPlay && ("".equals(Btn3.getText()) || " ".equals(Btn3.getText()))) {
            Btn3.setText(String.valueOf(playerX));
            game.setBtn3(playerX);
            ClientHandler.sendMoveRequest(0, 2);
            checkWinOrDraw();
            playerXHandle();
        }
    }

    @FXML
    private void Btn4Handler(ActionEvent event) {
        if (isPlay && ("".equals(Btn4.getText()) || " ".equals(Btn4.getText()))) {
            Btn4.setText(String.valueOf(playerX));
            game.setBtn4(playerX);
            ClientHandler.sendMoveRequest(1, 0);
            checkWinOrDraw();
            playerXHandle();
        }
    }

    @FXML
    private void Btn5Handler(ActionEvent event) {
        if (isPlay && ("".equals(Btn5.getText()) || " ".equals(Btn5.getText()))) {
            Btn5.setText(String.valueOf(playerX));
            game.setBtn5(playerX);
            ClientHandler.sendMoveRequest(1, 1);
            checkWinOrDraw();
            playerXHandle();
        }
    }

    @FXML
    private void Btn6Handler(ActionEvent event) {
        if (isPlay && ("".equals(Btn6.getText()) || " ".equals(Btn6.getText()))) {
            Btn6.setText(String.valueOf(playerX));
            game.setBtn6(playerX);
            ClientHandler.sendMoveRequest(1, 2);
            checkWinOrDraw();
            playerXHandle();
        }
    }

    @FXML
    private void Btn7Handler(ActionEvent event) {
        if (isPlay && ("".equals(Btn7.getText()) || " ".equals(Btn7.getText()))) {
            Btn7.setText(String.valueOf(playerX));
            game.setBtn7(playerX);
            ClientHandler.sendMoveRequest(2, 0);
            checkWinOrDraw();
            playerXHandle();
        }
    }

    @FXML
    private void Btn8Handler(ActionEvent event) {
        if (isPlay && ("".equals(Btn8.getText()) || " ".equals(Btn8.getText()))) {
            Btn8.setText(String.valueOf(playerX));
            game.setBtn8(playerX);
            ClientHandler.sendMoveRequest(2, 1);
            checkWinOrDraw();
            playerXHandle();
        }

    }

    @FXML
    private void Btn9Handler(ActionEvent event) {
        if (isPlay && ("".equals(Btn9.getText()) || " ".equals(Btn9.getText()))) {
            Btn9.setText(String.valueOf(playerX));
            game.setBtn9(playerX);
            ClientHandler.sendMoveRequest(2, 2);
            checkWinOrDraw();
            playerXHandle();
        }
    }

    private void setSceneVisibility(Boolean visible) {
        if (visible) {
            resultAnchor.setVisible(true);
        } else {
            resultAnchor.setVisible(false);
        }
    }

//    private void exitBtnHandler(ActionEvent event) {
//        Platform.exit();
//    }
    @FXML
    private void backBtnHandler(ActionEvent event) {
        setSceneVisibility(false);
    }

    @FXML
    private void quitBtnHandler(ActionEvent event) {
        ClientHandler.setReplay(false);

        JSONObject gameQuit = new JSONObject();

        gameQuit.put("type", "gameQuit");
        gameQuit.put("responseStatus", "true");

        ClientHandler.sendRequest(gameQuit);

        
            changeScene("Dashboard");//should be the scene for starting a game
        
    }

    @FXML
    private void saveBtnHandler(ActionEvent event) {
        String nextMove = " ";
        if (game.getNextMove() == 0) {
            nextMove = "X";
        } else if (game.getNextMove() == 1) {
            nextMove = "O";
        }
        ClientHandler.saveGameRequest(nextMove);
    }

    private void clearBtns() {
        Stream.of(Btn1, Btn2, Btn3, Btn4, Btn5, Btn6, Btn7, Btn8, Btn9).forEach(button -> {
            button.setText("");
        });
    }

    private void togglePlay() {
        if (isPlay == true) {
            isPlay = false;
        } else {
            isPlay = true;
        }

    }

    private void toggleNextMove() {
        if (game.getNextMove() == 0) {
            game.setNextMove(1);
        } else {
            game.setNextMove(0);
        }
    }

    public void secondPlayerMove() {
        if (!isFinish) {

            //get Btn move of the second player
            GameHandler.btnPosition resultCell = GameHandler.getMoveOfNextPlayer();

            if (resultCell.row == 0) {

                switch (resultCell.col) {
                    case 0:
                        Btn1.setText(String.valueOf(playerO));
                        game.setBtn1(playerO);
                        playerOHandle();
                        checkWinOrDraw();
                        break;

                    case 1:
                        Btn2.setText(String.valueOf(playerO));
                        game.setBtn2(playerO);
                        playerOHandle();
                        checkWinOrDraw();
                        break;

                    case 2:
                        Btn3.setText(String.valueOf(playerO));
                        game.setBtn3(playerO);
                        playerOHandle();
                        checkWinOrDraw();
                        break;

                    default:
                        break;
                }
            } else if (resultCell.row == 1) {
                switch (resultCell.col) {
                    case 0:
                        Btn4.setText(String.valueOf(playerO));
                        game.setBtn4(playerO);
                        playerOHandle();
                        checkWinOrDraw();
                        break;
                    case 1:
                        Btn5.setText(String.valueOf(playerO));
                        game.setBtn5(playerO);
                        playerOHandle();
                        checkWinOrDraw();
                        break;
                    case 2:
                        Btn6.setText(String.valueOf(playerO));
                        game.setBtn6(playerO);
                        playerOHandle();
                        checkWinOrDraw();
                        break;
                    default:
                        break;
                }
            } else if (resultCell.row == 2) {
                switch (resultCell.col) {
                    case 0:
                        Btn7.setText(String.valueOf(playerO));
                        game.setBtn7(playerO);
                        playerOHandle();
                        checkWinOrDraw();
                        break;
                    case 1:
                        Btn8.setText(String.valueOf(playerO));
                        game.setBtn8(playerO);
                        playerOHandle();
                        checkWinOrDraw();
                        break;
                    case 2:
                        Btn9.setText(String.valueOf(playerO));
                        game.setBtn9(playerO);
                        playerOHandle();
                        checkWinOrDraw();
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void setPlayerData() {
        if (ClientHandler.getPlayer().getInvited()) {
            isPlay = false;
            playerX = 'O';
            playerO = 'X';
            player1.setText(ClientHandler.getPlayer().getUsername());
            player2.setText(ClientHandler.getPlayer().getOpponent());
        } else {
            isPlay = true;
            playerX = 'X';
            playerO = 'O';
            player1.setText(ClientHandler.getPlayer().getUsername());
            player2.setText(ClientHandler.getPlayer().getOpponent());
        }
    }

    private void setGameLoaded() {
        if (ClientHandler.getNextPlayer().equals(ClientHandler.getPlayer().getUsername())) {
            if (ClientHandler.getNextMove() == 'X') {
                playerX = 'X';
                playerO = 'O';
                game.setNextMove(0);
            } else {
                playerX = 'O';
                playerO = 'X';
                game.setNextMove(1);
            }
            player1.setText(ClientHandler.getPlayer().getUsername());
            player2.setText(ClientHandler.getPlayer().getOpponent());
            isPlay = true;
        } else {
            if (ClientHandler.getNextMove() == 'X') {
                playerX = 'O';
                playerO = 'X';
                game.setNextMove(0);
            } else {
                playerX = 'X';
                playerO = 'O';
                game.setNextMove(1);
            }
            player1.setText(ClientHandler.getPlayer().getUsername());
            player2.setText(ClientHandler.getPlayer().getOpponent());
            isPlay = false;
        }

        game.setBoard(ClientHandler.getBoard());

    }

    private void setLoadedBoard() {
        int numOfMoves = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game.getBoard()[i][j] == 'X' || game.getBoard()[i][j] == 'O') {
                    numOfMoves++;
                }

                if (i == 0) {
                    switch (j) {
                        case 0:
                            Btn1.setText(String.valueOf(game.getBoard()[i][j]));
                            break;

                        case 1:
                            Btn2.setText(String.valueOf(game.getBoard()[i][j]));
                            break;

                        case 2:
                            Btn3.setText(String.valueOf(game.getBoard()[i][j]));
                            break;

                        default:
                            break;
                    }
                } else if (i == 1) {
                    switch (j) {
                        case 0:
                            Btn4.setText(String.valueOf(game.getBoard()[i][j]));
                            break;
                        case 1:
                            Btn5.setText(String.valueOf(game.getBoard()[i][j]));
                            break;
                        case 2:
                            Btn6.setText(String.valueOf(game.getBoard()[i][j]));
                            break;
                        default:
                            break;
                    }
                } else if (i == 2) {
                    switch (j) {
                        case 0:
                            Btn7.setText(String.valueOf(game.getBoard()[i][j]));
                            break;
                        case 1:
                            Btn8.setText(String.valueOf(game.getBoard()[i][j]));
                            break;
                        case 2:
                            Btn9.setText(String.valueOf(game.getBoard()[i][j]));
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        game.setMovesCount(numOfMoves);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        clearBtns();
        setSceneVisibility(false);
        ClientHandler.setMultigameCtrl(this);
        savingSubscene.setVisible(false);
        homeBtn.setDisable(true);
        waitingSubscene.setVisible(false);
        okBtn.setDisable(true);
        game = new GameHandler();

        if (ClientHandler.getIsLoaded()) {

            setGameLoaded();
            setLoadedBoard();
        } else {
            game.setNextMove(0);
            setPlayerData();
        }

        isFinish = false;
        isDraw = false;
    }

    @FXML
    private void playAgainHandler(ActionEvent event) {
        ClientHandler.invitePlayerRequest(ClientHandler.getPlayer().getOpponent());
        ClientHandler.setReplay(true);
        waitingSubscene.setVisible(true);
    }

    @FXML
    private void exitHandler(ActionEvent event) {
        ClientHandler.getPlayer().updateStatus("online");
        ClientHandler.setReplay(false);
       
           changeScene("Dashboard");
        
    }

    @FXML
    private void homeBtnHandler(ActionEvent event) {
        
            changeScene("Dashboard");
        
    }

    @FXML
    private void okBtnHandler(ActionEvent event) {

        clearBtns();
        game.clearBoard();

        if (ClientHandler.getGameAccepted()) {

            game.setNextMove(0);
            game.setMovesCount(0);
            setPlayerData();
            isFinish = false;
            isDraw = false;
            setSceneVisibility(false);
            waitingSubscene.setVisible(false);
            okBtn.setDisable(true);
            ClientHandler.setReplay(false);
            ClientHandler.setIsLoaded(false);
        } else {
            
                changeScene("Dashboard");
            
        }
    }

    public Label getWaitingLbl() {

        return this.waitingLbl;
    }

    public Label getSavingLbl() {

        return this.savingLbl;
    }

    public Button getOkBtn() {

        return this.okBtn;
    }

    public Button getHomtBtn() {

        return this.homeBtn;
    }

    public AnchorPane getSavingSubscene() {

        return this.savingSubscene;
    }

    public AnchorPane getWaitingSubscene() {

        return this.waitingSubscene;
    }

}
